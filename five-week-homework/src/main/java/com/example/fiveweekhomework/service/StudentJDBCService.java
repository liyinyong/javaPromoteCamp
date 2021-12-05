package com.example.fiveweekhomework.service;

import com.example.fiveweekhomework.bean.Student;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class StudentJDBCService {
    private static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true&SSL=true";
    private static final String user = "root";
    private static final String password = "123456";

    public Student insert(Student student) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement("insert into student (name) values(?)");
                statement.setString(1, student.getName());
                statement.executeUpdate();
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                throw e;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public Student update(Student student) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement("update student set name = ? where id = ?");
                statement.setInt(2, student.getId());
                statement.setString(1, student.getName());
                statement.executeUpdate();
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                throw e;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public Student query(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("select * from student where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return new Student(resultSet.getInt(1), resultSet.getString(2));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("delete from student where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
