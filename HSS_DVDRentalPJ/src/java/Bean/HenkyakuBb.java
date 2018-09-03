/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Manager.DvdManager;
import Manager.HenkyakuManager;
import java.util.List;
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
public class HenkyakuBb {
    private String barcode;            //DVDバーコード
    private String barcodes[] = new String[10];            //DVDバーコード配列
    private int scancnt;            //スキャンした回数
    private String titles[] = new String[10]; 
    private String days[] = new String[10];
    private String entaidays[] = new String[10];
    private String moneys[] = new String[10];
    private boolean flg1[] = new boolean[10];
    private boolean flg2[] = new boolean[10];
    static private int total;
    private int tax;
    private int deposit;            //預かり金
    private int change;            //おつり
    
    private String memberno;            //会員No
    private String birthday;            //生年月日
    private String name;                //氏名
    private String kana;                //会員名(フリガナ)
    private String sex;                 //性別
    private String phone;               //電話番号
    
    private String scanflg;

    @EJB
    HenkyakuDb db;
    @EJB
    HenkyakuManager mng;
    @EJB
    DvdDb dvddb;
    @EJB
    DvdManager dvdmng;
    @EJB
    MemberDb memdb;
    @EJB
    MemberManager memmng;
    
    Kashi_meisai k = null;
    Menber m = null;
    List<Dvd> d = null;
    
    
    

    
    public String next(){
        setScancnt(0);
        setTotal(0);
        setTax(0);
        setScanflg("false");
        for(int i=0;i<10;i++){
            setBarcodes("",i);
            setTitles("",i);
            setDays("",i);
            setEntaidays("",i);
            setMoneys("",i);
            setFlg1(true,i);
            setFlg2(false,i);
        }
        delMember();
        System.out.print(getScanflg());
        
        return "/pages/henkyaku/henkyaku.xhtml";
    }
    
    public String comp(){
        return "/pages/henkyaku/henkyakucomp.xhtml";
    }
    
    public String back(){
        return "henkyaku.xhtml";
    }
    
    public String scan(){
        try {
            k = mng.getKashiBercode(barcode);
            d = dvdmng.getDvdDate();
        } catch (Exception e) {
            e.printStackTrace();
            setScanflg("true");
            return "henkyakuScanerror.xhtml";
        }
        if(!getBarcode().equals("")){
            setBarcodes(getBarcode(),getScancnt());
            setTitles("パパ嫌い",getScancnt());
            setDays("2018/8/1～2018/8/5",getScancnt());
            setEntaidays("-",getScancnt());
            setMoneys("100",getScancnt());
            setFlg1(false,getScancnt());
            setFlg2(true,getScancnt());
            String mons[] = getMoneys();
            setTotal(getTotal()+Integer.parseInt(mons[getScancnt()]));
            setTax((int)(getTotal()/1.08*0.08));
            setScancnt(getScancnt()+1);
            if(getScancnt()==1){
                catchMember(getBarcode());
            }
        }
        return "henkyaku.xhtml";
    }
    
    public String del(int it){
        if(it == 9){
            String mons[] = getMoneys();
            setBarcodes("",it);
            setTitles("",it);
            setDays("",it);
            setEntaidays("",it);
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
            String edas[] = getEntaidays();
            String mons[] = getMoneys();
            boolean flgs1[] = getFlg1();
            boolean flgs2[] = getFlg2();
            setTotal(getTotal()-Integer.parseInt(mons[it]));
            setTax((int)(getTotal()/1.08*0.08));
            for(int i=it+1;i<getScancnt();i++){
                setBarcodes(bars[i],it);
                setTitles(titls[i],it);
                setDays(das[i],it);
                setEntaidays(edas[i],it);
                setMoneys(mons[i],it);
                setFlg1(flgs1[i],it);
                setFlg2(flgs2[i],it);
                it++;
            }
            setScancnt(getScancnt()-1);
            setBarcodes("",getScancnt());
            setTitles("",getScancnt());
            setDays("",getScancnt());
            setEntaidays("",getScancnt());
            setMoneys("",getScancnt());
            setFlg1(true,getScancnt());
            setFlg2(false,getScancnt());
        }
        if(getScancnt()==0){
            delMember();
        }
        return "henkyaku.xhtml";
    }
    
    public String complete(){
        HenkyakuBb tot = new HenkyakuBb();
        setChange(getDeposit()-tot.getTotal());
        return "complete";
    }
    
    public String totalpage(){
        setDeposit(0);
        return "totalpage";
    }
    
    public void catchMember(String barcord){
        if(barcord.equals("1")){
            setMemberno("1");
            setSex("男性");
            setName("加藤弘幸");
            setKana("カトウヒロユキ");
            setBirthday("1987/6/5");
            setPhone("001-831-5511");
        }else if(barcord.equals("2")){
            setMemberno("2");
            setSex("男性");
            setName("佐藤弘幸");
            setKana("サトウヒロユキ");
            setBirthday("1987/7/5");
            setPhone("002-832-5522");
        }
    }
    
    public void delMember(){
        setMemberno("");
        setSex("");
        setName("");
        setKana("");
        setBirthday("");

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
    
    public String[] getEntaidays() {
        return entaidays;
    }

    public void setEntaidays(String entaiday,int scancnt) {
        this.entaidays[scancnt] = entaiday;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKana() {
        return kana;
    }

    public void setKana(String kana) {
        this.kana = kana;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemberno() {
        return memberno;
    }

    public void setMemberno(String memberno) {
        this.memberno = memberno;
    }

    public String getScanflg() {
        return scanflg;
    }

    public void setScanflg(String scanflg) {
        this.scanflg = scanflg;
    }
    
}
