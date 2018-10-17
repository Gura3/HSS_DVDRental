/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Lend;
import Bean.Lend_item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
/**
 *
 * @author s20163002
 */
@Stateless
public class KashiDvdManager {
    @PersistenceContext
    EntityManager em;
    
    public Lend_item getKashiDvdData(String dvd_barcode){
        System.out.println("getKashiDvdData");
        Lend_item d = null;
        System.out.println(1);
        TypedQuery query = em.createNamedQuery(Lend_item.Comedvd, Lend_item.class);
        System.out.println(2);
        query.setParameter(1,dvd_barcode);
        System.out.println(3);
        d = (Lend_item)query.getSingleResult();
        System.out.println(4);
        
        return d;
    }
    
    public Lend getKashiData(String lend_no){
        Lend l = null;
        System.out.println(1);
        TypedQuery query = em.createNamedQuery(Lend.Comelend, Lend.class);
        System.out.println(2);
        query.setParameter(1,lend_no);
        System.out.println(3);
        l = (Lend)query.getSingleResult();
        System.out.println(4);
        
        return l;
    }
    
    public List<Lend> getMemkashi(String member_no){
        System.out.println("getMemkashi");
        TypedQuery<Lend> query = null;
        System.out.println(1);
        query = em.createNamedQuery(Lend.Memlend, Lend.class);
        System.out.println(2);
        query.setParameter(1,member_no);
        System.out.println(3);
        
        return query.getResultList();
    }
    
   
}
