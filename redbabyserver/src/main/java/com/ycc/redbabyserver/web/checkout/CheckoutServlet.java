package com.ycc.redbabyserver.web.checkout;

import com.ycc.redbabyserver.dao.impl.*;
import com.ycc.redbabyserver.domain.*;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.AddressService;
import com.ycc.redbabyserver.service.CartService;
import com.ycc.redbabyserver.utils.CommonUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/14.
 */
@WebServlet(name = "CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    private String userId;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sku = request.getParameter("sku");
        userId = request.getHeader("userid");
        System.out.println(userId);
        String[] proParas = StringUtils.split(sku, "|");
		/*for(int i=0;i<proParas.length;i++){
			System.out.println(proParas[i]);
		}*/
        // 测试用 userid头信息
        if (StringUtils.isBlank(userId))
            userId = "2537a732-dccf-49c5-b562-82fe8095b2e3";

        Map<String, Object> res = new HashMap<String, Object>();
        res.put("response", "checkout");
        //res.put("address_info", getAddressInfo(userId));
        //res.put("payment_info", getPaymentInfo());
        //res.put("delivery_info", getDeliveryInfo());
        res.put("productlist", getProductLists(proParas));
        //res.put("checkout_prom", getCheckProm(proParas));
        res.put("checkout _addup", getCheckoutAddup(userId));

        JSONObject object = JSONObject.fromObject(res);
        String json = object.toString();
        CommonUtil.renderJson(response, json);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public List<Map<String, Object>> getProductLists(String[] proParas) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < proParas.length; i++) {
            String[] proPara = StringUtils.split(proParas[i], ":");
            String[] propertyIds = StringUtils.split(proPara[2], ",");
            list.add(getProduct(proPara[0], proPara[1], propertyIds));
        }
        System.out.println("list是否为null"+list==null);
        return list;
    }

    /**
     * 根据用户userId得到地址信息的Map集合
     *
     * @param userId
     *            用户的userId
     * @return 含有地址信息的Map集合
     */
    // 测试通过
    public Map<String, String> getAddressInfo(String userId) {
        Map<String, String> map = new HashMap<String, String>();
        AddressService addressService = BasicFactory.getInstance(AddressService.class);
        List<Address> addressLists = addressService.getAddressList(userId);

        for (Address address : addressLists) {
            if (address.getIsdefault().equals("1")) {
                System.out.println("11111111111111");
                //map.put("id", address.getAddress_id());
                map.put("name", address.getName());
                map.put("addressDetail", address.getAreaDetail());
                //map.put("area_id", address.getArea_id());
            }
        }
        // 根据地址表的Id(area_id)在地址三级列表中查找地区名称
        //AddressAreaDaoImpl addressareaDaoImpl = new AddressAreaDaoImpl();
        //AddressArea area = addressareaDaoImpl.findAddrAreaByAreaId(map.get("area_id"));
        //map.remove("area_id");
        //map.put("addressArea", area.getArea());
        return map;
    }

    /**
     * 得到支付方式的Map集合
     *
     * @return
     */
    // 测试通过
    public Map<String, String> getPaymentInfo() {
        PaymentInfoDaoImpl paymentInfoDaoImpl = new PaymentInfoDaoImpl();
        List<PaymentInfo> lists = paymentInfoDaoImpl.findAll();

        Map<String, String> paymentInfoMap = new HashMap<String, String>();
        for (PaymentInfo paymentInfo : lists) {
            paymentInfoMap.put(paymentInfo.getCode(), paymentInfo.getPaytype());
        }

        return paymentInfoMap;
    }

    /**
     * 得送货时间的Map集合
     *
     * @return
     */
    // 测试通过
    public Map<String, String> getDeliveryInfo() {
        DeliveryInfoDaoImpl deliveryInfoDaoImpl = new DeliveryInfoDaoImpl();
        List<DeliveryInfo> lists = deliveryInfoDaoImpl.findAll();

        Map<String, String> deliveryInfoMap = new HashMap<String, String>();
        for (DeliveryInfo deliveryInfo : lists) {
            deliveryInfoMap.put(deliveryInfo.getCode(), deliveryInfo.getDeliverytime());
        }

        return deliveryInfoMap;
    }

    public Map<String, String> getProductProperty(String propertyId) {
        ProductPropertyDaoImpl productPropertyDaoImpl = new ProductPropertyDaoImpl();
        ProductProperty property = productPropertyDaoImpl.findProductPropertyById(Integer.parseInt(propertyId));
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", property.getKey());
        map.put("value", property.getValue());
        return map;
    }

    Map<String, Object> getProduct(String proId, String num, String[] propertyIds) {
        System.out.println(propertyIds[1]);
        ProDaoImpl proDaoImpl = new ProDaoImpl();
        Product pro = proDaoImpl.findById(proId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", pro.getId());
        map.put("name", pro.getName());
        map.put("pic", pro.getPic());
        map.put("price", pro.getPrice());
        // List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        // for(int i = 0;i < propertyIds.length;i++){
        // list.add(getProductProperty(propertyIds[i]));
        // }

        CartService cartService = BasicFactory.getInstance(CartService.class);
        String cartId = String.valueOf(cartService.findCartIdByUserid(userId));
        List<Map<String, Object>> list = cartService.getCartProdProperties(cartId, proId);
        map.put("product_property", list);
        map.put("number", num);
        map.put("uplimit", pro.getBuyLimit());
        map.put("isgift", pro.getIsgift());
        System.out.println("mapshifou wei null"+map==null);
        return map;
    }

    // 测试通过
    public List<String> getCheckProm(String[] proParas) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < proParas.length; i++) {
            String[] proPara = StringUtils.split(proParas[i], ":");
            ProDaoImpl proDaoImpl = new ProDaoImpl();
            Product pro = proDaoImpl.findById(proPara[0]);
            list.add(pro.getProductProm());
        }
        return list;
    }

    Map<String, String> getCheckoutAddup(String userId) {
        Map<String, String> map = new HashMap<String, String>();
        CartDaoImpl cartDaoImpl = new CartDaoImpl();
        Cart1 cart = cartDaoImpl.findCartByUserId(userId);
        map.put("totalCount", String.valueOf(cart.getTotalCount()));
        map.put("totalPrice", String.valueOf(cart.getTotalPrice()));
        map.put("totalPoint", String.valueOf(cart.getTotalPoint()));
        map.put("freight", "10");
        map.put("promCut", "20");
        return map;
    }
}
