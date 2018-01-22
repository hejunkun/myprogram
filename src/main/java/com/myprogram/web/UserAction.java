package com.myprogram.web;

import com.myprogram.entity.Stu;
import com.myprogram.entity.User;
import com.myprogram.service.UserService;
import jdk.nashorn.internal.runtime.GlobalConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
//import javax.servlet.http.HttpSession;

/**
 * Created by hjk on 2017/11/8.
 */
@Controller
@RequestMapping("/userAction")
public class UserAction {

    @Resource(name = "userService")
    private UserService userService;
    //登录
    @RequestMapping("/doLogin")
    @ResponseBody
    public User doLogin(User user, RedirectAttributes attr, HttpSession session) { //用户登录
        if (user!= null) {
            user = userService.doLogin(user);
            if (user != null) {
                session.setAttribute("loginUser", user);
                return user;
            } else {
                attr.addAttribute("rtype", "-1");
            }
        }
        return user;
    }


    //注册
    @RequestMapping("/RegisterUser")
    public String  RegisterUser(User user, RedirectAttributes attr){
        if (userService.addUser(user)){
            return "redirect:/index.jsp";
        }else {
            attr.addAttribute("utype","-1");
        }
        return "redirect:/register.jsp";
    }

    @RequestMapping("/exitLogin")
    public String exitLogin(HttpSession session){
        session.setAttribute("loginUser", null);
        return "redirect:/index.jsp";
    }

    /**
     * 修改密码信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(User user, String newpwd, HttpSession session) {
        String pwd = user.getUpwd();
        System.out.println("1:" + pwd);
        user = userService.getUserById(user.getUno());
        System.out.println("2:" + user.getUpwd());
        if(!user.getUpwd().equals(pwd)){
            return "fail";
        }
        user.setUpwd(newpwd);
        if (userService.updateUser(user)) {
            return "success";
        }
        return "fail";
    }


    @RequestMapping("/findUsersList")
    @ResponseBody
    public List findClsList(){
        return userService.findUsersList();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
