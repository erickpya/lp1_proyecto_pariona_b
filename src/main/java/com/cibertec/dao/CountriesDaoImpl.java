package com.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cibertec.conexion.ConexionSQLServer;
import com.cibertec.entidad.Countries;
import com.cibertec.utils.ConstantesQuery;

public class CountriesDaoImpl implements ICountriesDao {
	private static final Logger LOG = LogManager.getLogger(CountriesDaoImpl.class);

	@Override
	public int guardar(Countries objCountries) {
		int procesar = -1;
		try (Connection con = ConexionSQLServer.conexion();
				PreparedStatement pst = con.prepareStatement(ConstantesQuery.QUERY_COUNTRIES_INSERTAR);) {
			pst.setString(1, objCountries.getCountryId());
			pst.setString(2, objCountries.getCountryName());
			pst.setInt(3, objCountries.getRegionId());
			procesar = pst.executeUpdate();
			LOG.info("Se inserto : " + procesar);
		} catch (Exception e) {
			LOG.error("guardar() - Error : " + e.getMessage());
		}
		return procesar;
	}

	@Override
	public int actualizar(Countries objCountries) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(String countryId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Countries> consultar() {
		List<Countries> listado = new ArrayList<Countries>();
		try (Connection con = ConexionSQLServer.conexion();
				PreparedStatement pst = con.prepareStatement(ConstantesQuery.QUERY_COUNTRIES_CONSULTAR_TODO);
				ResultSet rs = pst.executeQuery();) {
			Countries objCountries ;
			while(rs.next()) {
				objCountries = new Countries();
				objCountries.setCountryId(rs.getString("country_id"));
				objCountries.setCountryName(rs.getString("country_name"));
				objCountries.setRegionId(rs.getInt("region_id"));
				listado.add(objCountries);
			}
		} catch (SQLException ex) {
			LOG.error("consultar() - Error : " + ex.getMessage());
		}
		return listado;
	}

	@Override
	public Countries consultarPorId(String countryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
