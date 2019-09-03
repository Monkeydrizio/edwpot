package esericizioCountries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class CountryDAO { // DAO sta per 

	private Connection conn;

	public CountryDAO(DataSource ds) {
		try {
			this.conn = ds.getConnection();
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}

	public List<CountryBean> getEU() {
		List<CountryBean> results = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT country_id, country_name FROM countries NATURAL JOIN regions WHERE region_id=1 ORDER BY country_name");

			while (rs.next()) {
				results.add(new CountryBean(rs.getLong("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
			}
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}

		return results;
	}

	public List<CountryBean> getAS() {
		List<CountryBean> results = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT country_id, country_name FROM countries NATURAL JOIN regions WHERE region_id=3 ORDER BY country_name");

			while (rs.next()) {
				results.add(new CountryBean(rs.getLong("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
			}
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}

		return results;
	}

	public List<CountryBean> getAMER() {
		List<CountryBean> results = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT country_id, country_name FROM countries NATURAL JOIN regions WHERE region_id=2 ORDER BY country_name");

			while (rs.next()) {
				results.add(new CountryBean(rs.getLong("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
			}
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}

		return results;
	}

	public List<CountryBean> getMEA() {
		List<CountryBean> results = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT country_id, country_name FROM countries NATURAL JOIN regions WHERE region_id= ORDER BY country_name");

			while (rs.next()) {
				results.add(new CountryBean(rs.getLong("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
			}
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}

		return results;
	}

}
