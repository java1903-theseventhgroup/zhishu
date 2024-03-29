package com.qf.controller;

import com.qf.domain.Course;
import com.qf.response.QueryResponseResult;
import com.qf.service.CourseService;
import com.qf.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.List;
import java.util.Map;


@Controller
@ResponseBody
@RequestMapping("Course")
public class CourseController {
    @Autowired
    private  CourseService courseService;
    @Autowired
    private FileService fileService;

    @Value("${baseUploadUrl}")
    private String url;

    //查询全部课程表
    @RequestMapping(value = "loadAll",method = RequestMethod.GET)
    @ApiOperation(value = "课程全部查询接口",notes = "返回的是课程表所有数据")
    public QueryResponseResult loadAll(){
        return courseService.loadAll();
    }


    @RequestMapping(value = "findByAbility",method = RequestMethod.POST)     //查询课程里边的能力学院
    @ApiOperation(value = "课程对应能力学院查询接口",notes ="返回全部课程能力学院的客程内容")
    public QueryResponseResult findByAbility(@RequestParam("college")String courseCollege){
        return courseService.findByAbility(courseCollege);
    }

    @RequestMapping(value = "findHomePage",method = RequestMethod.POST)     //题首页过滤返回 （首页图片，上架时间，书标题，）
    @ApiOperation(value = "专题首页展示内容接口",notes ="返回专题首页图片，上架时间，书标题，并根据上架时间排序")
    public QueryResponseResult findHomePage() {
        return courseService.findHomePage();
    }


    /**
     * 以下是后端接口
     */

//    @RequestMapping(value = "loadAll",method = RequestMethod.POST)
//    @ApiOperation(value = "后端接口",notes ="查全部")
//    public String loadAll(Model model, @RequestParam("page")) {
//        List<Course> courseList=courseService.loadAll();
//        model.addAttribute("courseList",courseList);
//        return "成功";
//    }
    //后台查询所有用户
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation("后台分查询页课程")
    public String loadAll(Model model, @RequestParam(required = false,defaultValue = "1")Integer page,
                          @RequestParam(required = false,defaultValue = "5")Integer rows
    ){
        int maxpage=courseService.selectRows(rows);
        if (page<1){page=1;}
        if(page>maxpage){page=maxpage;}
        List<Course> courses = courseService.findAll(page, rows);
        model.addAttribute("maxpage",maxpage);
        model.addAttribute("page",page);
        model.addAttribute("coursesList",courses);

        System.out.println(page+"="+maxpage+"=="+courses);
        return "";
    }



//    @RequestMapping(value = "inserCourse",method = RequestMethod.POST)
//    @ApiOperation(value = "后端接口",notes ="添加数据")
//    public String inserCourse( Course course,@RequestParam(value = "files")MultipartFile [] multipartFiles) {
//
//        System.out.println(multipartFiles);
//        for (MultipartFile f:
//                multipartFiles) {
//            System.out.println(f.getOriginalFilename());
//        }
//
////        String fileName = multipartFiles.getOriginalFilename();
//////        String fileName1 = multipartFiles1.getOriginalFilename();
////        File file = new File(url+fileName);
//////        File file1 = new File(url+fileName1);
////
////        try{
////            //将MulitpartFile文件转化为file文件格式
////            multipartFiles.transferTo(file);
//////            multipartFiles.transferTo(file1);
////            Map  response = fileService.uploadFile(file);
//////            Map  response1 = fileService.uploadFile(file1);
////            Object imageName = response.get("imgName");
//////            Object imageName1 = response1.get("imgName");
//////            System.out.println(imageName);
////            course.setCourseImgurl((String)imageName);
//////            course.setCourseTitleImgurl((String)imageName);
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////        courseService.inserCourse(course);
//        return "成功";
//    }












    @RequestMapping(value = "inserCourse",method = RequestMethod.POST)
    @ApiOperation(value = "后端接口",notes ="添加数据")
    public String inserCourse( Course course) {
        courseService.inserCourse(course);
        return "成功";
    }
    @RequestMapping(value = "uploadcourseImgurl",method = RequestMethod.POST)
    @ApiOperation(value = "后端接口上传uploadcourseImgurl",notes ="上传uploadcourseImgurl")
    public String uploadcourseImgurl(Integer courseId,@RequestParam(value = "courseImgurl")MultipartFile multipartFiles) {
        String fileName = multipartFiles.getOriginalFilename();
        File file = new File(url+fileName);
        try{
            multipartFiles.transferTo(file);
            Map  response = fileService.uploadFile(file);
            Object imageName = response.get("imgName");
            Course course=new Course();
            course.setCourseImgurl((String)imageName);
            course.setCourseId(courseId);
            courseService.uploadcourseImgurl(course);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "成功";
    }

    @RequestMapping(value = "uploadCourseTitleImgurl",method = RequestMethod.POST)
    @ApiOperation(value = "后端接口上传uploadCourseTitleImgurl",notes ="上传uploadCourseTitleImgurl")
    public String uploadCourseTitleImgurl(Integer courseId,@RequestParam(value = "courseTitleImgurl")MultipartFile multipartFiles) {
        String fileName = multipartFiles.getOriginalFilename();
        File file = new File(url+fileName);
        try{
            multipartFiles.transferTo(file);
            Map  response = fileService.uploadFile(file);
            Object imageName = response.get("imgName");
            Course course=new Course();
            course.setCourseTitleImgurl((String)imageName);
            course.setCourseId(courseId);
            courseService.uploadCourseTitleImgurl(course);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "成功";
    }


    @RequestMapping(value = "uploadCourseOtherImgurl",method = RequestMethod.POST)
    @ApiOperation(value = "后端接口上传uploadCourseOtherImgurl",notes ="上传uploadCourseOtherImgurl")
    public String uploadCourseOtherImgurl(Integer courseId,@RequestParam(value = "courseOtherImgurl")MultipartFile multipartFiles) {
        String fileName = multipartFiles.getOriginalFilename();
        File file = new File(url+fileName);
        try{
            multipartFiles.transferTo(file);
            Map  response = fileService.uploadFile(file);
            Object imageName = response.get("imgName");
            Course course=new Course();
            course.setCourseOtherImgurl((String)imageName);
            course.setCourseId(courseId);
            courseService.uploadCourseOtherImgurl(course);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "成功";
    }


    @RequestMapping(value = "uploadCourseTableImgurl",method = RequestMethod.POST)
    @ApiOperation(value = "后端接口上传uploadCourseTableImgurl",notes ="uploadCourseTableImgurl")
    public String uploadCourseTableImgurl(Integer courseId,@RequestParam(value = "courseTableImgurl")MultipartFile multipartFiles) {
        String fileName = multipartFiles.getOriginalFilename();
        File file = new File(url+fileName);
        try{
            multipartFiles.transferTo(file);
            Map  response = fileService.uploadFile(file);
            Object imageName = response.get("imgName");
            Course course=new Course();
            course.setCourseTableImgurl((String)imageName);
            course.setCourseId(courseId);
            courseService.uploadCourseTableImgurl(course);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "成功";
    }




    @RequestMapping(value = "deleteCourse",method = RequestMethod.POST)
    @ApiOperation(value = "后端接口",notes ="删除")
    public String deleteCourse(Integer courseId) {
       courseService.deleteCourse(courseId);
        return "成功";
    }
}
