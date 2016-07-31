package com.cmcc.flowmoney.model.json.input;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by LIGHTNING on 2016/7/31.
 */
public class BusiInfo {

    @JSONField(name = "migusum")
    private String migusum;

    @JSONField(name = "passId")
    private String passId;

    @JSONField(name = "count")
    private String count;

    @JSONField(name = "freezeSn")
    private String freezeSn;

    @JSONField(name = "passId")
    private String passName;

    @JSONField(name = "transactionId")
    private String transactionId;

    @JSONField(name = "message")
    private String message;

    @JSONField(name = "transPassName")
    private String transPassName;

    @JSONField(name = "oldPassName")
    private String oldPassName;

    public String getMigusum() {
        return migusum;
    }

    public void setMigusum(String migusum) {
        this.migusum = migusum;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getFreezeSn() {
        return freezeSn;
    }

    public void setFreezeSn(String freezeSn) {
        this.freezeSn = freezeSn;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransPassName() {
        return transPassName;
    }

    public void setTransPassName(String transPassName) {
        this.transPassName = transPassName;
    }

    public String getOldPassName() {
        return oldPassName;
    }

    public void setOldPassName(String oldPassName) {
        this.oldPassName = oldPassName;
    }
}
