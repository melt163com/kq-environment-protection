package com.demo.yunshucheliangxinxi.controller;


import com.demo.util.Result;
import com.demo.yunshucheliangxinxi.domain.Ysclxx;
import com.demo.yunshucheliangxinxi.service.YsclxxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("all")
@RestController
@RequestMapping("/ysclxx")
@Slf4j
public class YsclxxController {


  @Autowired
  private YsclxxService ysclxxService;


  @PostMapping("/clxxselect")
  public Result CheLiangXinZheng(Ysclxx ysclxx) {
    HashMap<String, Object> hm = new HashMap<>();
    List<Ysclxx> ysclxx1 = ysclxxService.CheLiangXinZheng(ysclxx);


    if (Objects.isNull(ysclxx1)) {
      return Result.error();
    }
    // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
    Result.ok().putData(ysclxx1);

    System.out.print(Result.ok().putData(ysclxx1));
    return Result.ok().putData(ysclxx1);
  }

  @PostMapping("/addclxx")
  public Result CheLiangXinZheng(Ysclxx ysclxx, HttpServletRequest request) {
    ysclxx.setZcrq(new Date());
    ysclxx.setFzrq(new Date());
    ysclxx.setObdanzhrq(new Date());


    int i = ysclxxService.addCheLiang(ysclxx);
    System.out.println("为何蚕食不对 你先看看"+ysclxxService.addCheLiang(ysclxx));
    if (Objects.isNull(i)) {
      return Result.error();

    }
    Result.ok().putData(i);
    System.out.print(Result.ok().putData(i));
    return Result.ok().putData(i);


  }
}
