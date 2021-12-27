package com.www.acorn.enums;

public enum AcornTypeEnum {
    //Success or failure
    Success(200),failure(500);
    private Integer type;

    public Integer getType() {
        return type;
    }
    AcornTypeEnum(Integer type){
        this.type=type;
    }

    public static boolean isExist(Integer type) {
        for(AcornTypeEnum cte:AcornTypeEnum.values()){
            if(cte.type==type){
                return true;
            }
        }
        return false;
    }

}
