/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.joolun.cloud.mall.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joolun.cloud.common.core.util.R;
import com.joolun.cloud.common.log.annotation.SysLog;
import com.joolun.cloud.mall.admin.service.GoodsCategoryUserService;
import com.joolun.cloud.mall.common.entity.GoodsCategoryUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 租户商品分类表
 *
 * @author code generator
 * @date 2020-05-23 14:04:52
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/goodscategoryuser")
@Api(value = "goodscategoryuser", tags = "租户商品分类表管理")
public class GoodsCategoryUserController {

    private final GoodsCategoryUserService goodsCategoryUserService;

    /**
     * 分页列表
     * @param page 分页对象
     * @param goodsCategoryUser 租户商品分类表
     * @return
     */
    @ApiOperation(value = "分页列表")
    @GetMapping("/page")
    @PreAuthorize("@ato.hasAuthority('generator:goodscategoryuser:index')")
    public R getPage(Page page, GoodsCategoryUser goodsCategoryUser) {
        return R.ok(goodsCategoryUserService.page(page, Wrappers.query(goodsCategoryUser)));
    }

    /**
     * 租户商品分类表查询
     * @param id
     * @return R
     */
    @ApiOperation(value = "租户商品分类表查询")
    @GetMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('generator:goodscategoryuser:get')")
    public R getById(@PathVariable("id") String id) {
        return R.ok(goodsCategoryUserService.getById(id));
    }

    /**
     * 租户商品分类表新增
     * @param goodsCategoryUser 租户商品分类表
     * @return R
     */
    @ApiOperation(value = "租户商品分类表新增")
    @SysLog("新增租户商品分类表")
    @PostMapping
    @PreAuthorize("@ato.hasAuthority('generator:goodscategoryuser:add')")
    public R save(@RequestBody GoodsCategoryUser goodsCategoryUser) {
        return R.ok(goodsCategoryUserService.save(goodsCategoryUser));
    }

    /**
     * 租户商品分类表修改
     * @param goodsCategoryUser 租户商品分类表
     * @return R
     */
    @ApiOperation(value = "租户商品分类表修改")
    @SysLog("修改租户商品分类表")
    @PutMapping
    @PreAuthorize("@ato.hasAuthority('generator:goodscategoryuser:edit')")
    public R updateById(@RequestBody GoodsCategoryUser goodsCategoryUser) {
        return R.ok(goodsCategoryUserService.updateById(goodsCategoryUser));
    }

    /**
     * 租户商品分类表删除
     * @param id
     * @return R
     */
    @ApiOperation(value = "租户商品分类表删除")
    @SysLog("删除租户商品分类表")
    @DeleteMapping("/{id}")
    @PreAuthorize("@ato.hasAuthority('generator:goodscategoryuser:del')")
    public R removeById(@PathVariable String id) {
        return R.ok(goodsCategoryUserService.removeById(id));
    }

}
