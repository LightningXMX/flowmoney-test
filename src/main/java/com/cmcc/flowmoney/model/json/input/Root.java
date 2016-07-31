package com.cmcc.flowmoney.model.json.input;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by LIGHTNING on 2016/7/31.
 */
//@JSONField(name = "ROOT")

public class Root {

    @JSONField(name = "BODY")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
