package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name="REGI_TIGHTEN")
public class Rezisime implements Serializable {
    
    @Id
    @NotNull
    private String regi_tig_day;
    @NotNull
    private String store_cd;
    @NotNull
    private String regi_code;
    private String total_fee;
    private String discount;
    private String manyen;
    private String gosenyen;
    private String nisenyen;
    private String senyen;
    private String gohyakuyen;
    private String hyakuyen;
    private String gojuyen;
    private String juyen;
    private String goyen;
    private String ichiyen;
    private String total_sales;
    private String difference;

    public Rezisime() {
    }

    public Rezisime(Rezisime rezisime) {
        this.store_cd = rezisime.getStore_cd();
        this.regi_code = rezisime.getRegi_code();
        this.regi_tig_day = rezisime.getRegi_tig_day();
        this.total_fee = rezisime.getTotal_fee();
        this.discount = rezisime.getDiscount();
        this.manyen = rezisime.getManyen();
        this.gosenyen = rezisime.getGosenyen();
        this.nisenyen = rezisime.getNisenyen();
        this.senyen = rezisime.getSenyen();
        this.gohyakuyen = rezisime.getGohyakuyen();
        this.hyakuyen = rezisime.getHyakuyen();
        this.gojuyen = rezisime.getGojuyen();
        this.juyen = rezisime.getJuyen();
        this.goyen = rezisime.getGoyen();
        this.ichiyen = rezisime.getIchiyen();
        this.total_sales = rezisime.getTotal_sales();
        this.difference = rezisime.getDifference();
    }

    public Rezisime(String store_cd, String regi_code, String regi_tig_day,String total_fee,String discount,String manyen,String gosenyen,String nisenyen,String senyen,String gohyakuyen,String hyakuyen,String gojuyen,String juyen,String goyen,String ichiyen,String total_sales,String difference) {
        this.store_cd = store_cd;
        this.regi_code = regi_code;
        this.regi_tig_day = regi_tig_day;
        this.total_fee = total_fee;
        this.discount = discount;
        this.manyen = manyen;
        this.gosenyen = gosenyen;
        this.nisenyen = nisenyen;
        this.senyen = senyen;
        this.gohyakuyen = gohyakuyen;
        this.hyakuyen = hyakuyen;
        this.gojuyen = gojuyen;
        this.juyen = juyen;
        this.goyen = goyen;
        this.ichiyen = ichiyen;
        this.total_sales = total_sales;
        this.difference = difference;
        System.out.println(store_cd+"A"+regi_code+"B"+regi_tig_day+"C"+total_fee+"D"+discount+"E"+manyen+"F"+gosenyen+"G"+nisenyen+"H"+senyen+"I"+gohyakuyen+"J"+hyakuyen+"K"+gojuyen+"L"+juyen+"M"+goyen+"N"+ichiyen+"O"+total_sales+"P"+difference);
    }

    public String getStore_cd() {
        return store_cd;
    }

    public void setStore_cd(String store_cd) {
        this.store_cd = store_cd;
    }

    public String getRegi_code() {
        return regi_code;
    }

    public void setRegi_cd(String regi_code) {
        this.regi_code = regi_code;
    }

    public String getRegi_tig_day() {
        return regi_tig_day;
    }

    public void setRegi_tig_day(String regi_tig_day) {
        this.regi_tig_day = regi_tig_day;
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

    public String getManyen() {
        return manyen;
    }

    public void setManyen(String manyen) {
        this.manyen = manyen;
    }

    public String getGosenyen() {
        return gosenyen;
    }

    public void setGosenyen(String gosenyen) {
        this.gosenyen = gosenyen;
    }

    public String getNisenyen() {
        return nisenyen;
    }

    public void setNisenyen(String nisenyen) {
        this.nisenyen = nisenyen;
    }

    public String getSenyen() {
        return senyen;
    }

    public void setSenyen(String senyen) {
        this.senyen = senyen;
    }

    public String getGohyakuyen() {
        return gohyakuyen;
    }

    public void setGohyakuyen(String gohyakuyen) {
        this.gohyakuyen = gohyakuyen;
    }

    public String getHyakuyen() {
        return hyakuyen;
    }

    public void setHyaku(String hyakuyen) {
        this.hyakuyen = hyakuyen;
    }

    public String getGojuyen() {
        return gojuyen;
    }

    public void setGojuyen(String gojuyen) {
        this.gojuyen = gojuyen;
    }

    public String getJuyen() {
        return juyen;
    }

    public void setJuyen(String juyen) {
        this.juyen = juyen;
    }

    public String getGoyen() {
        return goyen;
    }

    public void setGoyen(String goyen) {
        this.goyen = goyen;
    }

    public String getIchiyen() {
        return ichiyen;
    }

    public void setIchiyen(String ichiyen) {
        this.ichiyen = ichiyen;
    }

    

}
