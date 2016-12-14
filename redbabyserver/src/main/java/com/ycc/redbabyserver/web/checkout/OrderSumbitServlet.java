package com.ycc.redbabyserver.web.checkout;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ycc.redbabyserver.dao.impl.CartDaoImpl;
import com.ycc.redbabyserver.dao.impl.OrderDaoImpl;
import com.ycc.redbabyserver.domain.Cart1;
import com.ycc.redbabyserver.domain.Order;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.LogisticsService;
import com.ycc.redbabyserver.utils.CommonUtil;
import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2016/12/14.
 */
@WebServlet(name = "OrderSumbitServlet")
public class OrderSumbitServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getHeader("userid");
        String addressid = request.getParameter("addressid");
        String sku = request.getParameter("sku");
        String paymentid = request.getParameter("paymentid");
        String deliveryid = request.getParameter("deliveryid");
        String invoicetype = request.getParameter("invoicetype");
        String invoicetitle = request.getParameter("invoicetitle");
        String invoicecontent = request.getParameter("invoicecontent");

        System.out.println("addressid"+addressid);
        System.out.println("sku"+sku);
        System.out.println("paymentid"+paymentid);
        System.out.println("deliveryid"+deliveryid);
        System.out.println("invoicetype"+invoicetype);
        System.out.println("invoicetitle"+invoicetitle);
        System.out.println("invoicecontent"+invoicecontent);

        CartDaoImpl cartDaoImpl = new CartDaoImpl();
        Cart1 cart = cartDaoImpl.findCartByUserId(userId);

        Order order = new Order();
        order.setUserid(userId);
        order.setOrder_uuid(UUID.randomUUID().toString());

        order.setType("1");
//		order.setType("近一个的订单");
//		order.setStatus("qqqqqqqqqq");
        order.setStatus("未处理");

        order.setType("1");
        order.setStatus("未处理");

        order.setPrice(String.valueOf(cart.getTotalPrice()));
        order.setFlag("1");
//		order.setFlag("可删除可修改的订单");
//		order.setPayment_info_code("paymentid");
        order.setPayment_info_code("货到付款");
//		order.setDelivery_info_code("deliveryid");
        order.setDelivery_info_code("时间不限，工作日双休日及公众假期均可送货");
        order.setTotal_count(String.valueOf(cart.getTotalCount()));
        order.setTotal_point(String.valueOf(cart.getTotalPoint()));
        order.setTotal_price(String.valueOf(cart.getTotalPrice()));
        order.setFreight("10");
        order.setProm_cut("20");
//		order.setInvoicetitle("invoicetitle");
        order.setInvoicetitle("北京红孩子互联科技有限公司");
//		order.setInvoicecontent("invoicecontent");
        order.setInvoicecontent("个人");
        order.setInvoicetype("个人");
        order.setState(1);

        OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
        orderDaoImpl.insertOrder(order);

        LogisticsService logistService = BasicFactory.getInstance(LogisticsService.class);
        logistService.insertLogistics(order.getOrder_uuid());

        Map<String,String> orderinfoMap = new HashMap<String,String>();
        orderinfoMap.put("orderid", order.getOrder_uuid());
        orderinfoMap.put("price", order.getPrice());
        orderinfoMap.put("paymenttype", order.getPayment_info_code());

        Map<String, Object> orderMap = new HashMap<String, Object>();
        orderMap.put("response", "ordersumbit");
        orderMap.put("orderinfo", orderinfoMap);
        JSONObject object = JSONObject.fromObject(orderMap);
        String json = object.toString();
        System.out.println("提交订单："+json);
        CommonUtil.renderJson(response, json);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
