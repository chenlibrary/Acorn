package com.www.acorn.enums;

public enum StatusTypeEnum {
    //Success or failure
    unread(0),//未读
    read(1);//已读
    private Integer type;

    public Integer getType() {
        return type;
    }
    StatusTypeEnum(Integer type){
        this.type=type;
    }

    public static boolean isExist(Integer type) {
        for(StatusTypeEnum cte:StatusTypeEnum.values()){
            if(cte.type==type){
                return true;
            }
        }
        return false;
    }
}
