package com.demo.util;

//import com.chinasoft.newExtranet.systemEnum.SystemEnums;
//import com.github.pagehelper.PageInfo;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * todo: 返回结果类
 * @author :Ws
 * @Auther: Ws
 * @Date: 2023/02/09/10:26
 * @Description:
 */
@SuppressWarnings("all")
public class Result extends HashMap<String,Object> {



    /**
     * 单例
     */
    private static Result r=null;

    public Result() {
        put("code", 200);
        put("msg","success");
    }

    /**
     * todo：获取对象
     * @return
     */
    public static synchronized Result  ok(){
        return r==null?new Result():r;
    }

    /**
     * todo: 调用错误
     * @return
     */
    public static Result error(){
        return error(500,"系统异常请联系管理员");
    }

    /**
     * todo：返回错误
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg){
        Result ok = new Result();
        ok.put("code",code);
        ok.put("msg",msg);
        return ok;
    }
//    /**
//     * todo：返回分页数据结果
//     * @param list
//     * @return
//     */
//    public Result putPage(List list){
//        super.put("pageInfo", new  PageInfo (list));
//        return this;
//    }

    /**
     * todo：返回数据JSON
     * @param list
     * @return
     */
    public Result putData(Object object){
        super.put("data",object);
        return this;
    }

}
