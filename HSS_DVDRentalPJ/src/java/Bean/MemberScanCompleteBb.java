/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import static HenkanTools.Tool.differenceDays;
import static HenkanTools.Tool.fmtSlash;
import Manager.MemberCardManager;
import Manager.MemberManager;
import Parameters.Nowfield;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Gura3
 */
@Named
//ログインしてからログアウトするまでの過程でオブジェクトを生成
@SessionScoped

/* 貸出会員スキャンバッキングビーン */
public class MemberScanCompleteBb implements Serializable{
    private String memberno;            //会員No・・・検索に使用する
    
    //
    private String sex;                 //性別
    private String name;                //氏名
    private String kana;                //氏名(フリガナ)
    private String birthday;            //生年月日
    private String phone;               //電話番号
    
    private String postal;              //郵便番号
    private String address;             //住所
    private String occupation;          //職業
    private String mail_address;        //メールアドレス
    private String mail_magazine;       //メールマガジン
    private String registararion_date;  //仮会員登録日
    private String delay;  //未払い金
    private boolean flg1 = false;// 未払いフラグ
    private String expirationDate;  //残り有効期限
    private String mem_barcode;
    private String issue_date;
    private String del_flg;

    @EJB
    MemberCardDb db;
    @EJB
    MemberCardManager mcMng;    //会員カードマネージャ
    @EJB
    MemberManager mMng;     //会員マネージャ
    
    Member_card mc;   //会員カード
    Menber mem;      //会員
    
    public String next() throws ParseException {
        mc = null;
        mem = null;
        
        try{
            //会員カード探す
            mc = mcMng.getMemBercode(mem_barcode);
            //会員カードの情報を元に会員を探す
            mem = mMng.getTheMem(mc.getMember_no());
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        
        if(mc == null){
            //見つからなかった場合
            return "memberScanError";
        }else{
            //見つかった場合
            if(mem.getDel_flg().equals("0")){
                //表示する情報をセット
                setMemberno(mc.getMember_no());
                Nowfield.MEMBERNO = getMemberno();
                    System.out.println("MemScanCompBb memberno"+Nowfield.MEMBERNO);
                setSex(mem.getSex());
                setName(mem.getName());
                setKana(mem.getKana());
                setBirthday(fmtSlash(mem.getBirth_day()));
                setPhone(mem.getPhone());
                Date date = new Date();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
                int ret = differenceDays(sdf1.format(date),fmtSlash(mc.getIssue_date()));
                ret = 365 - ret;
                if(ret < 31){
                    if(ret < 1){
                        ret = 0;
                    }
                    setFlg1(true);
                    setFlg2(false);
                    setExpirationDate(Integer.toString(ret));
                    return "memberScanComplete";
                }
                return  "memberScanComplete";
            }else{
                return "memberEmptyError";
            }
        }
        
    }
        //test
//        setSex("男性");
//        setBirthday("1990/1/1");
//        setPhone("001-831-5511");

//        if (("1").equals(comeMember())) {
//            if (("00000000").equals(getMemberno())) {
//                setName("A");
//                setKana("エー");
//            } else if (("11111115").equals(getMemberno())) {
//                setName("B");
//                setKana("ビー");
//            } else if (("22222220").equals(getMemberno())) {
//                setName("C");
//                setKana("シー");
//            } else if (("33333335").equals(getMemberno())) {
//                setName("D");
//                setKana("ディー");
//            } else if (("01234565").equals(getMemberno())) {
//                setName("山田太郎");
//                setKana("ヤマダタロウ");
//            }

//            setFlg1(false);
//            setFlg2(false);
//            return "memberScanComplete";                //正常
//        } else if (("2").equals(getMemberno())) {          //スキャン完了有効期限切れ1ヶ月前へ
//            setFlg1(true);
//            setFlg2(false);
//            setExpirationDate("30");
//            return "memberScanComplete";
//        } else if (("3").equals(getMemberno())) {          //スキャン完了未払い金へ
//            setFlg1(false);
//            setFlg2(true);
//            setDelay("300");
//            return "memberScanComplete";
//        } else if (("4").equals(getMemberno())) {          //スキャン完了未払い金有効期限切れ1ヶ月前へ
//            setFlg1(true);
//            setFlg2(true);
//            setExpirationDate("30");
//            setDelay("300");
//            return "memberScanComplete";
//                                                        //スキャン完了有効期限切れ1ヶ月前へ
//            //スキャン完了未払い金へ
//        } else if (("5").equals(getMemberno())) {          //有効期限更新へ
//            return "memberExpirationDate";
//        } else if (("6").equals(getMemberno())) {          //会員情報無しエラー
//            return "memberEmptyError";
//        } else {                                          //スキャンエラー
//            return "memberScanError";
//        }
//    }

//    public String comeMember() {
//            Member_card c = new Member_card();
//            List<Member_card> memlist = null;
//            try{
//                memlist= db.comemember(memberno);
//            }catch(Exception e){
//                e.printStackTrace();
//            }

//        System.out.println(this.memberno);
//        Member_card m = null;
//        try {
//            m = db.getCard(mem_barcode);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //System.out.println(m.getMember_no()+"ふぉおおおおおおおおおおおおｵｵｵｵｵｵｵｵｵｵｵｵｵｵｵｵｵｵ");
//        if (m == null) {
//            return "0";
//        } else {
//            setMemberno(m.getMember_no());
//            return "1";
//        }
//        return 
//    }

    public void setMemberno(String memberno) {
        this.memberno = memberno;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKana(String kana) {
        this.kana = kana;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setMail_address(String mail_address) {
        this.mail_address = mail_address;
    }

    public void setMail_magazine(String mail_magazine) {
        this.mail_magazine = mail_magazine;
    }

    public void setRegistararion_date(String registararion_date) {
        this.registararion_date = registararion_date;
    }

    public String getMemberno() {
        return memberno;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public String getKana() {
        return kana;
    }

    public String getSex() {
        return sex;
    }

    public String getPostal() {
        return postal;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getMail_address() {
        return mail_address;
    }

    public String getMail_magazine() {
        return mail_magazine;
    }

    public String getRegistararion_date() {
        return registararion_date;
    }

    public boolean isFlg1() {
        return flg1;
    }

    public void setFlg1(boolean flg1) {
        this.flg1 = flg1;
    }

    public boolean isFlg2() {
        return flg2;
    }

    public void setFlg2(boolean flg2) {
        this.flg2 = flg2;
    }

    /**
     * 延滞フラグ
     */
    private boolean flg2 = false;

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getMem_barcode() {
        return mem_barcode;
    }

    public void setMem_barcode(String mem_barcode) {
        this.mem_barcode = mem_barcode;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getDel_flg() {
        return del_flg;
    }

    public void setDel_flg(String del_flg) {
        this.del_flg = del_flg;
    }
}
