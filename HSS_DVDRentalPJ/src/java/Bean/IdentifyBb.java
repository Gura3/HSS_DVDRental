package Bean;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class IdentifyBb {

    private String[] iden;
    private static Map<String, String> items;

    static {
        items = new LinkedHashMap<>();
        items.put("運転免許（未成年を除く）", "1");//各身分証区分略称
        items.put("保険証（健康保険）", "2");
        items.put("学生証（高校生を除く）", "3");
        items.put("保険証（後期高齢者医療）", "4");
        items.put("パスポート（未成年を除く）", "5");
        items.put("その他", "6");
    }

    public Map<String, String> getItems() {
        return items;
    }

    public String next() {
        return "identifyconfirm.xhtml";
    }

    @Override
    public String toString() {
        return "IdentifyBb{" + "iden=" + iden + '}';
    }

    public String[] getIden() {
        return iden;
    }

    public void setIden(String[] iden) {
        this.iden = iden;
    }

}
