/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import static HenkanTools.Tool.cnvSextion;
import static HenkanTools.Tool.fmtSlash;
import static HenkanTools.Tool.getHostName;
import Manager.DvdManager;
import Manager.KashiDvdManager;
import Parameters.Nowfield;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
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
    private int sales;              //割引
    private boolean plan1;
    private boolean plan2;
    private boolean plan3;
    private String planview1;
    private String planview2;
    private String planview3;
    private String planview11;
    private String planview22;
    private String planview33;
    private String planmoney1;
    private String planmoney2;
    private String planmoney3;
    
    private String today;
    private String retplanday;
    private String retplandays[] = new String[10];
    private String addday;
    
    private boolean mai1;
    private boolean mai2;
    private boolean mai3;
    private boolean mai4;
    private boolean mai5;
    private boolean mai6;
    private boolean mai7;
    private boolean mai8;
    private boolean mai9;
    private boolean mai10;
        
    private String maiview1;
    private String maiview2;
    private String maiview3;
    private String maiview4;
    private String maiview5;
    private String maiview6;
    private String maiview7;
    private String maiview8;
    private String maiview9;
    private String maiview10;
    
    
    @EJB
    KashiDvdManager kashimng;
    @EJB
    DvdManager dvdmng;
    @EJB
    LendDb lenddb;
    @EJB
    Kashi_meisaiDb kashidb;
    
    Lend l = new Lend();
    Lend_item kd = null;
    Kashi_meisai km = new Kashi_meisai();
    Dvd d = null;
    Sextion s = null;
    
    public String next(){
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        setToday(sdf1.format(date));
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
            return "DVDScanerror.xhtml";
        }
        setTitle(d.getTitle());
        setNewold(cnvSextion(s.getSextion()));
        if(s.getSextion().equals("0")){
            setPlanview1("当日 \\200");
            setPlanview2("1泊2日 \\260");
            setPlanview11("当日");
            setPlanview22("1泊2日");
            setPlanmoney1("200");
            setPlanmoney2("260");
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
            setPlanmoney1("200");
            setPlanmoney2("260");
            setPlanmoney2("300");
            setPlan1(true);
            setPlan2(true);
            setPlan3(true);
        }else{
            setPlanview1("7泊8日 \\160");
            setPlanview11("7泊8日");
            setPlanmoney1("160");
            setPlan1(true);
            setPlan2(false);
            setPlan3(false);
        }
        return "DVDPlan.xhtml";
    }
    
    public String plans(int choose){
        setBarcodes(getBarcode(),getScancnt());
        System.out.println("スキャンカウント"+getScancnt());
        System.out.println("バーコード"+getBarcodechan(getScancnt()));
        setTitles(d.getTitle(),getScancnt());
        setFlg1(false,getScancnt());
        setFlg2(true,getScancnt());
        // フォーマット変換用のSimpleDateFormatオブジェクトを生成
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
 
        // 現在日時を保持するCalendarオブジェクトを生成
        Calendar cal = Calendar.getInstance();
 
        // 現在日時をyyyyMMdd形式で出力（結果：20130814）
        System.out.println(df.format(cal.getTime()));
 
        if(choose == 1){
            setMoneys(getPlanmoney1(),getScancnt());
            if(s.getSextion().equals("0")){
                // 加算しないで格納
                setRetplanday(getToday());
            }else if(s.getSextion().equals("1")){
                // 加算しないで格納
                setRetplanday(getToday());
            }else if(s.getSextion().equals("2")){
                // 7日を加算
                cal.add(Calendar.DATE, 7);
                setRetplanday(df.format(cal.getTime()));
            }
        }else if(choose == 2){
            setMoneys(getPlanmoney2(),getScancnt());
            if(s.getSextion().equals("0")){
                // 1日を加算
                cal.add(Calendar.DATE, 1);
                setRetplanday(df.format(cal.getTime()));
            }else if(s.getSextion().equals("1")){
                // 1日を加算
                cal.add(Calendar.DATE, 1);
                setRetplanday(df.format(cal.getTime()));
            }
        }else if(choose == 3){
            setMoneys(getPlanmoney3(),getScancnt());
            // 2日を加算
                cal.add(Calendar.DATE, 2);
                setRetplanday(df.format(cal.getTime()));
        }
        String mons[] = getMoneys();
        setTotal(getTotal()+Integer.parseInt(mons[getScancnt()]));
        setTax((int)(getTotal()/1.08*0.08));
        setDays(fmtSlash(today)+"～"+fmtSlash(getRetplanday()),getScancnt());
        setRetplandays(getRetplanday(), getScancnt());
        setScancnt(getScancnt()+1);
        return "DVDScan.xhtml";
    }
    
    public String mais(int choose){
        setSales(choose);
        setTotal(getTotal()-50*choose);
        setTax((int)(getTotal()/1.08*0.08));
        return "totalpage.xhtml";
    }
    
    public String risettosan(){
        setTotal(getTotal()+50*getSales());
        setTax((int)(getTotal()/1.08*0.08));
        setSales(0);
        return "totalpage.xhtml";
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
        String name = getHostName();
        System.out.println("ホスト名 = '"+name+"'");
        System.out.println(getChange());
        if(getChange()<0){
            System.out.println("1");
            return "totalpage";
        }
        if(name.equals("HCS70148")){
            System.out.println("2");
            l.setStore_cd("00");
        }else{
            l.setStore_cd("00");
        }
        System.out.println("3");
        Random bango = new Random();
        System.out.println("4");
        int lenddayo = bango.nextInt(100000000);
        System.out.println("5");
        System.out.println(lenddayo);
        l.setLend_no(String.format("%08d",lenddayo));
        l.setMember_no(Nowfield.MEMBERNO);
        l.setLend_date(getToday());
        System.out.println("lendno"+l.getLend_no());
        System.out.println("memno"+l.getMember_no());
        lenddb.add(l);
        int cnti = 0;
        int cntj = getScancnt()-1;
        while(cntj > -1){
            km.setLend_no(l.getLend_no());
            km.setLend_det_no(String.format("%08d",cnti));
            km.setDvd_barcode(getBarcodechan(cnti));
            km.setReturn_plan_day(getRetplandaychan(cnti));
            km.setMoney(getMoneychan(cnti));
            cnti++;
            cntj--;
            System.out.println("lendno"+km.getLend_no());
            System.out.println("lenddetno"+km.getLend_det_no());
            System.out.println("dvdbar"+km.getDvd_barcode());
            System.out.println("retplan"+km.getReturn_plan_day());
            System.out.println("retday"+km.getReturn_day());
            System.out.println("money"+km.getMoney());
            kashidb.add(km);
        }
        return "complete";
    }
    
    public String totalpage(){
        setSales(0);
        setDeposit(0);
        setMai1(false);
        setMai2(false);
        setMai3(false);
        setMai4(false);
        setMai5(false);
        setMai6(false);
        setMai7(false);
        setMai8(false);
        setMai9(false);
        setMai10(false);
        setMaiview1("1");
        setMaiview2("2");
        setMaiview3("3");
        setMaiview4("4");
        setMaiview5("5");
        setMaiview6("6");
        setMaiview7("7");
        setMaiview8("8");
        setMaiview9("9");
        setMaiview10("10");
        if(getScancnt() == 1){
            setMai1(true);
        }else if(getScancnt() == 2){
            setMai1(true);
            setMai2(true);
        }else if(getScancnt() == 3){
            setMai1(true);
            setMai2(true);
            setMai3(true);
        }else if(getScancnt() == 4){
            setMai1(true);
            setMai2(true);
            setMai3(true);
            setMai4(true);
        }else if(getScancnt() == 5){
            setMai1(true);
            setMai2(true);
            setMai3(true);
            setMai4(true);
            setMai5(true);
        }else if(getScancnt() == 6){
            setMai1(true);
            setMai2(true);
            setMai3(true);
            setMai4(true);
            setMai5(true);
            setMai6(true);
        }else if(getScancnt() == 7){
            setMai1(true);
            setMai2(true);
            setMai3(true);
            setMai4(true);
            setMai5(true);
            setMai6(true);
            setMai7(true);
        }else if(getScancnt() == 8){
            setMai1(true);
            setMai2(true);
            setMai3(true);
            setMai4(true);
            setMai5(true);
            setMai6(true);
            setMai7(true);
            setMai8(true);
        }else if(getScancnt() == 9){
            setMai1(true);
            setMai2(true);
            setMai3(true);
            setMai4(true);
            setMai5(true);
            setMai6(true);
            setMai7(true);
            setMai8(true);
            setMai9(true);
        }else if(getScancnt() == 10){
            setMai1(true);
            setMai2(true);
            setMai3(true);
            setMai4(true);
            setMai5(true);
            setMai6(true);
            setMai7(true);
            setMai8(true);
            setMai9(true);
            setMai10(true);
        }
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

    public String getPlanmoney1() {
        return planmoney1;
    }

    public void setPlanmoney1(String planmoney1) {
        this.planmoney1 = planmoney1;
    }

    public String getPlanmoney2() {
        return planmoney2;
    }

    public void setPlanmoney2(String planmoney2) {
        this.planmoney2 = planmoney2;
    }

    public String getPlanmoney3() {
        return planmoney3;
    }

    public void setPlanmoney3(String planmoney3) {
        this.planmoney3 = planmoney3;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String[] getRetplandays() {
        return retplandays;
    }

    public void setRetplandays(String retplandays,int scancnt) {
        this.retplandays[scancnt] = retplandays;
    }

    public String getAddday() {
        return addday;
    }

    public void setAddday(String addday) {
        this.addday = addday;
    }

    public String getRetplanday() {
        return retplanday;
    }

    public void setRetplanday(String retplanday) {
        this.retplanday = retplanday;
    }

    public boolean isMai1() {
        return mai1;
    }

    public void setMai1(boolean mai1) {
        this.mai1 = mai1;
    }

    public String getMaiview1() {
        return maiview1;
    }

    public void setMaiview1(String maiview1) {
        this.maiview1 = maiview1;
    }

    public boolean isMai2() {
        return mai2;
    }

    public void setMai2(boolean mai2) {
        this.mai2 = mai2;
    }

    public boolean isMai3() {
        return mai3;
    }

    public void setMai3(boolean mai3) {
        this.mai3 = mai3;
    }

    public boolean isMai4() {
        return mai4;
    }

    public void setMai4(boolean mai4) {
        this.mai4 = mai4;
    }

    public boolean isMai5() {
        return mai5;
    }

    public void setMai5(boolean mai5) {
        this.mai5 = mai5;
    }

    public boolean isMai6() {
        return mai6;
    }

    public void setMai6(boolean mai6) {
        this.mai6 = mai6;
    }

    public boolean isMai7() {
        return mai7;
    }

    public void setMai7(boolean mai7) {
        this.mai7 = mai7;
    }

    public boolean isMai8() {
        return mai8;
    }

    public void setMai8(boolean mai8) {
        this.mai8 = mai8;
    }

    public boolean isMai9() {
        return mai9;
    }

    public void setMai9(boolean mai9) {
        this.mai9 = mai9;
    }

    public boolean isMai10() {
        return mai10;
    }

    public void setMai10(boolean mai10) {
        this.mai10 = mai10;
    }

    public String getMaiview2() {
        return maiview2;
    }

    public void setMaiview2(String maiview2) {
        this.maiview2 = maiview2;
    }

    public String getMaiview3() {
        return maiview3;
    }

    public void setMaiview3(String maiview3) {
        this.maiview3 = maiview3;
    }

    public String getMaiview4() {
        return maiview4;
    }

    public void setMaiview4(String maiview4) {
        this.maiview4 = maiview4;
    }

    public String getMaiview5() {
        return maiview5;
    }

    public void setMaiview5(String maiview5) {
        this.maiview5 = maiview5;
    }

    public String getMaiview6() {
        return maiview6;
    }

    public void setMaiview6(String maiview6) {
        this.maiview6 = maiview6;
    }

    public String getMaiview7() {
        return maiview7;
    }

    public void setMaiview7(String maiview7) {
        this.maiview7 = maiview7;
    }

    public String getMaiview8() {
        return maiview8;
    }

    public void setMaiview8(String maiview8) {
        this.maiview8 = maiview8;
    }

    public String getMaiview9() {
        return maiview9;
    }

    public void setMaiview9(String maiview9) {
        this.maiview9 = maiview9;
    }

    public String getMaiview10() {
        return maiview10;
    }

    public void setMaiview10(String maiview10) {
        this.maiview10 = maiview10;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getBarcodechan(int cnt){
        return barcodes[cnt];
    }
    
    public String getRetplandaychan(int cnt){
        return retplandays[cnt];
    }
    
    public String getMoneychan(int cnt){
        return moneys[cnt];
    }

}
