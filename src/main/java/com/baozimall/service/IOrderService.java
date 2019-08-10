package com.baozimall.service;

import com.github.pagehelper.PageInfo;
import com.baozimall.common.ServerResponse;
import com.baozimall.vo.OrderVo;

import java.util.Map;

public interface IOrderService {
    /**
     * 支付相关
     **/
    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    /**
     * 订单相关
     **/
    ServerResponse createOrder(Integer userId, Integer shippingId);

    ServerResponse<String> cancel(Integer userId, Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    //backend
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);

    //hour个小时以内未付款的订单，进行关闭
    void closeOrder(int hour);
}
