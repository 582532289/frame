package com.frame.joke.model;

import java.util.List;

/**
 * Created by xuning on 17/3/2.
 */

public class Back {

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<JokeBean> data;

        public List<JokeBean> getData() {
            return data;
        }

        public void setData(List<JokeBean> data) {
            this.data = data;
        }

    }


    @Override
    public String toString() {
        return "Back{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
