/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.joolun.cloud.upms.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joolun.cloud.common.core.util.R;
import com.joolun.cloud.upms.common.entity.Inveri;
import com.joolun.cloud.upms.common.entity.MerchantEnterprise;
import com.joolun.cloud.upms.common.entity.MerchantPersonage;
import com.joolun.cloud.upms.common.vo.InveriVo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 审核状态
 *
 * @author code generator
 * @date 2020-05-27 11:08:32
 */
public interface InveriService extends IService<Inveri> {

	/**
	 * 添加个人或企业入驻审核资料
	 * @param 审核信息
	 * @return R
	 */
	R saveMsg(InveriVo inveri);

	/**
	 * 获取属于自身审批的代理信息
	 * @param id 代理商id
	 * @return R
	 */
	R parentGetMsg(String id);

	/**
	 * 代理商审核入驻
	 * @param inveri 代理商审核信息
	 * @return R
	 */
	R parentCheck(Inveri inveri);

	/**
	 * 管理员审核入驻
	 * @param inveri 代理商审核信息
	 * @return R
	 */
	R adminCheck(Inveri inveri);

	/**
	 * 根据id删除入驻信息
	 * @param id
	 * @return
	 */
	R removeMsg(String id);


}
