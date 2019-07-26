package com.qf.controller;

import com.qf.domain.Course;
import com.qf.domain.ShoppingCar;
import com.qf.response.QueryResponseResult;
import com.qf.service.ShoppingCarService;
import com.qf.service.ShoppingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ShoppingCarController {
//    ShoppingCar shoppingCar=new ShoppingCar();
    @Autowired
    private ShoppingCarService shoppingCarService;
    private ShoppingService shoppingService;

    //通过ID查询出来的课程存入到购物车的数据库中
    @ResponseBody
    @RequestMapping(value = "/addCourse",method = RequestMethod.GET)
    @ApiOperation("此接口在controller内部调用。通过课程ID查询到对象保存到购物车数据库，并返回给前台一个对象")
    public ShoppingCar addCourse(ShoppingCar shoppingCar, HttpSession session){


      /*QueryResponseResult admin =(QueryResponseResult) session.getAttribute("admin");
        Integer id = admin.getQueryResult().getUser().getId();*/
       Course course =(Course) session.getAttribute("course");
       /* System.out.println(id);
        System.out.println(course);
*/

      ShoppingCar shoppingCar1=new ShoppingCar();

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


        shoppingCar1.setId(id);
        shoppingCar1.setCourseId(courseId);
        shoppingCar1.setCourseTitleImgurl(courseTitleImgurl);
        shoppingCar1.setCourseSubtitle(courseSubtitle);
        shoppingCar1.setCourseAuthor(courseAuthor);
        shoppingCar1.setCourseSprice(courseSprice);
        shoppingCar1.setCourseSummary(courseSummary);
        shoppingCar1.setCourseClassNum(courseClassNum);
        shoppingCar1.setCourseStudyPeoples(courseStudyPeoples);
        shoppingCar1.setCourseImgurl(courseImgurl);
        shoppingCar1.setCourseOtherImgurl(courseOtherImgurl);
        shoppingCar1.setCourseTeacherIntro(courseTeacherIntro);
        shoppingCar1.setCourseFeatureIntroI(courseFeatureIntroI);
        shoppingCar1.setCourseFeatureIntroII(courseFeatureIntroII);
        shoppingCar1.setCourseTitle(courseTitle);
        shoppingCar1.setCoursePeoples(coursePeoples);
        shoppingCar1.setCourseTableImgurl(courseTableImgurl);
        shoppingCar1.setCoursePurchaseAttention(coursePurchaseAttention);
        shoppingCar1.setCourseCollege(courseCollege);
        shoppingCar1.setCourseUpdateTime(courseUpdateTime);
        shoppingCar1.setChecked(true);

        System.out.println(courseAuthor);

        int i = shoppingCarService.addCourse(shoppingCar1);
        System.out.println(i);
        return shoppingCar1;

    }
    @ResponseBody
    @RequestMapping(value = "/findMoney",method = RequestMethod.POST)
    @ApiOperation("根据当前用户登录的Id,查询购物车里对应的所有购买课程的总钱数")
    public QueryResponseResult findMoney(int id){
       /* QueryResponseResult admin =(QueryResponseResult) session.getAttribute("admin");
        Integer id1 = admin.getQueryResult().getUser().getId();
        System.out.println("id1="+id1);*/
        QueryResponseResult money = shoppingCarService.findMoney(id);
        System.out.println(money);
        return money;
    }
//根据当前用户ID查询购物车对应的所有对象
    @ResponseBody
    @RequestMapping(value = "/findAllShoppingCar",method = RequestMethod.POST)
    @ApiOperation("根据当前用户ID查询购物车对应的所有对象")
    public QueryResponseResult findAllShoppingCar(int id){
        System.out.println(id);
        /*QueryResponseResult admin =(QueryResponseResult) session.getAttribute("admin");
        Integer id2 = admin.getQueryResult().getUser().getId();*/
        QueryResponseResult allShoppingCar = shoppingCarService.findAllShoppingCar(id);
        System.out.println(allShoppingCar);
        return allShoppingCar;
    }
    @ResponseBody
    @RequestMapping(value = "/uptShoppingCar",method = RequestMethod.POST)
    @ApiOperation("根据当前用户ID，删除购物车对应的对象，实现购物车支付成功")
    public QueryResponseResult uptShoppingCar(int id){
       /* QueryResponseResult admin =(QueryResponseResult) session.getAttribute("admin");
        Integer id3 = admin.getQueryResult().getUser().getId();
        System.out.println(id3+"=id3");*/
        QueryResponseResult queryResponseResult = shoppingCarService.uptShoppingCar(id);
        return queryResponseResult;
    }
    //复选框删除多个对象
    @RequestMapping(value = "/deletShoppingCarAll",method = RequestMethod.POST)
    @ApiOperation("复选框删除购物车多个对象存入待发货数据库，")
    public String deletShoppingCarAll(@RequestParam("list[]")  Integer[] list, @RequestParam("id") int id, HttpSession session){
        List<Integer> list1 = Arrays.asList(list);

        List<ShoppingCar> shoppingCars = shoppingCarService.selShoppingCarAll(list1,id);
        System.out.println("======="+shoppingCars);
        session.setAttribute("queryResponseResult1",shoppingCars);

        QueryResponseResult queryResponseResult = shoppingCarService.deletShoppingCarAll(list1,id);
        return "redirect:/inShopping";
    }
    @ResponseBody
    @RequestMapping(value = "/selShoppingCarAll",method = RequestMethod.POST)
    @ApiOperation("复选框查询购物车所选对象的全部信息")
    public List<ShoppingCar> selShoppingCarAll(@RequestParam("list[]") Integer[] list, @RequestParam("id") int id){
        List<Integer> list1 = Arrays.asList(list);
        List<ShoppingCar> shoppingCars = shoppingCarService.selShoppingCarAll(list1,id);
        return shoppingCars;
    }

    //复选框删除多个对象
    @ResponseBody
    @RequestMapping(value = "/deletShoppingCar",method = RequestMethod.POST)
    @ApiOperation("复选框删除购物车多个对象")
    public  QueryResponseResult deletShoppingCar(@RequestParam("list[]")  Integer[] list, @RequestParam("id") int id, HttpSession session){
        List<Integer> list1 = Arrays.asList(list);
        QueryResponseResult queryResponseResult1 = shoppingCarService.deletShoppingCarAll(list1, id);
        return queryResponseResult1;
    }

}
