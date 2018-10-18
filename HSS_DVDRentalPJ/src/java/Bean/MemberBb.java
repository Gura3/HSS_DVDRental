package Bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class MemberBb {

    private Integer member_no;
    private Integer birthday;
    private String name;
    private String kana;
    private String sex;
    private Integer postal;
    private String address;
    private Integer phone;
    private String job;
    private Integer last_visits;
    private String mail_address;
    private boolean mail_magazine;  //メールマガジン
    private boolean unpaid;
    private boolean lend_cnt;
    private boolean del_flg;
    private boolean dangercnt;
    
   

    
    
    //身分証明賞
    private String iden_kbn;    //身分証明書区分
    private String iden_no;     //身分証明書番号
    
    //会員登録トップ画面
    public String next() {
        return "/pages/enroll/enrollment_top";
    }
    
    //身分証明書入力
    public String inputIden(){
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

    public Integer getMember_no() {
        return member_no;
    }

    public void setMember_no(Integer member_no) {
        this.member_no = member_no;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
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

    public Integer getPostal() {
        return postal;
    }

    public void setPostal(Integer postal) {
        this.postal = postal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getLast_visits() {
        return last_visits;
    }

    public void setLast_visits(Integer last_visits) {
        this.last_visits = last_visits;
    }

    public String getMail_address() {
        return mail_address;
    }

    public void setMail_address(String mail_address) {
        this.mail_address = mail_address;
    }

    public boolean isMail_magazine() {
        return mail_magazine;
    }

    public void setMail_magazine(boolean mail_magazine) {
        this.mail_magazine = mail_magazine;
    }

    public boolean isUnpaid() {
        return unpaid;
    }

    public void setUnpaid(boolean unpaid) {
        this.unpaid = unpaid;
    }

    public boolean isLend_cnt() {
        return lend_cnt;
    }

    public void setLend_cnt(boolean lend_cnt) {
        this.lend_cnt = lend_cnt;
    }

    public boolean isDel_flg() {
        return del_flg;
    }

    public void setDel_flg(boolean del_flg) {
        this.del_flg = del_flg;
    }

    public boolean isDangercnt() {
        return dangercnt;
    }

    public void setDangercnt(boolean dangercnt) {
        this.dangercnt = dangercnt;
    }
    
    //身分証明書のゲッターセッター
    public void setIden_no(String iden_no) {
        this.iden_no = iden_no;
    }

    public String getIden_kbn() {
        return iden_kbn;
    }

    public String getIden_no() {
        return iden_no;
    }
     public void setIden_kbn(String iden_kbn) {
        this.iden_kbn = iden_kbn;
    }
}

