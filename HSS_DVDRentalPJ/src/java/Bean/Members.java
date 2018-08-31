package Bean;


import java.io.Serializable;
import javax.persistence.Id;
import javax.validation.constraints.*;


public class Members implements Serializable {
    @Id
    @NotNull
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
    private boolean mail_magazine;
    private boolean unpaid;
    private boolean lend_cnt;
    private boolean del_flg;
    private boolean dangercnt;

    public Members() {
    }

    public Members(Members members){
        this.member_no = members.getMember_no();
        this.birthday=members.getBirthday();
        this.name=members.getName();
        this.kana=members.getKana();
        this.sex=members.getSex();
        this.postal=members.getPostal();
        this.address=members.getAddress();
        this.phone=members.getPhone();
        this.job=members.getJob();
        this.last_visits=members.getLast_visits();
        this.mail_address=members.getMail_address();
        this.mail_magazine=members.isMail_magazine();
        this.lend_cnt=members.isLend_cnt();
        this.del_flg=members.isDel_flg();
        this.unpaid=members.isUnpaid();
        this.dangercnt=members.isDangercnt();
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
    
    
  
}
