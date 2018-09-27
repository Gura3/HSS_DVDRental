package Manager;

import Bean.Dvd;
import Bean.Sextion;
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
//        query.setFirstResult(0);    //取り出し位置(0が初期値)
//        query.setMaxResults(5);     //最大取り出し件数
        return query.getResultList();
    }
    
    public  List<DvdInfo> getDvdInfoDb(){
        String sql;
//        sql = "SELECT d.DVD_CODE,d.TITLE,d.GENRE1,d.GENRE2,sex.SEXTION " +
//                "FROM DVD d,LEND_ITEM li,SEXTION sex " +
//                "WHERE d.DVD_CODE = li.DVD_CODE " +
//                "AND d.DVD_CODE = sex.DVD_CODE";
        sql = "SELECT d.DVD_CODE,d.TITLE,d.GENRE1,d.GENRE2,sex.SEXTION" +
"FROM DVD d,SEXTION sex" +
"WHERE d.DVD_CODE = sex.DVD_CODE";
        TypedQuery q = em.createQuery(sql,DvdInfo.class);
        q.setFirstResult(0);
        q.setMaxResults(10);
        return q.getResultList();
    }
    
    public Dvd getDvdData(String dvd_code) {
        System.out.println("getDvdData");
        Dvd d = null;
        TypedQuery query = null;
        System.out.println(1);
        query = em.createNamedQuery(Dvd.Comeon, Dvd.class);
        System.out.println(2);
        query.setParameter(1,dvd_code);
        System.out.println(3);
        d = (Dvd)query.getSingleResult();
        System.out.println(4);
        return d;
    }
    
    public Sextion getSextiondvd(String dvd_code,String store_cd) {
        System.out.println("getSextiondvd");
        Sextion d = null;
        TypedQuery query = null;
        System.out.println(1);
        query = em.createNamedQuery(Sextion.Sextionserch, Sextion.class);
        System.out.println(2);
        query.setParameter(1,dvd_code);
        query.setParameter(2,store_cd);
        System.out.println(3);
        System.out.println("dvd_code"+dvd_code);
        System.out.println("store_cd"+store_cd);
        d = (Sextion)query.getSingleResult();
        System.out.println(4);
        return d;
    }
}