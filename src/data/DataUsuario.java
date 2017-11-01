package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.security.KeyStore.ProtectionParameter;
import java.sql.*;

import entity.*;

public class DataUsuario {
	
	public ArrayList<Usuario> getAll() throws Exception{
	
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Usuario> user= new ArrayList<Usuario>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from usuarios");
			if(rs!=null){
				while(rs.next()){
					Usuario u=new Usuario();
					u.setId_usuario(rs.getInt("id_usuario"));
					u.setNombre_de_usuario(rs.getString("nombre_de_usario"));
					u.setEmail(rs.getString("email"));
					u.setClave(rs.getString("clave"));
					u.setRol(rs.getString("rol"));
					u.setEstado(rs.getString("estado"));
					
					user.add(u);
				}
			}
		} catch (SQLException e) {
			AppDataException ade=new AppDataException(e, "Error al recuperar listado de Usuarios.\n"+e.getSQLState()+":"+e.getMessage(), Level.WARN);
			throw ade;
		} catch (AppDataException ade){
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	public void add(Usuario u) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into usuarios(nombre_de_usuario, email, clave, rol, estado) values (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, u.getNombre_de_usuario());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getClave());
			stmt.setString(4, u.getRol());
			stmt.setString(5, u.getEstado());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				u.setId_usuario(keyResultSet.getInt(1));
			}
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario getLogedUser(Usuario use) throws Exception{
		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select u.id_usuario, nombre_de_usuario, email, clave, rol, estado where nombre_de_usuario=? and clave=?");
			stmt.setString(1, use.getNombre_de_usuario());
			stmt.setString(2, use.getClave());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					Usuario u=new Usuario();
					u.setId_usuario(rs.getInt("id_usuario"));
					u.setNombre_de_usuario(rs.getString("nombre_de_usario"));
					u.setEmail(rs.getString("email"));
					u.setClave(rs.getString("clave"));
					u.setRol(rs.getString("rol"));
					u.setEstado(rs.getString("estado"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}

		return u;
	}

	public void remove(Usuario u) throws Exception{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
				.prepareStatement(
					"update usuarios set estado=? from usuarios where id_usuario=?"
				);
			stmt.setString(1, "Baneado");
			stmt.setInt(2, u.getId_usuario())
			stmt.executeUpdate();
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void update(Usuario u) throws Exception{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"update usuarios set nombre_de_usuario=?, email=?, clave=?, rol=?, estado=? where id_usuario=?"
					);
			stmt.setString(1, u.getNombre_de_usuario());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getClave());
			stmt.setString(4, u.getRol());
			stmt.setString(5, u.getEstado());
			stmt.setInt(6, u.getId_usuario());
			stmt.executeUpdate();
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Usuario getByEmail(Usuario use) throws Exception{
		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select u.id_usuario, nombre_de_usuario, email, clave, rol, estado where email=?");
			stmt.setString(1, use.getEmail());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				Usuario u=new Usuario();
				u.setId_usuario(rs.getInt("id_usuario"));
				u.setNombre_de_usuario(rs.getString("nombre_de_usario"));
				u.setEmail(rs.getString("email"));
				u.setClave(rs.getString("clave"));
				u.setRol(rs.getString("rol"));
				u.setEstado(rs.getString("estado"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}

		return u;
	}
}
