package com.example.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.**.dao","com.example.**.*.dao","com.example..**.*.mapping"},sqlSessionFactoryRef = "sqlSessionFactory",sqlSessionTemplateRef="sqlSessionTemplate" )
public class AuthenticationApplication {

    private static Logger logger = LoggerFactory.getLogger(AuthenticationApplication.class);

    public static void main(String[] args) {
        logger.info("*****************  正在启动服务，请稍后。 *****************");
        try {
            SpringApplication.run(AuthenticationApplication.class, args);
            logger.info("*****************  HyErpApplication 服务启动成功！ *****************");
        } catch (Exception e) {
            logger.error("服务启动失败:{}",e.getMessage(),e);
        }
    }

}
