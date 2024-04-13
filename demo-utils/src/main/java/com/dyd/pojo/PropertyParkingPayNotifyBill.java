package com.dyd.pojo;

import java.io.Serializable;

/**
 * @author ChengKang
 * @version Id: PropertyParkingPayNotifyBill.java v 0.1 2019/7/16 15:21 ChengKang Exp $$
 */
public class PropertyParkingPayNotifyBill implements Serializable {

    private String otBillId;//车场唯一账单id
    private String acctItemId;//计费唯一账单标识
    private String acctItemTypeId;
    private String feeItemTypeId;
    private String fee;
    private String lfree;
    private String billingCycle;
    private String billStart;
    private String billEnd;
    private String custId;
    private String resInstType;//2:车位 28:月卡
    private String resInstId;
    private String resInstCode;//车位编码/月卡编码
    private String resInstName;//车位名称/月卡编码

    public String getOtBillId() {
        return otBillId;
    }

    public void setOtBillId(String otBillId) {
        this.otBillId = otBillId;
    }

    public String getAcctItemId() {
        return acctItemId;
    }

    public void setAcctItemId(String acctItemId) {
        this.acctItemId = acctItemId;
    }

    public String getAcctItemTypeId() {
        return acctItemTypeId;
    }

    public void setAcctItemTypeId(String acctItemTypeId) {
        this.acctItemTypeId = acctItemTypeId;
    }

    public String getFeeItemTypeId() {
        return feeItemTypeId;
    }

    public void setFeeItemTypeId(String feeItemTypeId) {
        this.feeItemTypeId = feeItemTypeId;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getLfree() {
        return lfree;
    }

    public void setLfree(String lfree) {
        this.lfree = lfree;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public String getBillStart() {
        return billStart;
    }

    public void setBillStart(String billStart) {
        this.billStart = billStart;
    }

    public String getBillEnd() {
        return billEnd;
    }

    public void setBillEnd(String billEnd) {
        this.billEnd = billEnd;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getResInstType() {
        return resInstType;
    }

    public void setResInstType(String resInstType) {
        this.resInstType = resInstType;
    }

    public String getResInstId() {
        return resInstId;
    }

    public void setResInstId(String resInstId) {
        this.resInstId = resInstId;
    }

    public String getResInstCode() {
        return resInstCode;
    }

    public void setResInstCode(String resInstCode) {
        this.resInstCode = resInstCode;
    }

    public String getResInstName() {
        return resInstName;
    }

    public void setResInstName(String resInstName) {
        this.resInstName = resInstName;
    }

    @Override
    public String toString() {
        return "PropertyParkingPayNotifyBill{" +
                "otBillId='" + otBillId + '\'' +
                ", acctItemId='" + acctItemId + '\'' +
                ", acctItemTypeId='" + acctItemTypeId + '\'' +
                ", feeItemTypeId='" + feeItemTypeId + '\'' +
                ", fee='" + fee + '\'' +
                ", lfree='" + lfree + '\'' +
                ", billingCycle='" + billingCycle + '\'' +
                ", billStart='" + billStart + '\'' +
                ", billEnd='" + billEnd + '\'' +
                ", custId='" + custId + '\'' +
                ", resInstType='" + resInstType + '\'' +
                ", resInstId='" + resInstId + '\'' +
                ", resInstCode='" + resInstCode + '\'' +
                ", resInstName='" + resInstName + '\'' +
                '}';
    }
}
