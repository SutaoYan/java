package com.sutao.database.jdbc;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcPersonDAOTest {
    private PersonDAO dao = new jdbcPersonDAO();

    @Test
    public void findAll () throws Exception {
        List<Person> people = dao.finaAll();
        System.out.println(people);
        assertTrue(people.size() > 0);
    }

    @Test
    public void findById () throws Exception {
        for (int id : dao.getIds()) {
            assertNotNull(dao.findById(id));
        }
    }

    @Test
    public void save() throws Exception {
        Person p = new Person("Pulaski");
        int before = dao.finaAll().size();
        int generatedId = dao.save(p);
        System.out.println(generatedId);
        int after = dao.finaAll().size();
        assertEquals(after, before + 1);
    }

    @Test
    public void delete() {
        int maxId = dao.getIds().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(1);
        System.out.println("maxId=" + maxId);
        Person p = dao.findById(maxId);
        dao.delete(p);
        assertNull(dao.findById(maxId));
    }

    @Test
    public void getIds() {
        System.out.println(dao.getIds());
    }
}
