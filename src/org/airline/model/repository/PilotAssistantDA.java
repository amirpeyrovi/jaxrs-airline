package org.airline.model.repository;

import org.airline.model.common.JDBC;
import org.airline.model.entity.Hosts;
import org.airline.model.entity.PilotAssistant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotAssistantDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public PilotAssistantDA() throws Exception
    {
        connection = JDBC.getConnection();
    }

    public void insert(PilotAssistant pilotAssistant) throws SQLException
    {
        preparedStatement = connection.prepareStatement("INSERT INTO person (id,firstName,lastName,age,salary,flightTime,flightCount,certificate,type) VALUES (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, pilotAssistant.getId());
        preparedStatement.setString(2, pilotAssistant.getFirstName());
        preparedStatement.setString(3, pilotAssistant.getLastName());
        preparedStatement.setInt(4, pilotAssistant.getAge());
        preparedStatement.setInt(5, pilotAssistant.getSalary());
        preparedStatement.setInt(6, pilotAssistant.getFlightTime());
        preparedStatement.setInt(7, pilotAssistant.getFlightCount());
        preparedStatement.setInt(8, pilotAssistant.getCertificate());
        preparedStatement.setInt(9, pilotAssistant.getType());
    }

    public void update(PilotAssistant pilotAssistant) throws SQLException
    {
        preparedStatement = connection.prepareStatement("UPDATE person SET firstName = ?,lastName = ?,age = ?,salary = ?,flightTime = ?,flightCount = ? WHERE id = ?");
        preparedStatement.setString(1, pilotAssistant.getFirstName());
        preparedStatement.setString(2, pilotAssistant.getLastName());
        preparedStatement.setInt(3, pilotAssistant.getAge());
        preparedStatement.setInt(4, pilotAssistant.getSalary());
        preparedStatement.setInt(5, pilotAssistant.getFlightTime());
        preparedStatement.setInt(6, pilotAssistant.getFlightCount());
        preparedStatement.setInt(7, pilotAssistant.getId());
    }

    public void delete(PilotAssistant pilotAssistant) throws SQLException
    {
        preparedStatement = connection.prepareStatement("DELETE FROM preson WHERE id = ?");
        preparedStatement.setInt(1, pilotAssistant.getId());
    }

    public List<PilotAssistant> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person WHERE type = 1");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<PilotAssistant> pilotAssistantList = new ArrayList<>();
        while (resultSet.next()){
            pilotAssistantList.add(
                    new PilotAssistant()
                    .setId(resultSet.getInt("id"))
                    .setFirstName(resultSet.getString("firstName"))
                    .setLastName(resultSet.getString("lastName"))
                    .setAge(resultSet.getInt("age"))
                    .setSalary(resultSet.getInt("salary"))
                    .setFlightTime(resultSet.getInt("flightTime"))
                    .setFlightCount(resultSet.getInt("flightCount"))
            );
        }

        return pilotAssistantList;
    }

    public PilotAssistant selectOne(PilotAssistant pilotAssistant) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where type = 1 AND id=?");
        preparedStatement.setLong(1,pilotAssistant.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new PilotAssistant()
                .setId(resultSet.getInt("id"))
                .setFirstName(resultSet.getString("firstName"))
                .setLastName(resultSet.getString("lastName"))
                .setAge(resultSet.getInt("age"))
                .setSalary(resultSet.getInt("salary"))
                .setFlightTime(resultSet.getInt("flightTime"))
                .setFlightCount(resultSet.getInt("flightCount"))
                ;
    }

    public PilotAssistant selectOneById(Integer id) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where type = 1 AND id=?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new PilotAssistant()
                .setId(resultSet.getInt("id"))
                .setFirstName(resultSet.getString("firstName"))
                .setLastName(resultSet.getString("lastName"))
                .setAge(resultSet.getInt("age"))
                .setSalary(resultSet.getInt("salary"))
                .setFlightTime(resultSet.getInt("flightTime"))
                .setFlightCount(resultSet.getInt("flightCount"))
                ;
    }

    @Override
    public void close() throws Exception {

    }
}
