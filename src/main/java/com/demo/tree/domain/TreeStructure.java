package com.demo.tree.domain;

import lombok.Data;

import java.util.List;

@Data
public class TreeStructure {
  /**
   * 功能编号
   */
  private Integer fid;
  /**
   * 父功能编号
   */
  private Integer pid;
  /**
   * 父功能名称
   */
  private String fname;
  /**
   * 子节点
   */
  private Integer tree_type;


  private List<TreeStructure> childList;
}
