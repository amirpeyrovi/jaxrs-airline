package org.airline.model.repository;

import org.airline.model.common.JDBC;
import org.airline.model.entity.Pilot;
import org.airline.model.entity.PilotAssistant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public PilotDA() throws Exception
    {
        connection = JDBC.getConnection();
    }

    public void insert(Pilot pilot) throws SQLException
    {
        preparedStatement = connection.prepareStatement("INSERT INTO person (id,firstName,lastName,age,salary,flightTime,flightCount,certificate,type) VALUES (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, pilot.getId());
        preparedStatement.setString(2, pilot.getFirstName());
        preparedStatement.setString(3, pilot.getLastName());
        preparedStatement.setInt(4, pilot.getAge());
        preparedStatement.setInt(5, pilot.getSalary());
        preparedStatement.setInt(6, pilot.getFlightTime());
        preparedStatement.setInt(7, pilot.getFlightCount());
        preparedStatement.setInt(8, pilot.getCertificate());
        preparedStatement.setInt(9, pilot.getType());
    }

    public void update(Pilot pilot) throws SQLException
    {
        preparedStatement = connection.prepareStatement("UPDATE person SET firstName = ?,lastName = ?,age = ?,salary = ?,flightTime = ?,flightCount = ?, certificate = ? WHERE id = ?");
        preparedStatement.setString(1, pilot.getFirstName());
        preparedStatement.setString(2, pilot.getLastName());
        preparedStatement.setInt(3, pilot.getAge());
        preparedStatement.setInt(4, pilot.getSalary());
        preparedStatement.setInt(5, pilot.getFlightTime());
        preparedStatement.setInt(6, pilot.getFlightCount());
        preparedStatement.setInt(7, pilot.getCertificate());
        preparedStatement.setInt(8, pilot.getId());
    }

    public void delete(Pilot pilot) throws SQLException
    {
        preparedStatement = connection.prepareStatement("DELETE FROM preson WHERE id = ?");
        preparedStatement.setInt(1, pilot.getId());
    }

    public List<Pilot> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person WHERE type = 0");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Pilot> pilotList = new ArrayList<>();
        while (resultSet.next()){
            pilotList.add(
                    new Pilot()
                    .setId(resultSet.getInt("id"))
                    .setFirstName(resultSet.getString("firstName"))
                    .setLastName(resultSet.getString("lastName"))
                    .setAge(resultSet.getInt("age"))
                    .setSalary(resultSet.getInt("salary"))
                    .setFlightTime(resultSet.getInt("flightTime"))
                    .setFlightCount(resultSet.getInt("flightCount"))
                    .setCertificate(resultSet.getInt("certificate"))
            );
        }

        return pilotList;
    }

    public Pilot selectOne(Pilot pilot) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where type = 0 AND id=?");
        preparedStatement.setLong(1,pilot.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Pilot()
                .setId(resultSet.getInt("id"))
                .setFirstName(resultSet.getString("firstName"))
                .setLastName(resultSet.getString("lastName"))
                .setAge(resultSet.getInt("age"))
                .setSalary(resultSet.getInt("salary"))
                .setFlightTime(resultSet.getInt("flightTime"))
                .setFlightCount(resultSet.getInt("flightCount"))
                .setCertificate(resultSet.getInt("certificate"))
                ;
    }

    public Pilot selectOneById(Integer id) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where type = 0 AND id=?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Pilot()
                .setId(resultSet.getInt("id"))
                .setFirstName(resultSet.getString("firstName"))
                .setLastName(resultSet.getString("lastName"))
                .setAge(resultSet.getInt("age"))
                .setSalary(resultSet.getInt("salary"))
                .setFlightTime(resultSet.getInt("flightTime"))
                .setFlightCount(resultSet.getInt("flightCount"))
                .setCertificate(resultSet.getInt("certificate"))
                ;
    }

    @Override
    public void close() throws Exception {

    }
}
