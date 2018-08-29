/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author s20163002
 */
public class DvdInfo {
    private String dvd_code;    //DVDコード
    private String title;       //タイトル
    private String genre1;      //ジャンル1
    private String genre2;      //ジャンル2
    //private String actor;       //主演者
    //private String come;        //コメント
    //private String arrivalday;  //入荷日
    private String sextion;     //新作区分
    //private String stock;       //在庫個数
    /* コンストラクタ*/
    public DvdInfo() {
    }

    public DvdInfo(String dvd_code, String title, String genre1, String genre2, String actor, String arrivalday, String sextion, String stock) {
        this.dvd_code = dvd_code;
        this.title = title;
        this.genre1 = genre1;
        this.genre2 = genre2;
//        this.actor = actor;
//        this.arrivalday = arrivalday;
        this.sextion = sextion;
//        this.stock = stock;
    }
    
    /* 取得・設定メソッド */
    public String getDvd_code() {
        return dvd_code;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre1() {
        return genre1;
    }

    public String getGenre2() {
        return genre2;
    }

//    public String getActor() {
//        return actor;
//    }
//
//    public String getCome() {
//        return come;
//    }
//
//    public String getArrivalday() {
//        return arrivalday;
//    }

    public String getSextion() {
        return sextion;
    }

//    public String getStock() {
//        return stock;
//    }

    public void setDvd_code(String dvd_code) {
        this.dvd_code = dvd_code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

//    public void setActor(String actor) {
//        this.actor = actor;
//    }
//
//    public void setCome(String come) {
//        this.come = come;
//    }
//
//    public void setArrivalday(String arrivalday) {
//        this.arrivalday = arrivalday;
//    }

    public void setSextion(String sextion) {
        this.sextion = sextion;
    }

//    public void setStock(String stock) {
//        this.stock = stock;
//    }
    
    
}
