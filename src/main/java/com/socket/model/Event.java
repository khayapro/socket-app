package com.socket.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by khayapro on 2016/04/11
 */
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(propOrder = {"userPin", "deviceId", "deviceSerial", "deviceVersion", "transType"})
public class Event implements Serializable {

    @XmlElement(name = "UserPin")
    private long userPin;
    @XmlElement(name = "DeviceId")
    private long deviceId;
    @XmlElement(name = "DeviceSer")
    private String deviceSerial;
    @XmlElement(name = "DeviceVer")
    private String deviceVersion;
    @XmlElement(name = "TransType")
    private String transType;

    public long getUserPin() {
        return userPin;
    }

    public void setUserPin(long userPin) {
        this.userPin = userPin;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "userPin=" + userPin +
                ", deviceId=" + deviceId +
                ", deviceSerial='" + deviceSerial + '\'' +
                ", deviceVersion='" + deviceVersion + '\'' +
                ", transType='" + transType + '\'' +
                '}';
    }
}
