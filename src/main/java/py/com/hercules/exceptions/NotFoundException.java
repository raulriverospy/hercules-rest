package py.com.hercules.exceptions;

/**
 * Created by mcespedes on 26/01/2019
 */
public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}