package com.itwx.environment.util.model;

import java.util.Date;

/**
 * @Author:wx
 * @Date:2019/8/14 10:48
 */
public class NiptConfig {

    private String niptConfigId;

    private String labId;
    /**Reads总数*/
    private Integer readsCount;
    /**比对率*/
    private Float ratio;
    /**GC*/
    private Float gcRatio;
    /**stock文库浓度值*/
    private Float stock;
    /**胎儿染色体比率*/
    private Float fetusRatio;
    /**状态*/
    private Integer state;

    private Date createTime;

    public String getNiptConfigId() {
        return niptConfigId;
    }

    public void setNiptConfigId(String niptConfigId) {
        this.niptConfigId = niptConfigId;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public Integer getReadsCount() {
        return readsCount;
    }

    public void setReadsCount(Integer readsCount) {
        this.readsCount = readsCount;
    }

    public Float getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }

    public Float getGcRatio() {
        return gcRatio;
    }

    public void setGcRatio(Float gcRatio) {
        this.gcRatio = gcRatio;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public Float getFetusRatio() {
        return fetusRatio;
    }

    public void setFetusRatio(Float fetusRatio) {
        this.fetusRatio = fetusRatio;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
