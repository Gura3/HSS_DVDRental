/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Manager.DvdManager;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Named
@SessionScoped
public class SectionChangeBb implements Serializable{
    @Id
    @NotNull
    private String dvd_code;//DVDコード
    @NotNull
    private String title;//タイトル
    @NotNull
    private String ｇenre;//ジャンル
    @NotNull
    private String actor;//主演者
    private String come;//コメント
    @NotNull
    private String arrivalday;//入荷日
    @EJB
    DvdDb dd;
    @EJB
    DvdManager dm;
    Dvd sel;
    public String next(){
        return "/pages/dvd_information_change/section_change.xhtml";
    }
    
    public String disp(){
        return "/pages/dvd_information_change/dvd_disp.xhtml";
    }
    
    //全取得するやつ
    public List<Dvd> getFromDb(){
        List<Dvd> list = null;
        try{
            list = dm.getFromDb();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
//    public String detail(Dvd dvd){
//        sel = dvd;
//    }
    

//    //DB処理
//    public List<Dvd> getAll(){
//        return db.getAll();
//    }
    
    //getter・setter
    public String getDvd_code() {
        return dvd_code;
    }

    public String getTitle() {
        return title;
    }

    public String getＧenre() {
        return ｇenre;
    }

    public String getActor() {
        return actor;
    }

    public String getCome() {
        return come;
    }

    public String getArrivalday() {
        return arrivalday;
    }

    public void setDvd_code(String dvd_code) {
        this.dvd_code = dvd_code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setＧenre(String ｇenre) {
        this.ｇenre = ｇenre;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setCome(String come) {
        this.come = come;
    }

    public void setArrivalday(String arrivalday) {
        this.arrivalday = arrivalday;
    }
    
    
}
