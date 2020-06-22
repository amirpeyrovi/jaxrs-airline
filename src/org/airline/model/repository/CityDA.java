package org.airline.model.repository;

import org.airline.model.common.JDBC;
import org.airline.model.entity.Certificate;
import org.airline.model.entity.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public CityDA() throws Exception
    {
        connection = JDBC.getConnection();
    }

    public void insert(City city) throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO city (id,name,latitude,longitude) VALUES (?,?,?,?)");
        preparedStatement.setInt(1,city.getId());
        preparedStatement.setString(2, city.getName());
        preparedStatement.setInt(3, city.getLatitude());
        preparedStatement.setInt(4, city.getLongitude());
        preparedStatement.executeUpdate();
    }

    public void update(City city) throws Exception
    {
        preparedStatement = connection.prepareStatement("UPDATE city SET name = ?, latitude = ?, longitude = ? WHERE id = ?");
        preparedStatement.setString(1, city.getName());
        preparedStatement.setInt(2, city.getLatitude());
        preparedStatement.setInt(3, city.getLongitude());
        preparedStatement.setInt(4, city.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(City city) throws Exception
    {
        preparedStatement = connection.prepareStatement("DELETE FROM city WHERE id = ?");
        preparedStatement.setLong(1, city.getId());
        preparedStatement.executeUpdate();
    }

    public List<City> selectAll() throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM city");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<City> cityList = new ArrayList<>();
        while (resultSet.next())
        {
            cityList.add(
                    new City()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setLatitude(resultSet.getInt("latitude"))
                            .setLongitude(resultSet.getInt("longitude"))
            );
        }
        return cityList;
    }

    public City selectOne(City city)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM city WHERE id = ?");
        preparedStatement.setLong(1, city.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new City()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setLatitude(resultSet.getInt("latitude"))
                .setLongitude(resultSet.getInt("longitude"))
                ;

    }

    public City selectOneById(Integer id)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM city WHERE id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new City()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setLatitude(resultSet.getInt("latitude"))
                .setLongitude(resultSet.getInt("longitude"))
                ;

    }

    @Override
    public void close() throws Exception {

    }
}
