package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Rating;


public class DataRating {
	public ArrayList<Rating> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Rating> rtng= new ArrayList<Rating>();
		try{
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from rating");
			if(rs!=null){
				while(rs.next()){
					Rating r=new Rating();
					r.setId_rating(rs.getInt("id_rating"));
					r.setVoto(rs.getInt("voto"));
					rtng.add(r);
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
		
		return rtng;
	}
}
