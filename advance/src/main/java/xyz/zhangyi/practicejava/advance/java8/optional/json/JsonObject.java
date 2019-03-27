package xyz.zhangyi.practicejava.advance.java8.optional.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public class JsonObject extends Json implements Serializable {

    private static final long serialVersionUID = 1L;
    private JSONObject currentJsonObj;

    public JsonObject() {
        this.currentJsonObj = new JSONObject();
    }

    public JsonObject(JSONObject currentJsonObj) {
        this.currentJsonObj = currentJsonObj;
    }

    public JSONObject getJSONObject() {
        return (JSONObject) currentJsonObj.clone();
    }

    public String getString(String key) {
        return getString(key, null);
    }

    public String getString(String key, String defaultValue) {
        String result = currentJsonObj.getString(key);
        if (result == null) {
            return defaultValue;
        }
        return result;
    }

    public Integer getInteger(String key) {
        return getInteger(key, 0);
    }

    public Integer getInteger(String key, Integer defaultValue) {
        Integer result = currentJsonObj.getInteger(key);
        if (result == null) {
            return defaultValue;
        }
        return result;
    }

    public Double getDouble(String key) {
        return getDouble(key, 0.0D);
    }

    public Double getDouble(String key, Double defaultValue) {
        Double result = currentJsonObj.getDouble(key);
        if (result == null) {
            return defaultValue;
        }
        return result;
    }

    public Set<String> keySet() {
        return currentJsonObj.keySet();
    }

    public Optional<JsonObject> getJsonObject(String key) {
        try {
            JSONObject jsonObject = currentJsonObj.getJSONObject(key);
            if (jsonObject == null) {
                return Optional.empty();
            }
            return Optional.of(new JsonObject(jsonObject));
        } catch (ClassCastException ex) {
            //todo: logging
            return Optional.empty();
        }
    }

    public <T> JsonArray<T> getJsonArray(String key) {
        try {
            if (isObject(key)) {
                return getJsonArrayIfIsJSONObject(key);
            }
            if (isArray(key)) {
                return getJsonArrayIfIsJSONArray(key);
            }
            return getJsonArrayIfIsObject(key);
        } catch (ClassCastException ex) {
            return new JsonArray<>();
        }
    }

    private <T> JsonArray<T> getJsonArrayIfIsObject(String key) {
        Object obj = currentJsonObj.get(key);
        if (obj == null) {
            return new JsonArray<>();
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, obj);
        return new JsonArray<>(jsonArray);
    }

    private <T> JsonArray<T> getJsonArrayIfIsJSONArray(String key) {
        JSONArray jsonArray = currentJsonObj.getJSONArray(key);
        if (jsonArray == null || jsonArray.isEmpty()) {
            return new JsonArray<>();
        }
        return new JsonArray<>(jsonArray);
    }

    private <T> JsonArray<T> getJsonArrayIfIsJSONObject(String key) {
        JSONObject jsonObject = currentJsonObj.getJSONObject(key);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, jsonObject);
        return new JsonArray<>(jsonArray);
    }

    public JsonObject remove(String key) {
        return new JsonObject(currentJsonObj.fluentRemove(key));
    }

    public JsonObject removeAll(String... key) {
        for (int i = 0; i < key.length; i++) {
            currentJsonObj = currentJsonObj.fluentRemove(key[i]);
        }
        return new JsonObject(currentJsonObj);
    }

    public JsonObject put(String key, Object value) {
        return new JsonObject(currentJsonObj.fluentPut(key, value));
    }

    public boolean isArray(String key) {
        return byFlag(key, "[");
    }

    public boolean isObject(String key) {
        return byFlag(key, "{");
    }

    private boolean byFlag(String key, String flag) {
        return getString(key, "").trim().startsWith(flag);
    }

    @Override
    public String toString() {
        return currentJsonObj.toString();
    }
}
