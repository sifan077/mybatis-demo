package com.shentu.mapper;

import com.shentu.pojo.Orders;

public interface OrdersMapper {
    Orders selectOrdersById(Integer oid);
}
