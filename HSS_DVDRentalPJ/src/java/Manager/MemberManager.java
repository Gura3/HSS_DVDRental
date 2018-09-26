/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Menber;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author s20163002
 */
@Stateless
public class MemberManager {
    @PersistenceContext
    EntityManager em;
    
    public Menber getMemB(String memberno){
        System.out.println("getMemB");
        Menber m = null;
        System.out.println(1);
        return m;
    }
    
    public Menber getTheMem(String mem_no){
        System.out.println("getTheMem");
        Menber m = null;
        System.out.println(1);
        System.out.println(mem_no);
        TypedQuery query = em.createNamedQuery(Menber.Comemembers, Menber.class);
        System.out.println(2);
        query.setParameter(1,Integer.parseInt(mem_no));
        System.out.println(3);
        m = (Menber)query.getSingleResult();
        System.out.println(4);
        
        return m;
    }
}
