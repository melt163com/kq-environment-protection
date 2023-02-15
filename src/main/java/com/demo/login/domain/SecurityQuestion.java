package com.demo.login.domain;

import lombok.Data;

/**
  * Created with IntelliJ IDEA.
  * 密保问题类
  *
  * @author 15015
  * @Auther: Ws
  * @Date: 2023/02/18/9:32
  * @Description:
  */
@Data
public class SecurityQuestion {
  /**
   * uuid
   */
  private Integer uuid;
  /**
   * 密保问题
   */
  private String question;

}
