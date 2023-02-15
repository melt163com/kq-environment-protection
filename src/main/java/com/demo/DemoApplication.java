package com.demo;

import com.demo.login.domain.UserInfo;
import com.demo.login.mapper.UserInfoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("all")
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@MapperScan(basePackages={
  "com.demo.login.mapper",
  "com.demo.yunshucheliangxinxi.mapper",
  "com.demo.tree.mapper",
  "com.demo.video.mapper",
  "com.demo.filetype.mapper",
  "com.demo.policy.mapper"
})
public class DemoApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

  /**
   * todo:这俩玩意打包用
   * @param application
   * @return
   */
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(DemoApplication.class);
  }
  private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
    return builder.sources(DemoApplication.class);
  }

}
