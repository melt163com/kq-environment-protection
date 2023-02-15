package com.demo.tree.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.tree.domain.TreeStructure;
import com.demo.tree.service.TreeStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.tree.DefaultMutableTreeNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/tree")
@RestController
public class TreeStructureController {


  @Autowired
  public TreeStructureService service;

  @RequestMapping("/tree")
  public void selectAll(){
    TreeStructure treeStructure = new TreeStructure();
    List<TreeStructure> treeStructureList = service.selectAll();
    System.out.println("这是表里数据看看查到没"+treeStructureList);

    //筛选出根类
    for (int i = 0; i < treeStructureList.size(); i++) {

      System.out.println("这是位置看看都查到没有" + treeStructureList.get(i).toString());

      if (treeStructureList.get(i).getPid() == 10) {
        System.out.println("z看看这个父功能 找到没>>>>>>>>>>"+treeStructureList.get(i).getPid());
        treeStructure = treeStructureList.get(i);
        System.out.println("这是根类++++》"+ treeStructure);

        break;
      }

      System.out.println("这是根类fsajfisjaifioasjf》"+ treeStructure);
    }
    //递归
    TreeStructure treeStructure1 = getTreeStructure(treeStructure, 10);

    System.out.println("这是递归+++++++"+treeStructure1);
    //转json
    String jsonTreeStructure = JSON.toJSONString(treeStructure1);


    System.out.println(jsonTreeStructure);
    //获取该树表的层级=pid的不同值的个数
    int cengJi = service.selectLevel();

    System.out.println("这是父功能的个数 不同的 说白了 看看有没有视频管理"+cengJi);
    //界面
    jFrame(treeStructure1,cengJi);



  }

  public TreeStructure getTreeStructure(TreeStructure area, Integer parentId) {
    //获取到所有的数据
    List<TreeStructure> areaList = service.selectAll();
    List<TreeStructure> childList = new ArrayList<>();

    //进行子结构设置
    for (int i = 0; i < areaList.size(); i++) {

      System.out.println("这是位置看看查到没有+++" + areaList.get(i).toString());

      if (areaList.get(i).getTree_type().equals(area.getPid())) {
        childList.add(areaList.get(i));

        System.out.println("这是集合里的数据看看有没有"+childList);

        System.out.println("都进来啥了"+ areaList);
      }
    }
    area.setChildList(childList);
    //中国-省-市-县-镇-村  一共6层 也就是说中国这个父节点的子节点的层级有五层
    int cengJi = service.selectLevel();
    parentId = parentId + 1;
    if (parentId < cengJi) {
      for (int i = 0; i < area.getChildList().size(); i++) {
        getTreeStructure(area.getChildList().get(i), parentId);
      }
    }
    return area;

  }

  public void jFrame(TreeStructure treeStructure, Integer cengJi){
    JFrame jFrame = new JFrame("树形结构");
    jFrame.setBounds(500, 400, 500, 400);
    JPanel panel = new JPanel(new BorderLayout());
    System.out.println(treeStructure);
    // 创建根节点
    DefaultMutableTreeNode root = new DefaultMutableTreeNode(treeStructure.getFname());
    //转为json对象
    JSONObject jsonObject = (JSONObject) JSON.toJSON(treeStructure);
    System.out.println(jsonObject);

    //第一层节点数
    int firstPoint = jsonObject.getJSONArray("childList").size();
    //获取第一层的集合
    List<TreeStructure> first = new ArrayList<TreeStructure>();
    for (int i = 0; i < firstPoint; i++) {
      JSONObject jsonObject1 = jsonObject.getJSONArray("childList").getJSONObject(i);
      TreeStructure treeStructure1 = JSON.toJavaObject(jsonObject1, TreeStructure.class);
      DefaultMutableTreeNode firstTree = new DefaultMutableTreeNode(treeStructure1.getFname());
      //创建第一级子节点
      root.add(firstTree);
      tree(treeStructure1,jsonObject1,firstTree);
      System.out.println(first);
    }
    // 使用根节点创建树组件
    JTree tree = new JTree(root);

    // 设置树显示根节点句柄
    tree.setShowsRootHandles(true);
    // 设置树节点可编辑
    tree.setEditable(true);
    // 创建滚动面板，包裹树
    JScrollPane scrollPane = new JScrollPane(tree);
    // 添加滚动面板内容面板
    panel.add(scrollPane, BorderLayout.CENTER);
    jFrame.setContentPane(panel);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.setVisible(true);

  }


  public void tree(TreeStructure treeStructure1, JSONObject jsonObject1,DefaultMutableTreeNode firstTree){
    if (treeStructure1.getChildList().size() != 0) {
      //第二层节点数
      int secondPoint = treeStructure1.getChildList().size();
      for (int j = 0; j < secondPoint; j++) {
        JSONObject jsonObject = jsonObject1.getJSONArray("childList").getJSONObject(j);
        TreeStructure treeStructure = JSON.toJavaObject(jsonObject, TreeStructure.class);
        DefaultMutableTreeNode tree = new DefaultMutableTreeNode(treeStructure.getFname());
        firstTree.add(tree);
        if (treeStructure.getChildList().size() != 10){
          tree(treeStructure, jsonObject, tree);
        }
      }
    }

  }

}
