package Manager;

import Bean.Dvd;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DvdManager {

    @PersistenceContext
    EntityManager em;

    public List<Dvd> getFromDb() {
        TypedQuery<Dvd> query = null;
        query = em.createNamedQuery(Dvd.Qall, Dvd.class);
        query.setFirstResult(0);    //取り出し位置(0が初期値)
        query.setMaxResults(1);     //最大取り出し件数
        return query.getResultList();
    }

}
