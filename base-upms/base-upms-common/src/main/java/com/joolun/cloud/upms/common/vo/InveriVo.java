package com.joolun.cloud.upms.common.vo;

import com.joolun.cloud.upms.common.entity.Inveri;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class InveriVo extends Inveri implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 个人 0 企业 1
	 */
	private Integer typeId;

	/**
	 * 个人商铺名称
	 */

	private String personageName;
	/**
	 * 个人商铺用户名称
	 */

	private String personageUsername;
	/**
	 * 身份证号
	 */
	private String personageIdcard;
	/**
	 * 身份证正面
	 */

	private String personageIdcardFront;
	/**
	 * 身份证反面
	 */

	private String personageIdcardReverse;
	/**
	 * 详细地址
	 */

	private String address;
	/**
	 * 联系方式
	 */

	private String mobileno;
	/**
	 * 银行名称
	 */

	private String bankname;
	/**
	 * 银行卡号
	 */

	private String bankaccountno;
	/**
	 * 开户地址
	 */
	private String bankaddress;
	/**
	 * 银行卡正面
	 */

	private String bankImgFront;
	/**
	 * 银行卡反面
	 */

	private String bankImgReverse;
	/**
	 * 创建时间
	 */

	private LocalDateTime createtime;
	/**
	 * 更新时间
	 */

	private LocalDateTime updatetime;

	/**
	 * 企业商铺名称
	 */

	private String enterpriseName;
	/**
	 * 公司全称
	 */

	private String enterpriseUsername;
	/**
	 * 营业执照
	 */

	private String businesslicenseId;
	/**
	 * 执照开始时间
	 */

	private LocalDateTime businesslicenseStarttime;
	/**
	 * 执照最后有效时间
	 */

	private LocalDateTime businesslicenseEndtime;
	/**
	 * 法人身份证号
	 */

	private String enterpriseIdcard;
	/**
	 * 法人姓名
	 */
	private String enterpriseIdcardName;
	/**
	 * 身份证正面
	 */
	private String enterpriseIdcardFront;
	/**
	 * 身份证反面
	 */
	private String enterpriseIdcardReverse;

	/**
	 * 开户许可证
	 */
	private String lfoa;



}
