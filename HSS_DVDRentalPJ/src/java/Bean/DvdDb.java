/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.Stateless;

@Stateless
public class DvdDb extends TryCatchDb{
    public DvdDb(){
        super(Dvd.class);
    }
}
