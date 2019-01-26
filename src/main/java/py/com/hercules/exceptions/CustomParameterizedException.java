package py.com.hercules.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import py.com.hercules.common.dtos.FieldErrorDTO;

/**
 * Custom, parameterized exception, which can be translated on the client side.
 * For example:
 *
 * <pre>
 * throw new CustomParameterizedException(&quot;myCustomError&quot;, &quot;hello&quot;, &quot;world&quot;);
 * </pre>
 *
 * Can be translated with:
 *
 * <pre>
 * "error.myCustomError" :  "The server says {{param0}} to {{param1}}"
 * </pre>
 */
public class CustomParameterizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final String PARAM = "param";

    private final String message;

    private final Map<String, Collection<String>> paramMap = new HashMap<>();

    public CustomParameterizedException(String message, String... params) {
        super(message);
        this.message = message;
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                paramMap.put(PARAM + i,  Arrays.asList(params[i]));
            }
        }
    }

    public CustomParameterizedException(String message, Map<String, Collection<String>> paramMap) {
        super(message);
        this.message = message;
        this.paramMap.putAll(paramMap);
    }


    public List<FieldErrorDTO> getFieldErrors() {
        List<FieldErrorDTO> fields = new ArrayList<>();
        if (paramMap != null) {
            this.paramMap.entrySet()
                    .stream()
                    .forEach(entry -> fields.add(new FieldErrorDTO(null, entry.getKey(), entry.getValue())));
        }
        return fields;
    }
}
