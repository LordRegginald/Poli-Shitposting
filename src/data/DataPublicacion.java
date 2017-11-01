package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Publicacion;


public class DataPublicacion {
	public ArrayList<Publicacion> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Publicacion> pubs= new ArrayList<Publicacion>();
		try{
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from publicaciones");
			if(rs!=null){
				while(rs.next()){
					Publicacion p=new Publicacion();
					p.setId_publicacion(rs.getInt("id_publicacion"));
					p.setTitulo(rs.getString("titulo"));
					p.setFecha_hora_publicacion(rs.getDate("fecha_hora_publicacion"));
					p.setArchivo_swf(rs.getString("archivo_swf"));
					p.setUbicacion_swf(rs.getString("ubicacion_swf"));
					pubs.add(p);
				}
			}
		} catch (Exception e){
			throw e;
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pubs;
	}
}
