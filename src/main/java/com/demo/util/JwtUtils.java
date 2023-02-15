package com.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.demo.comment.PassToken;
import com.demo.systemEnum.SystemEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Date;

/**
 *  JWT工具类
 * @Auther: TongDeYi
 * @Date: 2022/05/12/10:53
 * @Description:
 */
@SuppressWarnings("all")
public class JwtUtils {

  @Value("${common.expirationtime}")
  private static Integer expirationTime;
    /**
     *  签发对象：这个用户的账号
     *  签发时间：系统时间
     *  有效时间：30分钟
     *  载荷内容：用户真实姓名，账号
     *  加密密钥：这个人的id加上盐
     * @param accountNumber
     * @param userName
     * @param userName
     * @return
     */
    public static String createToken(String usernumber){
        //设置签证有效时间
        Calendar nowTime = Calendar.getInstance();
        //有效期半个点
        nowTime.add(Calendar.MINUTE,30);
        Date time = nowTime.getTime();
        return JWT.create().withAudience(usernumber)//签发对象
                           .withIssuedAt(new Date())//发行时间
                           .withExpiresAt(time)//有效时间
                           .withClaim("userpwd",usernumber)//负荷 装载对象用的 多少都行
                           .sign(Algorithm.HMAC256(usernumber+ SystemEnums.JWTSALCODE)); // 盐加密
    }
    /**
     *  签发对象：这个用户的账号
     *  签发时间：系统时间
     *  有效时间：30分钟
     *  载荷内容：用户真实姓名，账号
     *  加密密钥：这个人的id加上盐
     * @param accountNumber
     * @param userName
     * @param userName
     * @return
     */
    public static String createTokenUpdatePwd(String usernumber){
        //设置签证有效时间
        Calendar nowTime = Calendar.getInstance();
        //有效期半个点
        nowTime.add(Calendar.MINUTE,30);
        Date time = nowTime.getTime();
        return JWT.create().withAudience(usernumber)//签发对象
                .withIssuedAt(new Date())//发行时间
                .withExpiresAt(time)//有效时间
                .sign(Algorithm.HMAC256(usernumber+ SystemEnums.JWTSALCODE)); // 盐加密
    }

    /**
     *  翻译 verify-确认
     *      secret-机密
     *  校验合法性，其中secret参数传入的是用户的账号
     * @param token
     * @param secret
     */
    public static Boolean verifyToken(String token,String secret){
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier=JWT.require(Algorithm.HMAC256(secret+SystemEnums.JWTSALCODE)).build();
            jwt = verifier.verify(token);
        }catch (Exception e){
            //校验失败，抛出异常
            return false;
//            throw e;
        }
        return true;
    }

    /**
     *  获取签发对象
     * @param token
     * @return
     */
    @PassToken
    public static String getAudience(String token){
        String audience=null;
        audience = JWT.decode(token).getAudience().get(0);
        return audience;
    }

    /**
     *  通过载荷名字获取载荷的值
     * @param token
     * @param name
     * @return
     */
    public static Claim getClaimByName(String token ,String name){
        return JWT.decode(token).getClaim(name);
    }


}
