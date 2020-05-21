package com.example.appointment.service;

import com.alibaba.fastjson.JSONObject;
import com.example.appointment.dao.TimeDao;
import com.example.appointment.entity.TimeBean;
import com.example.appointment.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {
    @Autowired
    private TimeDao timeDao;

    /**
     * 发布预约
     * @param timeBean
     * @return
     */
    public JSONObject addTime(TimeBean timeBean){
        List<TimeBean> timeBeans = timeDao.queryTime(null, timeBean.getUser_id(), -1, timeBean.getStarttime(), timeBean.getEndtime(), null);
        if(!timeBeans.isEmpty() || timeBeans.size() != 0){
            return StringUtils.result(1, "该时间段内已经发布预约！");
        }

        timeBean.setTid(StringUtils.getUUID());
        if(timeDao.insertTime(timeBean) == 0){
            return StringUtils.result(1, "预约发布失败");
        }

        return StringUtils.result(0, "预约发布成功！");
    }

    /**
     * 查询预约列表
     * @param pagesize
     * @param pagenum
     * @param user_id
     * @param schedule
     * @return
     */
    public JSONObject getTimeList(int pagesize, int pagenum, String user_id, int schedule, String schedule_user){
        PageHelper.startPage(pagenum, pagesize);
        PageInfo<TimeBean> pageinfo = new PageInfo<TimeBean>(timeDao.queryTime(null, user_id, schedule, null, null, schedule_user));
        if(pageinfo.getList() == null || pageinfo.getList().size() == 0){
            return StringUtils.result(1, "未查询到数据！");
        }

        return StringUtils.result(0, pageinfo);
    }

    /**
     * 修改预约信息
     * @param address
     * @param starttime
     * @param endtime
     * @param tid
     * @return
     */
    public JSONObject editTime(String address, String starttime, String endtime, String tid){
        if(timeDao.updateById(address, starttime, endtime, -1, null, null, tid) == 0){
            return StringUtils.result(1, "预约信息修改失败！");
        }

        return StringUtils.result(0, "预约信息修改成功！");
    }

    /**
     * 提交预约人信息
     * @param schedule_user
     * @param detail
     * @param tid
     * @return
     */
    public JSONObject editTime(String schedule_user, String detail, String tid){
        List<TimeBean> timeBeans = timeDao.queryTime(tid, null, 1, null, null, null);//判断是否已经被预约
        if(!timeBeans.isEmpty() && timeBeans.size() != 0){
            return StringUtils.result(1, "预约失败，该时段已被预约！");
        }

        if(timeDao.updateById(null, null, null, 1, schedule_user, detail, tid) == 0){
            return StringUtils.result(1, "预约失败！");
        }

        return StringUtils.result(0, "预约成功！");
    }

    /**
     * 单个删除
     * @param tid
     * @return
     */
    public JSONObject remove(String tid){
        if(timeDao.deleteById(tid) == 0){
            return StringUtils.result(1, "删除失败！");
        }
        return StringUtils.result(0, "删除成功！");
    }

    /**
     * 批量删除
     * @param tid
     * @return
     */
    public JSONObject remove(List<String> tid){
        if(timeDao.deleteByIdList(tid) == 0){
            return StringUtils.result(1, "删除失败！");
        }
        return StringUtils.result(0, "删除成功！");
    }
}
