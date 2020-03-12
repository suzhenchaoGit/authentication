package com.example.authentication.service;/**
 * @author: ait
 * @date: 2020/3/12 21:17
 * @description:
 */

import com.example.authentication.dao.MemberInfoEntityMapper;
import com.example.authentication.dao.UserInfoEntityMapper;
import com.example.authentication.entity.MemberInfoEntity;
import com.example.authentication.entity.UserInfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project   : authentication
 * @className : AuthService
 * @author    : ait
 * @time      : 2020年03月12日 21:17
 * @desc      : 数据库service
 **/
@Service
public class AuthService {
    @Autowired
    private MemberInfoEntityMapper memberInfoMapper;
    @Autowired
    private UserInfoEntityMapper userInfoMapper;

    private static Logger logger = LoggerFactory.getLogger(AuthService.class);

    public void getInfo() {
        List<UserInfoEntity> userInfoEntities = userInfoMapper.selectAll();
        List<MemberInfoEntity> memberInfoEntities = memberInfoMapper.selectAll();
        logger.info("userInfoEntities:{}",userInfoEntities.toString());
        logger.info("memberInfoEntities:{}",memberInfoEntities.toString());
    }
}
