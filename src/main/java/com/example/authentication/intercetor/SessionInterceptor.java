package com.example.authentication.intercetor;/**
 * @author: ait
 * @date: 2020/3/13 21:03
 * @description:
 */

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @project   : authentication
 * @className : SessionInterceptor
 * @author    : ait
 * @time      : 2020年03月13日 21:03
 * @desc      : TODO
 **/
@Component
public class SessionInterceptor implements WebMvcConfigurer {
    /**
     * 自定义拦截器，添加拦截路径和排除拦截路径
     * addPathPatterns():添加需要拦截的路径
     * excludePathPatterns():添加不需要拦截的路径
     */
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> list = new ArrayList<>();
        list.add("/auth/welcome");
        list.add("/auth/login");
        list.add("/auth/loginUser");
        list.add("/auth/toRegister");
        list.add("/auth/register");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/auth/**");
//        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**").excludePathPatterns(list);

    }
}
