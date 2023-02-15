package com.demo.comment;

/**
 * Created with IntelliJ IDEA.
 * @author 15015
 * @Auther: TongDeYi
 * @Date: 2022/05/19/10:11
 * @Description: 自定义错误类
 */

public class ErrorReturnPageException extends RuntimeException{
    /**
     * 错误码
     */
    private int code;


    public ErrorReturnPageException() {
    }

    public ErrorReturnPageException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ErrorReturnPageException(String message) {
        super(message);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
