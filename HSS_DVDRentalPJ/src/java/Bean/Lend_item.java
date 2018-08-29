/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//貸出物Bean
@Entity
public class Lend_item implements Serializable{
    @Id
    @NotNull
    private String dvd_barcode; //◎DVDバーコード
    @NotNull
    private String dvd_code;    //○DVDコード
    @NotNull
    private String title_no;    //タイトルNo
    @NotNull
    private String store_cd;    //○店舗コード
    @NotNull
    private String disk_type;   //ディスク区分
    @NotNull
    private String del_flg;     //Del_Flg
    //private String del_flg;     //棚卸し_Flg

    //コンストラクタ
    public Lend_item() {}
    
    public Lend_item(String dvd_barcode, String dvd_code, String title_no, String store_cd, String disk_type, String del_flg) {
        this.dvd_barcode = dvd_barcode;
        this.dvd_code = dvd_code;
        this.title_no = title_no;
        this.store_cd = store_cd;
        this.disk_type = disk_type;
        this.del_flg = del_flg;
    }
    
    /* getter */
    public String getDvd_barcode() {
        return dvd_barcode;
    }

    public String getDvd_code() {
        return dvd_code;
    }

    public String getTitle_no() {
        return title_no;
    }

    public String getStore_cd() {
        return store_cd;
    }

    public String getDisk_type() {
        return disk_type;
    }

    public String getDel_flg() {
        return del_flg;
    }

    /* setter */
    public void setDvd_barcode(String dvd_barcode) {
        this.dvd_barcode = dvd_barcode;
    }

    public void setDvd_code(String dvd_code) {
        this.dvd_code = dvd_code;
    }

    public void setTitle_no(String title_no) {
        this.title_no = title_no;
    }

    public void setStore_cd(String store_cd) {
        this.store_cd = store_cd;
    }

    public void setDisk_type(String disk_type) {
        this.disk_type = disk_type;
    }

    public void setDel_flg(String del_flg) {
        this.del_flg = del_flg;
    }
}
