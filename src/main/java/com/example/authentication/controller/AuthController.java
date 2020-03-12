package com.example.authentication.controller;/**
 * @author: ait
 * @date: 2020/3/12 21:20
 * @description:
 */

import com.example.authentication.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project   : authentication
 * @className : AuthController
 * @author    : ait
 * @time      : 2020年03月12日 21:20
 * @desc      : AuthController
 **/
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/getData/{id}")
    public String getData(@PathVariable String id) {
        logger.info("GET请求取得ID:{}", id);
        return "请求成功";
    }

    @PostMapping("/post")
    public static String post() {
        return "请求成功！";
    }

    @GetMapping("/get")
    public String get() {
        authService.getInfo();
        return "请求成功！";
    }
}
