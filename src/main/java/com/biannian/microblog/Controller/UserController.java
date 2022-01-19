package com.biannian.microblog.Controller;

import com.biannian.microblog.Entity.User;
import com.biannian.microblog.Entity.VerifyCode;
import com.biannian.microblog.Model.Result;
import com.biannian.microblog.Service.UserService;
import com.biannian.microblog.Utils.IVerifyCodeGen;
import com.biannian.microblog.Utils.SimpleCharVerifyCodeGenImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping({"/User"})
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping({"/getUserInfo"})
    public Result<?> getBlogInfo(String userId) {
        return Result.success(service.getUserInfo(userId));
    }

    @RequestMapping({"/login"})
    public Result<?> login(String account, String password) {
        List<User> users = service.login(account,password);
        if (users.size() != 1 ){
            return Result.fail(-1);
        }
        return Result.success(users.get(0).getUserId());
    }

    @RequestMapping({"/verifyCode"})
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(100, 24);
            String code = verifyCode.getCode();
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            response.setHeader("VerifyCode", code);
            response.addHeader("Access-Control-Expose-Headers", "VerifyCode");
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
