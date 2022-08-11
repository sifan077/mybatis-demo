package com.shentu.mapper;

import com.shentu.pojo.Orders;

import java.util.List;

public interface CustomerMapper {
    List<Orders> selectUserOrderById(Integer cid);
}
