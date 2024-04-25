package com.dyd.pojo;

import org.springframework.util.StringUtils;

import java.beans.Transient;
import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * 包:        com.segi.uhomecp.parking.adapter.vo
 * 类名称:    RequestData
 * 类描述:
 * 创建人:    kinas
 * 创建时间:  2020/1/21 14:24
 * 修改人:    kinas
 * 修改时间:  2020/1/21 14:24
 * 修改备注:  [说明本次修改内容]
 * 版本:      v1.0
 */
public class RequestData implements Serializable {

    private String requestId;

    private String requestTime;

    private String businessCode;

    private String systemCode;

    private String systemVersion;

    private String action;

    private Object data;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "requestId='" + requestId + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", businessCode='" + businessCode + '\'' +
                ", systemCode='" + systemCode + '\'' +
                ", systemVersion='" + systemVersion + '\'' +
                ", action='" + action + '\'' +
                ", data=" + data +
                '}';
    }
}
