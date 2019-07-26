package com.qf.dao;

import com.qf.domain.ShoppingCar1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCar1Dao {
    public int inShopping(ShoppingCar1 shoppingCar1);//将删除的用户存入到待发货数据库
    public List<ShoppingCar1> chaShoppingCarAll(int id);//前端出入用户ID查询对应的代发货信息

}
