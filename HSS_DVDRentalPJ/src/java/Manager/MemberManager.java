/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Member_card;
import java.lang.reflect.Member;
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
    
    public Member getMemBercode(String memberno){
        Member m = null;
        return m;
    }
}
