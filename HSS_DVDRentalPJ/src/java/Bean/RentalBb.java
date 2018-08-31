/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import static Parameters.RentalPaths.*;
import javax.ejb.EJB;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 *
 * @author s20163002
 */
@Named
@RequestScoped

public class RentalBb {
    @EJB
    RentalDb db;
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
    
    public String next(){
        return "/pages/kashidashi/memberScan.xhtml";
    }
    
    //DB処理
    public List<Lend_item> getAll(){
        return db.getAll();
    }
    
    
    //getter・setter
    public RentalDb getDb() {
        return db;
    }

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

    public void setDb(RentalDb db) {
        this.db = db;
    }

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
