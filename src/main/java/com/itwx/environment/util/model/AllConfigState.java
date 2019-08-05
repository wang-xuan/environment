package com.itwx.environment.util.model;

/**
 * @Author:wx
 * @Date:2018/12/21 13:14
 */
public final class AllConfigState {
    /**项目类型：项目分类 0*/
    public final static Integer ITEM_TYPE_PARENT = 0;
    /**项目类型：项目 1*/
    public final static Integer ITEM_TYPE_CHILDREN = 1;
    /**项目状态：启用 1*/
    public final static Integer ITEM_OPEN_STATE = 1;
    /**项目状态：停用 0*/
    public final static Integer ITEM_STOP_STATE = 0;

    public static final String ADMIN = "admin";


    public static final String[] EXCEL_TITLE = {
            "检测项目","样品编号","孕妇姓名","拼音", "身份证号","手机","病案号","采血管类型",
            "采血医院","送检单位", "采血时间","是否重采血","孕周","孕天","孕妇年龄","是否上保险",
            "孕妇生日","胎儿父亲年龄","采血时体重","身高","紧急联系电话","月经周期","未次月经",
            "邮寄地址","邮编","孕数","产数","不良孕产史","不良孕产史情况","家族遗传病","家庭遗传病情况",
            "夫妻双方染色体核型","夫妻双方染色体核型情况","双胎/多胎妊娠","妊娠情况其他","IVF-ET妊娠",
            "超声检查","超声检查情况","血清筛查","21体","18体","预约介入性穿刺手术","预约介入性穿刺手术时间",
            "细胞治疗","细胞治疗情况","肿瘤患者","肿瘤患者情况","一年内异体输血","一年内异体输血情况","特殊情况备注",
            "住院/门诊号","NTD","筛查模式","临床诊断","送检医生","接收日期","申请单ID","检测者","审核者","预产期","原样本编号"};

    public static final String SHEET_NAME = "样本信息";
}
