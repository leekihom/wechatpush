package com.wechatpush.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.wechatpush.entity.Indices;
import com.wechatpush.entity.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author leezihong
 * @date 2023/1/4 15:51
 * @description
 */
@Component
@Slf4j
public class WeatherUtil {

    @Value("${api.weatherApi}")
    private String weatherApi;

    @Value("${api.indicesApi}")
    private String indicesApi;

    @Value("${api.cityid}")
    private String citycode;

    @Value("${api.cityname}")
    private String cityname;

    @Value("${api.key}")
    private String key;

    @Value("${api.type}")
    private String type;


    public Weather getWeather(String citycode){

        HashMap<String, Object> param = new HashMap<>();
        param.put("location",citycode);
        param.put("key",key);
        String response = HttpUtil.get(weatherApi, param);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        Weather weather = (Weather)jsonObject.get("now");
        return weather;
    }

    public Weather getWeather(){

        HashMap<String, Object> param = new HashMap<>();
        param.put("location",citycode);
        param.put("key",key);
        String response = HttpUtil.get(weatherApi, param);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        JSONObject weatherobj = (JSONObject) jsonObject.get("now");
        Weather weather = new Weather(cityname,weatherobj.get("text").toString(),weatherobj.get("windDir").toString(),
                weatherobj.get("temp").toString(),
                weatherobj.get("feelsLike").toString(),weatherobj.get("humidity").toString());
        log.info(weather.toString());
        return weather;
    }

    public Indices getIndices(){

        HashMap<String, Object> param = new HashMap<>();
        param.put("location",citycode);
        param.put("key",key);
        param.put("type",type);
        String response = HttpUtil.get(indicesApi, param);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        List<JSONObject> list = (List) jsonObject.get("daily");
        Indices indices = new Indices(list.get(0).get("name").toString(),list.get(0).get("text").toString(),
                list.get(1).get("name").toString(),list.get(1).get("text").toString(),
                list.get(2).get("name").toString(),list.get(2).get("text").toString());
        log.info(indices.toString());
        return indices;
    }

}
