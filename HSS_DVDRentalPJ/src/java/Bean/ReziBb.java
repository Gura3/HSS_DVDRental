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
    
    private String gohyakumai;
    private String hyakumai;
    private String gojumai;
    private String jumai;
    private String goyenmai;
    private String ichimai;
    
    private String gohyakuhon;
    private String hyakuhon;
    private String gojuhon;
    private String juhon;
    private String goyenhon;
    private String ichihon;
    
    private String manmai;
    private String gosenmai;
    private String nisenmai;
    private String senmai;
    
    private int maisu;
    private String totalmai;
    private int kosu;
    private int honsu;
    private int satutotal;
    private int kahetotal;
    
    private String mancheck;
    private String gosencheck;
    private String nisencheck;
    private String sencheck;
    private String gohyakucheck;
    private String gohyakuhoncheck;
    private String hyakucheck;
    private String hyakuhoncheck;
    private String gojucheck;
    private String gojuhoncheck;
    private String jucheck;
    private String juhoncheck;
    private String gocheck;
    private String gohoncheck;
    private String ichicheck;
    private String ichihoncheck;
    
    private boolean hyoji;

    @EJB
    RezisimeDb db;
    
    
    public String next(){
        setTenpocd("10");
        setSimetime("2");
        setRezicd("01");
        setMan("0");
        setGosen("0");
        setNisen("0");
        setSen("0");
        setGohyaku("0");
        setHyaku("0");
        setGoju("0");
        setJu("0");
        setGoyen("0");
        setIchi("0");
        setTotal_fee("0");
        setDiscount("1");
        setTotal_sales("1");
        setDifference("1");
        setGohyakuhon("0");
        setHyakuhon("0");
        setGojuhon("0");
        setJuhon("0");
        setGoyenhon("0");
        setIchihon("0");
        setKosu(0);
        setHonsu(0);
        setMaisu(0);
        setSatutotal(0);
        setKahetotal(0);
        setManmai("0");
        setGosenmai("0");
        setNisenmai("0");
        setSenmai("0");
        setGohyakumai("0");
        setHyakumai("0");
        setGojumai("0");
        setJumai("0");
        setGoyenmai("0");
        setIchimai("0");
        setMancheck("-1");
        setGosencheck("-1");
        setNisencheck("-1");
        setSencheck("-1");
        setGohyakucheck("-1");
        setHyakucheck("-1");
        setGojucheck("-1");
        setJucheck("-1");
        setGocheck("-1");
        setIchicheck("-1");
        setGohyakuhoncheck("-1");
        setHyakuhoncheck("-1");
        setGojuhoncheck("-1");
        setJuhoncheck("-1");
        setGohoncheck("-1");
        setIchihoncheck("-1");
        setHyoji(true); 
        
       return "/pages/rezi/rezisime";
    }
    
    public String copy(){
        if(!getMan().equals("0")){
            if(!getMancheck().equals(getMan())){
                setManmai(getMan()+"0000");
                if(!getMancheck().equals("-1")){
                    setMaisu(getMaisu()-Integer.parseInt(getMancheck()));
                    setSatutotal(getSatutotal()-Integer.parseInt(getMancheck())*10000);
                }
                setMaisu(getMaisu()+Integer.parseInt(getMan()));
                setSatutotal(getSatutotal()+Integer.parseInt(getMan())*10000);
                setMancheck(getMan());
            }
        }else{
            setManmai("0");
            if(!getMancheck().equals("-1")){
                    setMaisu(getMaisu()-Integer.parseInt(getMancheck()));
                    setSatutotal(getSatutotal()-Integer.parseInt(getMancheck())*10000);
                    setMancheck(getMan());
                }
        }
        if(!getGosen().equals("0")){
            if(!getGosencheck().equals(getGosen())){
                setGosenmai(Integer.parseInt(getGosen())*5+"000");
                if(!getGosencheck().equals("-1")){
                    setMaisu(getMaisu()-Integer.parseInt(getGosencheck()));
                    setSatutotal(getSatutotal()-Integer.parseInt(getGosencheck())*10000);
                }
                setMaisu(getMaisu()+Integer.parseInt(getGosen()));
                setSatutotal(getSatutotal()+Integer.parseInt(getGosen())*5000);
                setGosencheck(getGosen());
            }
        }else{
            setGosenmai("0");
            if(!getGosencheck().equals("-1")){
                    setMaisu(getMaisu()-Integer.parseInt(getGosencheck()));
                    setSatutotal(getSatutotal()-Integer.parseInt(getGosencheck())*10000);
                    setGosencheck(getGosen());
                }
        }
        if(!getNisen().equals("0")){
            if(!getNisencheck().equals(getNisen())){
                setNisenmai(Integer.parseInt(getNisen())*2+"000");
                if(!getNisencheck().equals("-1")){
                    setMaisu(getMaisu()-Integer.parseInt(getNisencheck()));
                    setSatutotal(getSatutotal()-Integer.parseInt(getNisencheck())*10000);
                }
                setMaisu(getMaisu()+Integer.parseInt(getNisen()));
                setSatutotal(getSatutotal()+Integer.parseInt(getNisen())*2000);
                setNisencheck(getNisen());
            }
        }else{
            setNisenmai("0");
            if(!getNisencheck().equals("-1")){
                    setMaisu(getMaisu()-Integer.parseInt(getNisencheck()));
                    setSatutotal(getSatutotal()-Integer.parseInt(getNisencheck())*10000);
                    setNisencheck(getNisen());
                }
        }
        if(!getSen().equals("0")){
            if(!getSencheck().equals(getSen())){
                setSenmai(getSen()+"000");
                if(!getSencheck().equals("-1")){
                    setMaisu(getMaisu()-Integer.parseInt(getSencheck()));
                    setSatutotal(getSatutotal()-Integer.parseInt(getSencheck())*10000);
                }
                setMaisu(getMaisu()+Integer.parseInt(getSen()));
                setSatutotal(getSatutotal()+Integer.parseInt(getSen())*1000);
                setSencheck(getSen());
            }
        }else{
            setSenmai("0");
            if(!getSencheck().equals("-1")){
                    setMaisu(getMaisu()-Integer.parseInt(getSencheck()));
                    setSatutotal(getSatutotal()-Integer.parseInt(getSencheck())*10000);
                    setSencheck(getSen());
                }
        }
        if(getMaisu()==0){
            setMaisu(0);
            setSatutotal(0);
        }
        
        if(!getGohyaku().equals("0")){
            if(!getGohyakucheck().equals(getGohyaku())){
                setGohyakumai(Integer.toString(Integer.parseInt(getGohyaku())*500+Integer.parseInt(getGohyakuhon())*5000));
                if(!getGohyakucheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getGohyakucheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getGohyakucheck())*500);
                }
                setKosu(getKosu()+Integer.parseInt(getGohyaku()));
                setKahetotal(getKahetotal()+Integer.parseInt(getGohyaku())*500);
                setGohyakucheck(getGohyaku());
            }
        }else{
            setGohyakumai(Integer.toString(Integer.parseInt(getGohyakuhon())*5000));
            if(!getGohyakucheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getGohyakucheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getGohyakucheck())*500);
                    setGohyakucheck(getGohyaku());
                }
        }
        if(!getGohyakuhon().equals("0")){
            if(!getGohyakuhoncheck().equals(getGohyakuhon())){
                setGohyakumai(Integer.toString(Integer.parseInt(getGohyaku())*500+Integer.parseInt(getGohyakuhon())*5000));
                if(!getGohyakuhoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getGohyakuhoncheck()));
                    setKosu(getKosu()-Integer.parseInt(getGohyakuhoncheck())*10);
                    setKahetotal(getKahetotal()-Integer.parseInt(getGohyakuhoncheck())*5000);
                }
                setHonsu(getHonsu()+Integer.parseInt(getGohyakuhon()));
                setKahetotal(getKahetotal()+Integer.parseInt(getGohyakuhon())*5000);
                setGohyakuhoncheck(getGohyakuhon());
            }
        }else{
            setGohyakumai(Integer.toString(Integer.parseInt(getGohyaku())*500));
            if(!getGohyakuhoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getGohyakuhoncheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getGohyakuhoncheck())*5000);
                    setGohyakuhoncheck(getGohyakuhon());
                }
        }
        
        if(!getHyaku().equals("0")){
            if(!getHyakucheck().equals(getHyaku())){
                setHyakumai(Integer.toString(Integer.parseInt(getHyaku())*100+Integer.parseInt(getHyakuhon())*1000));
                if(!getHyakucheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getHyakucheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getHyakucheck())*100);
                }
                setKosu(getKosu()+Integer.parseInt(getHyaku()));
                setKahetotal(getKahetotal()+Integer.parseInt(getHyaku())*100);
                setHyakucheck(getHyaku());
            }
        }else{
            setHyakumai(Integer.toString(Integer.parseInt(getHyakuhon())*1000));
            if(!getHyakucheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getHyakucheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getHyakucheck())*100);
                    setHyakucheck(getHyaku());
                }
        }
        if(!getHyakuhon().equals("0")){
            if(!getHyakuhoncheck().equals(getHyakuhon())){
                setHyakumai(Integer.toString(Integer.parseInt(getHyaku())*100+Integer.parseInt(getHyakuhon())*1000));
                if(!getHyakuhoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getHyakuhoncheck()));
                    setKosu(getKosu()-Integer.parseInt(getHyakuhoncheck())*10);
                    setKahetotal(getKahetotal()-Integer.parseInt(getHyakuhoncheck())*1000);
                }
                setHonsu(getHonsu()+Integer.parseInt(getHyakuhon()));
                setKahetotal(getKahetotal()+Integer.parseInt(getHyakuhon())*1000);
                setHyakuhoncheck(getHyakuhon());
            }
        }else{
            setHyakumai(Integer.toString(Integer.parseInt(getHyaku())*100));
            if(!getHyakuhoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getHyakuhoncheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getHyakuhoncheck())*1000);
                    setHyakuhoncheck(getHyakuhon());
                }
        }
        
        if(!getGoju().equals("0")){
            if(!getGojucheck().equals(getGoju())){
                setGojumai(Integer.toString(Integer.parseInt(getGoju())*50+Integer.parseInt(getGojuhon())*500));
                if(!getGojucheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getGojucheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getGojucheck())*50);
                }
                setKosu(getKosu()+Integer.parseInt(getGoju()));
                setKahetotal(getKahetotal()+Integer.parseInt(getGoju())*50);
                setGojucheck(getGoju());
            }
        }else{
            setGojumai(Integer.toString(Integer.parseInt(getGojuhon())*500));
            if(!getGojucheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getGojucheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getGojucheck())*50);
                    setGojucheck(getGoju());
                }
        }
        if(!getGojuhon().equals("0")){
            if(!getGojuhoncheck().equals(getGojuhon())){
                setGojumai(Integer.toString(Integer.parseInt(getGoju())*50+Integer.parseInt(getGojuhon())*500));
                if(!getGojuhoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getGojuhoncheck()));
                    setKosu(getKosu()-Integer.parseInt(getGojuhoncheck())*10);
                    setKahetotal(getKahetotal()-Integer.parseInt(getGojuhoncheck())*500);
                }
                setHonsu(getHonsu()+Integer.parseInt(getGojuhon()));
                setKahetotal(getKahetotal()+Integer.parseInt(getGojuhon())*500);
                setGojuhoncheck(getGojuhon());
            }
        }else{
            setGojumai(Integer.toString(Integer.parseInt(getGoju())*50));
            if(!getGojuhoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getGojuhoncheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getGojuhoncheck())*500);
                    setGojuhoncheck(getGojuhon());
                }
        }
        
        if(!getJu().equals("0")){
            if(!getJucheck().equals(getJu())){
                setJumai(Integer.toString(Integer.parseInt(getJu())*10+Integer.parseInt(getJuhon())*100));
                if(!getJucheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getJucheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getJucheck())*10);
                }
                setKosu(getKosu()+Integer.parseInt(getJu()));
                setKahetotal(getKahetotal()+Integer.parseInt(getJu())*10);
                setJucheck(getJu());
            }
        }else{
            setJumai(Integer.toString(Integer.parseInt(getJuhon())*100));
            if(!getJucheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getJucheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getJucheck())*10);
                    setJucheck(getJu());
                }
        }
        if(!getJuhon().equals("0")){
            if(!getJuhoncheck().equals(getJuhon())){
                setJumai(Integer.toString(Integer.parseInt(getJu())*10+Integer.parseInt(getJuhon())*100));
                if(!getJuhoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getJuhoncheck()));
                    setKosu(getKosu()-Integer.parseInt(getJuhoncheck())*10);
                    setKahetotal(getKahetotal()-Integer.parseInt(getJuhoncheck())*100);
                }
                setHonsu(getHonsu()+Integer.parseInt(getJuhon()));
                setKahetotal(getKahetotal()+Integer.parseInt(getJuhon())*100);
                setJuhoncheck(getJuhon());
            }
        }else{
            setJumai(Integer.toString(Integer.parseInt(getJu())*10));
            if(!getJuhoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getJuhoncheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getJuhoncheck())*100);
                    setJuhoncheck(getJuhon());
                }
        }
        
        if(!getGoyen().equals("0")){
            if(!getGocheck().equals(getGoyen())){
                setGoyenmai(Integer.toString(Integer.parseInt(getGoyen())*5+Integer.parseInt(getGoyenhon())*50));
                if(!getGocheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getGocheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getGocheck())*5);
                }
                setKosu(getKosu()+Integer.parseInt(getGoyen()));
                setKahetotal(getKahetotal()+Integer.parseInt(getGoyen())*5);
                setGocheck(getGoyen());
            }
        }else{
            setGoyenmai(Integer.toString(Integer.parseInt(getGoyenhon())*50));
            if(!getGocheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getGocheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getGocheck())*5);
                    setGocheck(getGoyen());
                }
        }
        if(!getGoyenhon().equals("0")){
            if(!getGohoncheck().equals(getGoyenhon())){
                setGoyenmai(Integer.toString(Integer.parseInt(getGoyen())*5+Integer.parseInt(getGoyenhon())*50));
                if(!getGohoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getGohoncheck()));
                    setKosu(getKosu()-Integer.parseInt(getGohoncheck())*10);
                    setKahetotal(getKahetotal()-Integer.parseInt(getGohoncheck())*50);
                }
                setHonsu(getHonsu()+Integer.parseInt(getGoyenhon()));
                setKahetotal(getKahetotal()+Integer.parseInt(getGoyenhon())*50);
                setGohoncheck(getGoyenhon());
            }
        }else{
            setGoyenmai(Integer.toString(Integer.parseInt(getGoyen())*5));
            if(!getGohoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getGohoncheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getGohoncheck())*50);
                    setGohoncheck(getGoyenhon());
                }
        }
        
        if(!getIchi().equals("0")){
            if(!getIchicheck().equals(getIchi())){
                setIchimai(Integer.toString(Integer.parseInt(getIchi())+Integer.parseInt(getIchihon())*10));
                if(!getIchicheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getIchicheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getIchicheck()));
                }
                setKosu(getKosu()+Integer.parseInt(getIchi()));
                setKahetotal(getKahetotal()+Integer.parseInt(getIchi()));
                setIchicheck(getIchi());
            }
        }else{
            setIchimai(Integer.toString(Integer.parseInt(getIchihon())*10));
            if(!getIchicheck().equals("-1")){
                    setKosu(getKosu()-Integer.parseInt(getIchicheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getIchicheck()));
                    setIchicheck(getIchi());
                }
        }
        if(!getIchihon().equals("0")){
            if(!getIchihoncheck().equals(getIchihon())){
                setIchimai(Integer.toString(Integer.parseInt(getIchi())+Integer.parseInt(getIchihon())*10));
                if(!getIchihoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getIchihoncheck()));
                    setKosu(getKosu()-Integer.parseInt(getIchihoncheck())*10);
                    setKahetotal(getKahetotal()-Integer.parseInt(getIchihoncheck())*10);
                }
                setHonsu(getHonsu()+Integer.parseInt(getIchihon()));
                setKahetotal(getKahetotal()+Integer.parseInt(getIchihon())*10);
                setIchihoncheck(getIchihon());
            }
        }else{
            setIchimai(Integer.toString(Integer.parseInt(getIchi())));
            if(!getIchihoncheck().equals("-1")){
                    setHonsu(getHonsu()-Integer.parseInt(getIchihoncheck()));
                    setKahetotal(getKahetotal()-Integer.parseInt(getIchihoncheck())*10);
                    setIchihoncheck(getIchihon());
                }
        }
        
        setTotal_fee(Integer.toString(getSatutotal()+getKahetotal()));
        
        if(getTotal_fee().equals("0")){
           setHyoji(true); 
        }else{
            setHyoji(false);
        }
        
       return "/pages/rezi/rezisime";
    }
    
    public String kakunin(){
        return "/pages/rezi/rezisimekakunin";
    }
    
    public String kanryo(){
        return "/pages/rezi/rezisimekanryo";
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

    public String getManmai() {
        return manmai;
    }

    public void setManmai(String manmai) {
        this.manmai = manmai;
    }

    public String getTotalmai() {
        return totalmai;
    }

    public void setTotalmai(String totalmai) {
        this.totalmai = totalmai;
    }

    public String getGosenmai() {
        return gosenmai;
    }

    public void setGosenmai(String gosenmai) {
        this.gosenmai = gosenmai;
    }

    public String getNisenmai() {
        return nisenmai;
    }

    public void setNisenmai(String nisenmai) {
        this.nisenmai = nisenmai;
    }

    public String getSenmai() {
        return senmai;
    }

    public void setSenmai(String senmai) {
        this.senmai = senmai;
    }

    public int getSatutotal() {
        return satutotal;
    }

    public void setSatutotal(int satutotal) {
        this.satutotal = satutotal;
    }

    public String getMancheck() {
        return mancheck;
    }

    public void setMancheck(String mancheck) {
        this.mancheck = mancheck;
    }

    public String getGosencheck() {
        return gosencheck;
    }

    public void setGosencheck(String gosencheck) {
        this.gosencheck = gosencheck;
    }

    public String getNisencheck() {
        return nisencheck;
    }

    public void setNisencheck(String nisencheck) {
        this.nisencheck = nisencheck;
    }

    public String getSencheck() {
        return sencheck;
    }

    public void setSencheck(String sencheck) {
        this.sencheck = sencheck;
    }

    public String getGohyakumai() {
        return gohyakumai;
    }

    public void setGohyakumai(String gohyakumai) {
        this.gohyakumai = gohyakumai;
    }

    public String getHyakumai() {
        return hyakumai;
    }

    public void setHyakumai(String hyakumai) {
        this.hyakumai = hyakumai;
    }

    public String getGojumai() {
        return gojumai;
    }

    public void setGojumai(String gojumai) {
        this.gojumai = gojumai;
    }

    public String getJumai() {
        return jumai;
    }

    public void setJumai(String jumai) {
        this.jumai = jumai;
    }

    public String getGoyenmai() {
        return goyenmai;
    }

    public void setGoyenmai(String goyenmai) {
        this.goyenmai = goyenmai;
    }

    public String getIchimai() {
        return ichimai;
    }

    public void setIchimai(String ichimai) {
        this.ichimai = ichimai;
    }

    public int getKahetotal() {
        return kahetotal;
    }

    public void setKahetotal(int kahetotal) {
        this.kahetotal = kahetotal;
    }

    public String getGohyakucheck() {
        return gohyakucheck;
    }

    public void setGohyakucheck(String gohyakucheck) {
        this.gohyakucheck = gohyakucheck;
    }

    public String getGohyakuhoncheck() {
        return gohyakuhoncheck;
    }

    public void setGohyakuhoncheck(String gohyakuhoncheck) {
        this.gohyakuhoncheck = gohyakuhoncheck;
    }

    public String getHyakucheck() {
        return hyakucheck;
    }

    public void setHyakucheck(String hyakucheck) {
        this.hyakucheck = hyakucheck;
    }

    public String getHyakuhoncheck() {
        return hyakuhoncheck;
    }

    public void setHyakuhoncheck(String hyakuhoncheck) {
        this.hyakuhoncheck = hyakuhoncheck;
    }

    public String getGojucheck() {
        return gojucheck;
    }

    public void setGojucheck(String gojucheck) {
        this.gojucheck = gojucheck;
    }

    public String getGojuhoncheck() {
        return gojuhoncheck;
    }

    public void setGojuhoncheck(String gojuhoncheck) {
        this.gojuhoncheck = gojuhoncheck;
    }

    public String getJucheck() {
        return jucheck;
    }

    public void setJucheck(String jucheck) {
        this.jucheck = jucheck;
    }

    public String getJuhoncheck() {
        return juhoncheck;
    }

    public void setJuhoncheck(String juhoncheck) {
        this.juhoncheck = juhoncheck;
    }

    public String getGocheck() {
        return gocheck;
    }

    public void setGocheck(String gocheck) {
        this.gocheck = gocheck;
    }

    public String getGohoncheck() {
        return gohoncheck;
    }

    public void setGohoncheck(String gohoncheck) {
        this.gohoncheck = gohoncheck;
    }

    public String getIchicheck() {
        return ichicheck;
    }

    public void setIchicheck(String ichicheck) {
        this.ichicheck = ichicheck;
    }

    public String getIchihoncheck() {
        return ichihoncheck;
    }

    public void setIchihoncheck(String ichihoncheck) {
        this.ichihoncheck = ichihoncheck;
    }

    public boolean isHyoji() {
        return hyoji;
    }

    public void setHyoji(boolean hyoji) {
        this.hyoji = hyoji;
    }
    
    
}
