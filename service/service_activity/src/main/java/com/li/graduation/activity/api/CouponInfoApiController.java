package com.li.graduation.activity.api;

import com.li.graduation.activity.service.CouponInfoService;
import com.li.graduation.activity.service.CouponUseService;
import com.li.graduation.model.activity.CouponInfo;
import com.li.graduation.model.activity.CouponUse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "优惠券接口")
@RestController
@RequestMapping("/api/activity/couponInfo")
public class CouponInfoApiController {
    @Resource
    private CouponInfoService couponInfoService;

    @ApiOperation(value = "获取优惠券")
    @GetMapping(value = "inner/getById/{couponId}")
    public CouponInfo getById(@PathVariable("couponId") Long couponId) {
        return couponInfoService.getById(couponId);
    }

    @ApiOperation(value = "更新优惠券状态")
    @GetMapping(value = "inner/updateCouponInfoUseStatus/{couponUseId}/{orderId}")
    public Boolean updateCouponInfoUseStatus(@PathVariable Long couponUseId, @PathVariable Long orderId) {
        Boolean result = couponInfoService.updateCouponInfoUseStatus(couponUseId, orderId);
        return result;
    }
}
