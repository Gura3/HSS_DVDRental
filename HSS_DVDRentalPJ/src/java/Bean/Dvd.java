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
    @NamedQuery(name=Dvd.Qall,
                query="SELECT d FROM Dvd d ORDER BY d.dvd_code")
})

@Entity
@Table(name="dvd")
public class Dvd implements Serializable {
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    
    public static final String Qall ="Qall";
    @Id
    @NotNull
    private String dvd_code;    //DVDコード
    @NotNull
    private String title;       //タイトル
    @NotNull
    private String genre;      //ジャンル
    @NotNull
    private String actor;       //主演者
    private String come;        //コメント
    @NotNull
    private String arrivalday;//入荷日

    public Dvd() {}

    public Dvd(String dvd_code, String title, String genre, String actor, String come, String arrivalday) {
        this.dvd_code = dvd_code;
        this.title = title;
        this.genre = genre;
        this.actor = actor;
        this.come = come;
        this.arrivalday = arrivalday;
    }
    
    //getter
    public String getDvd_code() {
        return dvd_code;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
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

    //setter
    public void setDvd_code(String dvd_code) {
        this.dvd_code = dvd_code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setＧenre(String ｇenre) {
        this.genre = ｇenre;
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
//    
//    public Long getId() {
//        return id;
//    }
}
