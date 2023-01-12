package com.li.graduation.vod.controller;


import com.li.graduation.model.vod.Video;
import com.li.graduation.result.ResultUtils;
import com.li.graduation.vod.service.VideoService;
import com.li.graduation.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author chenshy
 * @since 2022-08-11
 */
@Api(tags = "课程小结（课时）")
@RestController
@RequestMapping(value = "/admin/vod/video")
public class VideoController {
    @Resource
    private VideoService videoService;

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public ResultUtils get(@PathVariable Long id) {
        Video video = videoService.getById(id);
        return ResultUtils.ok(video);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public ResultUtils save(@RequestBody Video video) {
        videoService.save(video);
        return ResultUtils.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public ResultUtils updateById(@RequestBody Video video) {
        String videoSourceId = video.getVideoSourceId();
        System.out.println("videoSourceId ==========================> " + videoSourceId);
        videoService.updateById(video);
        return ResultUtils.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public ResultUtils remove(@PathVariable Long id) {
        videoService.removeById(id);
        return ResultUtils.ok();
    }
}

