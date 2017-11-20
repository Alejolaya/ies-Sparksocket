

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnect {
	private String db_driver;
	private String db_url;
	private String db_user;
	private String db_password;
	private String max_pool;

	private Connection connection;
	private Properties properties;

	public void initDataDB(Globals globals) {
		setDb_driver("org.mariadb.jdbc.Driver");
		setDb_url("jdbc:mariadb://" + globals.getDb_ip() + ":" + String.valueOf(globals.getDb_port()) + "/" + globals.getDb_name());
		setDb_user(globals.getDb_user());
		setDb_password(globals.getDb_password());
		setMax_pool("250");
	}

	private Properties getProperties() {
		if(properties == null) {
			properties = new Properties();
			properties.setProperty("user", getDb_user());
			properties.setProperty("password", getDb_password());
			properties.setProperty("MaxPooledStatements", getMax_pool());
		}
		return properties;
	}

	public Connection connect() {
		if(connection == null) {
			try {
				Class.forName(getDb_driver());
				connection = DriverManager.getConnection(getDb_url(), getProperties());
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public void disconnect() {
		if(connection != null) {
			try {
				connection.close();
				connection = null;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ResultSet execQuery(String query) {
		Connection conn;
		ResultSet rs = null;
		Statement stmt;

		conn = this.connect(); // Abrir conexión

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query); // Ejecutar consulta
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect(); // Cerrar conexión
		}

		return rs;
	}

	public String getDb_driver() {
		return db_driver;
	}

	public void setDb_driver(String db_driver) {
		this.db_driver = db_driver;
	}

	public String getDb_url() {
		return db_url;
	}

	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}

	public String getDb_user() {
		return db_user;
	}

	public void setDb_user(String db_user) {
		this.db_user = db_user;
	}

	public String getDb_password() {
		return db_password;
	}

	public void setDb_password(String db_password) {
		this.db_password = db_password;
	}

	public String getMax_pool() {
		return max_pool;
	}

	public void setMax_pool(String max_pool) {
		this.max_pool = max_pool;
	}
}