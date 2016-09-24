package com.sutao.database.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcPersonDAO implements PersonDAO{

    private static final String DEIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/hr";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public jdbcPersonDAO() {
        try {
            Class.forName(DEIVER);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> finaAll() {
        List<Person> people = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = conn.prepareStatement("select * from hr.people")) {
             {
                 ResultSet rs = pst.executeQuery();
                 while (rs.next()) {
                     people.add(new Person(rs.getInt(1), rs.getString(2)));
                 }
                 rs.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public Person findById(Integer id) {
        Person p = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = conn.prepareStatement("select * from hr.people where id = ?")) {
            {
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                     p = new Person(id, rs.getString("name"));
                }
                rs.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public Integer save(Person p) {
        int generatedKey = 0;
        List<Person> people = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = conn.prepareStatement("insert into hr.people(name) values (?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            {
                pst.setString(1, p.getName());
                int uc = pst.executeUpdate();
                if (uc != 1) throw new SQLException("No rows added");
                try (ResultSet keys = pst.getGeneratedKeys()) {
                    if(keys.next()) {
                        generatedKey = keys.getInt(1);
                    }

                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedKey;
    }

    @Override
    public void delete(Person p) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = conn.prepareStatement("delete from hr.people where id = ?")) {
            {
                pst.setInt(1, p.getId());
                int uc = pst.executeUpdate();
                if (uc != 1) throw new SQLException("No rows removed");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Integer> getIds() {
        List<Integer> ids = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = conn.prepareStatement("select * from hr.people")) {
            {
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    ids.add(rs.getInt(1));
                }
                rs.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
}
