package com.demo.video.service.impl;

import com.demo.video.domain.Video;
import com.demo.video.mapper.VideoMapper;
import com.demo.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> videoInfo() {
        return videoMapper.videoInfo();
    }

    @Override
    public List<Video> videoInfoByPointName(String monitoring_point_name) {
        return videoMapper.videoInfoByPointName(monitoring_point_name);
    }

    @Override
    public List<Video> videoInfoByCameraName(String camera_name) {
        return videoMapper.videoInfoByCameraName(camera_name);
    }
}
