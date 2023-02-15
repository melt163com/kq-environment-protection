package com.demo.video.controller;

import com.demo.video.domain.Video;
import com.demo.video.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.util.Result;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/video")
@Slf4j
@CrossOrigin
public class VideoController {
    /**
     * 日志输出
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private VideoService videoService;

    /**
     * 查询所有视频信息
     * 测试网址：http://localhost:9099/video/queryAll
     * @return videos
     */
    @RequestMapping("/queryAll")
    public Result videoInfo(){
        List<Video> videos = videoService.videoInfo();

        if(Objects.isNull(videos)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(videos);
        System.out.print(Result.ok().putData(videos));
        return Result.ok().putData(videos);
    }

    /**
     * 根据检测点名称查询
     * 测试网址：http://localhost:9099/video/queryByPointName?monitoring_point_name=华晨宝马铁西工厂一号门1号
     * @return videos
     */
    @RequestMapping("/queryByPointName")
    public Result videoInfoByPointName(String monitoring_point_name){
        List<Video> videos = videoService.videoInfoByPointName(monitoring_point_name);

        if(Objects.isNull(videos)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(videos);
        System.out.print(Result.ok().putData(videos));
        return Result.ok().putData(videos);
    }

    /**
     * 根据摄像头名称查询
     * 测试网址：http://localhost:9099/video/queryByCameraName?camera_name=MGF22661VL
     * @return videos
     */
    @RequestMapping("/queryByCameraName")
    public Result videoInfoByCameraName(String camera_name){
        List<Video> videos = videoService.videoInfoByCameraName(camera_name);

        if(Objects.isNull(videos)){
            return Result.error();
        }
        // Result.ok() 生成实例对象、  putData(vehicles) 加入想返回给前端得对象vehicles
        Result.ok().putData(videos);
        System.out.print(Result.ok().putData(videos));
        return Result.ok().putData(videos);
    }
}
