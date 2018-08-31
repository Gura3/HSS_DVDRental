package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.*;

@NamedQueries({
    @NamedQuery(name=Kashi_meisai.ComeKashi_meisai,
                query="SELECT l FROM Kashi_meisai l WHERE l.dvd_barcode = ?1")
})

@Entity
@Table(name="LEND_DETAILS")
public class Kashi_meisai implements Serializable {
    
    public static final String ComeKashi_meisai ="ComeKashi_meisai";
    @Id
    @NotNull
    private String lend_no; //貸出番号
    @NotNull
    private String lend_det_no;  //貸出明細番号

    @NotNull
    private String dvd_barcode; //DVDバーコード
    @NotNull
    private String return_plan_day;//返却予定日
    
    private String return_day; //返却日
    @NotNull
    private String money;//金額


    public Kashi_meisai() {
    }

    public Kashi_meisai(String lend_no,String lend_det_no,String dvd_barcode,String return_plan_day,String return_day,String money) {
        this.lend_no = lend_no;
        this.lend_det_no = lend_det_no;
        this.dvd_barcode = dvd_barcode;
        this.return_plan_day = return_plan_day;
        this.return_day = return_day;
        this.money = money;
    }
    

    //セッター・ゲッター

    public String getLend_no() {
        return lend_no;
    }

    public void setLend_no(String lend_no) {
        this.lend_no = lend_no;
    }

    public String getDvd_barcode() {
        return dvd_barcode;
    }

    public void setDvd_barcode(String dvd_barcode) {
        this.dvd_barcode = dvd_barcode;
    }

    public String getReturn_plan_day() {
        return return_plan_day;
    }

    public void setReturn_plan_day(String return_plan_day) {
        this.return_plan_day = return_plan_day;
    }

    public String getReturn_day() {
        return return_day;
    }

    public void setReturn_day(String return_day) {
        this.return_day = return_day;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    
}
