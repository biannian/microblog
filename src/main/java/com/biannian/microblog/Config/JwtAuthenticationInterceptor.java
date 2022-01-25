package com.biannian.microblog.Config;

import com.biannian.microblog.Model.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


//        String token = request.getHeader("token");
//
//        if (!(handler instanceof HandlerMethod)) {
//            return true;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//        if (method.isAnnotationPresent(PassToken.class)) {
//            PassToken passToken = method.getAnnotation(PassToken.class);
//            if (passToken.required()) {
//                return true;
//            }
//        }
//        //默认全部检查
//        else {
//            // 执行认证
//            if (token == null) {
//                //登录失效了，没有taken了
//                System.out.println("登录失效，重新登录");
//                response.setStatus(ErrorCode.AUTH_ERROR.getValue());
//                return false;
//            }
//            String accountName = JWTUtil.getAudience(token);
//
//
//            //验证token是否过期
//            if (JWTUtil.verifyToken(token, accountName)) {
//                response.setStatus(ErrorCode.AUTH_ERROR.getValue());
//                return false;
//            }
//
////            if (JWTUtil.checkTokenDate(token)) {
////                String newToken = JWTUtil.createToken(accountName, accountLimit,accountUserId);
////                response.setStatus(213);
////                response.addHeader("newToken", newToken);
////                response.addHeader("Access-Control-Expose-Headers", "newToken");
////            }
//
//            request.setAttribute("accountName", accountName);
//            return true;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}