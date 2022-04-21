package com.jt808.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import com.jt808.protocol.basics.JTMessage;
import com.jt808.protocol.commons.JT808;

@Message(JT808.CollectAndReportDriverIdentityInformation)
public class T0702 extends JTMessage {

    @Field(length = 1, desc = "status")
    private int status;
    @Field(length = 6, charset = "BCD", desc = "time")
    private String dateTime;
    @Field(length = 1, desc = "IC card reading result")
    private int cardStatus;
    @Field(lengthUnit = 1, desc = "driver name")
    private String name;
    @Field(length = 20, desc = "Qualification certificate code")
    private String licenseNo;
    @Field(lengthUnit = 1, desc = "The name of the certificate-issuing institution")
    private String institution;
    @Field(length = 4, charset = "BCD", desc = "Certificate validity")
    private String licenseValidPeriod;
    @Field(length = 20, desc = "driver ID number", version = 1)
    private String idCard;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(int cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLicenseValidPeriod() {
        return licenseValidPeriod;
    }

    public void setLicenseValidPeriod(String licenseValidPeriod) {
        this.licenseValidPeriod = licenseValidPeriod;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}