/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.joolun.cloud.mall.admin.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joolun.cloud.mall.common.entity.Material;
import com.joolun.cloud.mall.common.entity.MaterialGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 素材
 *
 * @author JL
 * @date 2019-10-26 19:23:45
 */
public interface MaterialMapper extends BaseMapper<Material> {

	/**
	 * 素材库查询
	 * @param page
	 * @return
	 */
	@SqlParser(filter = true)
	IPage<Material> selectPageVo(Page<Material> page);


	/**
	 * 根据分组ID查询素材库
	 * @param page
	 * @param groupId
	 * @return
	 */
	@SqlParser(filter = true)
	IPage<Material> selectPageByGroupIdVo(@Param("page") Page<Material> page, @Param("groupId") String groupId);
}
