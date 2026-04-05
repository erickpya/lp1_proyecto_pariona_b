package com.cibertec.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cibertec.utils.ConstantesQuery;

public class ConexionSQLServer {
	private static final Logger LOG = LogManager.getLogger(ConexionSQLServer.class);

	public static Connection conexion() {
		LOG.info("Iniciando conexion......");
		String usuarioBD = "sa";
		String passwordBD = "sql";
		String urlConexion = "jdbc:sqlserver://localhost:1433;databaseName=BD_HR_LP1_B;encrypt=false";
		Connection con = null;
		try {
			con = DriverManager.getConnection(urlConexion, usuarioBD, passwordBD);
		} catch (SQLException ex) {
			LOG.error("conexion()-Error : " + ex.getMessage());
		}
		return con;
	} // fin del metodo conexion()
}
