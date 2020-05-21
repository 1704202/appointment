package com.example.appointment.dao;

import com.example.appointment.entity.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int insertUser(@Param("user") UserBean userBean);
    List<UserBean> queryUser(String user_account, String user_password, String user_id, int user_position);
    int updateById(String columname, Object value, String user_id);
    int deleteById(String user_id);
    int deleleByIdList(@Param("list") List<String> list);
}
