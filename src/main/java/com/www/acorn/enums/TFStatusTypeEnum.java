package com.www.acorn.enums;

public enum TFStatusTypeEnum {
    //Success or failure
    unok(0),//未读
    ok(1);//已读
    private Integer type;

    public Integer getType() {
        return type;
    }
    TFStatusTypeEnum(Integer type){
        this.type=type;
    }

    public static boolean isExist(Integer type) {
        for(TFStatusTypeEnum cte: TFStatusTypeEnum.values()){
            if(cte.type==type){
                return true;
            }
        }
        return false;
    }
}
