package com.qf.service.serviceImpl;

import com.qf.dao.ShoppingDao;
import com.qf.domain.Course;
import com.qf.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingServiceimpl implements ShoppingService {
    @Autowired
    private ShoppingDao shoppingDao;
    @Override
    //根据传回的课程id查询当前的对象
    public Course findShopById(int courseId) {
        return  shoppingDao.findShopById(courseId);
    }
}
