package com.sutao.database.jdbc;

import java.util.List;

public interface PersonDAO {
    List<Person> finaAll();
    Person findById(Integer id);
    Integer save(Person p);
    void delete(Person p);
    List<Integer> getIds();
}
