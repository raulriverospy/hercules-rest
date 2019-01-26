package py.com.hercules.seguridad.services;

public interface ApiLogService {

    Integer getCantAttemptsApiByTime(String api, String param1, String param2 );
}
