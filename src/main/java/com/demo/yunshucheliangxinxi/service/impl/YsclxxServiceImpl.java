package com.demo.yunshucheliangxinxi.service.impl;

import com.demo.yunshucheliangxinxi.domain.Ysclxx;
import com.demo.yunshucheliangxinxi.mapper.YsclxxMapper;
import com.demo.yunshucheliangxinxi.service.YsclxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
@SuppressWarnings("all")
public class YsclxxServiceImpl implements YsclxxService {

  @Autowired
  private  YsclxxMapper ysclxxMapper;


  @Override
  public List<Ysclxx> CheLiangXinZheng(Ysclxx ysclxx) {

    System.out.println("+++++++++++++++++这是mapper"+ysclxxMapper.CheLiangXinZheng(ysclxx));


    return ysclxxMapper.CheLiangXinZheng(ysclxx);
  }

  @Override
  public Integer addCheLiang(Ysclxx ysclxx) {


    System.out.println("这是参数里面有啥"+ysclxx);
    return ysclxxMapper.addCheLiang(ysclxx);
  }
}
