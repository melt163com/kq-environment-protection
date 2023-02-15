package com.demo.tree.mapper;

import com.demo.tree.domain.TreeStructure;

import java.util.List;

public interface TreeStructureMapper {
  /**
   * /**
   * 	*	子级节点
   *    **/
  List<TreeStructure> selectAll();


  public Integer selectLevel();
}
