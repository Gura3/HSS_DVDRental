package Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped

public class MemberBb {
    
   
    
     //とりあえず保留
    private Integer member_no;  //会員番号
    public Integer getMember_no() {
        return member_no;
    }

    public void setMember_no(Integer member_no) {
        this.member_no = member_no;
    }
    
    private String birthday;   //生年月日
    private String name;        //氏名
    private String kana;        //氏名カナ
    private String sex;         //性別
    private String postal;     //郵便番号
    private String address;     //住所
    private String phone;      //電話番号
    private String job;         //職業
    private String last_visits;    //最終来店日
    private String mail_address;    //メールアドレス
    private boolean mail_magazine;  //メールマガジン
    private boolean unpaid;         //未払金
    private boolean lend_cnt;       //貸出数
    private boolean del_flg;        //退会フラグ
    private boolean dangercnt;      //危険カウント

    //身分証明賞
    private String iden_kbn;    //身分証明書区分
    private String category;    //身分証明書の種類
    private String iden_no;     //身分証明書番号

    private Integer ijob;

    private static Map<String, Integer> items;


//    private static SelectItem[] items = {
//        new SelectItem(1,"運転免許（未成年を除く）"),
//        new SelectItem(2,"保険証（健康保険）"),
//        new SelectItem(3,"保険証（高校生を除く）"),
//        new SelectItem(4,"学生証（後期高齢者医療）"),
//        new SelectItem(5,"パスポート（未成年を除く）"),
//        new SelectItem(6,"その他")
//    };
    
    Menber m = new Menber();
    Member_card mc = new Member_card();
    @EJB
    MemberDb md;
    @EJB
    MemberCardDb mcd;
    
    //会員登録トップ画面
    public String next() {
        return "/pages/enroll/enrollment_top";
    }

    //身分証明書入力
    public String inputIden() {
        return "/pages/enroll/identify_confirm.xhtml";
    }

    //店内会員登録画面
    public String instore_next() {
        return "/pages/enroll/instore_enroll.xhtml";
    }

    //会員情報確認画面
    public String confirm() {
        return "/pages/enroll/enroll_confirm.xhtml";
    }

    public String memIns(){
        //Integer型に変換（保留
        m.setMember_no(member_no);  //会員番号
        m.setBirth_day(birthday);   //生年月日
        
        m.setName(name);            //氏名
        m.setKana(kana);            //氏名カナ
        m.setSex(sex);              //性別
        m.setPostal(postal);        //郵便番号
        m.setAddress(address);      //住所
        m.setPhone(phone);          //電話番号
        m.setJob(job);              //職業
        
        /* 最終来店日 */
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        m.setLast_visits(sdf1.format(date));
        
        m.setMail_address(mail_address);        //メールアドレス
        m.setMail_magazine(mail_magazine);  //メールマガジン
        m.setUnpaid("0");                       //未払い金
        m.setLend_cnt("0");                     //貸出数
        m.setDangercnt("0");                    //危険カウント
        m.setDel_flg("0");                      //削除フラグ
        
        md.add(m);
        mc.setMember_no(Integer.toString(member_no));
        mc.setMem_barcode(Integer.toString(member_no));
        mc.setIssue_date(sdf1.format(date));
        mc.setDel_flg("0");
        mcd.add(mc);
        
        
        return "/pages/enroll/enroll_comp.xhtml";
    }

    
    
    
    public String scan() {
        return "/pages/enroll/scan_card.xhtml";
    }

    public String staffConfirm() {
        return "/pages/enroll/memberinfo_confirm";
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

    public String getJob() {
        return job;
    }

    public String getLast_visits() {
        return last_visits;
    }

    public String getMail_address() {
        return mail_address;
    }

    public boolean isMail_magazine() {
        return mail_magazine;
    }

    public boolean isUnpaid() {
        return unpaid;
    }

    public boolean isLend_cnt() {
        return lend_cnt;
    }

    public boolean isDel_flg() {
        return del_flg;
    }

    public boolean isDangercnt() {
        return dangercnt;
    }

    public String getIden_kbn() {
        return iden_kbn;
    }

    public String getCategory() {
        return category;
    }

    public String getIden_no() {
        return iden_no;
    }

    public Integer getIjob() {
        return ijob;
    }

    public static Map<String, Integer> getItems() {
        return items;
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

    public void setJob(String job) {
        this.job = job;
    }

    public void setLast_visits(String last_visits) {
        this.last_visits = last_visits;
    }

    public void setMail_address(String mail_address) {
        this.mail_address = mail_address;
    }

    public void setMail_magazine(boolean mail_magazine) {
        this.mail_magazine = mail_magazine;
    }

    public void setUnpaid(boolean unpaid) {
        this.unpaid = unpaid;
    }

    public void setLend_cnt(boolean lend_cnt) {
        this.lend_cnt = lend_cnt;
    }

    public void setDel_flg(boolean del_flg) {
        this.del_flg = del_flg;
    }

    public void setDangercnt(boolean dangercnt) {
        this.dangercnt = dangercnt;
    }

    public void setIden_kbn(String iden_kbn) {
        this.iden_kbn = iden_kbn;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIden_no(String iden_no) {
        this.iden_no = iden_no;
    }

    public void setIjob(Integer ijob) {
        this.ijob = ijob;
    }

    public static void setItems(Map<String, Integer> items) {
        MemberBb.items = items;
    }
    public String cnvMg(boolean mg){
        if(mg){
            return "受け取る";
        }else{
            return "受け取らない";
        }
    }
}
/**
 * *** setter,getter*****
 */
