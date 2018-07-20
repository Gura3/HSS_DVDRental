/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author s20163002
 */

@Named
@RequestScoped
public class indexBb {
    public String next(){
        return "/../../index.xhtml";
    }
}
