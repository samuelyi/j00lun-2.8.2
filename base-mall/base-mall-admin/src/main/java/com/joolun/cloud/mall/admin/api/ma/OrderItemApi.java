/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.joolun.cloud.mall.admin.api.ma;

import com.joolun.cloud.common.core.util.R;
import com.joolun.cloud.mall.admin.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 商城订单详情
 *
 * @author JL
 * @date 2019-09-10 15:31:40
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/ma/orderitem")
@Api(value = "orderitem", tags = "商城订单详情API")
public class OrderItemApi {

    private final OrderItemService orderItemService;

    /**
    * 通过id查询商城订单详情
    * @param id
    * @return R
    */
	@ApiOperation(value = "通过id查询商城订单详情")
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") String id){
        return R.ok(orderItemService.getById2(id));
    }

}
