package com.cibertec.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionSQLServer {
	public static void main(String[] args) {
		conexion();
		
		String codigo = JOptionPane.showInputDialog("Ingrese codigo");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad: "));
		
		
		
	} // fin del metodo main()
	public static Connection conexion() {
		System.out.println("Iniciando conexion......");
		String usuarioBD = "sa";
		String passwordBD = "sql";
		String urlConexion = "jdbc:sqlserver://localhost:1433;databaseName=BD_HR_LP1_B;encrypt=false";
		Connection con = null;
		try {
			con = DriverManager.getConnection(urlConexion, usuarioBD, passwordBD);
		} catch (SQLException ex) {
			System.out.println("Error al conectar: " + ex.getMessage());
			ex.printStackTrace();
		}
		return con;
	} // fin del metodo conexion()

	public static void insertar() {

	}// fin del metodo insertar()

	public static void eliminar() {

	}// fin del metodo eliminar()

	public static void actualizar() {

	}// fin del metodo actualizar()

	public static void consultarTodo() {

	}// fin del metodo main()

	public static void consultarXId() {

	}// fin del metodo consultarXId()

}
