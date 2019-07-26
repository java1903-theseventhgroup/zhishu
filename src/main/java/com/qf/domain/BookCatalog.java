package com.qf.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class BookCatalog implements Serializable {
    private  Integer bookCatalogId;
    private Integer  bookCatalogNum;
    private String bookCatalogName;
    private String bookCatalogInfo;
    private String  bookRedioUrl;
    private Integer  bId;
}
