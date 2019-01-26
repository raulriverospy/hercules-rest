package py.com.hercules.seguridad.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Table;

@Table(name = "persona", schema = "ps_families")
public class PersonaEntity {
    
        private Long id;
        private LocalDateTime fechalog;
        private String nombres;
        private String apellidos;
        private TipoDocumentoEntity tipodoc;
        private String nrodoc;
        private String correo;
        private String telefonos;
        private String direccion;
        private String ubicacionGeografica;
        private String genero;
        private LocalDate fechaNacimiento;
        
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public LocalDateTime getFechalog() {
            return fechalog;
        }
        public void setFechalog(LocalDateTime fechalog) {
            this.fechalog = fechalog;
        }
        public String getNombres() {
            return nombres;
        }
        public void setNombres(String nombres) {
            this.nombres = nombres;
        }
        public String getApellidos() {
            return apellidos;
        }
        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }
        public TipoDocumentoEntity getTipodoc() {
            return tipodoc;
        }
        public void setTipodoc(TipoDocumentoEntity tipodoc) {
            this.tipodoc = tipodoc;
        }
        public String getNrodoc() {
            return nrodoc;
        }
        public void setNrodoc(String nrodoc) {
            this.nrodoc = nrodoc;
        }
        public String getCorreo() {
            return correo;
        }
        public void setCorreo(String correo) {
            this.correo = correo;
        }
        public String getTelefonos() {
            return telefonos;
        }
        public void setTelefonos(String telefonos) {
            this.telefonos = telefonos;
        }
        public String getDireccion() {
            return direccion;
        }
        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
        public String getUbicacionGeografica() {
            return ubicacionGeografica;
        }
        public void setUbicacionGeografica(String ubicacionGeografica) {
            this.ubicacionGeografica = ubicacionGeografica;
        }
        public String getGenero() {
            return genero;
        }
        public void setGenero(String genero) {
            this.genero = genero;
        }
        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }
        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

}
