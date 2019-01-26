package py.com.hercules.seguridad.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.hercules.common.Constantes;
import py.com.hercules.exceptions.UnauthorizedException;
import py.com.hercules.seguridad.services.ApiLogService;

@Service
public class ApiLogServiceImpl implements ApiLogService {

    @Autowired
    DataSource datasource;

    @Override
    public Integer getCantAttemptsApiByTime(String api, String param1,
            String param2) {
        // TODO Auto-generated method stub
        Integer ret = 0;
        try {
            Connection conn = datasource.getConnection();
            
            // traer por sql
            String sql = " select count(*) as cantidad from api_log ";
            sql += " where fechalog between now()- ("+Constantes.TIMEPO_INTENTOS_PERMITIDOS+" ||' hours')::interval and now() ";
            sql += " and api like ? ";
            if(!param1.equals(""))
            sql += " and param1 like  '" + param1.trim()+"'";
            if(!param2.equals(""))
                sql += " and param2 like  '" + param2.trim()+"'";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, api.trim());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ret = rs.getInt("cantidad");
            }

            ps.close();
            rs.close();
            conn.close();
            if(ret  >= Constantes.CANTIDAD_INTENTOS_PERMITIDOS)
                throw new UnauthorizedException("Exedió el máximo de intentos permitidos");
            
        } catch (Exception e) {
            // TODO: handle exception
            throw new UnauthorizedException("Exedió el máximo de intentos permitidos");
        }
        return ret;
    }
	
	

	
	
}
