package com.demo.login.service.impl;

import com.demo.comment.PassToken;
import com.demo.login.domain.UserInfo;
import com.demo.login.mapper.UserInfoMapper;
import com.demo.login.service.UserInfoService;
import com.demo.util.StringFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("all")
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  private UserInfoMapper userInfoMapper;


  @Override
  public List<Map<Object, Object>> testSelect() {
    return null;
  }

  @Override
  @PassToken
  public Integer register(UserInfo userInfo) {
    System.out.println(userInfo);
    return userInfoMapper.register(userInfo);
  }

  @Override
  public UserInfo selectUserInfoByAccountNumber(UserInfo userInfo) {
    System.out.println(userInfo);
    return userInfoMapper.selectUserInfoByAccountNumber(userInfo);
  }

//  @Override
//  public Object modifyPassword(String userpwd, String newuserword, String usernumber, HttpSession session) {
//    Map<String,Object> map=new HashMap<String, Object>();
//
//    if(userpwd!=null){
////       前端传过来的密码进行加密处理，如果你的数据用的是md5加密的话，需要进行一下加密，因为你前端传过来的是明文，数据库密码是经过加密的然后进行查询，
//      //   String passwords=MD5Encode.encode(password);
//      //  User user=userMapper.selectBypassword(passwords,username);
//      UserInfo user=userInfoMapper.selectBypassword(userpwd,usernumber);
//
//      Integer id=user.getUid();
//
//      String yspassword=user.getUserpwd();
//
//      if(yspassword.equals(userpwd)){
//        UserInfo u=new UserInfo();
//        u.setUid(id);
//
//        u.setUserpwd(newuserword);
//        return userInfoMapper.updateByPrimaryKeySelective(u);
//      }
//
//
//      return 0;
//
//  }

  @Override
  public Integer updateUserInfoByAccountNumber(UserInfo userInfo) {
    UserInfo userinfo2 = userInfoMapper.selectUserInfoByAccountNumber(userInfo);
    System.out.println(userInfo.getUserpwd() + "这是userInfo.getUserpwd()");
//    要求用户密码难度高点
    if (!StringFilter.inspectString1(userInfo.getUserpwd())) {
      System.out.print("++++++++++++++++++++" + userInfo.getUserpwd());
      return 4;
    }
    System.out.println(StringFilter.inspectString1(userInfo.getUserpwd()));


    String userpwd1 = userInfo.getUserpwd();

    if (userpwd1.equals(userinfo2.getUserpwd())) {
      return userInfoMapper.updateUserInfoByAccountNumber(userInfo);
    }
    return 4;
//    return 1;
  }


}
