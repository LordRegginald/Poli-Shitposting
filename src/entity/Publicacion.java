package entity;

import java.io.Serializable;
import java.util.Date;

public class Publicacion {
	private int id_publicacion;
	private Usuario usuario;
	private String titulo;
	private Date fecha_hora_publicacion;
	private String archivo_swf;
	private String ubicacion_swf;

	public int getId_publicacion() {
		return id_publicacion;
	}
	
	public void setId_publicacion(int Id_publicacion) {
		this.id_publicacion = id_publicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
		
	public Date getFecha_hora_publicacion() {
		return fecha_hora_publicacion;
	}
	
	public void setFecha_hora_publicacion(Date fecha_hora_publicacion) {
		this.fecha_hora_publicacion = fecha_hora_publicacion;
	}
	
	public String getArchivo_swf() {
		return archivo_swf;
	}
	
	public void setArchivo_swf(String archivo_swf) {
		this.archivo_swf = archivo_swf;
	}
		
	public String getUbicacion_swf() {
		return ubicacion_swf;
	}
	
	public void setUbicacion_swf(String ubicacion_swf) {
		this.ubicacion_swf = ubicacion_swf;
	}
	
	public Publicacion(String titulo, Usuario usuario, Date fecha_hora_publicacion, String archivo_swf, String ubicacion_swf) {
		this.setTitulo(titulo);
		this.setUsuario(usuario);
		this.setFecha_hora_publicacion(fecha_hora_publicacion);
		this.setArchivo_swf(archivo_swf);
		this.setUbicacion_swf(ubicacion_swf);
	}
	
	public Publicacion(){}
	
	@Override
	public boolean equals(Object p){
		return (p instanceof Publicacion) &&
			 (((Publicacion)p).getId_publicacion()==(this.getId_publicacion()));
	}
}