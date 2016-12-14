package com.ycc.redbabyserver.web;

import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.ProService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
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
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProService service = BasicFactory.getInstance(ProService.class);
        System.out.println("Search收到请求");
        //获取客户端的请求参数
        String keyword = request.getParameter("keyword");
        String orderby = request.getParameter("orderby");
        String pageNum = request.getParameter("pageNum");
        String page = request.getParameter("page");

        if (StringUtils.isBlank(keyword)) {
            CommonUtil.renderJson(response, GlobalParams.getError("关键字为空"));
            return;
        }
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageNum)) {
            pageNum = "10";
        }

        if("price_up".equals(orderby.trim())){
            orderby = "price asc";
        }else if("price_down".equals(orderby.trim())){
            orderby = "price desc";
        }else if("comment_down".equals(orderby.trim())){
            orderby = "comment desc";
        }else if("shelves_down".equals(orderby.trim())){
            orderby = "shelves desc";
        }else{
            orderby = "sale desc";
        }

        String newPage = (Integer.parseInt(page)-1)+"";
        List<Product> productlist = service.getProductlist(keyword, orderby, pageNum, newPage);
        if (productlist == null) {
            CommonUtil.renderJson(response, GlobalParams.getError("商品列表为空"));
        } else {
            Map<String, Object> favorites = new HashMap<String, Object>();
            favorites.put("response", "search");
            List<Object> items = new ArrayList<Object>();
            for (Product product : productlist) {
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("id", product.getPro_id());
                item.put("name", product.getName());
                item.put("pic", product.getPic());
                item.put("marketprice", product.getMarketPrice());
                item.put("price", product.getPrice());
                items.add(item);
            }
            favorites.put("productlist", items);
            favorites.put("list_count", service.getCount());

            JSONObject object = JSONObject.fromObject(favorites);
            String json = object.toString();
            CommonUtil.renderJson(response, json);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
