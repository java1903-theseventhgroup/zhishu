package com.qf.service.serviceImpl;

import com.qf.dao.ShoppingCarDao;
import com.qf.domain.ShoppingCar;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarServiceimpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarDao shoppingCarDao;
    @Override
    //通过ID查询出来的课程存入到购物车的数据库中
    public int addCourse(ShoppingCar shoppingCar) {
      return shoppingCarDao.addCourse(shoppingCar);
    }

    //根据当前用户登录的Id,查询购物车里对应的所有购买课程的总钱数
    @Override
    public QueryResponseResult findMoney(int id) {
        Double money = shoppingCarDao.findMoney(id);
        QueryResult<Double> queryResult = new QueryResult<>();
        queryResult.setADouble(money);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    //根据当前用户ID查询购物车对应的所有对象
    public QueryResponseResult findAllShoppingCar(int id) {
        List<ShoppingCar> allShoppingCar = shoppingCarDao.findAllShoppingCar(id);
        System.out.println(allShoppingCar);
        QueryResult<ShoppingCar> queryResult = new QueryResult<>();
        queryResult.setList(allShoppingCar);
        return new QueryResponseResult<>(CommonCode.SUCCESS,queryResult);
    }

    @Override
    //根据当前用户ID，删除购物车对应的对象，实现购物车支付成功
    public QueryResponseResult uptShoppingCar(int id) {
        int i = shoppingCarDao.uptShoppingCar(id);
        System.out.println(i);
        QueryResult<Integer> queryResult = new QueryResult<>();
        queryResult.setAnInt(i);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    //复选框删除多个对象
    public QueryResponseResult deletShoppingCarAll(List<Integer> list, int id) {
        int i = shoppingCarDao.deletShoppingCarAll(list,id);
        QueryResult<Integer> queryResult = new QueryResult<>();
        queryResult.setAnInt(i);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    //复选框查询购物车所选对象的全部信息
    public List<ShoppingCar> selShoppingCarAll(List<Integer> list, int id) {
        List<ShoppingCar> shoppingCars = shoppingCarDao.selShoppingCarAll(list,id);


        return shoppingCars;
    }
}
