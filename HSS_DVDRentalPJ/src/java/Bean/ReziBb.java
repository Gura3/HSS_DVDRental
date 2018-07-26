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

    @EJB
    RezisimeDb db;
    
    public String next(){
        setTenpocd("1");
        setSimetime("1");
        setRezicd("1");
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
        add();
       return "/pages/rezi/rezisime";
    }
    
    public void add(){
        Rezisime a = new Rezisime();
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
    
    
}
