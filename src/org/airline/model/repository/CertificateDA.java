package org.airline.model.repository;

import org.airline.model.common.JDBC;
import org.airline.model.entity.Certificate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CertificateDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public CertificateDA() throws Exception
    {
        connection = JDBC.getConnection();
    }

    public void insert(Certificate certificate) throws Exception
    {
        preparedStatement = connection.prepareStatement("INSERT INTO certificate (id,name,code) VALUES (?,?,?)");
        preparedStatement.setInt(1,certificate.getId());
        preparedStatement.setString(2, certificate.getName());
        preparedStatement.setString(3, certificate.getCode());
        preparedStatement.executeUpdate();
    }

    public void update(Certificate certificate) throws SQLException
    {
        preparedStatement = connection.prepareStatement("UPDATE certificate SET name = ?, code = ? WHERE id = ?");
        preparedStatement.setString(1, certificate.getName());
        preparedStatement.setString(2, certificate.getCode());
        preparedStatement.setInt(3, certificate.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Certificate certificate) throws SQLException
    {
        preparedStatement = connection.prepareStatement("DELETE FROM certificate WHERE id = ?");
        preparedStatement.setInt(1, certificate.getId());
        preparedStatement.executeUpdate();
    }

    public List<Certificate> selectAll() throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM certificate");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Certificate> certificateList = new ArrayList<>();
        while (resultSet.next())
        {
            certificateList.add(
                    new Certificate()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setCode(resultSet.getString("code"))
            );
        }
        return certificateList;
    }

    public Certificate selectOne(Certificate certificate)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM certificate WHERE id = ?");
        preparedStatement.setLong(1, certificate.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Certificate()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setCode(resultSet.getString("code"))
                ;

    }

    public Certificate selectOneById(Integer id)throws Exception
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM certificate WHERE id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Certificate()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setCode(resultSet.getString("code"))
                ;

    }

    @Override
    public void close() throws Exception {

    }
}
