package com.demo.yunshucheliangxinxi.mapper;

import com.demo.yunshucheliangxinxi.domain.Ysclxx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface YsclxxMapper {

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
