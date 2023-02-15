package com.demo.login.domain;

import lombok.Data;

/**
 * 实体类
 */
@Data
public class UserInfo {

  private Integer uid;

  private String username;

  private String userpwd;

  private String usernumber;

  private String tel;

  private String token;

  private String sal;

  /**
   * 备用1
   */
  private Integer spare1;
  /**
   * 备用2
   */
  private String spare2;
  /**
   * 备用3
   */
  private String spare3;


//  /**
//   * 验证码
//   */
//  private String verificationCode;
//  /**
//   * 是否锁定 日期类型 yyyy-MM-dd HH:mm:ss
//   */
//  private String blockTime;
//  /**
//   * 问题类
//   */
//  private SecurityQuestion securityQuestion;
}
