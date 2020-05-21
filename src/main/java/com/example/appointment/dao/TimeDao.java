package com.example.appointment.dao;

import com.example.appointment.entity.TimeBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeDao {
    int insertTime(@Param("time") TimeBean timeBean);
    List<TimeBean> queryTime(String tid, String user_id, int schedule, String starttime, String endtime, String schedule_user);
    int updateById(String address, String starttime, String endtime, int schedule, String schedule_user, String detail, String tid);
    int deleteById(String tid);
    int deleteByIdList(List<String> list);
}
