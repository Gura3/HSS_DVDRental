/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Member_card;
import Bean.Menber;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author s20163002
 */
public class MemberManager {
    @PersistenceContext
    EntityManager em;
    
    public Menber getMemBercode(String memberno){
        Menber m = null;
        return m;
    }
    
    public Menber getTheMem(String mem_no){
        Menber m = null;
        System.out.println(1);
        TypedQuery query = em.createNamedQuery(Menber.Comemem, Menber.class);
        System.out.println(2);
        query.setParameter(1,mem_no);
        System.out.println(3);
        m = (Menber)query.getSingleResult();
        System.out.println(4);
        
        return m;
    }
}
