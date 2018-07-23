/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/* 会員カード再発行 */
@Named
@RequestScoped
public class ReissueCard {
    //会員カード再発行トップ
    public String reissue(){
        return "/pages/card_reissue/reissue_top.xhtml";
    }
    private String testNo = null;

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }
    
    
    //遷移
    public String scan(){
        //スキャンエラー
        return "reissue_scan_error";
    }
    
    public String comp(){
        //スキャンエラー
        return "reissue_comp";
    }
}
