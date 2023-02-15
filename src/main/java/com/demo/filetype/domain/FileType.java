package com.demo.filetype.domain;

import lombok.Data;

import java.util.Date;

@Data
public class FileType {
//    序号
    private int id;
//    分类名称
    private String type_name;
//    父级分类
    private String parent_classification;
//    深度
    private int depth;
//    描述
    private String description;
//    创建人
    private String creator;
//    创建时间
    private Date create_time;
}
