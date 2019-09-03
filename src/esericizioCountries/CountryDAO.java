package esericizioCountries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class CountryDAO { // DAO sta per Data access Object

	private Connection conn;

	public CountryDAO(DataSource ds) {
		try {
			this.conn = ds.getConnection();
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}

	public List<CountryBean> getCountriesByRegion(String regionId) {
		List<CountryBean> results = new ArrayList<>();

		try {
			Long regionIdL = Long.parseLong(regionId);
			PreparedStatement countriesQuery = null;
			String s = "SELECT country_id, country_name FROM countries NATURAL JOIN regions WHERE region_id= ? ORDER BY country_name";
			countriesQuery = conn.prepareStatement(s);
			countriesQuery.setLong(1, regionIdL);
			ResultSet rs = countriesQuery.executeQuery();

			while (rs.next()) {
				results.add(new CountryBean(rs.getString("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
			}
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}

		return results;
	}
}
