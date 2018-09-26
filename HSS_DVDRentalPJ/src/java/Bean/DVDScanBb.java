/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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
    private String titles[] = new String[10]; 
    private String days[] = new String[10];
    private String moneys[] = new String[10];
    private boolean flg1[] = new boolean[10];
    private boolean flg2[] = new boolean[10];
    static private int total;
    private int tax;
    private int deposit;            //預かり金
    private int change;            //おつり

    @EJB
    KashiDvdManager kashimng;
    
    Lend_item kd = null;
    
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
        } catch (Exception e) {
                e.printStackTrace();
                return "DVDScan.xhtml";
            }
        if(!getBarcode().equals("")){
            setBarcodes(getBarcode(),getScancnt());
            if(getBarcode().equals("1234567890128")){
                setTitles("パパ嫌い！～頑張れヒロユキ、二人ではじめてのおつかい～",getScancnt());
                setDays("2018/8/30～2018/9/6",getScancnt());
                setMoneys("160",getScancnt());
                setFlg1(false,getScancnt());
                setFlg2(true,getScancnt());
                String mons[] = getMoneys();
                setTotal(getTotal()+Integer.parseInt(mons[getScancnt()]));
                setTax((int)(getTotal()/1.08*0.08));
                setScancnt(getScancnt()+1);
            }else if(getBarcode().equals("2234567890127")){
                setTitles("-MESHIYA-この国に独裁者が現れたら、戦う勇気を持てるか？",getScancnt());
                setDays("2018/8/30～2018/9/6",getScancnt());
                setMoneys("160",getScancnt());
                setFlg1(false,getScancnt());
                setFlg2(true,getScancnt());
                String mons[] = getMoneys();
                setTotal(getTotal()+Integer.parseInt(mons[getScancnt()]));
                setTax((int)(getTotal()/1.08*0.08));
                setScancnt(getScancnt()+1);
            }else if(getBarcode().equals("3234567890126")){
                setTitles("ビール大好き高濱プレゼンツ！通販天国",getScancnt());
                setDays("2018/8/30～2018/9/6",getScancnt());
                setMoneys("160",getScancnt());
                setFlg1(false,getScancnt());
                setFlg2(true,getScancnt());
                String mons[] = getMoneys();
                setTotal(getTotal()+Integer.parseInt(mons[getScancnt()]));
                setTax((int)(getTotal()/1.08*0.08));
                setScancnt(getScancnt()+1);
            }else if(getBarcode().equals("4234567890125")){
                setTitles("おかせん THE MOVIE",getScancnt());
                setDays("2018/8/30～2018/9/6",getScancnt());
                setMoneys("160",getScancnt());
                setFlg1(false,getScancnt());
                setFlg2(true,getScancnt());
                String mons[] = getMoneys();
                setTotal(getTotal()+Integer.parseInt(mons[getScancnt()]));
                setTax((int)(getTotal()/1.08*0.08));
                setScancnt(getScancnt()+1);
            }
        }
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

    

}
