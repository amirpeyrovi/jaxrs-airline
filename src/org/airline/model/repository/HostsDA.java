package org.airline.model.repository;

import org.airline.model.common.JDBC;
import org.airline.model.entity.Engineer;
import org.airline.model.entity.Hosts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HostsDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public HostsDA() throws Exception
    {
        connection = JDBC.getConnection();
    }

    public void insert(Hosts hosts) throws SQLException
    {
        preparedStatement = connection.prepareStatement("INSERT INTO person (id,firstName,lastName,age,salary,flightTime,flightCount,certificate,type) VALUES (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, hosts.getId());
        preparedStatement.setString(2, hosts.getFirstName());
        preparedStatement.setString(3, hosts.getLastName());
        preparedStatement.setInt(4, hosts.getAge());
        preparedStatement.setInt(5, hosts.getSalary());
        preparedStatement.setInt(6, hosts.getFlightTime());
        preparedStatement.setInt(7, hosts.getFlightCount());
        preparedStatement.setInt(8, hosts.getCertificate());
        preparedStatement.setInt(9, hosts.getType());
    }

    public void update(Hosts hosts) throws SQLException
    {
        preparedStatement = connection.prepareStatement("UPDATE person SET firstName = ?,lastName = ?,age = ?,salary = ?,flightTime = ?,flightCount = ? WHERE id = ?");
        preparedStatement.setString(1, hosts.getFirstName());
        preparedStatement.setString(2, hosts.getLastName());
        preparedStatement.setInt(3, hosts.getAge());
        preparedStatement.setInt(4, hosts.getSalary());
        preparedStatement.setInt(5, hosts.getFlightTime());
        preparedStatement.setInt(6, hosts.getFlightCount());
        preparedStatement.setInt(7, hosts.getId());
    }

    public void delete(Hosts hosts) throws SQLException
    {
        preparedStatement = connection.prepareStatement("DELETE FROM preson WHERE id = ?");
        preparedStatement.setInt(1, hosts.getId());
    }

    public List<Hosts> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person WHERE type = 2");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Hosts> hostsList = new ArrayList<>();
        while (resultSet.next()){
            hostsList.add(
                    new Hosts()
                    .setId(resultSet.getInt("id"))
                    .setFirstName(resultSet.getString("firstName"))
                    .setLastName(resultSet.getString("lastName"))
                    .setAge(resultSet.getInt("age"))
                    .setSalary(resultSet.getInt("salary"))
                    .setFlightTime(resultSet.getInt("flightTime"))
                    .setFlightCount(resultSet.getInt("flightCount"))
            );
        }

        return hostsList;
    }

    public Hosts selectOne(Hosts hosts) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where type = 2 AND id=?");
        preparedStatement.setLong(1,hosts.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Hosts()
                .setId(resultSet.getInt("id"))
                .setFirstName(resultSet.getString("firstName"))
                .setLastName(resultSet.getString("lastName"))
                .setAge(resultSet.getInt("age"))
                .setSalary(resultSet.getInt("salary"))
                .setFlightTime(resultSet.getInt("flightTime"))
                .setFlightCount(resultSet.getInt("flightCount"))
                ;
    }

    public Hosts selectOneById(Integer id) throws Exception{
        preparedStatement = connection.prepareStatement("select * from person where type = 2 AND id=?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Hosts()
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
