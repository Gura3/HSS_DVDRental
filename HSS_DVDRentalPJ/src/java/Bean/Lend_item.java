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
    @NamedQuery(name=Lend_item.Comedvd,
                query="SELECT l FROM Lend_item l WHERE l.dvd_barcode = ?1")
})

@Entity
@Table(name="Lend_item")
public class Lend_item implements Serializable {
    
    public static final String Comedvd ="Comedvd";
    @Id
    @NotNull
    private String dvd_barcode;    //DVDバーコード
    private String del_flg;       //削除フラグ
    private String disk_type;      //ディスク区分
    private String dvd_code;     //dvdコード
    private String store_cd;       //店舗コード
    private String title_no;        //タイトル番号

    public Lend_item() {}

    public Lend_item(String dvd_barcode, String del_flg, String disk_type,String dvd_code, String store_cd, String title_no) {
        this.dvd_barcode = dvd_barcode;
        this.del_flg = del_flg;
        this.disk_type = disk_type;
        this.dvd_code = dvd_code;
        this.store_cd = store_cd;
        this.title_no = title_no;
    }

    public String getDvd_barcode() {
        return dvd_barcode;
    }

    public void setDvd_barcode(String dvd_barcode) {
        this.dvd_barcode = dvd_barcode;
    }

    public String getDel_flg() {
        return del_flg;
    }

    public void setDel_flg(String del_flg) {
        this.del_flg = del_flg;
    }

    public String getDisk_type() {
        return disk_type;
    }

    public void setDisk_type(String disk_type) {
        this.disk_type = disk_type;
    }

    public String getDvd_code() {
        return dvd_code;
    }

    public void setDvd_code(String dvd_code) {
        this.dvd_code = dvd_code;
    }

    public String getStore_cd() {
        return store_cd;
    }

    public void setStore_cd(String store_cd) {
        this.store_cd = store_cd;
    }

    public String getTitle_no() {
        return title_no;
    }

    public void setTitle_no(String title_no) {
        this.title_no = title_no;
    }
    
   
}
