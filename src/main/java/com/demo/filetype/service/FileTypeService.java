package com.demo.filetype.service;

import com.demo.filetype.domain.FileType;

import java.util.List;

public interface FileTypeService {
    //    查询所有分类信息
    List<FileType> FileTypeInfo();

    //    根据分类名称查询
    List<FileType> FileTypeInfoByTypeName(String type_name);

    //    新增分类
    Integer InsertFileType(FileType fileType);

    //    编辑分类
    Integer updateFileType(FileType FileType);

    //    删除分类
    Integer deleteFileType(Integer id);

}
