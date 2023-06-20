package info3.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DAO {

	private static DAO instance;

	private static final String HOST = "sea-of-crabes-db-do-user-12793941-0.b.db.ondigitalocean.com";
	private static final String USERNAME = "doadmin";
	private static final String PASSWORD = "AVNS_Tt0S0KQowpxwevfrqPG";
	private static final String DBNAME = "defaultdb";
	private static final int PORT = 25060;

	private Connection connection;
	private Statement statement;
	private ResultSet result;
	private PreparedStatement prepare;

	public DAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + Integer.toString(PORT) + "/" + DBNAME,
				USERNAME, PASSWORD);
	}

	public static DAO getInstance() {
		if (instance == null) {
			try {
				instance = new DAO();
			} catch (ClassNotFoundException | SQLException e) {
				return null;
			}
		}
		return instance;
	}

	public void disconnect() throws SQLException {
		this.connection.close();
	}

	public boolean isConnected() throws SQLException {
		return connection != null && connection.isValid(1000);
	}

	public boolean addUser(String username) {
		if (isUsernameExists(username)) {
			return false;
		} else {
			try {
				prepare = connection.prepareStatement("insert into " + DBNAME + ".user (username) values(?)");
				prepare.setString(1, username);
				prepare.execute();
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
	}

	public boolean isUsernameExists(String username) {
		try {
			prepare = connection.prepareStatement("select username from " + DBNAME + ".user where username=?");
			prepare.setString(1, username);
			result = prepare.executeQuery();
			return result.next();
		} catch (SQLException e) {
			return false;
		}
	}

}
