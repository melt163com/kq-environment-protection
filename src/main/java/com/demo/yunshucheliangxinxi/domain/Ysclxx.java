package com.demo.yunshucheliangxinxi.domain;

import lombok.Data;
import org.apache.ibatis.ognl.ASTGreater;

import java.util.Date;

/**
 * 车辆信息
 */
@Data
public class Ysclxx {

  private Integer cl_id;

  private Integer cljinchu_type;
  private String cargo_type;
  private String cl_dengjishiyou;
  private String cl_tihuodanwei;
  private String cl_qiyundi;
  private String cl_huowushuliang;
  private String bumen_type;
  private String bumen_name;
  private String sj_name;
  private String sj_phone;
  private String sj_sfz;
  private String cl_cph;
  private String cl_cdmc;
  private String cl_cz;
  private String cl_dz;
  private String cl_ppxh;
  private String cl_sbm;
  private String cl_hdzzl;
  private String cl_fdjhm;
  private String cl_fdjxh;
  private Date zcrq;
  private Date fzrq;
  private Date obdanzhrq;
  private String obd;
  private YunShuCheXing cx_id;
  private YunShuChePaiYanSe cp_id;
  private YunShuCheLiangRanFang clrl_id;
  private YunShuCheLiangPaiFang clpf_id;
  private YunShuCheLiangShiYongXingZhi clsyxz_id;


}
