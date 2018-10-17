/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@NamedQueries({
    @NamedQuery(name=Lend.Comelend,
                query="SELECT l FROM Lend l WHERE l.lend_no = ?1"),
    @NamedQuery(name=Lend.Memlend,
                query="SELECT l FROM Lend l WHERE l.member_no = ?1"),
    @NamedQuery(name=Lend.Cntlend,
                query="SELECT COUNT(l) FROM Lend l")
})

@Entity
@Table(name="Lend")
public class Lend implements Serializable {
    
    public static final String Comelend ="Comelend";
    public static final String Memlend ="Memlend";
    public static final String Cntlend ="Cntlend";
    @Id
    @NotNull
    private String lend_no;    //貸出番号
    private String member_no;       //会員番号
    private String store_cd;      //店舗コード
    private String lend_date;     //貸出日付

    public Lend() {}

    public Lend(String lend_no, String member_no, String store_cd,String lend_date) {
        this.lend_no = lend_no;
        this.member_no = member_no;
        this.store_cd = store_cd;
        this.lend_date = lend_date;
    }

    public String getStore_cd() {
        return store_cd;
    }

    public void setStore_cd(String store_cd) {
        this.store_cd = store_cd;
    }

    public String getLend_no() {
        return lend_no;
    }

    public void setLend_no(String lend_no) {
        this.lend_no = lend_no;
    }

    public String getMember_no() {
        return member_no;
    }

    public void setMember_no(String member_no) {
        this.member_no = member_no;
    }

    public String getLend_date() {
        return lend_date;
    }

    public void setLend_date(String lend_date) {
        this.lend_date = lend_date;
    }

    
   
}
