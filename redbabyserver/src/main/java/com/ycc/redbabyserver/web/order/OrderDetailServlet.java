package com.ycc.redbabyserver.web.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.ycc.redbabyserver.domain.Address;
import com.ycc.redbabyserver.domain.AddressArea;
import com.ycc.redbabyserver.domain.Cart;
import com.ycc.redbabyserver.domain.CartItem;
import com.ycc.redbabyserver.domain.Order;
import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.domain.Property;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.AddressAreaService;
import com.ycc.redbabyserver.service.AddressService;
import com.ycc.redbabyserver.service.CartItemService;
import com.ycc.redbabyserver.service.CartService;
import com.ycc.redbabyserver.service.OrderDetailService;
import com.ycc.redbabyserver.service.ProService;
import com.ycc.redbabyserver.service.PropertyService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;

public class OrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDetailService orderDetailService = BasicFactory.getInstance(OrderDetailService.class);
		CartService cartService = BasicFactory.getInstance(CartService.class);
		CartItemService cartItemService = BasicFactory.getInstance(CartItemService.class);
		ProService proService = BasicFactory.getInstance(ProService.class);
		PropertyService propertyService = BasicFactory.getInstance(PropertyService.class);
		AddressAreaService addrAreaService = BasicFactory.getInstance(AddressAreaService.class);
		AddressService addrService = BasicFactory.getInstance(AddressService.class);

		String orderid = request.getParameter("orderId");
		String userid = request.getHeader("userid");
		System.out.println("订单id:"+orderid);
		System.out.println("userid:"+userid);

		System.out.println("orderid"+orderid);
		System.out.println("userid"+userid);
		if (StringUtils.isBlank(userid))
			userid = "2537a732-dccf-49c5-b562-82fe8095b2e3";
		if (userid == null || "".equals(userid.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("用户ID为空"));
			return;
		}
		/************************* 获取数据 *******************************************/
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		Order order = orderDetailService.getOrderById(userid, orderid);
		System.out.println("order==null?"+order==null);

		Cart cart = cartService.findCartByUserid(userid);
		System.out.println("cart==null?"+cart==null);
		List<CartItem> cartItemList = cartItemService.findCartItemListByUserId(cart.getUser_id());

		/******************************************************************/

		orderDetailMap.put("response", "orderdetail");

		Map<String, Object> item = new HashMap<String, Object>();
		item.put("orderid", order.getOrder_uuid());
		item.put("status", order.getStatus());
		item.put("time", order.getTime());
		item.put("flag", order.getFlag());
		orderDetailMap.put("order_info", item);

		// 地址
		Map<String, Object> addrMap = new HashMap<String, Object>();

		List<Address> addressList = addrService.getAddressList(userid);
		System.out.println("addressList.size()="+addressList.size());
		if (addressList != null) {
			for (Address address : addressList) {
				if ("1".equals(address.getIsdefault())) {
					AddressArea area = addrAreaService.findAddrAreaByAreaId(address.getArea_id());
					addrMap.put("id", address.getAddress_id());
					addrMap.put("name", address.getName());
					addrMap.put("address_area", area.getArea());
					addrMap.put("address_detail", address.getAreaDetail());
					addrMap.put("phonenumber", address.getPhonenumber());
					orderDetailMap.put("address_info", addrMap);
					break;
				}
			}
		}

		// 支付方式
		Map<String, Object> paymentMap = new HashMap<String, Object>();
		paymentMap.put("type", order.getPayment_info_code());
		orderDetailMap.put("payment_info", paymentMap);

		// 送货时间
		Map<String, Object> deliveryMap = new HashMap<String, Object>();
		deliveryMap.put("type", order.getDelivery_info_code());
		orderDetailMap.put("delivery_info", deliveryMap);

		// 发票信息
		Map<String, Object> invoiceMap = new HashMap<String, Object>();
		invoiceMap.put("title", order.getInvoicetitle());
		invoiceMap.put("content", order.getInvoicecontent());
		orderDetailMap.put("invoice_info", invoiceMap);

		// 促销信息
		List<Object> promList = new ArrayList<Object>();

		// 商品列表
		List<Object> prodList = new ArrayList<Object>();
		for (CartItem cartItem : cartItemList) {
			Map<String, Object> cartItemMap = new HashMap<String, Object>();
			Product product = proService.findProById(String.valueOf(cartItem.getProduct_id()));
			cartItemMap.put("id", product.getPro_id());
			cartItemMap.put("name", product.getName());
			cartItemMap.put("pic", product.getPic());
			cartItemMap.put("price", product.getPrice());

			// List<Object> propList = new ArrayList<Object>();
			// List<Property> props =
			// propertyService.findAllPropertyById(Integer.parseInt(product.getPro_id()));
			List<Map<String, Object>> propList = cartService.getCartProdProperties(userid, product.getPro_id());
			/*
			 * for(Property prop : props){ Map<String, Object> propMap = new
			 * HashMap<String, Object>(); propMap.put("key", prop.getKey());
			 * propMap.put("value", prop.getValue()); propList.add(propMap); }
			 */
			cartItemMap.put("product_property", propList);
			cartItemMap.put("number", product.getSalesNum());
			cartItemMap.put("uplimit", product.getBuyLimit());
			cartItemMap.put("isgift", product.getIsGift());

			// 促销信息
			promList.add(product.getProductProm());

			// 产品信息
			prodList.add(cartItemMap);
		}
		orderDetailMap.put("productlist", prodList);

		orderDetailMap.put("checkout_prom", promList);

		// 总计
		Map<String, Object> addUpMap = new HashMap<String, Object>();
		addUpMap.put("total_count", cart.getTotalCount());
		addUpMap.put("total_price", cart.getTotalPrice());
		addUpMap.put("total_point", cart.getTotalPoint());
		addUpMap.put("freight", order.getFreight());
		addUpMap.put("prom_cut", order.getProm_cut());
		orderDetailMap.put("checkout_addup", addUpMap);

		JSONObject object = JSONObject.fromObject(orderDetailMap);
		String json = object.toString();
		System.out.println("****"+json);
		CommonUtil.renderJson(response, json);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
