package com.demo.policy.service;

import com.demo.policy.domain.Policy;

import java.util.List;

public interface PolicyService {

    //    查询所有政策法规
    List<Policy> PolicyInfo();

    //    根据文件名称查询
    List<Policy> PolicyInfoByFileName(String file_name);
}

