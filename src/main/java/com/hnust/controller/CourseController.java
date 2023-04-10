package com.hnust.controller;

import com.hnust.entity.Course;
import com.hnust.service.CourseService;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


/**
 * @author 长夜
 * @date 2023/3/23 8:54
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping ("/main_page")
//    @ResponseBody
    public ModelAndView main_page() {
        ModelAndView mav = new ModelAndView("main");
        List<Course> courses=courseService.selectAll();
        //按照id升序排序
        Collections.sort(courses, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getSchools() - o2.getSchools();
            }
        });
//        mav.addObject("photo_name", "undraw_Conference_speaker_re_1rna.png");
        mav.addObject("courses",courses);
        return mav;
    }
    @GetMapping ("/add_page")
    public String add_page() {
        //Boolean success =courseService.insertAutoId(course);
        return "add_course";
    }
    @GetMapping("/update_page")
    @ResponseBody
    public ModelAndView update_page(Course course){
        ModelAndView mav = new ModelAndView("update_course");
        mav.addObject("course",course);
        return mav;
    }
    @PostMapping("/add_solve")
    public String add_solve(@RequestParam("imageFile") MultipartFile imageFile,@RequestParam("name") String name,
                            @RequestParam("hours") Integer hours,@RequestParam("schools") Integer schools
    ){
        List<Course> courses=courseService.selectAll();
        Boolean success =true;
        for(Course res :courses)
        {
            if(res.getName().equals(name))
            {
                success=false;break;
            }
        }
        if(success.equals(true)) {
            try {
                String imageName;
                if (ObjectUtils.isEmpty(imageFile) || imageFile.getSize() <= 0) {
                    imageName = "c974612e-552b-4733-9d0d-9286c4af620c.png";//默认图片
                    System.out.println(imageName+"我是null");
                }else{
                    imageName = UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(imageFile.getOriginalFilename());
                    // 生成图片文件名
                    String imagePath = "F:\\IEDAUltimate\\code\\save\\images\\" + imageName;
                    // 将图片保存到磁盘
                    Path imageFilePath = Paths.get(imagePath);
                    Files.write(imageFilePath, imageFile.getBytes());
                    System.out.println(imageName+"我不是null");
                }
                Course course =new Course(null,imageName,name,hours,schools);
                courseService.insertAutoId(course);
                System.out.println("{'module':'course save success'}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("{'module':'course save fail'}");
        }
        return "redirect:/course/main_page";
    }
    @PostMapping ("/update_solve")
    public String update_solve(@RequestParam("id") Integer id,@RequestParam("imageFile") MultipartFile imageFile,
    @RequestParam("name") String name, @RequestParam("hours") Integer hours,
    @RequestParam("schools") Integer schools
    ){
        List<Course> courses=courseService.selectAll();
        Boolean success =true;
        for(Course res :courses)
        {
            if(!res.getId().equals(id)&&res.getName().equals(name))
            {
                success=false;break;
            }
        }
        if(success.equals(true)) {
            try {
                String imageName=courseService.selectImage(id);
                if (!ObjectUtils.isEmpty(imageFile) && imageFile.getSize() > 0) {
                    imageName = UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(imageFile.getOriginalFilename());
                    // 生成图片文件名
                    String imagePath = "F:\\IEDAUltimate\\code\\save\\images\\" + imageName;
                    // 将图片保存到磁盘
                    Path imageFilePath = Paths.get(imagePath);
                    Files.write(imageFilePath, imageFile.getBytes());
                    System.out.println(imageName+"我不是null");
                }
                Course course =new Course(id,imageName,name,hours,schools);
                courseService.update(course);
                System.out.println("{'module':'course update success'}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("{'module':'course update fail'}");
        }
        return "redirect:/course/main_page";
    }
    @GetMapping  ("/delete_solve")
    public String delete_solve(Integer id){
        System.out.println("course delete ==> "+ id);
        Boolean success = courseService.deleteById(id);
        if(success.equals(true)) {
            System.out.println("{'module':'course delete success'}");
        }else{
            System.out.println("{'module':'course delete fail'}");
        }
        return "redirect:/course/main_page";
    }
}
