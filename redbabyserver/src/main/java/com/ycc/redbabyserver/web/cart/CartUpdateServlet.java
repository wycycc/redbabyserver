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
@WebServlet(name = "CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
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
        String sku = req.getParameter("sku");

        // 参数不能为空
        if (!StringUtils.isBlank(sku)) {
            String[] strs = StringUtils.split(sku, ":");
            strs[2] = strs[2].replace(",", "000");
            try {
                service.updateCart(userid, strs);
            } catch (Exception e) {
                CommonUtil.renderJson(resp, GlobalParams.getError("修改失败"));
            }
        }
        // 返回成功信息
        Map<String, Object> responseData = new HashMap<String, Object>();
        responseData.put("response", "success");

        JSONObject jsonObject = JSONObject.fromObject(responseData);
        String json = jsonObject.toString();
        CommonUtil.renderJson(resp, json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
