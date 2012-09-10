package net.bevster.lorenskog.info.sql;

import simplemysql.SimpleMySQL;
import simplemysql.SimpleMySQLResult;

public class Mysql {

	SimpleMySQL sql;

	public static final String SQL_DATABASE = "kdoyjwal_lorenskog";

	public static final String SQL_PASSWORD = "jeglikeris1";
	public static final String SQL_USERNAME = "kdoyjwal_seb";

	public Mysql() {
		// TODO Auto-generated constructor stub

		sql = new SimpleMySQL();

		sql.connect("server6.lithiumhosting.com", SQL_USERNAME, SQL_PASSWORD, SQL_DATABASE);

		SimpleMySQLResult result;

		result = sql.Query("SELECT * FROM Studenter");

		System.out.println(result.toString());

		result.close();
		sql.close();

	}

}
