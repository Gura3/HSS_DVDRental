package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.*;

@NamedQueries({
    @NamedQuery(name=Member_card.Comemem,
                query="SELECT d FROM Member_card d WHERE d.mem_barcode = ?1")
})

@Entity
@Table(name="member_card")
public class Member_card implements Serializable {
    
    public static final String Comemem ="Comemem";
    @Id
    @NotNull
    private String mem_barcode; //会員バーコード
    @NotNull
    private String issue_date;  //発行日
    @NotNull
    private String del_flg; //無効フラグ
    @NotNull
    private String member_no;//会員No


    public Member_card() {
    }

    public Member_card(String mem_barcode,String issue_date,String del_flg,String member_no) {
        this.mem_barcode = mem_barcode;
        this.issue_date = issue_date;
        this.del_flg = del_flg;
        this.member_no = member_no;
    }
    
    //
//    public Member_card(Member_card membercard) {
//        this.mem_barcode = membercard.getMem_barcode();
//        this.issue_date = membercard.getIssue_date();
//        this.del_flg = membercard.getDel_flg();
//        this.member_no = membercard.getMember_no();
//    }

    //セッター・ゲッター
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

    public String getMember_no() {
        return member_no;
    }

    public void setMember_no(String member_no) {
        this.member_no = member_no;
    }
}
