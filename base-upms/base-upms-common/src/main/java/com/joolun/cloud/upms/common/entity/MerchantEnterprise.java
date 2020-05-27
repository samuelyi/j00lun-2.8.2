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
 * 入驻企业信息
 *
 * @author code generator
 * @date 2020-05-27 11:08:28
 */
@Data
@TableName("merchant_enterprise")
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "入驻企业信息")
public class MerchantEnterprise extends Model<MerchantEnterprise> {
    private static final long serialVersionUID=1L;

    /**
     * 企业商铺id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "企业商铺id")
    private String id;
    /**
     * 企业商铺名称
     */
    @ApiModelProperty(value = "企业商铺名称")
    private String enterpriseName;
    /**
     * 公司全称
     */
    @ApiModelProperty(value = "公司全称")
    private String enterpriseUsername;
    /**
     * 营业执照
     */
    @ApiModelProperty(value = "营业执照")
    private String businesslicenseId;
    /**
     * 执照开始时间
     */
    @ApiModelProperty(value = "执照开始时间")
    private LocalDateTime businesslicenseStarttime;
    /**
     * 执照最后有效时间
     */
    @ApiModelProperty(value = "执照最后有效时间")
    private LocalDateTime businesslicenseEndtime;
    /**
     * 法人身份证号
     */
    @ApiModelProperty(value = "法人身份证号")
    private String enterpriseIdcard;
    /**
     * 法人姓名
     */
    @ApiModelProperty(value = "法人姓名")
    private String enterpriseIdcardName;
    /**
     * 身份证正面
     */
    @ApiModelProperty(value = "身份证正面")
    private String enterpriseIdcardFront;
    /**
     * 身份证反面
     */
    @ApiModelProperty(value = "身份证反面")
    private String enterpriseIdcardReverse;
    /**
     * 法人联系方式
     */
    @ApiModelProperty(value = "法人联系方式")
    private String mobileno;
    /**
     * 开户许可证
     */
    @ApiModelProperty(value = "开户许可证")
    private String lfoa;
    /**
     * 企业详细地址
     */
    @ApiModelProperty(value = "企业详细地址")
    private String address;
    /**
     * 银行名称
     */
    @ApiModelProperty(value = "银行名称")
    private String bankname;
    /**
     * 银行账户
     */
    @ApiModelProperty(value = "银行账户")
    private String bankaccountno;
    /**
     * 开户地址
     */
    @ApiModelProperty(value = "开户地址")
    private String bankaddress;
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
