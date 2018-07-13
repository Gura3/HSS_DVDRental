/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author s20163002
 */
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class ProtectBb {

    public String next() {
        return "pages/dvd_information_change/protect.xhtml";
    }
}
