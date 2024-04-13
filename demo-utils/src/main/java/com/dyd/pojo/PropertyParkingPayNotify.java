package com.dyd.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ChengKang
 * @version Id: PropertyParkingPayNotify.java v 0.1 2019/7/16 15:20 ChengKang Exp $$
 */
public class PropertyParkingPayNotify implements Serializable {

    private String paySerialNbr;
    private String payDate;
    private String payMethod;
    private String payAmount;
    private String transNo;
    private List<PropertyParkingPayNotifyBill> billList;

    public String getPaySerialNbr() {
        return paySerialNbr;
    }

    public void setPaySerialNbr(String paySerialNbr) {
        this.paySerialNbr = paySerialNbr;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public List<PropertyParkingPayNotifyBill> getBillList() {
        return billList;
    }

    public void setBillList(List<PropertyParkingPayNotifyBill> billList) {
        this.billList = billList;
    }

    @Override
    public String toString() {
        return "PropertyParkingPayNotify{" +
                "paySerialNbr='" + paySerialNbr + '\'' +
                ", payDate='" + payDate + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", transNo='" + transNo + '\'' +
                ", billList=" + billList +
                '}';
    }
}
