package com.demo.tree.service.impl;

import com.demo.tree.domain.TreeStructure;
import com.demo.tree.mapper.TreeStructureMapper;
import com.demo.tree.service.TreeStructureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("all")
public class TreeStructureServiceImpl implements TreeStructureService {


  @Autowired
  private TreeStructureMapper treeStructureMapper;

  @Override
  public List<TreeStructure> selectAll() {

    List<TreeStructure> treeStructureList = treeStructureMapper.selectAll();
    return treeStructureList;
  }

  @Override
  public Integer selectLevel() {

    Integer cengJi = treeStructureMapper.selectLevel();
    return cengJi;
  }
}
