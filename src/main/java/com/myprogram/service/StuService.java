package com.myprogram.service;
import com.myprogram.dao.StuDao;
import com.myprogram.entity.Cls;
import com.myprogram.entity.Stu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2017/11/19.
 */

@Service("stuService")
@Transactional(propagation = Propagation.REQUIRED)
public class StuService {

    @Resource(name = "stuDao")
    private StuDao stuDao;

    /**
     * 添加学生
     *
     * @param stu 学生对象
     * @return true or false
     */
    public boolean addStu(Stu stu) {
        return stuDao.addObject(stu);
    }

    /**
     * 修改学生
     *
     * @param stu 学生对象
     * @return true or false
     */
    public boolean updateStu(Stu stu) {
        return stuDao.updateObject(stu);
    }

    /**
     * 删除学生
     *
     * @param stu 学生对象
     * @return true or false
     */
    public boolean deleteStu(Stu stu) {
        return stuDao.deleteObject(stu);
    }

    /**
     * 查询学生信息
     *
     * @return 学生信息集合
     */
    public List findStuList() {
        String hql = "from Stu s left join s.cls c order by c.cname";
        return stuDao.findObjectList(hql);
    }

    /**
     * 根据班级查询学生
     * @param cls
     * @return
     */
    public List findStuList(Cls cls) {
        String hql = "from Stu s where s.cls.cno="+cls.getCno();
        return stuDao.findObjectList(hql);
    }

    /**
     * 通过id获取学生
     *
     * @param sno 学生id
     * @return 学生对象
     */
    public Stu getStuById(int sno) {
        return (Stu) stuDao.getObjectById(Stu.class, sno);
    }

    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }
}
