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
 * 入驻个人
 *
 * @author code generator
 * @date 2020-05-27 11:08:30
 */
@Data
@TableName("merchant_personage")
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "入驻个人")
public class MerchantPersonage extends Model<MerchantPersonage> {
    private static final long serialVersionUID=1L;

    /**
     * 个人商铺id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "个人商铺id")
    private String id;
    /**
     * 个人商铺名称
     */
    @ApiModelProperty(value = "个人商铺名称")
    private String personageName;
    /**
     * 个人商铺用户名称
     */
    @ApiModelProperty(value = "个人商铺用户名称")
    private String personageUsername;
    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    private String personageIdcard;
    /**
     * 身份证正面
     */
    @ApiModelProperty(value = "身份证正面")
    private String personageIdcardFront;
    /**
     * 身份证反面
     */
    @ApiModelProperty(value = "身份证反面")
    private String personageIdcardReverse;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;
    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    private String mobileno;
    /**
     * 银行名称
     */
    @ApiModelProperty(value = "银行名称")
    private String bankname;
    /**
     * 银行卡号
     */
    @ApiModelProperty(value = "银行卡号")
    private String bankaccountno;
    /**
     * 开户地址
     */
    @ApiModelProperty(value = "开户地址")
    private String bankaddress;
    /**
     * 银行卡正面
     */
    @ApiModelProperty(value = "银行卡正面")
    private String bankImgFront;
    /**
     * 银行卡反面
     */
    @ApiModelProperty(value = "银行卡反面")
    private String bankImgReverse;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatetime;

}
