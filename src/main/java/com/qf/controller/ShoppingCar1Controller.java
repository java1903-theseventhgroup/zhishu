package com.qf.controller;

import com.qf.domain.ShoppingCar;
import com.qf.domain.ShoppingCar1;
import com.qf.response.QueryResponseResult;
import com.qf.service.ShoppingCar1Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ShoppingCar1Controller {
    @Autowired
    private ShoppingCar1Service shoppingCar1Service;


    @ResponseBody
    @RequestMapping(value = "/inShopping", method = RequestMethod.GET)
    @ApiOperation("将删除的用户存入到待发货数据库,此接口内部调用")
    public String inShopping(ShoppingCar1 shoppingCar1, HttpSession session) {


        List<ShoppingCar> list = (ArrayList<ShoppingCar>) session.getAttribute("queryResponseResult1");
        System.out.println((session.getAttribute("queryResponseResult1")));
        ShoppingCar1 shoppingCar2 = new ShoppingCar1();
        //ShoppingCar course = list.get(0);
        List<ShoppingCar> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ShoppingCar course = list.get(i);
            int id = course.getId();
            Integer courseId = course.getCourseId();
            String courseTitleImgurl = course.getCourseTitleImgurl();
            String courseSubtitle = course.getCourseSubtitle();
            String courseAuthor = course.getCourseAuthor();
            Double courseSprice = course.getCourseSprice();
            //============
            String courseSummary = course.getCourseSummary();
            Integer courseClassNum = course.getCourseClassNum();
            Integer courseStudyPeoples = course.getCourseStudyPeoples();
            String courseImgurl = course.getCourseImgurl();
            String courseOtherImgurl = course.getCourseOtherImgurl();
            String courseTeacherIntro = course.getCourseTeacherIntro();
            String courseFeatureIntroI = course.getCourseFeatureIntroI();
            String courseFeatureIntroII = course.getCourseFeatureIntroII();
            String courseTitle = course.getCourseTitle();
            Integer coursePeoples = course.getCoursePeoples();
            String courseTableImgurl = course.getCourseTableImgurl();
            String coursePurchaseAttention = course.getCoursePurchaseAttention();
            String courseCollege = course.getCourseCollege();
            Date courseUpdateTime = course.getCourseUpdateTime();


            shoppingCar2.setId(id);
            shoppingCar2.setCourseId(courseId);
            shoppingCar2.setCourseTitleImgurl(courseTitleImgurl);
            shoppingCar2.setCourseSubtitle(courseSubtitle);
            shoppingCar2.setCourseAuthor(courseAuthor);
            shoppingCar2.setCourseSprice(courseSprice);
            shoppingCar2.setCourseSummary(courseSummary);
            shoppingCar2.setCourseClassNum(courseClassNum);
            shoppingCar2.setCourseStudyPeoples(courseStudyPeoples);
            shoppingCar2.setCourseImgurl(courseImgurl);
            shoppingCar2.setCourseOtherImgurl(courseOtherImgurl);
            shoppingCar2.setCourseTeacherIntro(courseTeacherIntro);
            shoppingCar2.setCourseFeatureIntroI(courseFeatureIntroI);
            shoppingCar2.setCourseFeatureIntroII(courseFeatureIntroII);
            shoppingCar2.setCourseTitle(courseTitle);
            shoppingCar2.setCoursePeoples(coursePeoples);
            shoppingCar2.setCourseTableImgurl(courseTableImgurl);
            shoppingCar2.setCoursePurchaseAttention(coursePurchaseAttention);
            shoppingCar2.setCourseCollege(courseCollege);
            shoppingCar2.setCourseUpdateTime(courseUpdateTime);
            shoppingCar2.setChecked(true);
            System.out.println(shoppingCar2);

            QueryResponseResult queryResponseResult = shoppingCar1Service.inShopping(shoppingCar2);

        }
            return "成功";
        }

     @RequestMapping(value = "chaShoppingCarAll",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("前端输入用户ID查询对应的代发货信息")
    public QueryResponseResult chaShoppingCarAll(int id){
         QueryResponseResult queryResponseResult = shoppingCar1Service.chaShoppingCarAll(id);
         return queryResponseResult;
     }

    }