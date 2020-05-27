/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.joolun.cloud.upms.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joolun.cloud.common.core.util.R;
import com.joolun.cloud.common.log.annotation.SysLog;
import com.joolun.cloud.upms.admin.service.MerchantEnterpriseService;
import com.joolun.cloud.upms.admin.service.MerchantPersonageService;
import com.joolun.cloud.upms.admin.service.SysUserService;
import com.joolun.cloud.upms.common.entity.Inveri;
import com.joolun.cloud.upms.admin.service.InveriService;
import com.joolun.cloud.upms.common.entity.MerchantEnterprise;
import com.joolun.cloud.upms.common.entity.MerchantPersonage;
import com.joolun.cloud.upms.common.entity.SysUser;
import com.joolun.cloud.upms.common.vo.InveriVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 审核状态
 *
 * @author code generator
 * @date 2020-05-27 11:08:32
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/inveri")
@Api(value = "inveri", tags = "审核状态管理")
public class InveriController {

    private final InveriService inveriService;

	/**
	 * 添加个人或企业入驻审核资料
	 * @param inveri 审核状态
	 * @return R
	 */
	@ApiOperation(value = "添加个人或企业入驻审核资料")
	@SysLog("添加个人或企业入驻审核资料")
	@PostMapping("/add")
	@PreAuthorize("@ato.hasAuthority('admin:inveri:add')")
	public R saveMsg(@RequestBody InveriVo inveri) {
		return inveriService.saveMsg(inveri);
	}

	/**
	 * 获取属于自身审批的代理信息
	 * @param id 代理商id
	 * @return R
	 */
	@ApiOperation(value = "获取属于自身审批的代理信息")
	@SysLog("获取属于自身审批的代理信息")
	@GetMapping("/getMsg/{id}")
	@PreAuthorize("@ato.hasAuthority('admin:inveri:getMsg')")
	public R parentGetMsg(@PathVariable("id") String id) {
		return inveriService.parentGetMsg(id);
	}

	/**
	 * 代理商审核入驻
	 * @param inveri 代理商审核信息
	 * @return R
	 */
	@ApiOperation(value = "代理商审核入驻")
	@SysLog("代理商审核入驻")
	@PostMapping("/checkParent")
	@PreAuthorize("@ato.hasAuthority('admin:inveri:checkParent')")
	public R parentCheck(@RequestBody Inveri inveri) {
		return inveriService.parentCheck(inveri);
	}

	/**
	 * 管理员审核入驻
	 * @param inveri 管理员审核信息
	 * @return R
	 */
	@ApiOperation(value = "管理员审核入驻")
	@SysLog("管理员审核入驻")
	@PostMapping("/checkAdmin")
	@PreAuthorize("@ato.hasAuthority('admin:inveri:checkAdmin')")
	public R adminCheck(@RequestBody Inveri inveri) {
		return inveriService.adminCheck(inveri);
	}

	/**
	 * 删除入驻信息
	 * @param id
	 * @return R
	 */
	@ApiOperation(value = "删除入驻信息")
	@SysLog("删除入驻信息")
	@GetMapping("/delete/{id}")
	@PreAuthorize("@ato.hasAuthority('admin:inveri:delete')")
	public R adminCheck(@PathVariable("id") String id) {
		return inveriService.removeMsg(id);
	}
}
