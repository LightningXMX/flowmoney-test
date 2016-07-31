package com.cmcc.flowmoney.model.json.input;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by LIGHTNING on 2016/7/31.
 */
public class InputJsonData {


    @JSONField(name = "ROOT")
    private Root root;


    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }
}
