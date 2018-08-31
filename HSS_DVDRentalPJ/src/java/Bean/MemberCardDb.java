package Bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MemberCardDb extends TryCatchDb {
    public MemberCardDb(){
        super(Member_card.class);
    }
    @PersistenceContext
    private EntityManager em;
    

    public void create(Member_card membercard) {
        em.persist(membercard);
    }

    public void update(Member_card membercard) {
        em.merge(membercard);
    }

    public void delete(Member_card membercard) {
        em.remove(em.merge(membercard));  // mergしてから削除する
    }

    public Member_card find(String key) {
        return em.find(Member_card.class, key);
    }

    public List<Member_card> getAll() {
        return em.createQuery("SELECT * FROM member_card").getResultList();
    }
    
    public List<Member_card> comemember(String mem_barcode){
        TypedQuery<Member_card> query = null;
        query = em.createNamedQuery(Member_card.Comemem, Member_card.class);
        query.setParameter(1,mem_barcode);
        return query.getResultList();
    } 
    
}
