package py.com.hercules.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Constantes {

    public static final String EMAIL_MF = "clubdeclientes@fundacionparaguaya.org.py";
    public static final String EMAIL_TI = "appfupa@fundacionparaguaya.org.py";
    public static final int BUTTONS_TO_SHOW = 5;
    public static final int INITIAL_PAGE = 0;
    public static final int INITIAL_PAGE_SIZE = 5;
    public static final int[] PAGE_SIZES = { 5, 10, 20 };
    
    public static final int TIMEPO_INTENTOS_PERMITIDOS = 24; //en horas
    public static final int CANTIDAD_INTENTOS_PERMITIDOS = 5;
    public static final String EMAIL_ADMIN = "sistema@fundacionparaguaya.org.py";

    public static final String getTemporalPass() {
        String password = "temporal";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

}
