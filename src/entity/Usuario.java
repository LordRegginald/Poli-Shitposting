package entity;

import java.io.Serializable;

public class Usuario implements Serializable {
	private int id_usuario;
	private String nombre_de_usuario;
	private String email;
	private String clave;
	private String rol;
	private String estado;

	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getNombre_de_usuario() {
		return nombre_de_usuario;
	}
	
	public void setNombre_de_usuario(String nombre_de_usuario) {
		this.nombre_de_usuario = nombre_de_usuario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Usuario (String nombre_de_usuario, String email, String clave, String rol, String estado) {
		this.setNombre_de_usuario(nombre_de_usuario);
		this.setEmail(email);
		this.setClave(clave);
		this.setRol(rol);
		this.setEstado(estado);
	}
	
	public Usuario(){}
	
	@Override
	public boolean equals(Object u){
		return (u instanceof Usuario) &&
			 (((Usuario)u).getId_usuario()==(this.getId_usuario()));
	
	}
}