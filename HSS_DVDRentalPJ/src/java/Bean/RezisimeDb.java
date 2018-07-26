package Bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class RezisimeDb extends TryCatchDb {
    public RezisimeDb(){
        super(Rezisime.class);
    }
    @PersistenceContext
    private EntityManager em;
    

    public void create(Rezisime rezisime) {
        em.persist(rezisime);
    }

    public void update(Rezisime rezisime) {
        em.merge(rezisime);
    }

    public void delete(Rezisime rezisime) {
        em.remove(em.merge(rezisime));  // mergしてから削除する
    }

    public Rezisime find(String key) {
        return em.find(Rezisime.class, key);
    }

    public List<Rezisime> getAll() {
        return em.createQuery("SELECT * FROM regi_tighten").getResultList();
    }
    
    
}
