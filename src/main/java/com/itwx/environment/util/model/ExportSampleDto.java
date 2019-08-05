package com.itwx.environment.util.model;

import java.util.Date;

/**
 * @Author:wx
 * @Date:2019/7/18 17:38
 */
public class ExportSampleDto {
    /**检测项目*/
    private String itemName;
    /**样品编号->实验编号*/
    private String labNo;
    /**孕妇姓名*/
    private String patientName;
    /**拼音*/
    private String spell;
    /**身份证号*/
    private String identityCard;
    /**手机*/
    private String mobile;
    /**病案号->门诊号*/
    private String sourcePatientId;
    /**采血管类型*/
    private String bloodType;
    /**采血医院*/
    private String departmentName;
    /**送检单位*/
    private String sourceDept;
    /**采血时间*/
    private String collectDate;
    /**是否重采血*/
    private String heavyBlood;
    /**孕周*/
    private String cycleWeek;
    /**孕天*/
    private String cycleDay;
    /**孕妇年龄*/
    private Integer age;
    /**是否上保险*/
    private Boolean insurance;
    /**孕妇生日*/
    private Date birthday;
    /**胎儿父亲年龄*/
    private Integer fatherAge;
    /**采血时体重(KG)*/
    private Float weight;
    /**身高(CM)*/
    private Float height;
    /**紧急联系电话->手机号*/
    private String urgencyMobile;
    /**月经周期*/
    private String  menstrualCycle;
    /**未次月经*/
    private String lmpDate;
    /**邮寄地址*/
    private String mailingAddress;
    /**邮编*/
    private String postcode;
    /**孕数*/
    private String gravidity;
    /**产数*/
    private String parity;
    /**不良孕产史*/
    private String badHistory;
    /**不良孕产史情况*/
    private String badHistoryCondition;
    /**家族遗传病*/
    private String familyHeredity;
    /**家庭遗传病情况*/
    private String familyHeredityCondition;
    /**夫妻双方染色体核型*/
    private String karyotype;
    /**夫妻双方染色体核型情况*/
    private String karyotypeCondition;
    /**双胎/多胎妊娠*/
    private String fetusNum;
    /**妊娠情况其他*/
    private String gravidityCondition;
    /**IVF-ET妊娠*/
    private String isIvf;
    /**超声检查*/
    private String supersonicInspection;
    /**超声检查情况*/
    private String supersonCondition;
    /**血清筛查*/
    private String serumScreening;
    /**21体风险值*/
    private String t21Risk;
    /**18体风险值*/
    private String t18Risk;
    /**预约介入性穿刺手术*/
    private String subscribePuncture;
    /**预约介入性穿刺手术时间*/
    private String subscribePunctureDate;
    /**细胞治疗*/
    private String cellTherapy;
    /**细胞治疗情况*/
    private String cellTherapyCondition;
    /**肿瘤患者*/
    private String cancerPatient;
    /**肿瘤患者情况*/
    private String cancerPatientCondition;
    /**一年内异体输血*/
    private String annuallyTransfusion;
    /**一年内异体输血情况*/
    private String annuallyTransfusionCondition;
    /**特殊情况备注*/
    private String specialSituation;
    /**住院/门诊号->住院号*/
    private String admissionNo;
    /**NTD*/
    private String ntd;
    /**筛查模式*/
    private String screeningModel;
    /**临床诊断*/
    private String clinicalDiagnosis;
    /**送检医生*/
    private String applyDocName;
    /**接收日期*/
    private String receiveDate;
    /**申请单ID*/
    private String applyId;
    /**检测者*/
    private String experimenterName;
    /**审核者*/
    private String checkerName;
    /**预产期*/
    private String expectedDate;
    /**原样本编号*/
    private String historyLabNo;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getLabNo() {
        return labNo;
    }

    public void setLabNo(String labNo) {
        this.labNo = labNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSourcePatientId() {
        return sourcePatientId;
    }

    public void setSourcePatientId(String sourcePatientId) {
        this.sourcePatientId = sourcePatientId;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSourceDept() {
        return sourceDept;
    }

    public void setSourceDept(String sourceDept) {
        this.sourceDept = sourceDept;
    }

    public String getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(String collectDate) {
        this.collectDate = collectDate;
    }

    public String getHeavyBlood() {
        return heavyBlood;
    }

    public void setHeavyBlood(String heavyBlood) {
        this.heavyBlood = heavyBlood;
    }

    public String getCycleWeek() {
        return cycleWeek;
    }

    public void setCycleWeek(String cycleWeek) {
        this.cycleWeek = cycleWeek;
    }

    public String getCycleDay() {
        return cycleDay;
    }

    public void setCycleDay(String cycleDay) {
        this.cycleDay = cycleDay;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getFatherAge() {
        return fatherAge;
    }

    public void setFatherAge(Integer fatherAge) {
        this.fatherAge = fatherAge;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getUrgencyMobile() {
        return urgencyMobile;
    }

    public void setUrgencyMobile(String urgencyMobile) {
        this.urgencyMobile = urgencyMobile;
    }

    public String getMenstrualCycle() {
        return menstrualCycle;
    }

    public void setMenstrualCycle(String menstrualCycle) {
        this.menstrualCycle = menstrualCycle;
    }

    public String getLmpDate() {
        return lmpDate;
    }

    public void setLmpDate(String lmpDate) {
        this.lmpDate = lmpDate;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getGravidity() {
        return gravidity;
    }

    public void setGravidity(String gravidity) {
        this.gravidity = gravidity;
    }

    public String getParity() {
        return parity;
    }

    public void setParity(String parity) {
        this.parity = parity;
    }

    public String getBadHistory() {
        return badHistory;
    }

    public void setBadHistory(String badHistory) {
        this.badHistory = badHistory;
    }

    public String getBadHistoryCondition() {
        return badHistoryCondition;
    }

    public void setBadHistoryCondition(String badHistoryCondition) {
        this.badHistoryCondition = badHistoryCondition;
    }

    public String getFamilyHeredity() {
        return familyHeredity;
    }

    public void setFamilyHeredity(String familyHeredity) {
        this.familyHeredity = familyHeredity;
    }

    public String getFamilyHeredityCondition() {
        return familyHeredityCondition;
    }

    public void setFamilyHeredityCondition(String familyHeredityCondition) {
        this.familyHeredityCondition = familyHeredityCondition;
    }

    public String getKaryotype() {
        return karyotype;
    }

    public void setKaryotype(String karyotype) {
        this.karyotype = karyotype;
    }

    public String getKaryotypeCondition() {
        return karyotypeCondition;
    }

    public void setKaryotypeCondition(String karyotypeCondition) {
        this.karyotypeCondition = karyotypeCondition;
    }

    public String getFetusNum() {
        return fetusNum;
    }

    public void setFetusNum(String fetusNum) {
        this.fetusNum = fetusNum;
    }

    public String getGravidityCondition() {
        return gravidityCondition;
    }

    public void setGravidityCondition(String gravidityCondition) {
        this.gravidityCondition = gravidityCondition;
    }

    public String getIsIvf() {
        return isIvf;
    }

    public void setIsIvf(String isIvf) {
        this.isIvf = isIvf;
    }

    public String getSupersonicInspection() {
        return supersonicInspection;
    }

    public void setSupersonicInspection(String supersonicInspection) {
        this.supersonicInspection = supersonicInspection;
    }

    public String getSupersonCondition() {
        return supersonCondition;
    }

    public void setSupersonCondition(String supersonCondition) {
        this.supersonCondition = supersonCondition;
    }

    public String getSerumScreening() {
        return serumScreening;
    }

    public void setSerumScreening(String serumScreening) {
        this.serumScreening = serumScreening;
    }

    public String getT21Risk() {
        return t21Risk;
    }

    public void setT21Risk(String t21Risk) {
        this.t21Risk = t21Risk;
    }

    public String getT18Risk() {
        return t18Risk;
    }

    public void setT18Risk(String t18Risk) {
        this.t18Risk = t18Risk;
    }

    public String getSubscribePuncture() {
        return subscribePuncture;
    }

    public void setSubscribePuncture(String subscribePuncture) {
        this.subscribePuncture = subscribePuncture;
    }

    public String getSubscribePunctureDate() {
        return subscribePunctureDate;
    }

    public void setSubscribePunctureDate(String subscribePunctureDate) {
        this.subscribePunctureDate = subscribePunctureDate;
    }

    public String getCellTherapy() {
        return cellTherapy;
    }

    public void setCellTherapy(String cellTherapy) {
        this.cellTherapy = cellTherapy;
    }

    public String getCellTherapyCondition() {
        return cellTherapyCondition;
    }

    public void setCellTherapyCondition(String cellTherapyCondition) {
        this.cellTherapyCondition = cellTherapyCondition;
    }

    public String getCancerPatient() {
        return cancerPatient;
    }

    public void setCancerPatient(String cancerPatient) {
        this.cancerPatient = cancerPatient;
    }

    public String getCancerPatientCondition() {
        return cancerPatientCondition;
    }

    public void setCancerPatientCondition(String cancerPatientCondition) {
        this.cancerPatientCondition = cancerPatientCondition;
    }

    public String getAnnuallyTransfusion() {
        return annuallyTransfusion;
    }

    public void setAnnuallyTransfusion(String annuallyTransfusion) {
        this.annuallyTransfusion = annuallyTransfusion;
    }

    public String getAnnuallyTransfusionCondition() {
        return annuallyTransfusionCondition;
    }

    public void setAnnuallyTransfusionCondition(String annuallyTransfusionCondition) {
        this.annuallyTransfusionCondition = annuallyTransfusionCondition;
    }

    public String getSpecialSituation() {
        return specialSituation;
    }

    public void setSpecialSituation(String specialSituation) {
        this.specialSituation = specialSituation;
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getNtd() {
        return ntd;
    }

    public void setNtd(String ntd) {
        this.ntd = ntd;
    }

    public String getScreeningModel() {
        return screeningModel;
    }

    public void setScreeningModel(String screeningModel) {
        this.screeningModel = screeningModel;
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    public String getApplyDocName() {
        return applyDocName;
    }

    public void setApplyDocName(String applyDocName) {
        this.applyDocName = applyDocName;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getExperimenterName() {
        return experimenterName;
    }

    public void setExperimenterName(String experimenterName) {
        this.experimenterName = experimenterName;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getHistoryLabNo() {
        return historyLabNo;
    }

    public void setHistoryLabNo(String historyLabNo) {
        this.historyLabNo = historyLabNo;
    }
}
