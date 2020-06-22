package org.airline.model.repository;


import org.airline.model.common.JDBC;
import org.airline.model.entity.Aircraft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AircraftDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public AircraftDA() throws Exception
    {
        connection = JDBC.getConnection();
    }

    public void insert(Aircraft aircraft) throws SQLException
    {
        preparedStatement = connection.prepareStatement("insert into aircraft (id,company,vendor,model,certificate,flightTime,flightCount,flightMaxTime,flightMaxCount) values (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1,aircraft.getId());
        preparedStatement.setString(2,aircraft.getCompany());
        preparedStatement.setString(3,aircraft.getVendor());
        preparedStatement.setString(4,aircraft.getModel());
        preparedStatement.setInt(5,aircraft.getCertificate());
        preparedStatement.setInt(6,aircraft.getFlightTime());
        preparedStatement.setInt(7,aircraft.getFlightCount());
        preparedStatement.setInt(8,aircraft.getFlightMaxTime());
        preparedStatement.setInt(9,aircraft.getFlightMaxCount());
        preparedStatement.executeUpdate();
    }

    public void update(Aircraft aircraft) throws SQLException
    {
        preparedStatement = connection.prepareStatement("UPDATE aircraft SET company = ?, vendor = ?, model = ?, certificate = ?, flightTime = ?, flightCount = ?, flightMaxTime = ?, flightMaxCount WHERE id = ?");
        preparedStatement.setString(1,aircraft.getCompany());
        preparedStatement.setString(2,aircraft.getVendor());
        preparedStatement.setString(3,aircraft.getModel());
        preparedStatement.setInt(4,aircraft.getCertificate());
        preparedStatement.setInt(5,aircraft.getFlightTime());
        preparedStatement.setInt(6,aircraft.getFlightCount());
        preparedStatement.setInt(7,aircraft.getFlightMaxTime());
        preparedStatement.setInt(8,aircraft.getFlightMaxCount());
        preparedStatement.setInt(9,aircraft.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Aircraft aircraft) throws SQLException
    {
        preparedStatement = connection.prepareStatement("DELETE FROM aircraft WHERE id = ?");
        preparedStatement.setLong(1, aircraft.getId());
    }

    public List<Aircraft> selectAll() throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM aircraft");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Aircraft> personList = new ArrayList<>();
        while (resultSet.next())
        {
            personList.add(
                    new Aircraft()
                    .setId(resultSet.getInt("id"))
                    .setCompany(resultSet.getString("company"))
                    .setVendor(resultSet.getString("vendor"))
                    .setModel(resultSet.getString("model"))
                    .setCertificate(resultSet.getInt("certificate"))
                    .setFlightTime(resultSet.getInt("flightTime"))
                    .setFlightCount(resultSet.getInt("flightCount"))
                    .setFlightMaxTime(resultSet.getInt("flightMaxTime"))
                    .setFlightMaxCount(resultSet.getInt("flightMaxCount"))
            );
        }
        return personList;
    }

    public Aircraft selectOne(Aircraft certificate) throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM aircraft WHERE id = ?");
        preparedStatement.setLong(1, certificate.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Aircraft()
                    .setId(resultSet.getInt("id"))
                    .setCompany(resultSet.getString("company"))
                    .setVendor(resultSet.getString("vendor"))
                    .setModel(resultSet.getString("model"))
                    .setCertificate(resultSet.getInt("certificate"))
                    .setFlightTime(resultSet.getInt("flightTime"))
                    .setFlightCount(resultSet.getInt("flightCount"))
                    .setFlightMaxTime(resultSet.getInt("flightMaxTime"))
                    .setFlightMaxCount(resultSet.getInt("flightMaxCount"))
                ;

    }

    public Aircraft selectOneById(Integer id) throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM aircraft WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Aircraft()
                    .setId(resultSet.getInt("id"))
                    .setCompany(resultSet.getString("company"))
                    .setVendor(resultSet.getString("vendor"))
                    .setModel(resultSet.getString("model"))
                    .setCertificate(resultSet.getInt("certificate"))
                    .setFlightTime(resultSet.getInt("flightTime"))
                    .setFlightCount(resultSet.getInt("flightCount"))
                    .setFlightMaxTime(resultSet.getInt("flightMaxTime"))
                    .setFlightMaxCount(resultSet.getInt("flightMaxCount"))
                ;

    }

    @Override
    public void close() throws Exception {

    }
}
