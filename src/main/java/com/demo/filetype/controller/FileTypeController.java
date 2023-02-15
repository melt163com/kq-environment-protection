package com.demo.filetype.controller;

import com.demo.filetype.domain.FileType;
import com.demo.filetype.service.FileTypeService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/fileType")
@Slf4j
public class FileTypeController {
    /**
     * 日志输出
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileTypeService fileTypeService;

    /**
     * 查询所有分类信息
     * 测试网址：http://localhost:9099/FileType/queryAll
     * @return fileTypes
     */
    @RequestMapping("/queryAll")
    public Result FileTypeInfo(){
        List<FileType> fileTypes = fileTypeService.FileTypeInfo();

        if(Objects.isNull(fileTypes)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(fileTypes);
        System.out.print(Result.ok().putData(fileTypes));
        return Result.ok().putData(fileTypes);
    }

    /**
     * 根据分类名称查询
     * 测试网址：http://localhost:9099/FileType/queryByTypeName?type_name=环保
     * @return fileTypes
     */
    @RequestMapping("/queryByTypeName")
    public Result FileTypeInfoByTypeName(String type_name){
        List<FileType> fileTypes = fileTypeService.FileTypeInfoByTypeName(type_name);

        if(Objects.isNull(fileTypes)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(fileTypes);
        System.out.print(Result.ok().putData(fileTypes));
        return Result.ok().putData(fileTypes);
    }

    /**
     * 新增分类
     * 测试网址：http://192.168.1.109:9099/FileType/insert?type_name=3&parent_classification=3&description=3
     * @return int
     */
    @RequestMapping("/insert")
    public Result InsertFileType(FileType fileType){
        fileType.setCreate_time(new Date());
        fileType.setCreator("测试");
        int i = fileTypeService.InsertFileType(fileType);
        if(Objects.isNull(i)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(i);
        System.out.print(Result.ok().putData(i));
        return Result.ok().putData(i);
    }

    /**
     * 编辑分类
     * 测试网址：http://192.168.1.109:9099/FileType/update?id=5&type_name=5&parent_classification=5&depth=5&description=5&2023-02-14T08:21:32.000%2B00:00
     * @return int
     */
    @RequestMapping("/update")
    public Result updateFileType(FileType fileType){
//        fileType.setCreate_time(new Date());
        int i = fileTypeService.updateFileType(fileType);
        if(Objects.isNull(i)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(i);
        System.out.print(Result.ok().putData(i));
        return Result.ok().putData(i);
    }

    /**
     * 删除分类
     * 测试网址：http://192.168.1.109:9099/FileType/delete?id=18
     * @return int
     */
    @RequestMapping("/delete")
    public Result deleteFileType(Integer id){
        int i = fileTypeService.deleteFileType(id);
        if(Objects.isNull(i)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(i);
        System.out.print(Result.ok().putData(i));
        return Result.ok().putData(i);
    }
}
