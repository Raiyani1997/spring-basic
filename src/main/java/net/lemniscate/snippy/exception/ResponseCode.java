package net.lemniscate.snippy.exception;

public enum ResponseCode {

    SUCCESS(0),
    ERROR(1);

    private final int responseCodeObj;

    ResponseCode(int rCode) {
        this.responseCodeObj = rCode;
    }

    public int getResponseCode() {
        return this.responseCodeObj;
    }
}
