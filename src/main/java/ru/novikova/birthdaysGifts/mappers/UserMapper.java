package ru.novikova.birthdaysGifts.mappers;

import ru.novikova.birthdaysGifts.entities.User;

import java.sql.*;

public class UserMapper {
    private final Connection connection;

    public UserMapper(Connection connection) {
        this.connection = connection;
    }

    public User findById(int idUser) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT id, name, birthdate FROM User WHERE idUser = ?");
        statement.setInt(1,idUser);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setBirthdate(resultSet.getDate(3));
                return user;
            }
        }
        throw new SQLException("User not found");
    }

    public void insert(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO User (id, name, birthdate) VALUES (?, ?, ?");
        statement.setLong(1, user.getId());
        statement.setString(2, user.getName());
        statement.setDate(3, (Date) user.getBirthdate());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }

    public void update(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE Users SET name = ?, birthdate = ? WHERE id = ?");
        statement.setString(1, user.getName());
        statement.setDate(2, (Date) user.getBirthdate());
        statement.setLong(3, user.getId());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }
    public void delete(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Users WHERE id = ?");
        statement.setLong(1, user.getId());
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
    }
}
