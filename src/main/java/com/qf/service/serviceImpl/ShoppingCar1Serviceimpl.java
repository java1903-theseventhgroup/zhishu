package com.qf.service.serviceImpl;

import com.qf.dao.ShoppingCar1Dao;
import com.qf.domain.ShoppingCar1;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.service.ShoppingCar1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCar1Serviceimpl implements ShoppingCar1Service {
    @Autowired
    private ShoppingCar1Dao shoppingCar1Dao;

    @Override
    //将删除的用户存入到待发货数据库
    public QueryResponseResult inShopping(ShoppingCar1 shoppingCar1) {
        int i = shoppingCar1Dao.inShopping(shoppingCar1);
        QueryResult<Integer> queryResult = new QueryResult<>();
        queryResult.setAnInt(i);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    //前端输入用户ID查询对应的代发货信息
    public QueryResponseResult chaShoppingCarAll(int id) {
        List<ShoppingCar1> shoppingCar1s = shoppingCar1Dao.chaShoppingCarAll(id);
        QueryResult<ShoppingCar1> queryResult = new QueryResult<>();
        queryResult.setList(shoppingCar1s);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);

    }
}
