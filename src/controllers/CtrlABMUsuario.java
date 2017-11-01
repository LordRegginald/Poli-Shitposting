package controllers;

import java.util.ArrayList;

import data.DataUsuario;
import data.DataRating;
import data.DataPublicacion;
import entity.Usuario;
import entity.Rating;
import entity.Publicacion;

public class CtrlABMUsuario {

	private DataUsuario dataUsu;
	private DataRating dataRat;
	private DataPublicacion dataPub;
	
	
	public CtrlABMUsuario(){
		dataUsu = new DataUsuario();
		dataRat = new DataRating();
		dataPub = new DataPublicacion();
	}
	
	public void add(Usuario u) throws Exception{
		dataUsu.add(u);
	}
	
	public void delete(Usuario u)throws Exception{
		dataUsu.remove(u);
	}
	
	public void update(Usuario u)throws Exception{
		dataUsu.update(u);
	}
	
	public Usuario getByEmail(Usuario u) throws Exception{
		return this.dataUsu.getByEmail(u);
		
	}

	public ArrayList<Usuario> getAll()throws Exception{
		return dataUsu.getAll();
	}
	
	public String usuarioListText() throws Exception {
		String texto="Nombre de usuario\tEmail\tClave\tRol\tEstado\n";
		ArrayList<Usuario> usuarios =this.getAll();
		for (Usuario u : usuarios){
			texto= texto + u.getNombre_de_usuario() +"\t"+u.getEmail()+"\t"+u.getClave()+"\t"+
					u.getRol()+"\t"+u.getEstado()+"\n";
		}
		return texto;
	}
	
	public ArrayList<Rating> getRating() throws Exception{
		return dataRat.getAll();
	}
	
	public ArrayList<Publicacion> getPublicacion() throws Exception{
		return dataPub.getAll();
	}
	
	public Usuario login(Usuario per) throws Exception{
		return dataUsu.getLogedUser(per);
	}
}
