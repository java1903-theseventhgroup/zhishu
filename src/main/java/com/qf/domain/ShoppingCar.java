package com.qf.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ShoppingCar implements Serializable {

    private Integer courseId;
    private String courseTitleImgurl ;                  //课程表面图片
    private String courseSubtitle  ;                  //书标题
    private String courseSummary;                   //书内容摘要
    private String courseAuthor;                    //作者
    private Integer courseClassNum;                 //总共多少讲
    private Double courseSprice;                    //价格
    private Integer courseStudyPeoples;             //加入学习人数
    private String courseImgurl;                    //界面的书图片
    private String courseOtherImgurl;               //详情页置顶作者的图片
    private String courseTeacherIntro;               //老师简介
    private String courseFeatureIntroI;              //课程简介的上层
    private String courseFeatureIntroII;             //课程简介的下层
    private String courseTitle;                     //发刊词内容
    private Integer coursePeoples;                   //学习过的人数               //外键（新建目录表存储每本书的目录以及每个目录对应音频地址
    private String courseTableImgurl;               //课程表图片
    private String coursePurchaseAttention;          //购买须知
    private String courseCollege;                    //学院
    private Date courseUpdateTime;                  //课程更新时间
    private int id;                                   //购物车添加后寻找用户

    private boolean checked=true;
}
