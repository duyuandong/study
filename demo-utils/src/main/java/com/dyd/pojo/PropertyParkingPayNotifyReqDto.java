package com.dyd.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ChengKang
 * @version Id: PropertyParkingPayNotifyReqDto.java v 0.1 2019/7/16 15:18 ChengKang Exp $$
 */
public class PropertyParkingPayNotifyReqDto implements Serializable {

    private Integer organId;
    private Integer communityId;
    private Integer operId;
    private String batchId;//缴费批次号
    private List<PropertyParkingPayNotify> payList;

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public List<PropertyParkingPayNotify> getPayList() {
        return payList;
    }

    public void setPayList(List<PropertyParkingPayNotify> payList) {
        this.payList = payList;
    }

    @Override
    public String toString() {
        return "PropertyParkingPayNotifyReqDto{" +
                "organId=" + organId +
                ", communityId=" + communityId +
                ", operId=" + operId +
                ", batchId='" + batchId + '\'' +
                ", payList=" + payList +
                '}';
    }
}
