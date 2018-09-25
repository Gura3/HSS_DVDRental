/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import static HenkanTools.Tool.cnvSextion;
import static HenkanTools.Tool.differenceDays;
import static HenkanTools.Tool.fmtSlash;
import Manager.DvdManager;
import Manager.HenkyakuManager;
import Manager.KashiDvdManager;
import Manager.MemberManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private String kashidashinow;
    
    private String memberno;            //会員No
    private String birthday;            //生年月日
    private String name;                //氏名
    private String kana;                //会員名(フリガナ)
    private String sex;                 //性別
    private String phone;               //電話番号
    
    private String syuen[] = new String[10];               //主演者
    private String komento[] = new String[10];             //コメント
    private String getday[] = new String[10];              //入荷日
    private String newold[] = new String[10];              //新作区分
    private String startday[] = new String[10];            //貸出開始日
    private String returnday[] = new String[10];           //返却期限日
    
    private String scanflg;

    @EJB
    HenkyakuDb db;
    @EJB
    HenkyakuManager mng;
    @EJB
    KashiDvdManager kashimng;
    @EJB
    DvdDb dvddb;
    @EJB
    KashiDvdDb kashidvddb;
    @EJB
    DvdManager dvdmng;
    @EJB
    MemberManager memmng;
    @EJB
    Kashi_meisaiDb kashidb;
    
    Kashi_meisai k = null;
    Dvd d = null;
    Lend_item kd = null;
    Lend l = null;
    Menber m = null;
    Sextion s = null;
    
    

    
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
        setKashidashinow("");
        delMember();
        System.out.print(getScanflg());
        
        return "/pages/henkyaku/henkyaku.xhtml";
    }
    
    public String comp(){
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        k.setReturn_day(sdf1.format(date));
        kashidb.update(k);
        return "/pages/henkyaku/henkyakucomp.xhtml";
    }
    
    public String back(){
        return "henkyaku.xhtml";
    }
    
    public String scan() throws ParseException{
        if(getScancnt()<10){
            try {
                k = mng.getKashiBercode(barcode);
                l = kashimng.getKashiData(k.getLend_no());
                kd = kashimng.getKashiDvdData(barcode);
                d = dvdmng.getDvdData(kd.getDvd_code());
                s = dvdmng.getSextiondvd(d.getDvd_code(), kd.getStore_cd());
            } catch (Exception e) {
                e.printStackTrace();
                setScanflg("true");
                return "henkyakuScanerror.xhtml";
            }
            setBarcodes(getBarcode(),getScancnt());
            setTitles(d.getTitle(),getScancnt());
            setDays(fmtSlash(l.getLend_date())+"～"+fmtSlash(k.getReturn_plan_day()),getScancnt());
            Date date = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
            int ret = differenceDays(sdf1.format(date),fmtSlash(k.getReturn_plan_day()));
            if(ret<=0){
                System.out.println("延滞してないよおおおおおおお"+ret);
                setEntaidays("-",getScancnt());
                setMoneys("0",getScancnt());
            }else{
                System.out.println("延滞してんじゃねえ！！！！！"+ret);
                setEntaidays(Integer.toString(ret),getScancnt());
                setMoneys(Integer.toString(ret*300),getScancnt());
            }
            setFlg1(false,getScancnt());
            setFlg2(true,getScancnt());
            setSyuen(d.getActor(),getScancnt());
            setKomento(d.getCome(),getScancnt());
            setGetday(d.getArrivalday(),getScancnt());
            setNewold(cnvSextion(s.getSextion()), scancnt);
            setStartday(fmtSlash(l.getLend_date()),getScancnt());
            setReturnday(fmtSlash(k.getReturn_plan_day()),getScancnt());
            System.out.println(k.getMoney());
            String mons[] = getMoneys();
            setTotal(getTotal()+Integer.parseInt(mons[getScancnt()]));
            setTax((int)(getTotal()/1.08*0.08));
            setScancnt(getScancnt()+1);
            if(getScancnt()==1){
                System.out.println("これ借りてる人は"+l.getMember_no());
                catchMember(l.getMember_no());
            }
            return "henkyaku.xhtml";
        }
        return "henkyaku.xhtml";         //10件超えたよってやりたい
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
    
    public void catchMember(String memberno){
        try {
            m = memmng.getTheMem(memberno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(m != null){
            setMemberno(Integer.toString(m.getMember_no()));
            setSex(m.getSex());
            setName(m.getName());
            setKana(m.getKana());
            setBirthday(fmtSlash(m.getBirth_day()));
            setPhone(m.getPhone());
            List<Lend> llist = kashimng.getMemkashi(getMemberno());
            if(llist != null){
                int cnt = 0;
                for(int i=0;i<llist.size();i++){
                    if(llist.get(i) != null){
                        if(mng.getKaeshitenai(llist.get(i).getLend_no()) != null){
                            cnt++;
                        }
                    }
                }
                setKashidashinow(Integer.toString(cnt));
            }else{
                setKashidashinow("0");
            }
        }
    }
    
    public void delMember(){
        setMemberno("");
        setSex("");
        setName("");
        setKana("");
        setBirthday("");
        setKashidashinow("");

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

    public String getKashidashinow() {
        return kashidashinow;
    }

    public void setKashidashinow(String kashidashinow) {
        this.kashidashinow = kashidashinow;
    }

    public String[] getSyuen() {
        return syuen;
    }

    public void setSyuen(String syuen,int scancnt) {
        this.syuen[scancnt] = syuen;
    }

    public String[] getGetday() {
        return getday;
    }

    public void setGetday(String getday,int scancnt) {
        this.getday[scancnt] = getday;
    }

    public String[] getNewold() {
        return newold;
    }

    public void setNewold(String newold,int scancnt) {
        this.newold[scancnt] = newold;
    }

    public String[] getStartday() {
        return startday;
    }

    public void setStartday(String startday,int scancnt) {
        this.startday[scancnt] = startday;
    }

    public String[] getReturnday() {
        return returnday;
    }

    public void setReturnday(String returnday,int scancnt) {
        this.returnday[scancnt] = returnday;
    }

    public String[] getKomento() {
        return komento;
    }

    public void setKomento(String komento,int scancnt) {
        this.komento[scancnt] = komento;
    }

}
