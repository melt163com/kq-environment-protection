package com.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * todo:配置类
 * @author TDY
 * @Auther: TongDeYi
 * @Date: 2022/05/12/10:17
 * @Description:
 */
@SuppressWarnings("all")
@Configuration
public class ShareWebAppConfigurer implements WebMvcConfigurer {
    /**
     * 注册拦截器
     * @param registry
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //默认拦截所有路径
//        registry.addInterceptor(authenticationInterceptor())
//                .addPathPatterns("/login");
//    }

    /**
     * 注入拦截器对象
     * @return
     */
//    @Bean
//    public HandlerInterceptor authenticationInterceptor() {
//        return new JwtAuthenticationInterceptor();
//    }


    /**
     * 验证码配置bean
     * @return
     */
//    @Bean
//    public DefaultKaptcha getDefaultKaptcha(){
//        DefaultKaptcha defaultKaptcha=new DefaultKaptcha();
//        Properties properties=new Properties();
//        //是否有边框
//        properties.setProperty(Constants.KAPTCHA_BORDER,"yes");
//        //验证码文本颜色
//        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR,"blue");
//        //验证码图片宽度
//        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH,"160");
//        //验证码图片高度
//        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT,"50");
//        //文本字符大小
//        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE,"28");
//        //验证码session的值
//        properties.setProperty(Constants.KAPTCHA_SESSION_CONFIG_KEY,"kaptchaCode");
//        //验证码文本长度
//        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH,"6");
//        //字体
//        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
//        Config config = new Config(properties);
//        defaultKaptcha.setConfig(config);
//        return defaultKaptcha;
//    }


    //设置字符编码集
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(
                StandardCharsets.UTF_8);
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

}
