package com.demo.policy.controller;

import com.demo.policy.domain.Policy;
import com.demo.policy.service.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.util.Result;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/policy")
@Slf4j
public class PolicyController {
    /**
     * 日志输出
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PolicyService policyService;

    /**
     * 查询所有分类信息
     * 测试网址：http://localhost:9099/policy/queryAll
     * @return fileTypes
     */
    @RequestMapping("/queryAll")
    public Result PolicyInfo(){
        List<Policy> policies = policyService.PolicyInfo();

        if(Objects.isNull(policies)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(policies);
        System.out.print(Result.ok().putData(policies));
        return Result.ok().putData(policies);
    }

    /**
     * 根据分类名称查询
     * 测试网址：http://localhost:9099/policy/queryByFileName?
     * @return fileTypes
     */
    @RequestMapping("/queryByFileName")
    public Result PolicyInfoByFileName(String file_name){
        List<Policy> policies = policyService.PolicyInfoByFileName(file_name);

        if(Objects.isNull(policies)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(policies);
        System.out.print(Result.ok().putData(policies));
        return Result.ok().putData(policies);
    }
}
