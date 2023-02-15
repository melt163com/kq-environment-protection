package com.demo.config;

import com.demo.comment.ErrorReturnPageException;
import com.demo.comment.PassToken;
import com.demo.login.domain.UserInfo;
import com.demo.login.service.UserInfoService;
import com.demo.systemEnum.SystemEnums;
import com.demo.util.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tdy
 * @Auther: TongDeYi
 * @Date: 2021/07/13/8:51
 * @Description: 拦截器
 */
@SuppressWarnings("all")
public class JwtAuthenticationInterceptor implements HandlerInterceptor {
    /**
     * 日志输出
     */
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    UserInfoService userInfoService;

    /**
     * 拦截器
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        //从请求头中取出token 这里需要和前端约定好 把jwt放到请求头一个叫token的地方
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注节，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                logger.info("不需要验证，直接放行!!!");
                return true;
            }
        } else {
            //否者进入验证token环节
            logger.info("被jwt拦截，需要验证！");
            if (token == null) {
            throw new ErrorReturnPageException(SystemEnums.TOKENCODE3MSG, SystemEnums.TOKENCODE3);
          }
//            logger.info("令牌：" + token);
            //获取 token中的 user name  获取签发对象
            String account;
            account = JwtUtils.getAudience(token);
            try {
                account = JwtUtils.getAudience(token);
            } catch (Exception e) {
//                response.getWriter().println(JSON.toJSON(Result.error(SystemEnums.TOKENCODE1, SystemEnums.TOKENCODE1MSG)));
                throw new ErrorReturnPageException(SystemEnums.TOKENCODE2MSG, SystemEnums.TOKENCODE2);
            }
            //验证token
            Boolean aBoolean = JwtUtils.verifyToken(token, account);
            System.out.println(aBoolean);
            if (!aBoolean) {
                throw new ErrorReturnPageException(SystemEnums.TOKENCODE2MSG, SystemEnums.TOKENCODE2);
            }
            UserInfo userInfo = new UserInfo();
            userInfo.setUsernumber(account);
            UserInfo user = userInfoService.selectUserInfoByAccountNumber(userInfo);
//            //获取载荷内容
//            String userName = JwtUtils.getClaimByName(token, "userName").asString();
//            //盐
//            String sal = JwtUtils.getClaimByName(token, "sal").asString();
            user.setToken(token);
            request.setAttribute("getUser", user);
            request.setAttribute("userId", user.getUid());
            logger.info("token验证通过");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
