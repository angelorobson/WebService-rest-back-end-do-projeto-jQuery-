package br.com.gerenciamentovacina.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {


	public static Connection getConnection() {
		Connection con=null;

		try {
			
			Class.forName("org.postgresql.Driver"); 
			con = DriverManager.getConnection("jdbc:postgresql://localhost/webservicejquery", "postgres", "admin");
//			System.out.println("Conectado com Sucesso!");
		} catch (SQLException e) {

			System.out.println("Não pode conectar: " + e.getMessage());

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
