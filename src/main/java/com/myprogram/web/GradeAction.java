package com.myprogram.web;

import com.myprogram.entity.Grade;
import com.myprogram.service.ClsService;
import com.myprogram.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by hjk on 2018/1/8.
 */
@Controller
@RequestMapping("/gradeAction")
public class GradeAction {
    @Resource(name = "gradeService")
    private GradeService gradeService;

    @Resource(name = "clsService")
    private ClsService clsService;

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
        return "pages/AddGrade";
    }

    /**
     * 添加成绩
     *
     * @param grade 成绩对象
     * @param attr 将添加的消息带到前台
     * @return 前台页面
     */
    @RequestMapping("/addGrade")
    public String addGrade(Grade grade,  BindingResult result, ModelMap modelMap, RedirectAttributes attr, HttpSession session) {
        if(result.hasErrors()){
            modelMap.addAttribute("backGrade", grade);
            return "/gradeAction/findClsList?addMessage=";
        }
        if (gradeService.addGrade(grade)) {
            attr.addFlashAttribute("addMessage", "1");
        } else {
            attr.addFlashAttribute("addMessage", "-1");
        }

        return "redirect:/gradeAction/findClsList";
    }

    /**
     * 通过id获取学生成绩
     *
     * @param gno      学生成绩id
     * @param modelMap
     * @return
     */
    @RequestMapping("/getGradeById/stk/{gno}/ktl")
    public String getGradeById(@PathVariable(name = "gno") int gno, ModelMap modelMap, @ModelAttribute(name = "updateMessage") String updateMsg) {
        if (gno != 0) {
            modelMap.addAttribute("grade", gradeService.getGradeById(gno));
            modelMap.addAttribute("clsList", clsService.findClsList());
            modelMap.addAttribute("updateMsg", updateMsg);
        }
        return "/pages/updateGrade";
    }

    /**
     * 修改学生成绩
     *
     * @param grade
     * @param attr
     * @return
     */
    @RequestMapping("/updateGrade")
    public String updategrade( Grade grade, HttpSession session, RedirectAttributes attr) {
        if (gradeService.updateGrade(grade)) {
            attr.addFlashAttribute("updateMessage", "1");
            return "redirect:/gradeAction/findGradeList";
        }
        attr.addFlashAttribute("updateMessage", "-1");
        return "redirect:/gradeAction/getGradeById/stk/" + grade.getGno() + "/ktl";
    }

    /**
     * 删除学生成绩
     *
     * @param grade  学生成绩
     * @param attr
     * @return
     */
    @RequestMapping("/deleteGrade/stk/{gno}/ktl")
    public String deleteGrade(@PathVariable(name = "gno") int gno, Grade grade, RedirectAttributes attr) {
        if (gno != 0) {
            grade.setGno(gno);
            if (gradeService.deleteGrade(grade)) {
                attr.addFlashAttribute("deleteMsg", "1");
                return "redirect:/gradeAction/findGradeList";
            }
        }
        attr.addFlashAttribute("deleteMsg", "-1");
        return "redirect:/gradeAction/findGradeList";
    }

    /**
     * 查询学生成绩信息
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/findGradeList")
    public String findGradeList(ModelMap modelMap, @ModelAttribute(name = "updateMessage") String updateMsg, @ModelAttribute(name = "deleteMsg") String deleteMsg) {
        modelMap.addAttribute("gradeList", gradeService.findGradeList());
        modelMap.addAttribute("updateMsg", updateMsg);
        modelMap.addAttribute("deleteMsg", deleteMsg);
        return "pages/showGrade";
    }

    public GradeService getGradeService() {
        return gradeService;
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public ClsService getClsService() {
        return clsService;
    }

    public void setClsService(ClsService clsService) {
        this.clsService = clsService;
    }
}
