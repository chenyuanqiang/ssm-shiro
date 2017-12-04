package com.execption.model;

/**
 * Created by cyq on 2017/12/4.
 */
public class result {
    private String resultCode;
    private String resultMess;
    private Object data;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMess() {
        return resultMess;
    }

    public void setResultMess(String resultMess) {
        this.resultMess = resultMess;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "result{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMess='" + resultMess + '\'' +
                ", data=" + data +
                '}';
    }
}
