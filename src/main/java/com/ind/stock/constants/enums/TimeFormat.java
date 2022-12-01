package com.ind.stock.constants.enums;

import java.sql.Time;

public enum TimeFormat {
    MINUTES("minutes"),
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    YEAR("year");

    private final String periodType;

    TimeFormat(String periodType){
        this.periodType=periodType;
    }

    public String getPeriodType() {
        return periodType;
    }

    public static TimeFormat getPeriodTypes(String periodType) {
        switch (periodType) {
            case "day":
                return DAY;
            case "week":
                return WEEK;
            case "month":
                return MONTH;
            case "year":
                return YEAR;
        }
        return null;
    }
}