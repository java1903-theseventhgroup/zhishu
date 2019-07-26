package com.qf.dao;

import com.qf.domain.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingDao {
    public Course findShopById(int id);//根据传回的课程id查询当前的对象

}
