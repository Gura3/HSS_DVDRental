/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RentalDb {
    @PersistenceContext
    private EntityManager em;
    public List<Lend_item> getAll(){
        return em.createQuery("SELECT * FROM lend_item").getResultList();
    }
}
