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


@Named
@SessionScoped
public class SectionChangeBb implements Serializable{
    private String dvd_code;//DVDコード
    private String title;//タイトル
    private String ｇenre1;//ジャンル
    private String ｇenre2;//ジャンル
    private String actor;//主演者
    private String come;//コメント
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
    public List<DvdInfo> getFromDb(){
        List<DvdInfo> list = null;
        try{
            list = dm.getDvdInfoDb();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
