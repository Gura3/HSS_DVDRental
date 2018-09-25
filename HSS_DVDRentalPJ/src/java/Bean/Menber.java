package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.*;
@NamedQueries({
    @NamedQuery(name=Menber.Comemembers,
                query="SELECT m FROM Menber m WHERE m.member_no = ?1")
})

@Entity
@Table(name="Member")
public class Menber implements Serializable {
    public static final String Comemembers ="Comemembers";
    
    @Id
    @NotNull
    private Integer member_no;  //会員No
    private String birth_day;    //誕生日
    private String name;    //氏名
    private String kana;    //氏名振り仮名
    private String sex;     //性別
    private String postal;  //郵便番号
    private String address; //住所
    private String phone;   //電話番号
    private String job;     //職業
    private String last_visits;//最終来店日
    private String mail_address;//メールアドレス
    private boolean mail_magazine;//メールマガジン
    private boolean unpaid;//未払い情報
    private boolean lend_cnt;//貸し出し中個数
    private boolean del_flg;//退会フラグ
    private boolean dangercnt;//危険なカウント
    
    //コンストラクタ
    public Menber() {
    }

    public Menber(Integer member_no, String birth_day, String name, String kana, String sex, String postal, String address, String phone, String job, String last_visits, String mail_address, boolean mail_magazine, boolean unpaid, boolean lend_cnt, boolean del_flg, boolean dangercnt) {
        this.member_no = member_no;
        this.birth_day = birth_day;
        this.name = name;
        this.kana = kana;
        this.sex = sex;
        this.postal = postal;
        this.address = address;
        this.phone = phone;
        this.job = job;
        this.last_visits = last_visits;
        this.mail_address = mail_address;
        this.mail_magazine = mail_magazine;
        this.unpaid = unpaid;
        this.lend_cnt = lend_cnt;
        this.del_flg = del_flg;
        this.dangercnt = dangercnt;
    }
    
    
    //ゲッター
    public Integer getMember_no() {
        return member_no;
    }

    public String getBirth_day() {
        return birth_day;
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
    
    //セッター
    public void setMember_no(Integer member_no) {
        this.member_no = member_no;
    }

    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
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
}
