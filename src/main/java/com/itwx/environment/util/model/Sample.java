package com.itwx.environment.util.model;

/**
 * @Author:wx
 * @Date:2019/8/20 13:20
 */
public class Sample {
    private String library;
    private String result;
    private String action;

    public Sample(String library, String result, String action) {
        this.library = library;
        this.result = result;
        this.action = action;
    }

    public Sample() {
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
