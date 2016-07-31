package com.cmcc.flowmoney.model.json.input;

import com.alibaba.fastjson.annotation.JSONField;
import com.cmcc.flowmoney.model.json.input.BusiInfo;

/**
 * Created by LIGHTNING on 2016/7/31.
 */
public class Body {

    @JSONField(name = "BUSI_INFO")
    private BusiInfo busiInfo;

    public BusiInfo getBusiInfo() {
        return busiInfo;
    }

    public void setBusiInfo(BusiInfo busiInfo) {
        this.busiInfo = busiInfo;
    }
}
