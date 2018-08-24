/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gura3
 */
@Named
@ApplicationScoped

/* 貸出会員スキャンバッキングビーン */
public class ReziBb {
    @NotNull
    private String tenpocd;
    @NotNull
    private String rezicd;
    @NotNull
    private String simetime;
    @Size(max = 20, min = 1)
    private String man;
    @Size(max = 20, min = 1)
    private String gosen;
    @Size(max = 20, min = 1)
    private String nisen;
    @Size(max = 20, min = 1)
    private String sen;
    @Size(max = 20, min = 1)
    private String gohyaku;
    @Size(max = 20, min = 1)
    private String hyaku;
    @Size(max = 20, min = 1)
    private String goju;
    @Size(max = 20, min = 1)
    private String ju;
    @Size(max = 20, min = 1)
    private String goyen;
    @Size(max = 20, min = 1)
    private String ichi;
    @Size(max = 20, min = 1)
    private String total_fee;
    @Size(max = 20, min = 1)
    private String discount;
    @Size(max = 20, min = 1)
    private String total_sales;
    @Size(max = 20, min = 1)
    private String difference;
    
    private String gohyakuhon;
    private String hyakuhon;
    private String gojuhon;
    private String juhon;
    private String goyenhon;
    private String ichihon;
    
    private int maisu;
    private int kosu;
    private int honsu;

    @EJB
    RezisimeDb db;
    
    public String next(){
        setTenpocd("10");
        setSimetime("2");
        setRezicd("01");
        setMan("1");
        setGosen("1");
        setNisen("1");
        setSen("1");
        setGohyaku("1");
        setHyaku("1");
        setGoju("1");
        setJu("1");
        setGoyen("1");
        setIchi("1");
        setTotal_fee("1");
        setDiscount("1");
        setTotal_sales("1");
        setDifference("1");
        add();
       return "/pages/rezi/rezisime";
    }
    
    public void add(){
        Rezisime a = new Rezisime(tenpocd,rezicd,simetime,total_fee,discount,man,gosen,nisen,sen,gohyaku,hyaku,goju,ju,goyen,ichi,total_sales,difference);
        db.add(a);
    }

    public String getTenpocd() {
        return tenpocd;
    }

    public void setTenpocd(String tenpocd) {
        this.tenpocd = tenpocd;
    }

    public String getRezicd() {
        return rezicd;
    }

    public void setRezicd(String rezicd) {
        this.rezicd = rezicd;
    }

    public String getSimetime() {
        return simetime;
    }

    public void setSimetime(String simetime) {
        this.simetime = simetime;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public String getGosen() {
        return gosen;
    }

    public void setGosen(String gosen) {
        this.gosen = gosen;
    }

    public String getNisen() {
        return nisen;
    }

    public void setNisen(String nisen) {
        this.nisen = nisen;
    }

    public String getSen() {
        return sen;
    }

    public void setSen(String sen) {
        this.sen = sen;
    }

    public String getGohyaku() {
        return gohyaku;
    }

    public void setGohyaku(String gohyaku) {
        this.gohyaku = gohyaku;
    }

    public String getHyaku() {
        return hyaku;
    }

    public void setHyaku(String hyaku) {
        this.hyaku = hyaku;
    }

    public String getGoju() {
        return goju;
    }

    public void setGoju(String goju) {
        this.goju = goju;
    }

    public String getJu() {
        return ju;
    }

    public void setJu(String ju) {
        this.ju = ju;
    }

    public String getGoyen() {
        return goyen;
    }

    public void setGoyen(String goyen) {
        this.goyen = goyen;
    }

    public String getIchi() {
        return ichi;
    }

    public void setIchi(String ichi) {
        this.ichi = ichi;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(String total_sales) {
        this.total_sales = total_sales;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public int getMaisu() {
        return maisu;
    }

    public void setMaisu(int maisu) {
        this.maisu = maisu;
    }

    public String getGohyakuhon() {
        return gohyakuhon;
    }

    public void setGohyakuhon(String gohyakuhon) {
        this.gohyakuhon = gohyakuhon;
    }

    public String getHyakuhon() {
        return hyakuhon;
    }

    public void setHyakuhon(String hyakuhon) {
        this.hyakuhon = hyakuhon;
    }

    public String getGojuhon() {
        return gojuhon;
    }

    public void setGojuhon(String gojuhon) {
        this.gojuhon = gojuhon;
    }

    public String getJuhon() {
        return juhon;
    }

    public void setJuhon(String juhon) {
        this.juhon = juhon;
    }

    public String getGoyenhon() {
        return goyenhon;
    }

    public void setGoyenhon(String goyenhon) {
        this.goyenhon = goyenhon;
    }

    public String getIchihon() {
        return ichihon;
    }

    public void setIchihon(String ichihon) {
        this.ichihon = ichihon;
    }

    public int getKosu() {
        return kosu;
    }

    public void setKosu(int kosu) {
        this.kosu = kosu;
    }

    public int getHonsu() {
        return honsu;
    }

    public void setHonsu(int honsu) {
        this.honsu = honsu;
    }
    
    
}
