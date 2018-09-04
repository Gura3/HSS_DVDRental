package Bean;

import javax.ejb.Stateless;


@Stateless
public class KashiDvdDb extends TryCatchDb {
    public KashiDvdDb(){
        super(Lend_item.class);

    }
}
