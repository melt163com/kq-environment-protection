package com.demo.login.controller;

import com.demo.comment.PassToken;
import com.demo.login.service.UserInfoService;
import com.demo.systemEnum.SystemEnums;
import com.demo.util.JwtUtils;
import com.demo.util.Result;
import com.demo.login.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@SuppressWarnings("all")
@RestController
@RequestMapping("/userInfo")
@Slf4j
public class UserInfoController {

  /**
   * 日志输出
   */
  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserInfoService userInfoService;

  /**
   * 注册
   *
   * @param userInfo
   * @return
   */
  @RequestMapping("/register")
  public Result register(UserInfo userInfo,HttpServletRequest request) {
//    UserInfo getUser = (UserInfo)request.getAttribute("getUser");
////    System.out.println(getUser);
////    log.info("这是getUser->{}",getUser);
    Integer register = userInfoService.register(userInfo);
          if (register == 1) {
      return Result.ok();
    } else if (register == 3) {
      return Result.error();
    } else if (register == 4) {
      return Result.error();
    } else {
      return Result.error();
    }
  }

  /**
   * 更改密码
   *
   * @param userInfo
   * @return
   */
  @RequestMapping("/updatePwd")
  @PassToken
  public Result updatePwd(UserInfo userInfo,String newPwd) throws Exception {

    log.info("这是userInfo->{}",userInfo);

    Integer integer = userInfoService.updateUserInfoByAccountNumber(userInfo);

    if (integer == 1) {
      return Result.ok();
    } else {
      return Result.error(400,"修改失败，请检查密码是否符合规范");
    }
  }




  @RequestMapping("/login")
  @PassToken
  public Result login(UserInfo userInfo, HttpServletRequest request) {
//      1.查看账号是否存在,如果存在验证密码，否者返回登陆失败告知前端账号不存在;

    userInfo.setUsernumber(userInfo.getUsernumber());
    userInfo.setUserpwd(userInfo.getUserpwd());
//    验证账号是否存在
    UserInfo userInfo1 = userInfoService.selectUserInfoByAccountNumber(userInfo);
  if(Objects.isNull(userInfo1)){

    return Result.error(403,"账号不存在，请检查账号是否正确");
  }
    System.out.print("+++++++++++++++++++++++++======="+userInfo1);

    if (userInfo1 != null) {
      String libraryHmac = userInfo.getUserpwd();
      if (libraryHmac.equals(userInfo1.getUserpwd())) {
        System.out.print("++++++11111111+++++======="+userInfo1);

        log.info("密码正确，进行配置token");
        String token = JwtUtils.createToken(userInfo1.getUsernumber());

        System.out.print("+++++++++++++++++++>>>>>>>>>========"+JwtUtils.createToken(userInfo1.getUsernumber()));
        userInfo1.setToken(token);
        userInfo1.setSpare2("");
        userInfo1.setUserpwd("");
        log.info("登录成功");
        return Result.ok().putData(userInfo1);

      }else {
        return Result.error(409,"密码错误，请检查密码是否正确");
      }



    }
    return Result.error(SystemEnums.OPERATION, "登陆失败，请检查账号密码");
  }
}

