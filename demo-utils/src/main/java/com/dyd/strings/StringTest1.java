package com.dyd.strings;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dyd.exception.ParkingException;
import com.dyd.pojo.JsonPojo;
import com.dyd.pojo.RequestData;
import com.dyd.utils.DateUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import segi.datacachesvr.queryparkingsys.stuParkingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：duyd@segimail.com
 * @class ：com.dyd.string.StringTest1
 * @date ：Created in 2024/2/22 9:52
 * @description：
 * @modified By：
 * @version:
 */
public class StringTest1 {
    public static void main(String[] args) {
        /*String s = StringUtils.joinWith(",", "22", "33,44");
        System.out.println(s);
        String ksis = "";
        Map map = JSONObject.parseObject(ksis, Map.class);
        System.out.println(map);*/

        JsonPojo sanni = new JsonPojo(1, "sanni", "222");
        JsonPojo sanni2 = new JsonPojo(2, "sanni", "333");
        JsonPojo sanni3 = new JsonPojo(3, "sanni2", "444");
        ArrayList<JsonPojo> jsonPojos = Lists.newArrayList(sanni);
        jsonPojos.add(sanni2);
        jsonPojos.add(sanni3);

        Map<String, String> dishesByName = jsonPojos.stream()
                .collect(Collectors.groupingBy(
                        JsonPojo::getUsername, // 根据菜的类型进行分组
                        Collectors.mapping(
                                JsonPojo::getTelNo, // 抽取出每个Dish的name属性
                                Collectors.joining(",") // 对每个分组内的name字段使用逗号和空格进行拼接
                        )
                ));

        System.out.println(JSON.toJSONString(dishesByName));


        Integer monthRate = new BigDecimal("200")
                .divide(new BigDecimal("3"),2,BigDecimal.ROUND_DOWN)
                .multiply(new BigDecimal("100")).intValue();
        System.out.println(monthRate);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sss",1992);
        jsonObject.put("zzz","ssss");
        RequestData ac = getRequestData("ac", jsonObject);
        System.out.println(JSON.toJSONString(ac));
        jsonObject.put("kkk","kiss me");
        System.out.println(JSON.toJSONString(ac));
    }


    public static RequestData getRequestData( String action, Object data) {
        RequestData requestData = new RequestData();
        requestData.setAction(action);
        requestData.setData(data);
        return requestData;
    }
}
