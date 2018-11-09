package com.ruoyi.common.enums;

public enum StartStatus {
    NoStart(0,"未启用"),Started(1,"已启用");

    private final int value;
    private final String isStart;

    public int getValue() {
        return value;
    }

    public String getIsStart() {
        return isStart;
    }

    StartStatus(int value, String isStart) {
        this.value = value;
        this.isStart = isStart;
    }
}
