/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 *
 * @author s20163031
 */
@Entity
public class Member implements Serializable{
    @Id @NotNull
    private Integer memberNo;
    private String birthDay;
    private String name;
    private String kana;
    private String sex;
    private String addressNo;
    private String address;
    private String tell;
    private String mail;
    private boolean mailFlg;
    private String profession;
    private String lastComeDay;
    private String delayMonney;
    private String rentals;
    private boolean delFlg;
    
    public Member(){}
}
