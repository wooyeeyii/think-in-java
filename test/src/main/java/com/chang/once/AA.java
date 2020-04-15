package com.chang.once;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AA {

    private String bb;

    private Integer cc;

    private Long aa;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String date;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
