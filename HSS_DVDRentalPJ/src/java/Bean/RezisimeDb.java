package Bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    public void insert(Rezisime rezisime) {
        System.out.println(rezisime.getRegi_tig_day());
        System.out.println(rezisime.getStore_cd());
        System.out.println(rezisime.getRegi_code());
        System.out.println(rezisime.getTotal_fee());
        System.out.println(rezisime.getDiscount());
        System.out.println(rezisime.getManyen());
        System.out.println(rezisime.getGosenyen());
        System.out.println(rezisime.getNisenyen());
        System.out.println(rezisime.getSenyen());
        System.out.println(rezisime.getGohyakuyen());
        System.out.println(rezisime.getHyakuyen());
        System.out.println(rezisime.getGojuyen());
        System.out.println(rezisime.getJuyen());
        System.out.println(rezisime.getGoyen());
        System.out.println(rezisime.getIchiyen());
        System.out.println(rezisime.getTotal_sales());
        System.out.println(rezisime.getDifference());
        System.out.println("2");
        em.createQuery("INSERT INTO regi_tighten(regi_tig_day,store_cd,regi_code,total_fee,discount,manyen,gosenyen,nisenyen,senyen,gohyakuyen,hyakuyen,gojuyen,juyen,goyen,ichiyen,total_sales,difference) VALUES ('"+rezisime.getRegi_tig_day()+"','"+rezisime.getStore_cd()+"','"+rezisime.getRegi_code()+"','"+rezisime.getTotal_fee()+"','"+rezisime.getDiscount()+"','"+rezisime.getManyen()+"','"+rezisime.getGosenyen()+"','"+rezisime.getNisenyen()+"','"+rezisime.getSenyen()+"','"+rezisime.getGohyakuyen()+"','"+rezisime.getHyakuyen()+"','"+rezisime.getGojuyen()+"','"+rezisime.getJuyen()+"','"+rezisime.getGoyen()+"','"+rezisime.getIchiyen()+"','"+rezisime.getTotal_sales()+"','"+rezisime.getDifference()+"')").getResultList();
        System.out.println("3");
    }
    
    
}
