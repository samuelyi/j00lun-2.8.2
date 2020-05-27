/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.joolun.cloud.upms.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.joolun.cloud.common.core.util.R;
import com.joolun.cloud.upms.admin.mapper.InveriMapper;
import com.joolun.cloud.upms.admin.mapper.MerchantEnterpriseMapper;
import com.joolun.cloud.upms.admin.mapper.MerchantPersonageMapper;
import com.joolun.cloud.upms.admin.mapper.SysUserMapper;
import com.joolun.cloud.upms.admin.service.InveriService;
import com.joolun.cloud.upms.common.entity.Inveri;
import com.joolun.cloud.upms.common.entity.MerchantEnterprise;
import com.joolun.cloud.upms.common.entity.MerchantPersonage;
import com.joolun.cloud.upms.common.entity.SysUser;
import com.joolun.cloud.upms.common.vo.InveriVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 审核状态
 *
 * @author code generator
 * @date 2020-05-27 11:08:32
 */
@Service
@AllArgsConstructor
public class InveriServiceImpl extends ServiceImpl<InveriMapper, Inveri> implements InveriService {

	private final InveriMapper inveriMapper;

	private final SysUserMapper sysUserMapper;

	private final MerchantEnterpriseMapper merchantEnterpriseMapper;

	private final MerchantPersonageMapper merchantPersonageMapper;

	/**
	 * 添加个人或企业入驻审核资料
	 * @param InveriVo 审核状态
	 * @return R
	 */
	@Override
	public R saveMsg(InveriVo inveri) {
		//默认代理商审核状态为 0
		//0个人入驻 1为企业入驻
		LocalDateTime localDateTime = LocalDateTime.now();
		getTime(inveri);
		if (inveri.getTypeId() == 0){
			//各自提供的入驻信息
			MerchantPersonage merchantPersonage = new MerchantPersonage();
			merchantPersonage.setPersonageName(inveri.getPersonageName());
			merchantPersonage.setPersonageUsername(inveri.getPersonageUsername());
			merchantPersonage.setPersonageIdcard(inveri.getPersonageIdcard());
			merchantPersonage.setPersonageIdcardFront(inveri.getPersonageIdcardFront());
			merchantPersonage.setPersonageIdcardReverse(inveri.getPersonageIdcardReverse());
			merchantPersonage.setAddress(inveri.getAddress());
			merchantPersonage.setMobileno(inveri.getMobileno());
			merchantPersonage.setBankname(inveri.getBankname());
			merchantPersonage.setBankaccountno(inveri.getBankaccountno());
			merchantPersonage.setBankaddress(inveri.getBankaddress());
			merchantPersonage.setBankImgFront(inveri.getBankImgFront());
			merchantPersonage.setBankImgReverse(inveri.getBankImgReverse());
			merchantPersonage.setCreatetime(localDateTime);
			merchantPersonage.setUpdatetime(localDateTime);
			merchantPersonageMapper.insert(merchantPersonage);
		}else {
			MerchantEnterprise merchantEnterprise = new MerchantEnterprise();
			merchantEnterprise.setEnterpriseName(inveri.getEnterpriseName());
			merchantEnterprise.setEnterpriseUsername(inveri.getEnterpriseUsername());
			merchantEnterprise.setBusinesslicenseId(inveri.getBusinesslicenseId());
			merchantEnterprise.setBusinesslicenseStarttime(inveri.getBusinesslicenseStarttime());
			merchantEnterprise.setBusinesslicenseEndtime(inveri.getBusinesslicenseEndtime());
			merchantEnterprise.setEnterpriseIdcard(inveri.getEnterpriseIdcard());
			merchantEnterprise.setEnterpriseIdcardName(inveri.getEnterpriseIdcardName());
			merchantEnterprise.setEnterpriseIdcardFront(inveri.getEnterpriseIdcardFront());
			merchantEnterprise.setEnterpriseIdcardReverse(inveri.getEnterpriseIdcardReverse());
			merchantEnterprise.setMobileno(inveri.getMobileno());
			merchantEnterprise.setLfoa(inveri.getLfoa());
			merchantEnterprise.setAddress(inveri.getAddress());
			merchantEnterprise.setBankname(inveri.getBankname());
			merchantEnterprise.setBankaccountno(inveri.getBankaccountno());
			merchantEnterprise.setBankaddress(inveri.getBankaddress());
			merchantEnterprise.setCreatetime(localDateTime);
			merchantEnterprise.setUpdatetime(localDateTime);
			merchantEnterpriseMapper.insert(merchantEnterprise);
		}
		return R.ok(inveriMapper.insert(inveri));
	}

	/**
	 * 获取属于自身审批的代理信息
	 * @param id 代理商id
	 * @return R
	 */
	@Override
	public R parentGetMsg(String id) {
		//这里是通过sysUser 通过用户id 查询他们的parentId  获取到自己管辖下的入驻商户信息
//		List<SysUser> list = sysUserMapper.selectList(new QueryWrapper<SysUser>().eq("tenant_id", id).ne("parent_id",0));
		HashMap<String, Object> hashMap = new HashMap<>();
		ArrayList<Object> inverList = new ArrayList<>();
		ArrayList<Object> enterList = new ArrayList<>();
		ArrayList<Object> personList = new ArrayList<>();
		List<SysUser> sons = sysUserMapper.getSon(id);

		for (SysUser sysUser : sons) {
			inverList.add(inveriMapper.selectById(sysUser.getId()));
			enterList.add(inveriMapper.selectById(sysUser.getId()));
			personList.add(merchantPersonageMapper.selectById(sysUser.getId()));
		}
		System.out.println(hashMap.size());
		hashMap.put("inver",inverList);
		hashMap.put("enter",enterList);
		hashMap.put("person",personList);
		//获取入驻的商户信息在 入驻审核表中
		return R.ok(hashMap);
	}

	/**
	 * 代理商审核入驻
	 * @param inveri 代理商审核信息
	 * @return R
	 */
	@Override
	public R parentCheck(Inveri inveri) {
		//从前台获取 代理商的审核信息 并通过被审核商户的id进行信息更新
		//如果 管理员已审核则 代理商不能再修改审核内容
//		List<Inveri> list = inveriMapper.selectList(new QueryWrapper<Inveri>().eq("admin_state", "0"));
//		for (Inveri inveri1 : list) {
//
//		}
//		Inveri one = inveriService.getOne(new QueryWrapper<Inveri>().eq("admin_state", inveri.getInveriId()));
//		Inveri byId = inveriMapper.selectById(inveri);
//		Integer adminState = byId.getAdminState();
//		if (adminState == 1){
//			return  R.failed("管理员已审核通过");
//		}
		getTime(inveri);
		return R.ok(inveriMapper.updateById(inveri));
	}

	/**
	 * 管理员审核入驻
	 * @param inveri 管理员审核信息
	 * @return R
	 */
	@Override
	public R adminCheck(Inveri inveri) {
//		//先查询代理商是否审核通过
//		Inveri byId = inveriMapper.selectById(inveriId);
//		//如果代理商未审核或审核失败 管理员不能对该企业进行审核  1为审核通过
//		if (byId.getParentState() != 1){
//			return R.failed("代理商未审核或审核未通过");
//		}
//		inveriMapper.updateById(inveri);
		getTime(inveri);
		return R.ok(inveriMapper.updateById(inveri));
	}

	@Override
	public R removeMsg(String id) {
		ArrayList<Object> list = new ArrayList<>();

		if (inveriMapper.deleteById(id) != 0){
			list.add("审核表删除成功");
		}
		if (merchantPersonageMapper.deleteById(id) != 0){
			list.add("个人入驻申请信息删除成功");
		}
		if (merchantEnterpriseMapper.deleteById(id) != 0){
			list.add("企业入驻申请信息删除成功");
		}

		return R.ok(list);
	}

	/**
	 * 获取时间公共类
	 * @param inveri
	 * @return
	 */
	public Inveri getTime(Inveri inveri){
		LocalDateTime localDateTime = LocalDateTime.now();
		inveri.setApplyTime(localDateTime);
		inveri.setUpdatetime(localDateTime);
		return inveri;
	}
}
