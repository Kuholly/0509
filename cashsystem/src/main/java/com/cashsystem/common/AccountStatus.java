package com.cashsystem.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public enum AccountStatus {
    UNLOCK(1,"启用"),LOCK(2,"启停");

    private  int flg;
    private String desc;
    private   AccountStatus(int flg,String desc){
        this.desc = desc;
        this.flg = flg;
    }
    public static AccountStatus valueOf(int flg){
        for(AccountStatus accountStatus:values()){
            if (accountStatus.flg == flg){
                return accountStatus;
            }
        }
        throw new RuntimeException("accountStatus flg" + flg + " not fount!");
    }


}
