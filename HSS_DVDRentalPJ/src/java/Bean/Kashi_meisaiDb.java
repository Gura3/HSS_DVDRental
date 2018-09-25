package Bean;

import javax.ejb.Stateless;


@Stateless
public class Kashi_meisaiDb extends TryCatchDb {
    public Kashi_meisaiDb(){
        super(Kashi_meisai.class);

    }
}
