package com.myprogram.service;

import com.myprogram.dao.UserDao;
import com.myprogram.entity.Stu;
import com.myprogram.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hjk on 2017/11/8.
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    //登录
    public User doLogin(User users) {
        String hql = "from User u where u.uname='" + users.getUname() + "'";
        List<User> list = userDao.findUsersList(hql); //取出同名的所有 用户
        if (list != null && list.size() > 0) {
            for (User user : list) {
                if (user.getUname().equals(users.getUname()) && user.getUpwd().equals(users.getUpwd())) {
                    return user;
                }
            }
        }
        return null;
    }

    //添加用户
    public boolean addUser(User user){
        return userDao.addUser(user);
    }

    /**
     * 通过id获取用户
     *
     * @param uno 用户id
     * @return 用户对象
     */
    public User getUserById(int uno) {
        return (User) userDao.getObjectById(User.class, uno);
    }

    /**
     * 修改用户
     *
     * @param user 用户对象
     * @return true or false
     */
    public boolean updateUser(User user) {
        return userDao.updateObject(user);
    }

    //查询所有用户
    public List findUsersList(){
        String hql = "from User";
        return userDao.findObjectList(hql);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
