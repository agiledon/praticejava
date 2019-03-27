package xyz.zhangyi.practicejava.advance.java8.optional.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonObjectUtil {
    private static String topJsonObjName = "caacetc";

    public static JSONObject getTopJsonObject(JSONObject jsonObj) {
        return jsonObj.getJSONObject(topJsonObjName);
    }

    public static boolean isArray(JSONObject jsonObj, String tagName) {
        return jsonObj.getString(tagName).startsWith("[");
    }

    public static String getOrElse(JSONObject jsonObject, String tagName, String defaultValue) {
        if (jsonObject.getString(tagName) != null) {
            return jsonObject.getString(tagName);
        }
        return defaultValue;
    }

    public static Integer getOrElse(JSONObject jsonObject, String tagName, Integer defaultValue) {
        if (jsonObject.getInteger(tagName) != null) {
            return jsonObject.getInteger(tagName);
        }
        return defaultValue;
    }

    public static String toJsonString(Object object) {
        return JSON.toJSONString(object);
    }
}
