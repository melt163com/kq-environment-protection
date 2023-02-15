package com.demo.systemEnum;

/**
 * Created with IntelliJ IDEA.
 * todo:枚举
 * @author 15015
 * @Auther: Ws
 * @Date: 20223/02/12/14:56
 * @Description:
 */
@SuppressWarnings("all")
public class SystemEnums {
    /**
     * 操作失败错误
     */
    public static final Integer OPERATION =400;
    /**
     * 参数不可为空
     */
    public static final String  PARAMSISNULL ="参数不可为空";
    /**
     * 接口访问成功code
     */
    public static final Integer SUCCESSCODE =200;
    /**
     * jwt密钥
     */
    public static final String JWTSALCODE ="HelloLehr";
    /**
     * token 未登录
     */
    public static final Integer TOKENCODE1 =401;
    public static final String TOKENCODE1MSG ="权限不足";
    /**
     * token 错误
     */
    public static final Integer TOKENCODE2 =402;
    public static final String TOKENCODE2MSG ="token错误";
    /**
     * token 空
     */
    public static final Integer TOKENCODE3 =403;
    public static final String TOKENCODE3MSG ="token为空";
    /**
     * 验证码
     */
    public static final Integer VERIFICATION_CODE =405;
    public static final String VERIFICATION_MSG ="验证码错误";
    public static final Integer VERIFICATION_CODE1 =406;
    public static final String VERIFICATION_MSG1 ="验证码为空";
    /**
     * 注册code
     */
    public static final String REGISTERMSG1 ="注册失败,账号已存在";
    public static final String REGISTERMSG2 ="参数不符合要求";
    /**
     * 修改密码
     */
    public static final String UPDATEPWD_MSG ="修改失败，请检查密码是否符合规范";

}
