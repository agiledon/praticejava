package xyz.zhangyi.practicejava.advance.java8.optional.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public abstract class Json {
    public static JsonObject parse(String jsonStr) {
        JSONObject rootJsonObj = JSON.parseObject(jsonStr);
        return new JsonObject(rootJsonObj);
    }

    public static String toJsonString(Object obj) {
        if (obj instanceof JsonObject) {
            return JSON.toJSONString(((JsonObject) obj).getJSONObject());
        }
        return JSON.toJSONString(obj);
    }

    public static <T> T toJavaObject(JsonObject json, Class<T> clazz) {
        return JSON.toJavaObject(json.getJSONObject(), clazz);
    }
}