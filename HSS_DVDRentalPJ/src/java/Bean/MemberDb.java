package Bean;

import javax.ejb.Stateless;


@Stateless
public class MemberDb extends TryCatchDb {
    public MemberDb(){
        super(Menber.class);

    }
}
