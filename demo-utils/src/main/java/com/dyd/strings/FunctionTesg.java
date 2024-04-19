package com.dyd.strings;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyd.pojo.JsonPojo;
import com.dyd.pojo.PropertyParkingPayNotify;
import com.dyd.pojo.PropertyParkingPayNotifyBill;
import com.dyd.pojo.PropertyParkingPayNotifyReqDto;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author ：duyd@segimail.com
 * @class ：com.dyd.strings.FunctionTesg
 * @date ：Created in 2024/4/13 16:42
 * @description：
 * @modified By：
 * @version:
 */
public class FunctionTesg {
    public static void main(String[] args) {
        String data = "{\"organId\":\"671024\",\"communityId\":\"67\",\"operId\":\"110117115\",\"batchId\":\"147577\",\"payList\":[{\"paySerialNbr\":\"k1\",\"payDate\":\"2024-04-10 15:09:04\",\"payMethod\":\"29\",\"payAmount\":\"50000\",\"transNo\":\"\",\"billList\":[{\"acctItemId\":\"q1\",\"otBillId\":\"70194\",\"acctItemTypeId\":\"3027\",\"feeItemTypeId\":\"230004\",\"fee\":\"50000\",\"lfree\":\"0\",\"billingCycle\":\"202404\",\"billStart\":\"20240401000000\",\"billEnd\":\"20240430235959\",\"custId\":\"112623188\",\"resInstType\":\"2\",\"resInstId\":\"910812467\",\"resInstCode\":\"\",\"resInstName\":\"AA停车费\"},{\"acctItemId\":\"q2\",\"otBillId\":\"70194\",\"acctItemTypeId\":\"3027\",\"feeItemTypeId\":\"230004\",\"fee\":\"50000\",\"lfree\":\"0\",\"billingCycle\":\"202404\",\"billStart\":\"20240401000000\",\"billEnd\":\"20240430235959\",\"custId\":\"112623188\",\"resInstType\":\"2\",\"resInstId\":\"910812467\",\"resInstCode\":\"\",\"resInstName\":\"AA停车费\"}]},{\"paySerialNbr\":\"k2\",\"payDate\":\"2024-04-10 15:09:04\",\"payMethod\":\"29\",\"payAmount\":\"50000\",\"transNo\":\"\",\"billList\":[{\"acctItemId\":\"r1\",\"otBillId\":\"70194\",\"acctItemTypeId\":\"3027\",\"feeItemTypeId\":\"230004\",\"fee\":\"50000\",\"lfree\":\"0\",\"billingCycle\":\"202404\",\"billStart\":\"20240401000000\",\"billEnd\":\"20240430235959\",\"custId\":\"112623188\",\"resInstType\":\"2\",\"resInstId\":\"910812467\",\"resInstCode\":\"\",\"resInstName\":\"AA停车费\"},{\"acctItemId\":\"r2\",\"otBillId\":\"70194\",\"acctItemTypeId\":\"3027\",\"feeItemTypeId\":\"230004\",\"fee\":\"50000\",\"lfree\":\"0\",\"billingCycle\":\"202404\",\"billStart\":\"20240401000000\",\"billEnd\":\"20240430235959\",\"custId\":\"112623188\",\"resInstType\":\"2\",\"resInstId\":\"910812467\",\"resInstCode\":\"\",\"resInstName\":\"AA停车费\"}]}]}";
        PropertyParkingPayNotifyReqDto pppfr = JSONObject.parseObject(data, PropertyParkingPayNotifyReqDto.class);
        Consumer<PropertyParkingPayNotifyBill> function = list -> {
            String acctItemId = list.getAcctItemId();
            if("q1".equals(acctItemId)){
                throw new RuntimeException("ds");
            }
            System.out.println(acctItemId+"执行吗");
        };
        /*for (PropertyParkingPayNotify ppn : pppfr.getPayList()) {
            for (PropertyParkingPayNotifyBill pppnb : ppn.getBillList()) {
                System.out.println("pppnb--->"+pppnb.getAcctItemId());
                function.accept(pppnb);
            }
            System.out.println("ppn--->"+ppn.getPaySerialNbr());
        }*/

        BigDecimal monthFee = new BigDecimal("200").multiply(new BigDecimal("100")).divide(new BigDecimal("3"), 0, BigDecimal.ROUND_DOWN);
        System.out.println(monthFee);
    }
}
