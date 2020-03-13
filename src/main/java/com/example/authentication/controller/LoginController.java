package com.example.authentication.controller;/**
 * @author: ait
 * @date: 2020/3/13 20:18
 * @description:
 */

import com.example.authentication.dao.MemberInfoEntityMapper;
import com.example.authentication.dao.UserInfoEntityMapper;
import com.example.authentication.dto.UserInfo;
import com.example.authentication.entity.UserInfoEntity;
import com.example.authentication.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @project   : authentication
 * @className : LoginController
 * @author    : ait
 * @time      : 2020年03月13日 20:18
 * @desc      : 登陆
 **/
@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private AuthService authService;
    @Autowired
    private MemberInfoEntityMapper memberInfoMapper;
    @Autowired
    private UserInfoEntityMapper userInfoMapper;

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    //跳转首页（登录页）
    @RequestMapping("/login")
    public String login() {
        logger.info("尝试登陆=== /login");
        return "login";
    }

    //登录操作
//    @ResponseBody
    @RequestMapping("/loginUser")
    public String login(UserInfo user, HttpServletRequest request) {
        logger.info("用户信息登陆=== /loginUser");
        Example example = new Example(UserInfoEntity.class);
        example.createCriteria().andEqualTo("name", user.getUserName())
                .andEqualTo("password", user.getPassWord());
        UserInfoEntity userInfoEntity = userInfoMapper.selectOneByExample(example);
        if (userInfoEntity == null) {
            return "register";
        } else {
            request.getSession().setAttribute("session_user",user);
            logger.info("登陆成功！session_user：{}",user);
//            logger.info("设置前session_user：",session_user);
//            logger.info("设置session_user=={}",user);
//            request.getSession().setAttribute("session_user", user);//登录成功后将用户放入session中，用于拦截
//            logger.info("生成的session_id:{}",request.getSession().getId());
            return "welcome";
        }
    }

    //跳转注册页
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    //注册操作
    @RequestMapping("/register")
    public String register(UserInfo user) {
        logger.info("注册操作：{}",user);
        UserInfoEntity entity = new UserInfoEntity();
        entity.setCode("P0");
        entity.setName(user.getUserName());
        entity.setPassword(user.getPassWord());
        userInfoMapper.insert(entity);
        return "login";
    }

    //测试未登陆拦截页面
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    //退出登录
    @RequestMapping("/outUser")
    public String outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
//        response.sendRedirect("/login");
        return "login";
    }

    @RequestMapping("/session")
    @ResponseBody
    public String showSession(HttpServletRequest request) {
        Object session_user = request.getSession().getAttribute("session_user");
        logger.info(String.valueOf(session_user));
        return String.valueOf(session_user);
    }
}