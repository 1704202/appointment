package com.example.appointment.util;

import com.alibaba.fastjson.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class StringUtils {
    /**
     * 统一接口返回格式
     * @param code
     * @param object
     * @return
     */
    public static JSONObject result(int code, Object object){
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("msg", code == 1 ? object : "");
        obj.put("data", code == 0 ? object : "");
        return obj;
    }

    /**
     * 获取唯一标识
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().toUpperCase().replaceAll("-","");
        return uuid;
    }

    /**
     * 按指定格式格式化时间
     * @param format
     * @return
     */
    public static String getFormatDate(String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }

    public static String getFormatDate(Timestamp timestamp, String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(timestamp);
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }

    public static String checkSum(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(str.getBytes());
            StringBuffer buf = new StringBuffer();
            byte[] bytes = md.digest();
            for(int i = 0; i < bytes.length; i++){
                int a = bytes[i];
                if(a < 0)
                    a += 256;
                if(a < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(a));
            }
            return buf.toString().toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
