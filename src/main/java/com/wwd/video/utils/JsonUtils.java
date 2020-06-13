package com.wwd.video.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wwd.video.common.JsonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class JsonUtils {
    public static void writeJsonInfo(int code, Object info, HttpServletResponse response){


//将形式参数带入方法中
        JsonResult r = new JsonResult(code,0,info);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
//    把null转为 空字符串
        //1.序列化 null
        //2.转化为 空
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString("");
            }
        });
        try {
            response.setContentType("text/html;charset=utf-8");
//            objectMapper 把一个对象转化成了json字符串
            String jsonInfo = objectMapper.writeValueAsString(r);
//            返回json字符串
            PrintWriter writer = response.getWriter();
            writer.write(jsonInfo);
            writer.flush();
            writer.close();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
