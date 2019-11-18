package com.demo.mysql.enums;

public enum  TimeEnum {

    SECOND("SECOND", "秒"),
    MINUTES("MINUTES", "分"),
    HOUR("HOUR","时"),
    DAY("DAY", "天"),
    WEEK("WEEK", "周"),
    MONTH("MONTH","月"),
    YEAR("YEAR","年");
    private String type;
    private String desc;


    TimeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
