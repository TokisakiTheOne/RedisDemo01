package com.yyh.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * json  java互相转化的工具类
 *
 * @author YanYuHang
 * @create 2019-12-25-14:57
 */
public class JsonJavaUtils {

    //对象映射
    private static ObjectMapper om = new ObjectMapper();


    //JsonToJava
    public static Object jsonToJava(String json, Class type) {
        try {
            return om.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //JavaToJson
    public static String javaToJson(Object object) {
        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
