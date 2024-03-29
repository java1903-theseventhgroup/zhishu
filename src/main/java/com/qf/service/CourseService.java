package com.qf.service;

import com.qf.domain.Course;
import com.qf.response.QueryResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {
    QueryResponseResult findAllCourse();
    QueryResponseResult findS22(String classification);
    QueryResponseResult findSujectsByName(String subject);
    QueryResponseResult loadAll();                 //查询全部课程
    QueryResponseResult findByAbility(String courseCollege);            //查能力学院的课程
    QueryResponseResult findHomePage();
    public QueryResponseResult findByNameOrAuthor(String subject);//模糊查询
    boolean inserCourse(Course course);
    boolean deleteCourse(Integer courseId);
    boolean uploadCourseTitleImgurl(Course course);
    public List<Course> findAll(Integer page, Integer rows);//后台查询所有用户
    public int selectRows(Integer rows);


    boolean uploadCourseOtherImgurl(Course course);
    boolean uploadCourseTableImgurl(Course course);
    boolean uploadcourseImgurl(Course course);
}
