package com.open4job.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BaseDatosDirecta {

	public BaseDatosDirecta() {}

	public DataSource abrirConexion() throws Exception {

		//Connection conexion = getDataSource().getConnection();
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		//Connection conn = ds.getConnection();

		return ds;
	}
}
