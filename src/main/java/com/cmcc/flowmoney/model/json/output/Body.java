package com.cmcc.flowmoney.model.json.output;

import com.alibaba.fastjson.annotation.JSONField;
import com.cmcc.flowmoney.model.json.input.OutData;

/**
 * Created by LIGHTNING on 2016/7/31.
 */
public class Body {

    @JSONField(name = "OUT_DATA")
    private OutData outData;

    @JSONField(name = "RETURN_CODE")
    private String returnCode;

    @JSONField(name = "RETURN_MSG")
    private String returnMsg;

    @JSONField(name = "USER_MSG")
    private String uesrMsg;

    @JSONField(name = "DETAIL_MSG")
    private String detailMsg;

    @JSONField(name = "PROMPT_MSG")
    private String promptMsg;

    @JSONField(name = "RUN_IP")
    private String runIp;


    public OutData getOutData() {
        return outData;
    }

    public void setOutData(OutData outData) {
        this.outData = outData;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getUesrMsg() {
        return uesrMsg;
    }

    public void setUesrMsg(String uesrMsg) {
        this.uesrMsg = uesrMsg;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public String getPromptMsg() {
        return promptMsg;
    }

    public void setPromptMsg(String promptMsg) {
        this.promptMsg = promptMsg;
    }

    public String getRunIp() {
        return runIp;
    }

    public void setRunIp(String runIp) {
        this.runIp = runIp;
    }
}
