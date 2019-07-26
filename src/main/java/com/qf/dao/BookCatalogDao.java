package com.qf.dao;

import com.qf.domain.BookCatalog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookCatalogDao {
    List<BookCatalog> findBookCatalogByName(String book_subtitle);
}
