/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Gura3
 */
@Named
@ApplicationScoped

/* 貸出会員スキャンバッキングビーン */
public class TotalBb {
    private int deposit;            //預かり金

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }
    
    public void setDeposit(String deposit) {
        this.deposit = Integer.parseInt(deposit);
    }
    
    public String next(){
        setDeposit(0);
        return "totalpage";
    }
    
    public String complete(){
        return "complete";
    }
    

}
