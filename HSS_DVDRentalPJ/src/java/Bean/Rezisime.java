package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;


//@Entity
public class Rezisime implements Serializable {
    
    @Id
    @NotNull
    private String tenpocd;
    private String rezicd;
    private String simetime;
    private String man;
    private String gosen;
    private String nisen;
    private String sen;
    private String gohyaku;
    private String hyaku;
    private String goju;
    private String ju;
    private String goyen;
    private String ichi;
    

    public Rezisime() {
    }

    public Rezisime(Rezisime rezisime) {
        this.tenpocd = rezisime.getTenpocd();
        this.rezicd = rezisime.getRezicd();
        this.simetime = rezisime.getSimetime();
        this.man = rezisime.getMan();
        this.gosen = rezisime.getGosen();
        this.nisen = rezisime.getNisen();
        this.sen = rezisime.getSen();
        this.gohyaku = rezisime.getGohyaku();
        this.hyaku = rezisime.getHyaku();
        this.goju = rezisime.getGoju();
        this.ju = rezisime.getJu();
        this.goyen = rezisime.getGoyen();
        this.ichi = rezisime.getIchi();
    }

    public Rezisime(String tenpocd, String rezicd, String simetime) {
        this.tenpocd = tenpocd;
        this.rezicd = rezicd;
        this.simetime = simetime;
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
