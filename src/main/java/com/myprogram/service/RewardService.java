package com.myprogram.service;

import com.myprogram.dao.RewardDao;
import com.myprogram.entity.Reward;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hjk on 2018/1/8.
 */
@Service("rewardService")
@Transactional(propagation = Propagation.REQUIRED)
public class RewardService {
    @Resource(name = "rewardDao")
    private RewardDao rewardDao;

    /**
     * 添加荣誉
     *
     * @param reward 荣誉
     * @return true or false
     */
    public boolean addReward(Reward reward) {
        return rewardDao.addObject(reward);
    }

    /**
     * 修改荣誉
     *
     * @param reward 荣誉
     * @return true or false
     */
    public boolean updateReward(Reward reward) {
        return rewardDao.updateObject(reward);
    }

    /**
     * 删除荣誉
     *
     * @param reward 荣誉
     * @return true or false
     */
    public boolean deleteReward(Reward reward) {
        return rewardDao.deleteObject(reward);
    }

    /**
     * 查询荣誉信息
     *
     * @return 荣誉信息集合
     */
    public List findRewardList() {
        String hql = "from Reward r inner join r.stu s join s.cls ";
        return rewardDao.findObjectList(hql);
    }

    /**
     * 通过id获取荣誉
     *
     * @param rno 荣誉id
     * @return 荣誉
     */
    public Reward getRewardById(int rno) {
        return (Reward) rewardDao.getObjectById(Reward.class, rno);
    }
}
