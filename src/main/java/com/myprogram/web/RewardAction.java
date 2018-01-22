package com.myprogram.web;

import com.myprogram.entity.Cls;
import com.myprogram.entity.Reward;
import com.myprogram.entity.Stu;
import com.myprogram.service.ClsService;
import com.myprogram.service.StuService;
import com.myprogram.service.RewardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by hjk on 2018/1/8.
 */
@Controller
@RequestMapping("/rewardAction")
public class RewardAction {

    @Resource(name = "rewardService")
    private RewardService rewardService;

    @Resource(name = "stuService")
    private StuService stuService;

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
        return "forward:findStuList";
    }
    /**
     * 查询学生信息
     *
     * @param message  添加的消息
     * @param modelMap 将学生信息和添加消息带到前台
     * @return 前台页面
     */
    @RequestMapping("/findStuList")
    public String findStuList(@ModelAttribute(name = "addMessage") String message, ModelMap modelMap) {
        modelMap.addAttribute("stuList", stuService.findStuList());
        if (message != null) {
            modelMap.addAttribute("addMessage", message);
        }
        return "pages/AddReward";
    }

    /**
     * 通过班级Id查询学生
     * @param cls
     * @return 学生列表
     */
    @RequestMapping("/findStuByClsId")
    @ResponseBody
    public List findStu(Cls cls){
        List stuList=stuService.findStuList(cls);
        return stuList;
    }
    /**
     * 添加荣誉
     *
     * @param reward 荣誉对象
     * @param attr 将添加的消息带到前台
     * @return 前台页面
     */
    @RequestMapping("/addReward")
    public String addReward(Reward reward, BindingResult result, ModelMap modelMap, RedirectAttributes attr, HttpSession session) {
        if(result.hasErrors()){
            modelMap.addAttribute("backReward", reward);
            return "/rewardAction/findClsList?addMessage=";
        }
        if (rewardService.addReward(reward)) {
            attr.addFlashAttribute("addMessage", "1");
        } else {
            attr.addFlashAttribute("addMessage", "-1");
        }

        return "redirect:/rewardAction/findClsList";
    }

    /**
     * 通过id获取荣誉
     *
     * @param gno      荣誉的id
     * @param modelMap
     * @return
     */
    @RequestMapping("/getRewardById/stk/{gno}/ktl")
    public String getRewardById(@PathVariable(name = "gno") int gno, ModelMap modelMap, @ModelAttribute(name = "updateMessage") String updateMsg) {
        if (gno != 0) {
            modelMap.addAttribute("reward", rewardService.getRewardById(gno));
            modelMap.addAttribute("stuList", stuService.findStuList());
            modelMap.addAttribute("updateMsg", updateMsg);
        }
        return "/pages/updateReward";
    }


    /**
     * 删除荣誉
     *
     * @param reward  荣誉对象
     * @param attr
     * @return
     */
    @RequestMapping("/deleteReward/stk/{rno}/ktl")
    public String deleteReward(@PathVariable(name = "rno") int rno, Reward reward, RedirectAttributes attr) {
        if (rno != 0) {
            reward.setRno(rno);
            if (rewardService.deleteReward(reward)) {
                attr.addFlashAttribute("deleteMsg", "1");
                return "redirect:/rewardAction/findRewardList";
            }
        }
        attr.addFlashAttribute("deleteMsg", "-1");
        return "redirect:/rewardAction/findRewardList";
    }

    /**
     * 查询荣誉信息
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/findRewardList")
    public String findRewardList(ModelMap modelMap, @ModelAttribute(name = "updateMessage") String updateMsg, @ModelAttribute(name = "deleteMsg") String deleteMsg) {
        modelMap.addAttribute("rewardList", rewardService.findRewardList());
        modelMap.addAttribute("updateMsg", updateMsg);
        modelMap.addAttribute("deleteMsg", deleteMsg);
        return "pages/showReward";
    }

    public RewardService getRewardService() {
        return rewardService;
    }

    public void setRewardService(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    public StuService getStuService() {
        return stuService;
    }

    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }

    public ClsService getClsService() {
        return clsService;
    }

    public void setClsService(ClsService clsService) {
        this.clsService = clsService;
    }
}
