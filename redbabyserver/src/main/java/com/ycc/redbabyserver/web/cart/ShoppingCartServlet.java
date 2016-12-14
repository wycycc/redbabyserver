package com.ycc.redbabyserver.web.cart;

import com.ycc.redbabyserver.domain.Cart;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.CartService;
import com.ycc.redbabyserver.service.ProService;
import com.ycc.redbabyserver.utils.CommonUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/14.
 */
@WebServlet(name = "ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartService service = BasicFactory.getInstance(CartService.class);
        ProService proService = BasicFactory.getInstance(ProService.class);
        System.out.println("购物车");
        // 获取请求
        String userId = request.getHeader("userid");
        System.out.println(userId);
        // 测试用 userid头信息
        if (StringUtils.isBlank(userId)) {
            //userId = request.getParameter("userid");
            if (StringUtils.isBlank(userId))
                userId = "2537a732-dccf-49c5-b562-82fe8095b2e3";

        }

        String sku = request.getParameter("sku");
        System.out.println("sku");
        // 带参数表示新增
        if (!StringUtils.isBlank(sku)) {
            String[] strs = StringUtils.split(sku, ":");
            strs[2] = strs[2].replace(",", "000");
            //service.addToCart(userId, strs);
        }
        System.out.println("test");
        // 获取购物车信息
        // 购物车项中的商品数
        // 购物车项中的商品List
        List<Map<String, Object>> cartitemList = service.getCartProList(userId);
        // 促销信息

        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, Object> cartMap = new HashMap<String, Object>();

        data.put("response", "cart");
        data.put("cart", cartMap);
        cartMap.put("cartitem", cartitemList);
        String[] prom = new String[]{"买奶粉，送女朋友","只要九九八，买不了吃亏买不了上当"};
        cartMap.put("prom", prom);

        Cart cart = service.findCartByUserid(userId);
        System.out.println(cart == null);
        cartMap.put("totalCount", cart.getTotalCount());
        cartMap.put("totalPrice", cart.getTotalPrice());
        cartMap.put("totalPoint", cart.getTotalPoint());

        JSONObject jsonObject = JSONObject.fromObject(data);
        String json = jsonObject.toString();
        System.out.println(json);
        CommonUtil.renderJson(response, json);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
