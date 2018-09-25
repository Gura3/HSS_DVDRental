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
    @NamedQuery(name=Sextion.Sextionserch,
                query="SELECT s FROM Sextion s WHERE s.dvd_code = ?1 AND s.store_cd = ?2")
})

@Entity
@Table(name="sextion")
public class Sextion implements Serializable {
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id; 
    
    public static final String Sextionserch ="Sextionserch";
    @Id
    @NotNull
    private String dvd_code;    //DVDコード
    @Id
    @NotNull
    private String store_cd;       //店舗コード
    @NotNull
    private String sextion;      //新作区分
   

    public Sextion() {}

    public Sextion(String dvd_code, String store_cd, String sextion) {
        this.dvd_code = dvd_code;
        this.store_cd = store_cd;
        this.sextion = sextion;
    }
    
    //getter
    public String getDvd_code() {
        return dvd_code;
    }

    //setter
    public void setDvd_code(String dvd_code) {
        this.dvd_code = dvd_code;
    }

    public String getStore_cd() {
        return store_cd;
    }

    public void setStore_cd(String store_cd) {
        this.store_cd = store_cd;
    }

    public String getSextion() {
        return sextion;
    }

    public void setSextion(String sextion) {
        this.sextion = sextion;
    }

    
}
