package com.qf.dao;

import com.qf.domain.Book;
import com.qf.domain.BookHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookDao {
    List<Book> findAll();
    List<Book> findType(String bookType);
    List<Book> findS2(String classification);
    List<Book> findSujectsByName(String subject);
    public List<Book> findByNameOrAuthor(@Param("subject") String subject);//模糊查询
    public List<BookHistory> getBookHistory();
    public void addHistory( BookHistory bookHistory);
    public void deleteHistory(String bookSubtile);
    public int deleteAll ();
}
