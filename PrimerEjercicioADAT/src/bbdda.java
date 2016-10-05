import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;

public class bbdda {
	private Connection conexion;

	public bbdda() {
		try {
			HashMap<String, String> hmret = loadFichero("fichero.ini");
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(hmret.get("url"),
					hmret.get("login"), hmret.get("pwd"));
			System.out.println("Todo ok");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no cargado");
		} catch (SQLException e) {
			System.out.println("Error de conexion con Sql");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HashMap<String, String> loadFichero(String nomFichero)
			throws IOException {
		HashMap<String, String> hmDatos = new HashMap<String, String>();
		FileReader fr = new FileReader(nomFichero);
		BufferedReader bf = new BufferedReader(fr);
		String lineaLeida = bf.readLine();
		while (lineaLeida != null) {
			String sar[] = lineaLeida.split("=");
			hmDatos.put(sar[0], sar[1]);
			lineaLeida = bf.readLine();
		}
		bf.close();
		fr.close();
		return hmDatos;
	}
	
	
	public ArrayList leerBbdda() {
		ArrayList<String>nombres=new ArrayList<String>();
		try {
			if (conexion != null) {
				String query = "SELECT Nombre From personajes.person  ;";
				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();
				while (rset.next()) {
                 
				    String nombre = rset.getString("Nombre");
					System.out.println(nombre);
					
					nombres.add(nombre);
				}
				
				pstmt.close();
				rset.close();
			} else {
				System.out.println("conexion Nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombres;
	}
	
	
	public void EscribirBbdda(String Nombre) {
		try {
			if (conexion != null) {
				String query = " INSERT INTO `personajes`.`person` (`Nombre`) VALUES (?)";
				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();
				pstmt.setString(1, Nombre);
				pstmt.close();
				System.out.println("Insercion Nombre Correcta");
				
			} else {
				System.out.println("conexion Nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
