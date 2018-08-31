package Bean;

import javax.ejb.Stateless;


@Stateless
public class HenkyakuDb extends TryCatchDb {
    public HenkyakuDb(){
        super(Member_card.class);

    }
}
