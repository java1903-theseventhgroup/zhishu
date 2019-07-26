package com.qf.service;

import com.qf.domain.ShoppingCar1;
import com.qf.response.QueryResponseResult;

public interface ShoppingCar1Service {
    public QueryResponseResult inShopping(ShoppingCar1 shoppingCar1);//将删除的用户存入到待发货数据库
    public QueryResponseResult chaShoppingCarAll(int id); //前端出入用户ID查询对应的代发货信息

}
