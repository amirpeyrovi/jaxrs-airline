package org.airline.model.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    private static BasicDataSource basicDataSource = new BasicDataSource();
    static
    {
        basicDataSource.setUsername("amir");
        basicDataSource.setPassword("amirp130");
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        basicDataSource.setMaxTotal(20);
        basicDataSource.setMaxIdle(5);
    }

    public static Connection getConnection()throws Exception
    {
        return basicDataSource.getConnection();
    }

}
