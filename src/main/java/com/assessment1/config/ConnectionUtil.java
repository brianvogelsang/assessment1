package com.assessment1.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

  private static String url = "jdbc:postgresql://mydbinstance1.ch83bku41eq5.us-east-2.rds.amazonaws.com:5432/brian_db";
  private static String username = "brian";
  private static String password = "password";

  public static Connection connect() throws SQLException {
    return DriverManager.getConnection(url, username, password);
  }
}
