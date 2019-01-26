package py.com.hercules.exceptions;

/**
 * Created by mcespedes on 26/01-2019
 */
public class ApiException extends Exception{

    private int code;

    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}