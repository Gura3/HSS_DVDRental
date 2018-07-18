
package Bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped

public class EnrollmentBb {
      public String next(){
        return "/pages/enroll/enrollment_top.xhtml";
    }

      

    public String instore_next(){
        return "/pages/enroll/instore_enroll.xhtml";
    }

}

