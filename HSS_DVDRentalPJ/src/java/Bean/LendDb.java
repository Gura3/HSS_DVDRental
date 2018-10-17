package Bean;

import javax.ejb.Stateless;


@Stateless
public class LendDb extends TryCatchDb {
    public LendDb(){
        super(Lend.class);

    }
}
