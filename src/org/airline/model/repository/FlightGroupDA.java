package org.airline.model.repository;

import org.airline.model.common.JDBC;
import org.airline.model.entity.Certificate;
import org.airline.model.entity.FlightGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightGroupDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public FlightGroupDA() throws Exception
    {
        connection = JDBC.getConnection();
    }

    public void insert(FlightGroup flightGroup) throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO flightgroup (id, groupName, groupCode, flightTime, flightCount, pilot, pilotAssistant, hosts, engineer) VALUES (?,?,?,?,?,?,?,?,?)");
        preparedStatement.setLong(1,flightGroup.getId());
        preparedStatement.setString(2, flightGroup.getGroupName());
        preparedStatement.setString(3, flightGroup.getGroupCode());
        preparedStatement.setInt(4, flightGroup.getFlightTime());
        preparedStatement.setInt(5, flightGroup.getFlightCount());
        preparedStatement.setInt(6, flightGroup.getPilot());
        preparedStatement.setInt(7, flightGroup.getPilotAssistant());
        preparedStatement.setInt(8, flightGroup.getHosts());
        preparedStatement.setInt(9, flightGroup.getEngineer());
        preparedStatement.executeUpdate();
    }

    public void update(FlightGroup flightGroup) throws SQLException
    {
        preparedStatement = connection.prepareStatement("UPDATE flightgroup SET groupName = ?, groupCode = ?, flightTime = ?, flightCount = ?, pilot = ?, pilotAssistant = ?, hosts = ?, engineer = ? WHERE id = ?");
        preparedStatement.setString(1, flightGroup.getGroupName());
        preparedStatement.setString(2, flightGroup.getGroupCode());
        preparedStatement.setLong(3, flightGroup.getFlightTime());
        preparedStatement.setLong(4, flightGroup.getFlightCount());
        preparedStatement.setLong(5, flightGroup.getPilot());
        preparedStatement.setLong(6, flightGroup.getPilotAssistant());
        preparedStatement.setLong(7, flightGroup.getHosts());
        preparedStatement.setLong(8, flightGroup.getEngineer());
        preparedStatement.setLong(9, flightGroup.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(FlightGroup flightGroup) throws SQLException
    {
        preparedStatement = connection.prepareStatement("DELETE FROM flightgroup WHERE id = ?");
        preparedStatement.setLong(1, flightGroup.getId());
        preparedStatement.executeUpdate();
    }

    public List<FlightGroup> selectAll() throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM flightgroup");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<FlightGroup> flightGroupList = new ArrayList<>();
        while (resultSet.next())
        {
            flightGroupList.add(
                    new FlightGroup()
                            .setId(resultSet.getInt("id"))
                            .setGroupName(resultSet.getString("groupName"))
                            .setGroupCode(resultSet.getString("groupCode"))
                            .setFlightTime(resultSet.getInt("flightTime"))
                            .setFlightCount(resultSet.getInt("flightCount"))
                            .setPilot(resultSet.getInt("pilot"))
                            .setPilotAssistant(resultSet.getInt("pilotAssistant"))
                            .setHosts(resultSet.getInt("hosts"))
                            .setEngineer(resultSet.getInt("engineer"))
            );
        }
        return flightGroupList;
    }

    public FlightGroup selectOne(FlightGroup flightGroup) throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM flightgroup WHERE id = ?");
        preparedStatement.setLong(1, flightGroup.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new FlightGroup()
                .setId(resultSet.getInt("id"))
                .setGroupName(resultSet.getString("groupName"))
                .setGroupCode(resultSet.getString("groupCode"))
                .setFlightTime(resultSet.getInt("flightTime"))
                .setFlightCount(resultSet.getInt("flightCount"))
                .setPilot(resultSet.getInt("pilot"))
                .setPilotAssistant(resultSet.getInt("pilotAssistant"))
                .setHosts(resultSet.getInt("hosts"))
                .setEngineer(resultSet.getInt("engineer"))
                ;

    }

    public FlightGroup selectOneById(Integer id) throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM flightgroup WHERE id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new FlightGroup()
                .setId(resultSet.getInt("id"))
                .setGroupName(resultSet.getString("groupName"))
                .setGroupCode(resultSet.getString("groupCode"))
                .setFlightTime(resultSet.getInt("flightTime"))
                .setFlightCount(resultSet.getInt("flightCount"))
                .setPilot(resultSet.getInt("pilot"))
                .setPilotAssistant(resultSet.getInt("pilotAssistant"))
                .setHosts(resultSet.getInt("hosts"))
                .setEngineer(resultSet.getInt("engineer"))
                ;

    }

    @Override
    public void close() throws Exception {

    }
}
