package com.myprogram.service;

import com.myprogram.dao.ClsDao;
import com.myprogram.entity.Cls;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("clsService")
@Transactional(propagation = Propagation.REQUIRED)
public class ClsService {

    @Resource(name = "clsDao")
    private ClsDao clsDao;

    /**
     * 添加班级
     *
     * @param cls 班级对象
     * @return true or false
     */
    public boolean addCls(Cls cls) {
        return clsDao.addObject(cls);
    }

    /**
     * 修改班级
     *
     * @param cls 班级对象
     * @return true or false
     */
    public boolean updateCls(Cls cls) {
        return clsDao.updateObject(cls);
    }

    /**
     * 删除班级
     *
     * @param cls 班级对象
     * @return true or false
     */
    public boolean deleteCls(Cls cls) {
        return clsDao.deleteObject(cls);
    }

    /**
     * 查询班级信息
     *
     * @return 班级信息集合
     */
    public List findClsList() {
        String hql = "from Cls c order by c.cname";
        return clsDao.findObjectList(hql);
    }


    /**
     * 班级详细信息
     *
     * @return 班级详细信息集合
     */
    public List findClsInfo(){
        String hql = "select c.cno,c.cname,count(s.sno) from Cls c left join Stu s on c.cno = s.cls.cno group by c.cno,c.cname order by c.cname";
        return clsDao.findObjectList(hql);
    }

    /**
     * 通过id获取班级信息
     *
     * @param cno 班级id
     * @return 班级对象
     */
    public Cls getClsById(int cno) {
        return (Cls) clsDao.getObjectById(Cls.class, cno);
    }

    public void setClsDao(ClsDao clsDao) {
        this.clsDao = clsDao;
    }
}
