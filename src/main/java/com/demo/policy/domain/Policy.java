package com.demo.policy.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Policy {

//    序号
    private Integer id;

//    文件名称
    private String file_name;

//    文件分类
    private String document_classification;

//    发布日期
    private Date release_date;

//    实施日期
    private Date implementation_date;

//    上传人
    private String uploader;

//    文件解析
    private String file_resolution;
}










