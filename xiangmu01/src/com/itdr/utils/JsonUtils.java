package com.itdr.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itdr.common.ResponseCode;

import java.io.IOException;

public class JsonUtils {
    //将string转换成JSon格式
    private static ObjectMapper objectMapper =new ObjectMapper();
    public static <T> String obj2String(T obj){
        if (obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ResponseCode rs = new ResponseCode();
        rs.setStatus(2);
        rs.setMag("测试");
        String s = obj2String(rs);
        System.out.println(s);
    }
}
