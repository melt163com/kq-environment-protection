package com.demo.yunshucheliangxinxi.service;

import com.demo.yunshucheliangxinxi.domain.Ysclxx;

import java.util.List;

public interface YsclxxService {

  /**
   * 车辆新入厂 信息
   * @param ysclxx
   * @return
   */
  List<Ysclxx> CheLiangXinZheng(Ysclxx ysclxx);

  /**
   * 车辆入厂新增
   */
  Integer addCheLiang(Ysclxx ysclxx);
}
