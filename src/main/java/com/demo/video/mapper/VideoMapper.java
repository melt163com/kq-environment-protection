package com.demo.video.mapper;

import com.demo.video.domain.Video;

import java.util.List;

public interface VideoMapper {

//    查询所有视频信息
    List<Video> videoInfo();

//    根据检测点名称查询
    List<Video> videoInfoByPointName(String monitoring_point_name);

//    根据摄像头名称查询
    List<Video> videoInfoByCameraName(String camera_name);
}
