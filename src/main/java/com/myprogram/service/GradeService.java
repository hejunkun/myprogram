package com.myprogram.service;

import com.myprogram.dao.GradeDao;
import com.myprogram.entity.Grade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hjk on 2018/1/8.
 */
@Service("gradeService")
@Transactional(propagation = Propagation.REQUIRED)
public class GradeService {
    @Resource(name = "gradeDao")
    private GradeDao gradeDao;

    /**
     * 添加学生成绩
     *
     * @param grade 学生成绩
     * @return true or false
     */
    public boolean addGrade(Grade grade) {
        return gradeDao.addObject(grade);
    }

    /**
     * 修改学生成绩
     *
     * @param grade 学生对象
     * @return true or false
     */
    public boolean updateGrade(Grade grade) {
        return gradeDao.updateObject(grade);
    }

    /**
     * 删除学生
     *
     * @param grade 学生成绩
     * @return true or false
     */
    public boolean deleteGrade(Grade grade) {
        return gradeDao.deleteObject(grade);
    }

    /**
     * 查询学生成绩
     *
     * @return 学生成绩集合
     */
    public List findGradeList() {
        String hql = "from Grade g left join g.cls c order by c.cname";
        return gradeDao.findObjectList(hql);
    }

    /**
     * 通过id获取学生成绩
     *
     * @param gno 学生成绩id
     * @return 学生成绩
     */
    public Grade getGradeById(int gno) {
        return (Grade) gradeDao.getObjectById(Grade.class, gno);
    }

    public GradeDao getGradeDao() {
        return gradeDao;
    }

    public void setGradeDao(GradeDao gradeDao) {
        this.gradeDao = gradeDao;
    }
}
