package com.sutao.database.jpa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNull;

public class JpaPersonDAOTest {
    private PersonDAO dao = new JpaPersonDAO();

    @Test
    public void finaAll() throws Exception {
        List<Person> people = new ArrayList<>();
        people = dao.finaAll();
        System.out.println(people);
        assertTrue(people.size() > 0);
    }

    @Test
    public void findById() throws Exception {
        for (int id : dao.getIds()) {
            assertNotNull(dao.findById(id));
        }
    }

    @Test
    public void save() throws Exception {
        Person p = new Person("Pulaski");
        int before = dao.finaAll().size();
        int generatedId = dao.save(p);
        int after = dao.finaAll().size();
        System.out.println(generatedId);
        assertEquals(after, before + 1);
    }

    @Test
    public void delete() throws Exception {
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
    public void getIds() throws Exception {
        System.out.println(dao.getIds());
    }
}