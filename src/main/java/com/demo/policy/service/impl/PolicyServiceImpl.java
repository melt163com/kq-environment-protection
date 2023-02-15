package com.demo.policy.service.impl;

import com.demo.policy.domain.Policy;
import com.demo.policy.mapper.PolicyMapper;
import com.demo.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyMapper policyMapper;

    @Override
    public List<Policy> PolicyInfo() {
        return policyMapper.PolicyInfo();
    }

    @Override
    public List<Policy> PolicyInfoByFileName(String file_name) {
        return policyMapper.PolicyInfoByFileName(file_name);
    }
}
