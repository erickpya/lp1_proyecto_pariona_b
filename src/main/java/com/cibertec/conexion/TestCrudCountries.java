package com.cibertec.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.cibertec.utils.ConstantesQuery;

public class TestCrudCountries {
	
	public static void main(String[] args) {
		consultarTodo();
	} // fin del metodo main()

	public static int soloEntero(String mensaje) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}

	public static String soloCadena(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}

	public static void insertar() {
		System.out.println("Iniciando proceso de insercion");
		try (Connection con = ConexionSQLServer.conexion();
				PreparedStatement pst = con.prepareStatement(ConstantesQuery.QUERY_COUNTRIES_INSERTAR);) {
			pst.setString(1, soloCadena("Ingrese codigo de pais : "));
			pst.setString(2, soloCadena("Ingrese nombre de pais : "));
			pst.setInt(3, soloEntero("Ingrese codigo de region : "));
			int procesar = pst.executeUpdate();
			System.out.println("Proceso : " + procesar);
		} catch (SQLException ex) {
			System.out.println("insertar - Error : " + ex.getMessage());
		}
		System.out.println("Terminando proceso de insercion");
	}// fin del metodo insertar()

	public static void eliminar() {
		System.out.println("Iniciando proceso de eliminacion");
		try (Connection con = ConexionSQLServer.conexion();
				PreparedStatement pst = con.prepareStatement(ConstantesQuery.QUERY_COUNTRIES_ELIMINAR);) {
			pst.setString(1, soloCadena("Ingrese codigo de pais : "));
			int procesar = pst.executeUpdate();
			System.out.println("Proceso : " + procesar);
		} catch (SQLException ex) {
			System.out.println("insertar - Error : " + ex.getMessage());
		}
		System.out.println("Terminando proceso de eliminacion");
	}// fin del metodo eliminar()

	public static void actualizar() {

	}// fin del metodo actualizar()

	public static void consultarTodo() {
		try (Connection con = ConexionSQLServer.conexion();
				PreparedStatement pst = con.prepareStatement(ConstantesQuery.QUERY_COUNTRIES_CONSULTAR_TODO);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				System.out.println("country_id: " + rs.getString("country_id") + "|" + "country_name: "
						+ rs.getString("country_name") + "|" + "region_id: " + rs.getString("region_id"));
			}
		} catch (SQLException ex) {
			System.out.println("consultarTodo - Error : " + ex.getMessage());
		}
	}// fin del metodo main()

	public static void consultarXId() {
		try (Connection con = ConexionSQLServer.conexion();
				PreparedStatement pst = con.prepareStatement(ConstantesQuery.QUERY_COUNTRIES_CONSULTAR_X_ID);) {
			pst.setString(1, soloCadena("Ingrese el codigo a consultar : "));
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					System.out.println("country_id: " + rs.getString("country_id") + "|" + "country_name: "
							+ rs.getString("country_name") + "|" + "region_id: " + rs.getString("region_id"));
				}
			}
		} catch (SQLException ex) {
			System.out.println("consultarTodo - Error : " + ex.getMessage());
		}
	}// fin del metodo consultarXId()
}
