package Manager;

import Bean.Dvd;
import Bean.DvdInfo;
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
    
    public  List<DvdInfo> getDvdInfoDb(){
        String sql;
        sql = "SELECT d.DVD_CODE,d.TITLE,d.GENRE1,d.GENRE2,sex.SEXTION " +
                "FROM DVD d,LEND_ITEM li,SEXTION sex " +
                "WHERE d.DVD_CODE = li.DVD_CODE " +
                "AND d.DVD_CODE = sex.DVD_CODE";
        TypedQuery q = em.createQuery(sql,DvdInfo.class);
        q.setFirstResult(0);
        q.setMaxResults(10);
        return q.getResultList();
    }
}