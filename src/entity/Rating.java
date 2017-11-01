package entity;

import java.io.Serializable;

public class Rating {
	private int id_rating;
	private Publicacion publicacion;
	private Usuario usuario;
	private int voto;

	public int getId_rating() {
		return id_rating;
	}
	
	public void setId_rating(int id_rating) {
		this.id_rating = id_rating;
	}
	
	public Publicacion getPublicacion() {
		return publicacion;
	}
	
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public int getVoto() {
		return voto;
	}
	
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	public Rating(Publicacion publicacion, Usuario usuario, int voto){
		this.setPublicacion(publicacion);
		this.setUsuario(usuario);
		this.setVoto(voto);
	}
	
	@Override
	public boolean equals(Object r){
		return (r instanceof Rating) &&
			 (((Rating)r).getId_rating()==(this.getId_rating()));
	}
}