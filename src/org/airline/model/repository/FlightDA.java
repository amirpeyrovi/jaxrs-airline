package org.airline.model.repository;

import org.airline.model.common.JDBC;
import org.airline.model.entity.Certificate;
import org.airline.model.entity.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public FlightDA() throws Exception
    {
        connection = JDBC.getConnection();
    }

    public void insert(Flight flight) throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO flight (id, code , dateTime, source, destination, flightGroup, aircraft) VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setInt(1,flight.getId());
        preparedStatement.setString(2, flight.getCode());
        preparedStatement.setString(3, flight.getDateTime());
        preparedStatement.setInt(4, flight.getSource());
        preparedStatement.setInt(5, flight.getDestination());
        preparedStatement.setInt(6, flight.getFlightGroup());
        preparedStatement.setInt(7, flight.getAircraft());
        preparedStatement.executeUpdate();
    }

    public void update(Flight flight) throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE flight SET code = ?, dateTime = ? source = ? destination = ? flightGroup = ? aircraft = ? WHERE id = ?");
        preparedStatement.setString(1, flight.getCode());
        preparedStatement.setString(2, flight.getDateTime());
        preparedStatement.setInt(3, flight.getSource());
        preparedStatement.setInt(4, flight.getDestination());
        preparedStatement.setInt(5, flight.getFlightGroup());
        preparedStatement.setInt(6, flight.getAircraft());
        preparedStatement.setInt(7, flight.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Flight flight) throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM flight WHERE id = ?");
        preparedStatement.setLong(1, flight.getId());
        preparedStatement.executeUpdate();
    }

    public List<Flight> selectAll() throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM flight");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Flight> flightList = new ArrayList<>();
        while (resultSet.next())
        {
            flightList.add(
                    new Flight()
                            .setId(resultSet.getInt("id"))
                            .setCode(resultSet.getString("code"))
                            .setDateTime(resultSet.getString("dateTime"))
                            .setSource(resultSet.getInt("source"))
                            .setDestination(resultSet.getInt("destination"))
                            .setFlightGroup(resultSet.getInt("flightGroup"))
                            .setAircraft(resultSet.getInt("aircraft"))
            );
        }
        return flightList;
    }

    public Flight selectOne(Flight flight)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM flight WHERE id = ?");
        preparedStatement.setLong(1, flight.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Flight()
                .setId(resultSet.getInt("id"))
                .setCode(resultSet.getString("code"))
                .setDateTime(resultSet.getString("dateTime"))
                .setSource(resultSet.getInt("source"))
                .setDestination(resultSet.getInt("destination"))
                .setFlightGroup(resultSet.getInt("flightGroup"))
                .setAircraft(resultSet.getInt("aircraft"))
                ;

    }

    public Flight selectOneById(Integer id)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM flight WHERE id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Flight()
                .setId(resultSet.getInt("id"))
                .setCode(resultSet.getString("code"))
                .setDateTime(resultSet.getString("dateTime"))
                .setSource(resultSet.getInt("source"))
                .setDestination(resultSet.getInt("destination"))
                .setFlightGroup(resultSet.getInt("flightGroup"))
                .setAircraft(resultSet.getInt("aircraft"))
                ;

    }

    @Override
    public void close() throws Exception {

    }
}
