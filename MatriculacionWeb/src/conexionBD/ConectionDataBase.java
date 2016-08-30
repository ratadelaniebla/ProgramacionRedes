package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConectionDataBase {

	private static final String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
	private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private String usuario = null;
	private String password = null;
	
	private Connection conn = null;
        /**
         * ingresa los accesos a la base de datos user y pass
         * @param usuario: root
         * @param clave : ""
         */
	public ConectionDataBase(String usuario, String password){
		this.usuario = usuario;
		this.password = password;
	}

	/**
         * 
         * @param ipBaseDatos: localhost
         * @param puerto: 
         * @param baseDatos: proyecto_final
         */
	public void getConetionOracle(String ipBaseDatos, String puerto, String baseDatos) {
		try {
			
			Class.forName(DRIVER_ORACLE).newInstance();
			String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + ipBaseDatos + ":" + puerto + ":" + baseDatos;
			conn = DriverManager.getConnection(ulrjdbc);
			conn.setAutoCommit(true);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	/**
         * 
         * @param ipBaseDatos: localhost
         * @param puerto: 3306
         * @param baseDatos: proyecto_final 
         */
	public void getConetionMySql(String ipBaseDatos, String puerto, String baseDatos) {
		try {
			
			Class.forName(DRIVER_MYSQL).newInstance();
			String ulrjdbc = "jdbc:mysql://" + ipBaseDatos + ":" + puerto + "/" + baseDatos;
			conn = DriverManager.getConnection(ulrjdbc, usuario, password);
			conn.setAutoCommit(true);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
        /**
         * 
         * @param sql: sentencia
         * @param parameters: parametro de la sentencia
         * @throws SQLException 
         */
	public void executeDML(String sql, List<String> parameters)
			throws SQLException {

		PreparedStatement stmt = null;

		stmt = conn.prepareStatement(sql);

		for (int i = 0; i < parameters.size(); i++)
			stmt.setString(i + 1, parameters.get(i));

		stmt.execute();

		if (stmt != null)
			stmt.close();
	}
	
	public List<List<String>> executeSelect(String sql, List<String> parameters)
			throws SQLException {
		List<String> rsRow = null;
		List<List<String>> rsRows = new ArrayList<List<String>>();
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = null;

		for (int i = 0; i < parameters.size(); i++)
			stmt.setString(i + 1, parameters.get(i));

		rs = stmt.executeQuery();

		ResultSetMetaData metadata = rs.getMetaData();

		int numcols = metadata.getColumnCount();

		while (rs.next()) {
			rsRow = new ArrayList<String>();
			for (int i = 0; i < numcols; i++) {
				rsRow.add(rs.getString(i + 1));
			}
			rsRows.add(rsRow);
		}

		rs.close();
		stmt.close();

		return rsRows;
	}

	public void closeConection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(
						"Ocurrio un error al cerrar la conexi�n a la base de datos.",
						e);
			}
		}
	}
}
