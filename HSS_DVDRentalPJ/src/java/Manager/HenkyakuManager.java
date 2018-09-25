/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Kashi_meisai;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
/**
 *
 * @author s20163002
 */
@Stateless
public class HenkyakuManager {
    @PersistenceContext
    EntityManager em;
    
    public Kashi_meisai getKashiBercode(String dvd_barcode){
        Kashi_meisai k = null;
        System.out.println(1);
        TypedQuery query = em.createNamedQuery(Kashi_meisai.ComeKashi_meisai, Kashi_meisai.class);
        System.out.println(2);
        query.setParameter(1,dvd_barcode);
        System.out.println(3);
        k = (Kashi_meisai)query.getSingleResult();
        System.out.println(4);
        
        return k;
    }
    
    public Kashi_meisai getKaeshitenai(String lend_no){
        System.out.println("getKaeshitenai");
        Kashi_meisai k = null;
        System.out.println(1);
        TypedQuery query = em.createNamedQuery(Kashi_meisai.Kaeshitakana, Kashi_meisai.class);
        System.out.println(2);
        query.setParameter(1,lend_no);
        System.out.println(3);
        k = (Kashi_meisai)query.getSingleResult();
        System.out.println(4);
        
        return k;
    }
    

}
