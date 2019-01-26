package py.com.hercules.common;

import java.sql.Date;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BaseServiceImpl {

    public BaseServiceImpl()  {
    }

    public String getHashPassword(String pass) {

        pass = BCrypt.hashpw(pass, BCrypt.gensalt(11));

        return pass;

    }
    
    public Boolean checkHashPassword(String pass, String pass2) throws Exception {
        BCryptPasswordEncoder cryp = new BCryptPasswordEncoder();
        
        if (cryp.matches(pass2,pass)) {
            return  true;
        } else {
            return  false;
        
        }
    }

}
