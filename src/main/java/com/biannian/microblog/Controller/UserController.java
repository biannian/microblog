package com.biannian.microblog.Controller;

import com.biannian.microblog.Entity.*;
import com.biannian.microblog.Model.Result;
import com.biannian.microblog.Service.UserService;
import com.biannian.microblog.Utils.IVerifyCodeGen;
import com.biannian.microblog.Utils.RandomUtils;
import com.biannian.microblog.Utils.SimpleCharVerifyCodeGenImpl;
import com.biannian.microblog.Utils.mailUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
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
        List<User> users = service.login(account, password);
        if (users.size() != 1) {
            User user = service.addWrongCount(account);
            if (StringUtils.isNotEmpty(user.getAccount())) {
                if (user.getWrongCount() >= 5) {
                    //账户登录错误次数过多被禁用
                    return Result.fail(-2);
                }
                return Result.fail(-3, String.valueOf(user.getWrongCount()));
            }
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

    @RequestMapping({"/getVerification"})
    public Result<?> getVerification(String email) {
        List<Account> account = service.queryEmail(email);
        if (account.size() > 0){
            return Result.fail(-1,"邮箱地址已被注册");
        }
        int verification = RandomUtils.nextInt(99999, 1000000);
        try {
            mailUtil.sendMail(email, "[MicroBlog]验证码", "您的验证码" + verification + "，请不要告诉他人");
        } catch (Exception e) {
            e.printStackTrace();
            EmailHistory emailHistory = new EmailHistory();
            emailHistory.setEmail(email);
            emailHistory.setVerifyCode(String.valueOf(verification));
            emailHistory.setCreatTime(new Date());
            emailHistory.setSendStatus("error");
            service.saveEmailHistory(emailHistory);
            return Result.fail(-1,"发送失败，请检查邮箱地址");
        }
        EmailHistory emailHistory = new EmailHistory();
        emailHistory.setEmail(email);
        emailHistory.setVerifyCode(String.valueOf(verification));
        emailHistory.setCreatTime(new Date());
        emailHistory.setSendStatus("success");
        service.saveEmailHistory(emailHistory);
        return Result.success(verification);
    }

    @RequestMapping({"/saveGlance"})
    public void saveGlance(String browserName, String glanceIp, String city) {
        GlanceHistroy glanceHistroy = new GlanceHistroy();
        glanceHistroy.setBrowserName(browserName);
        glanceHistroy.setCity(city);
        glanceHistroy.setGlanceIp(glanceIp);
        glanceHistroy.setGlanceTime(new Date());
        service.saveGlance(glanceHistroy);
    }

    @RequestMapping({"/register"})
    public Result<?> register(String email, String account, String password) {
        Account user = new Account();
        if (StringUtils.isEmpty(email))
            return Result.fail(-1, "邮箱不能为空");
        if (StringUtils.isEmpty(account))
            return Result.fail(-1, "账户不能为空");
        if (StringUtils.isEmpty(password))
            return Result.fail(-1, "密码不能为空");
        user.setAccount(account);
        user.setEmail(email);
        user.setPassword(password);
        service.register(user);
        return Result.success("注册成功！");
    }
}
