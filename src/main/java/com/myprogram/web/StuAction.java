package com.myprogram.web;

import com.myprogram.entity.Stu;
import com.myprogram.service.ClsService;
import com.myprogram.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hjk on 2017/12/24.
 */
@Controller
@RequestMapping("/stuAction")
public class StuAction {
    @Resource(name = "stuService")
    private StuService stuService;

    @Resource(name = "clsService")
    private ClsService clsService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 查询班级信息
     *
     * @param message  添加的消息
     * @param modelMap 将班级信息和添加消息带到前台
     * @return 前台页面
     */
    @RequestMapping("/findClsList")
    public String findClsList(@ModelAttribute(name = "addMessage") String message, ModelMap modelMap) {
        modelMap.addAttribute("clsList", clsService.findClsList());
        if (message != null) {
            modelMap.addAttribute("addMessage", message);
        }
        return "pages/AddStu";
    }

    /**
     * 添加学生
     *
     * @param stu  学生对象
     * @param attr 将添加的消息带到前台
     * @return 前台页面
     */
    @RequestMapping("/addStu")
    public String addStu(Stu stu, BindingResult result, ModelMap modelMap, RedirectAttributes attr) {
        if(result.hasErrors()){
            modelMap.addAttribute("backStu", stu);
            return "/stuAction/findClsList?addMessage=";
        }
            if (stuService.addStu(stu)) {
                attr.addFlashAttribute("addMessage", "1");
            } else {
                attr.addFlashAttribute("addMessage", "-1");
            }
        return "redirect:/stuAction/findClsList";
    }

    /**
     * 通过id获取学生
     *
     * @param sno      学生id
     * @param modelMap
     * @return
     */
    @RequestMapping("/getStuById/stk/{sno}/ktl")
    public String getStuById(@PathVariable(name = "sno") int sno, ModelMap modelMap, @ModelAttribute(name = "updateMessage") String updateMsg) {
        if (sno != 0) {
            modelMap.addAttribute("stu", stuService.getStuById(sno));
            modelMap.addAttribute("clsList", clsService.findClsList());
            modelMap.addAttribute("updateMsg", updateMsg);
        }
        return "/pages/updateStu";
    }

    /**
     * 修改学生信息
     *
     * @param stu
     * @param attr
     * @return
     */
    @RequestMapping("/updateStu")
    public String updateStu( Stu stu, RedirectAttributes attr) {
        if (stuService.updateStu(stu)) {
            attr.addFlashAttribute("updateMessage", "1");
            return "redirect:/stuAction/findStuList";
        }
        attr.addFlashAttribute("updateMessage", "-1");
        return "redirect:/stuAction/getStuById/stk/" + stu.getSno() + "/ktl";
    }

    /**
     * 删除学生
     *
     * @param stu  学生对象
     * @param attr
     * @return
     */
    @RequestMapping("/deleteStu/stk/{sno}/ktl")
    public String deleteStu(@PathVariable(name = "sno") int sno, Stu stu, RedirectAttributes attr) {
        if (sno != 0) {
            stu.setSno(sno);
            if (stuService.deleteStu(stu)) {
                attr.addFlashAttribute("deleteMsg", "1");
                return "redirect:/stuAction/findStuList";
            }
        }
        attr.addFlashAttribute("deleteMsg", "-1");
        return "redirect:/stuAction/findStuList";
    }

    /**
     * 查询学生信息
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/findStuList")
    public String findStuList(ModelMap modelMap, @ModelAttribute(name = "updateMessage") String updateMsg, @ModelAttribute(name = "deleteMsg") String deleteMsg) {
        modelMap.addAttribute("stuList", stuService.findStuList());
        modelMap.addAttribute("updateMsg", updateMsg);
        modelMap.addAttribute("deleteMsg", deleteMsg);
        return "pages/showStu";
    }

    //文件上传
//    private Stu upLoadFile(Stu stu, MultipartFile file, HttpSession session) {
//        //获取服务器路径
//        String basePath = session.getServletContext().getRealPath("/images");
//        //String realName = file.getOriginalFilename();//真实上传的文件名
//        //执行上传操作
//        try {
//            String fileName = sdf.format(new Date()) + "_" + realName;
//            file.transferTo(new File(basePath + "/" + fileName));
//            stu.setSimage(fileName);
//            return stu;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return null;
//    }

    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }

    public void setClsService(ClsService clsService) {
        this.clsService = clsService;
    }
}
