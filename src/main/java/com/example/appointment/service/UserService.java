package com.example.appointment.service;

import com.alibaba.fastjson.JSONObject;
import com.example.appointment.dao.UserDao;
import com.example.appointment.entity.UserBean;
import com.example.appointment.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 登录处理
     * @param account
     * @param password
     * @return
     */
    public JSONObject login(String account, String password, HttpSession session){
        List<UserBean> list = userDao.queryUser(account, password, null, -1);
        if(list.isEmpty() || list.size() == 0){
            return StringUtils.result(1, "用户不存在，或密码错误！");
        }

        UserBean userBean = list.get(0);
        if((userBean.getUser_position() == 1 || userBean.getUser_position() == 2) && userBean.getChecked() == 0){
            return StringUtils.result(1, "用户待审核中，请联系管理员！");
        }

        session.setAttribute("user_id", userBean.getUser_id());
        session.setAttribute("user_position", userBean.getUser_position());
        return StringUtils.result(0, userBean);
    }

    /**
     * 注册处理
     * @param userBean
     * @return
     */
    public JSONObject registe(UserBean userBean){
        List<UserBean> list = userDao.queryUser(userBean.getUser_account(), null, null, -1);
        if(!list.isEmpty() && list.size() != 0){
            return StringUtils.result(1, "注册失败，已存在该账户！");
        }

        userBean.setUser_id(StringUtils.getUUID());
        if(userDao.insertUser(userBean) != 0){
            return StringUtils.result(0, userBean.getUser_position() == 1 || userBean.getUser_position() == 2 ? "注册成功，待审核！" : "注册成功！");
        }
        return StringUtils.result(1, "注册失败！");
    }

    public JSONObject getUserList(int pagesize, int pagenum, int user_position){
        PageHelper.startPage(pagenum, pagesize);
        PageInfo<UserBean> pageInfo = new PageInfo<>(userDao.queryUser(null, null, null, user_position));
        if(pageInfo.getList() == null || pageInfo.getList().size() == 0){
            return StringUtils.result(1, "未查询到数据！");
        }
        return StringUtils.result(0, pageInfo);
    }

    /**
     * 修改用户密码
     * @param user_id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public JSONObject editPassword(String user_id, String oldPassword, String newPassword){
        List<UserBean> userBeans = userDao.queryUser(null, oldPassword, user_id, -1);
        if(userBeans.isEmpty() || userBeans.size() == 0){
            return StringUtils.result(1, "修改失败，原密码输入错误！");
        }

        if(userDao.updateById("user_password", newPassword, user_id) == 0){
            return StringUtils.result(1, "用户密码修改失败！");
        }

        return StringUtils.result(0, "用户密码修改成功！");
    }

    /**
     * 修改用户审核状态
     * @param user_id
     * @return
     */
    public JSONObject editChecked(String user_id){
        if(userDao.updateById("checked", 1, user_id) == 0){
            return StringUtils.result(1, "用户审核失败！");
        }
        return StringUtils.result(0, "用户审核成功！");
    }

    /**
     * 单个删除用户
     * @param user_id
     * @return
     */
    public JSONObject removeUser(String user_id){
        if (userDao.deleteById(user_id) == 0){
            return StringUtils.result(1, "用户删除失败！");
        }
        return StringUtils.result(0, "用户删除成功！");
    }

    /**
     * 批量删除用户
     * @param user_id
     * @return
     */
    public JSONObject removeUser(@RequestBody List<String> user_id){
        if (userDao.deleleByIdList(user_id) == 0){
            return StringUtils.result(1, "用户删除失败！");
        }
        return StringUtils.result(0, "用户删除成功！");
    }
}
