/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import static HenkanTools.Tool.cnvSextion;
import Manager.DvdManager;
import Manager.KashiDvdManager;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Gura3
 */
@Named
@ApplicationScoped

/* 貸出会員スキャンバッキングビーン */
public class DVDScanBb {
    private String barcode;            //DVDバーコード
    private String barcodes[] = new String[10];            //DVDバーコード配列
    private int scancnt;            //スキャンした回数
    private String title;
    private String titles[] = new String[10]; 
    private String days[] = new String[10];
    private String moneys[] = new String[10];
    private boolean flg1[] = new boolean[10];
    private boolean flg2[] = new boolean[10];
    private String newold;
    static private int total;
    private int tax;
    private int deposit;            //預かり金
    private int change;            //おつり
    private boolean plan1;
    private boolean plan2;
    private boolean plan3;
    private String planview1;
    private String planview2;
    private String planview3;
    private String planview11;
    private String planview22;
    private String planview33;
    

    @EJB
    KashiDvdManager kashimng;
    @EJB
    DvdManager dvdmng;
    
    Lend_item kd = null;
    Dvd d = null;
    Sextion s = null;
    
    public String next(){
        setScancnt(0);
        setTotal(0);
        setTax(0);
        for(int i=0;i<10;i++){
            setBarcodes("",i);
            setTitles("",i);
            setDays("",i);
            setMoneys("",i);
            setFlg1(true,i);
            setFlg2(false,i);
        }
        
        return "DVDScan.xhtml";
    }
    
    public String back(){
        return "DVDScan.xhtml";
    }
    
    public String scan(){
        try {
            kd = kashimng.getKashiDvdData(barcode);
            d = dvdmng.getDvdData(kd.getDvd_code());
            s = dvdmng.getSextiondvd(d.getDvd_code(), kd.getStore_cd());
        } catch (Exception e) {
            e.printStackTrace();
            return "DVDScan.xhtml";
        }
        setBarcodes(getBarcode(),getScancnt());
        setTitle(d.getTitle());
        setTitles(d.getTitle(),getScancnt());
        setDays("2018/8/30～2018/9/6",getScancnt());
        setMoneys("160",getScancnt());
        setNewold(cnvSextion(s.getSextion()));
        setFlg1(false,getScancnt());
        setFlg2(true,getScancnt());
        String mons[] = getMoneys();
        setTotal(getTotal()+Integer.parseInt(mons[getScancnt()]));
        setTax((int)(getTotal()/1.08*0.08));
        setScancnt(getScancnt()+1);
        if(s.getSextion().equals("0")){
            setPlanview1("当日 \\200");
            setPlanview2("1泊2日 \\260");
            setPlanview11("当日");
            setPlanview22("1泊2日");
            setPlan1(true);
            setPlan2(true);
            setPlan3(false);
        }else if(s.getSextion().equals("1")){
            setPlanview1("当日 \\200");
            setPlanview2("1泊2日 \\260");
            setPlanview3("2泊3日 \\300");
            setPlanview11("当日");
            setPlanview22("1泊2日");
            setPlanview33("2泊3日");
            setPlan1(true);
            setPlan2(true);
            setPlan3(true);
        }else{
            setPlanview1("7泊8日 \\160");
            setPlanview11("7泊8日");
            setPlan1(true);
            setPlan2(false);
            setPlan3(false);
        }
        return "DVDPlan.xhtml";
    }
    
    public String plan1(){
        return "DVDScan.xhtml";
    }
    
    public String plan2(){
        return "DVDScan.xhtml";
    }
    
    public String plan3(){
        return "DVDScan.xhtml";
    }
    
    public String del(int it){
        if(it == 9){
            String mons[] = getMoneys();
            setBarcodes("",it);
            setTitles("",it);
            setDays("",it);
            setMoneys("",it);
            setFlg1(true,it);
            setFlg2(false,it);
            setScancnt(getScancnt()-1);
            setTotal(getTotal()-Integer.parseInt(mons[it]));
            setTax((int)(getTotal()/1.08*0.08));
        }else{           
            String bars[] = getBarcodes();
            String titls[] = getTitles();
            String das[] = getDays();
            String mons[] = getMoneys();
            boolean flgs1[] = getFlg1();
            boolean flgs2[] = getFlg2();
            setTotal(getTotal()-Integer.parseInt(mons[it]));
            setTax((int)(getTotal()/1.08*0.08));
            for(int i=it+1;i<getScancnt();i++){
                setBarcodes(bars[i],it);
                setTitles(titls[i],it);
                setDays(das[i],it);
                setMoneys(mons[i],it);
                setFlg1(flgs1[i],it);
                setFlg2(flgs2[i],it);
                it++;
            }
            setScancnt(getScancnt()-1);
            setBarcodes("",getScancnt());
            setTitles("",getScancnt());
            setDays("",getScancnt());
            setMoneys("",getScancnt());
            setFlg1(true,getScancnt());
            setFlg2(false,getScancnt());
        }
        return "DVDScan.xhtml";
    }
    
    public String complete(){
        DVDScanBb tot = new DVDScanBb();
        setChange(getDeposit()-tot.getTotal());
        return "complete";
    }
    
    public String totalpage(){
        setDeposit(0);
        return "totalpage";
    }
    
       
    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }
    
    public void setDeposit(String deposit) {
        this.deposit = Integer.parseInt(deposit);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }


    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String title,int scancnt) {
        this.titles[scancnt] = title;
    }

    public String[] getDays() {
        return days;
    }

    public void setDays(String day,int scancnt) {
        this.days[scancnt] = day;
    }

    public String[] getMoneys() {
        return moneys;
    }

    public void setMoneys(String money,int scancnt) {
        this.moneys[scancnt] = money;
    }

    public boolean[] getFlg1() {
        return flg1;
    }

    public void setFlg1(boolean flg1,int scancnt) {
        this.flg1[scancnt] = flg1;
    }

    public boolean[] getFlg2() {
        return flg2;
    }

    public void setFlg2(boolean flg2,int scancnt) {
        this.flg2[scancnt] = flg2;
    }
    
    public int getScancnt() {
        return scancnt;
    }

    public void setScancnt(int scancnt) {
        this.scancnt = scancnt;
    }

    public String[] getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(String barcode,int scancnt) {
        this.barcodes[scancnt] = barcode;
    }
    

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewold() {
        return newold;
    }

    public void setNewold(String newold) {
        this.newold = newold;
    }

    public boolean isPlan1() {
        return plan1;
    }

    public void setPlan1(boolean plan1) {
        this.plan1 = plan1;
    }

    public boolean isPlan2() {
        return plan2;
    }

    public void setPlan2(boolean plan2) {
        this.plan2 = plan2;
    }

    public boolean isPlan3() {
        return plan3;
    }

    public void setPlan3(boolean plan3) {
        this.plan3 = plan3;
    }

    public String getPlanview1() {
        return planview1;
    }

    public void setPlanview1(String planview1) {
        this.planview1 = planview1;
    }

    public String getPlanview2() {
        return planview2;
    }

    public void setPlanview2(String planview2) {
        this.planview2 = planview2;
    }

    public String getPlanview3() {
        return planview3;
    }

    public void setPlanview3(String planview3) {
        this.planview3 = planview3;
    }

    public String getPlanview11() {
        return planview11;
    }

    public void setPlanview11(String planview11) {
        this.planview11 = planview11;
    }

    public String getPlanview22() {
        return planview22;
    }

    public void setPlanview22(String planview22) {
        this.planview22 = planview22;
    }

    public String getPlanview33() {
        return planview33;
    }

    public void setPlanview33(String planview33) {
        this.planview33 = planview33;
    }

    

}
