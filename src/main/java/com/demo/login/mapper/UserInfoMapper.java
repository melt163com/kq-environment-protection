package com.demo.login.mapper;

import com.demo.login.domain.SecurityQuestion;
import com.demo.login.domain.UserInfo;
import com.demo.util.Result;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;
@SuppressWarnings("all")
public interface UserInfoMapper {

  /**
   * 测试连接用
   * @return
   */
  List<Map<Object,Object>> testSelect();

  /**
   * 用户注册
   * @param userInfo
   * @return
   */
  Integer register(UserInfo userInfo);

  /**
   * 根据账号查询
   * 用途：用做查看账号是否已经纯在
   * @param userInfo
   * @return
   */
  UserInfo selectUserInfoByAccountNumber(UserInfo userInfo);

  /**
   * 根据账号更改密码
   * @param userInfo
   * @return
   */
  Integer updateUserInfoByAccountNumber(UserInfo userInfo);

}
