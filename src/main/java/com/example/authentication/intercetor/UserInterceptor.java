package com.example.authentication.intercetor;/**
 * @author: ait
 * @date: 2020/3/13 20:58
 * @description:
 */

import com.example.authentication.dto.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UserInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(UserInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        logger.info("拦截到了方法:{}",handler);
        if (request.getRequestURI().equals("/auth/login") || request.getRequestURI().equals("/auth/toRegister")
        || request.getRequestURI().equals("/auth/register")|| request.getRequestURI().equals("/auth/loginUser")) {
            return true;
        }
        Object session_user = request.getSession().getAttribute("session_user");
        logger.info("获取session_user结果：{}",session_user);
        //获取到的
        if (session_user == null){
            response.sendRedirect(request.getContextPath()+"/auth/login");//拦截后跳转的方法
            logger.info("未登陆导致拦截跳转登陆-> /login");
            return false;
        }
        System.out.println("合格不需要拦截，放行");
        return true;
    }

    /*
     * 处理请求完成后视图渲染之前的处理操作
     * 通过ModelAndView参数改变显示的视图，或发往视图的方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("执行了postHandle方法");
    }

    /*
     * 视图渲染之后的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        System.out.println("执行到了afterCompletion方法");
    }
}
