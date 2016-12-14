package com.ycc.redbabyserver.web.cart;

import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.CartService;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/14.
 */
@WebServlet(name = "CartClearServlet")
public class CartClearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartService service = BasicFactory.getInstance(CartService.class);

        String userid = req.getHeader("userid");
        // 测试用 userid头信息
        if (StringUtils.isBlank(userid)) {
            userid = req.getParameter("userid");
            if (StringUtils.isBlank(userid))
                userid = "1";
        }
        // pId为空就删除全部
        String pId = req.getParameter("pId");

        int result = service.deleteProd(userid, pId);

        if (result == 0)
            CommonUtil.renderJson(resp, GlobalParams.getError("删除失败"));
        else {
            Map<String, Object> responseData = new HashMap<String, Object>();
            responseData.put("response", "success");

            JSONObject jsonObject = JSONObject.fromObject(responseData);
            String json = jsonObject.toString();
            CommonUtil.renderJson(resp, json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
