package db;

import java.sql.*;

public class DBConexion {
	private static final String URL = "jdbc:mysql://localhost:3306/sakila";
	private static final String USER = "root";
	private static final String PASS = "ikasle";

	public static Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			System.out.println("Errorea konexioan: " + e.getMessage());
			return null;
		}
	}

	public static void mostrarTabla() {
		String sql = "SELECT id, izena, abizena, emaila FROM langile";

		try (Connection con = conectar(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

			System.out.println("\nID   IZENA          ABIZENAK         EMAIL");
			System.out.println("--------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%-4d %-14s %-16s %-20s%n", rs.getInt("id"), rs.getString("izena"),
						rs.getString("abizena"), rs.getString("emaila"));
			}

		} catch (Exception e) {
			System.out.println("Errorea datuak erakustean: " + e.getMessage());
		}
	}
}
