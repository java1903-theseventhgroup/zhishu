package com.qf.dao;

import com.qf.domain.Listen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ListenDao {
    List<Listen> findS21(String classification);
    List<Listen> findSujectsByName(String subject);
    List<Listen> loadAll();//加载所有听书
    List<Listen> selsctByListenType(String listenType);
    List<Listen> selsctByListenAuthor(Listen listen);
    public List<Listen> findByNameOrAuthor(@Param("subject")String subject); //模糊查询
}
