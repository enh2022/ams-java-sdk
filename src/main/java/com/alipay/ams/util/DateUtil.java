/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.alipay.ams.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.bind.DatatypeConverter;

/**
 * 
 * @author guangling.zgl
 * @version $Id: DateUtil.java, v 0.1 2019年10月16日 下午4:25:49 guangling.zgl Exp $
 */
public class DateUtil {

    /** ISO datetime最小长度，必须带有时区，可能还有微秒 */
    private final static int    ISO_DATE_LENGTH       = 25;

    /** UTC 0时区的ISO datetime最小长度，时区信息是字符Z，不是+00:00格式 */
    private final static int    UTC_0_ISO_DATE_LENGTH = 20;

    /** UTC 0时区的timezone标识 */
    private final static String UTC_0_TIMEZONE        = "Z";

    public final static String  longFormat            = "yyyyMMddHHmmss";

    /**
     * 获取ISO的时间字符串
     * 
     * @param date
     * @return ISO的时间字符串
     */
    public static String getISODateTimeStr(Date date) {
        return getISODateTimeStr(date, null);
    }

    /**
     * 获取指定时区的ISO的时间字符串
     * 
     * @param date 日期
     * @param timeZone 时区
     * @return ISO的时间字符串
     */
    public static String getISODateTimeStr(Date date, TimeZone timeZone) {
        if (date == null) {
            return null;
        }

        Calendar cal = new GregorianCalendar();
        if (timeZone != null) {
            cal.setTimeZone(timeZone);
        }
        cal.setTime(date);
        cal.set(Calendar.MILLISECOND, 0);
        return DatatypeConverter.printDateTime(cal);
    }

    /**
     * 解析ISO的时间字符串
     * 
     * @param isoDateStr
     * @return ISO的时间字符串
     */
    public static Date parseISODateTimeStr(String isoDateStr) {
        if (StringUtil.isBlank(isoDateStr)) {
            return null;
        }

        int minDateStrLength;
        // UTC 0时区字符串，时区标识是字符Z，不是+00:00
        if (isoDateStr.endsWith(UTC_0_TIMEZONE)) {
            minDateStrLength = UTC_0_ISO_DATE_LENGTH;

        } else {
            minDateStrLength = ISO_DATE_LENGTH;
        }

        if (isoDateStr.length() < minDateStrLength) {
            return null;
        }

        Calendar cal = DatatypeConverter.parseDate(isoDateStr);
        return cal.getTime();
    }
}
