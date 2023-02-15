package com.demo.tree.service;

import com.demo.tree.domain.TreeStructure;

import java.util.List;

public interface TreeStructureService {

  /**
   * /**
   * 	*	子级节点
   *    **/
  List<TreeStructure> selectAll();


   Integer selectLevel();
}
