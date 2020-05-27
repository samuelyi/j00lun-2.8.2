/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.joolun.cloud.upms.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

/**
 * 审核状态
 *
 * @author code generator
 * @date 2020-05-27 11:08:32
 */
@Data
@TableName("inveri")
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "审核状态")
public class Inveri extends Model<Inveri> {
    private static final long serialVersionUID=1L;

    /**
     * 申请id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "申请id")
    private String id;
    /**
     * 申请日期
     */
    @ApiModelProperty(value = "申请日期")
    private LocalDateTime applyTime;
    /**
     * 商户类型
     */
    @ApiModelProperty(value = "商户类型")
    private String merchantType;
    /**
     * 经营种类
     */
    @ApiModelProperty(value = "经营种类")
    private String businesType;
    /**
     * 抽成
     */
    @ApiModelProperty(value = "抽成")
    private String commission;
    /**
     * 商铺类型
     */
    @ApiModelProperty(value = "商铺类型")
    private String shopType;
    /**
     * 经营品牌
     */
    @ApiModelProperty(value = "经营品牌")
    private String brandBusiness;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String msg;
    /**
     * 所属代理商
     */
    @ApiModelProperty(value = "所属代理商")
    private String parentId;
    /**
     * 更新日期
     */
    @ApiModelProperty(value = "更新日期")
    private LocalDateTime updatetime;
    /**
     * 代理商意见
     */
    @ApiModelProperty(value = "代理商意见")
    private String parentIdea;
    /**
     * 0:未审核；1：审核通过；2：审核未通过
     */
    @ApiModelProperty(value = "0:未审核；1：审核通过；2：审核未通过")
    private Integer parentState;
    /**
     * 管理员意见
     */
    @ApiModelProperty(value = "管理员意见")
    private String adminIdea;
    /**
     * 0:未审核；1：审核通过；2：审核未通过
     */
    @ApiModelProperty(value = "0:未审核；1：审核通过；2：审核未通过")
    private Integer adminState;

}
