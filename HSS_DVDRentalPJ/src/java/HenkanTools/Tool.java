/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HenkanTools;

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

}
