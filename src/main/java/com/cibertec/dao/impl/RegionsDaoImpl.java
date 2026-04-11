package com.cibertec.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cibertec.conexion.ConexionSQLServer;
import com.cibertec.dao.IRegionsDao;
import com.cibertec.entidad.Regions;
import com.cibertec.utils.ConstantesProc;

public class RegionsDaoImpl implements IRegionsDao {

	private static final Logger LOG = LogManager.getLogger(RegionsDaoImpl.class);

	@Override
	public int guardar(Regions objRegion) {
		int procesar = -1;
		try (Connection con = ConexionSQLServer.conexion();
				CallableStatement cst = con.prepareCall(ConstantesProc.USP_REGIONS_INSERTAR);) {
			cst.setString(1, objRegion.getRegionName());
			procesar = cst.executeUpdate();

		} catch (SQLException ex) {
			LOG.error("guardar()-Error : " + ex.getMessage());
		}
		return procesar;
	}

	@Override
	public int actualizar(Regions objRegion) {
		int procesar = -1;
		try (Connection con = ConexionSQLServer.conexion();
				CallableStatement cst = con.prepareCall(ConstantesProc.USP_REGIONS_ACTUALIZAR);) {
			cst.setInt(1, objRegion.getRegionId());
			cst.setString(2, objRegion.getRegionName());
			cst.setObject(3, objRegion.getEstado(), java.sql.Types.BOOLEAN);
			procesar = cst.executeUpdate();
		} catch (SQLException ex) {
			LOG.error("actualizar()-Error : " + ex.getMessage());
		}
		return procesar;
	}

	@Override
	public int eliminar(int codigo) {
		int procesar = -1;
		try (Connection con = ConexionSQLServer.conexion();
				CallableStatement cst = con.prepareCall(ConstantesProc.USP_REGIONS_ELIMINAR);) {
			cst.setInt(1, codigo);
			procesar = cst.executeUpdate();
		} catch (SQLException ex) {
			LOG.error("eliminar()-Error : " + ex.getMessage());
		}
		return procesar;
	}

	@Override
	public List<Regions> consultar() {
		List<Regions> lista = new ArrayList<Regions>();
		try (Connection con = ConexionSQLServer.conexion();
				CallableStatement cst = con.prepareCall(ConstantesProc.USP_REGIONS_CONSULTAR);
				ResultSet rs = cst.executeQuery();) {
			Regions objRegion;
			while(rs.next()) {
				objRegion = new Regions();
				objRegion.setRegionId(rs.getInt("region_id"));
				objRegion.setRegionName(rs.getString("region_name"));
				objRegion.setEstado(rs.getObject("estado", Boolean.class));
				objRegion.setFechaRegistro(rs.getObject("fecha_registro", LocalDateTime.class));
				objRegion.setFechaActualizacion(rs.getObject("fecha_actualizacion", LocalDateTime.class));
				lista.add(objRegion);
			}
		} catch (SQLException ex) {
			LOG.error("eliminar()-Error : " + ex.getMessage());
		}
		return lista;
	}

	@Override
	public Regions consultarPorId(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
