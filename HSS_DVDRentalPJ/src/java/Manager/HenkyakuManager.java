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
    
    public Kashi_meisai getMemBercode(String dvd_barcode){
        Kashi_meisai k = null;
        TypedQuery query = em.createNamedQuery(Kashi_meisai.ComeKashi_meisai, Kashi_meisai.class);
        query.setParameter(1,dvd_barcode);
        k = (Kashi_meisai)query.getSingleResult();
        
        return k;
    }
}
