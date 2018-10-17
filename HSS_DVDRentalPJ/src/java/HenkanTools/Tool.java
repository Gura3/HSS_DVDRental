/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HenkanTools;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author s20163031
 */
public class Tool {

/**
 * 日付文字列スラッシュ編集
 * @param ymd 日付文字列(YYYYMMDD)
 * @return 結果文字列
 */
public static String fmtSlash(String ymd){
  if(ymd == null || ymd.length() != 8){
    return ymd;
  }
  
  return ymd.substring(0,4) + "/" +
         ymd.substring(4,6) + "/" +
         ymd.substring(6,8);
}


public static String cnvSextion(String sextion){
    switch (sextion) {
        case "0":
            sextion = "新作";
            break;
        case "1":
            sextion = "準新作";
            break;
        case "2":
            sextion = "旧作";
            break;
    }
    return sextion;
}

/**
 * 2つの日付の差を求めます。
 * 日付文字列 strDate1 – strDate2 が何日かを返します。
 * 
 * @param strDate1    日付文字列 yyyy/MM/dd
 * @param strDate2    日付文字列 yyyy/MM/dd
 * @return    2つの日付の差
 * @throws ParseException 日付フォーマットが不正な場合
 */
public static int differenceDays(String strDate1,String strDate2) 
    throws ParseException {
    Date date1 = DateFormat.getDateInstance().parse(strDate1);
    Date date2 = DateFormat.getDateInstance().parse(strDate2);
    return differenceDays(date1,date2);
}
/**
 * 2つの日付の差を求めます。
 * java.util.Date 型の日付 date1 – date2 が何日かを返します。
 * 
 * 計算方法は以下となります。
 * 1.最初に2つの日付を long 値に変換します。
 * 　※この long 値は 1970 年 1 月 1 日 00:00:00 GMT からの
 * 　経過ミリ秒数となります。
 * 2.次にその差を求めます。
 * 3.上記の計算で出た数量を 1 日の時間で割ることで
 * 　日付の差を求めることができます。
 * 　※1 日 ( 24 時間) は、86,400,000 ミリ秒です。
 * 
 * @param date1    日付 java.util.Date
 * @param date2    日付 java.util.Date
 * @return    2つの日付の差
 */
public static int differenceDays(Date date1,Date date2) {
    long datetime1 = date1.getTime();
    long datetime2 = date2.getTime();
    long one_date_time = 1000 * 60 * 60 * 24;
    long diffDays = (datetime1 - datetime2) / one_date_time;
    return (int)diffDays; 
}

public static String getHostName() {
    try {
        return InetAddress.getLocalHost().getHostName();
    }catch (Exception e) {
        e.printStackTrace();
    }
    return "UnknownHost";
}


}

