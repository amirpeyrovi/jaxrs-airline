package org.airline.model.repository;

import org.airline.model.common.JDBC;
import org.airline.model.entity.Engineer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EngineerDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public EngineerDA() throws Exception
    {
        connection = JDBC.getConnection();
    }

    public void insert(Engineer engineer) throws SQLException
    {
        preparedStatement = connection.prepareStatement("INSERT INTO person (id,firstName,lastName,age,salary,flightTime,flightCount,certificate,type) VALUES (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, engineer.getId());
        preparedStatement.setString(2, engineer.getFirstName());
        preparedStatement.setString(3, engineer.getLastName());
        preparedStatement.setInt(4, engineer.getAge());
        preparedStatement.setInt(5, engineer.getSalary());
        preparedStatement.setInt(6, engineer.getFlightTime());
        preparedStatement.setInt(7, engineer.getFlightCount());
        preparedStatement.setInt(8, engineer.getCertificate());
        preparedStatement.setInt(9, engineer.getType());
    }

    public void update(Engineer engineer) throws SQLException
    {
        preparedStatement = connection.prepareStatement("UPDATE person SET firstName = ?,lastName = ?,age = ?,salary = ?,flightTime = ?,flightCount = ? WHERE id = ?");
        preparedStatement.setString(1, engineer.getFirstName());
        preparedStatement.setString(2, engineer.getLastName());
        preparedStatement.setInt(3, engineer.getAge());
        preparedStatement.setInt(4, engineer.getSalary());
        preparedStatement.setInt(5, engineer.getFlightTime());
        preparedStatement.setInt(6, engineer.getFlightCount());
        preparedStatement.setInt(7, engineer.getId());
    }

    public void delete(Engineer engineer) throws SQLException
    {
        preparedStatement = connection.prepareStatement("DELETE FROM preson WHERE id = ?");
        preparedStatement.setInt(1, engineer.getId());
    }

    public List<Engineer> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person WHERE type = 3");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Engineer> engineerList = new ArrayList<>();
        while (resultSet.next()){
            engineerList.add(
                    new Engineer()
                    .setId(resultSet.getInt("id"))
                    .setFirstName(resultSet.getString("firstName"))
                    .setLastName(resultSet.getString("lastName"))
                    .setAge(resultSet.getInt("age"))
                    .setSalary(resultSet.getInt("salary"))
                    .setFlightTime(resultSet.getInt("flightTime"))
                    .setFlightCount(resultSet.getInt("flightCount"))
            );
        }

        return engineerList;
    }

    public Engineer selectOne(Engineer engineer) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where type = 3 AND id=?");
        preparedStatement.setLong(1,engineer.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Engineer()
                .setId(resultSet.getInt("id"))
                .setFirstName(resultSet.getString("firstName"))
                .setLastName(resultSet.getString("lastName"))
                .setAge(resultSet.getInt("age"))
                .setSalary(resultSet.getInt("salary"))
                .setFlightTime(resultSet.getInt("flightTime"))
                .setFlightCount(resultSet.getInt("flightCount"))
                ;
    }

    public Engineer selectOneById(Integer id) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where type = 3 AND id=?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Engineer()
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
