package com.demo.video.domain;

import lombok.Data;

@Data
public class Video {
//    序号
    private int id;
//    监测点名称
    private String monitoring_point_name;
//    摄像头名称
    private String camera_name;
//    视频存储地址
    private String video_storage_address;
//    视频时长
    private String video_duration;


}
