/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Gura3
 */
@Named
@RequestScoped

/* 貸出会員スキャンバッキングビーン */
public class DVDScanBb {
    private String memberno;            //会員No

    public void setMemberno(String memberno) {
        this.memberno = memberno;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKana(String kana) {
        this.kana = kana;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setMail_address(String mail_address) {
        this.mail_address = mail_address;
    }

    public void setMail_magazine(String mail_magazine) {
        this.mail_magazine = mail_magazine;
    }

    public void setRegistararion_date(String registararion_date) {
        this.registararion_date = registararion_date;
    }

    public String getMemberno() {
        return memberno;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public String getKana() {
        return kana;
    }

    public String getSex() {
        return sex;
    }

    public String getPostal() {
        return postal;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getMail_address() {
        return mail_address;
    }

    public String getMail_magazine() {
        return mail_magazine;
    }

    public String getRegistararion_date() {
        return registararion_date;
    }
    private String birthday;            //生年月日
    private String name;                //氏名
    private String kana;                //会員名(フリガナ)
    private String sex;                 //性別
    private String postal;              //郵便番号
    private String address;             //住所
    private String phone;               //電話番号
    private String occupation;          //職業
    private String mail_address;        //メールアドレス
    private String mail_magazine;       //メールマガジン
    private String registararion_date;  //仮会員登録日
    private String delay;  //未払い金
    /** 未払いフラグ */
    private boolean flg1 = false;

    public boolean isFlg1() {
        return flg1;
    }

    public void setFlg1(boolean flg1) {
        this.flg1 = flg1;
    }

    public boolean isFlg2() {
        return flg2;
    }

    public void setFlg2(boolean flg2) {
        this.flg2 = flg2;
    }

    /** 延滞フラグ */
    private boolean flg2 = false;

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    private String expirationDate;  //残り有効期限
    
    public String next(){
        return "DVDScan.xhtml";
    }
    
       

}
