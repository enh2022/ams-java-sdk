/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.alipay.ams.domain;

import java.util.Map;

/**
 * 
 * @author guangling.zgl
 * @version $Id: RequestHeader.java, v 0.1 2019年10月16日 下午3:47:58 guangling.zgl Exp $
 */
public class NotifyResponseHeader extends Header {

    private String              responseTime;

    private String              sdkVersion;
    private String              ext;
    private Map<String, String> extraHeaders;

    /** 
     * @see com.alipay.ams.domain.Header#toMap()
     */
    @Override
    public Map<String, String> toMap() {

        Map<String, String> map = super.toMap();
        map.put("response-Time", responseTime);
        map.put("sdkVersion", sdkVersion);
        map.put("ext", ext);

        return map;
    }

    /** 
     * @see com.alipay.ams.domain.Header#extraHeaders()
     */
    @Override
    public Map<String, String> extraHeaders() {
        return extraHeaders;
    }

    /**
     * Getter method for property <tt>responseTime</tt>.
     * 
     * @return property value of responseTime
     */
    public String getResponseTime() {
        return responseTime;
    }

    /**
     * Setter method for property <tt>responseTime</tt>.
     * 
     * @param responseTime value to be assigned to property responseTime
     */
    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * Getter method for property <tt>sdkVersion</tt>.
     * 
     * @return property value of sdkVersion
     */
    public String getSdkVersion() {
        return sdkVersion;
    }

    /**
     * Setter method for property <tt>sdkVersion</tt>.
     * 
     * @param sdkVersion value to be assigned to property sdkVersion
     */
    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    /**
     * Getter method for property <tt>ext</tt>.
     * 
     * @return property value of ext
     */
    public String getExt() {
        return ext;
    }

    /**
     * Setter method for property <tt>ext</tt>.
     * 
     * @param ext value to be assigned to property ext
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * Setter method for property <tt>extraHeaders</tt>.
     * 
     * @param extraHeaders value to be assigned to property extraHeaders
     */
    public void setExtraHeaders(Map<String, String> extraHeaders) {
        this.extraHeaders = extraHeaders;
    }
}
