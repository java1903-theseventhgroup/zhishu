package com.qf.service;

import com.qf.domain.ShoppingCar;
import com.qf.response.QueryResponseResult;

import java.util.List;

public interface ShoppingCarService {
    public int addCourse(ShoppingCar shoppingCar);//通过ID查询出来的课程存入到购物车的数据库中
    public QueryResponseResult findMoney(int id);//根据当前用户登录的Id,查询购物车里对应的所有购买课程的总钱数
    public QueryResponseResult findAllShoppingCar(int id);//根据当前用户ID查询购物车对应的所有对象
    public QueryResponseResult uptShoppingCar(int id);//根据当前用户ID，删除购物车对应的对象，实现购物车支付成功
    public QueryResponseResult deletShoppingCarAll(List<Integer> list, int id);//复选框删除多个对象
    public List<ShoppingCar> selShoppingCarAll(List<Integer> list, int id);//复选框查询购物车所选对象的全部信息
}
