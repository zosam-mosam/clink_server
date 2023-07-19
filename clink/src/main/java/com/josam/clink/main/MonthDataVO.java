package com.josam.clink.main;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter
public class MonthDataVO {

    Date date;
    int val;
    
    public MonthDataVO(Date date, int val) {
        this.date = date;
        this.val = val;
    }
}
