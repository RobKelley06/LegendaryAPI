package com.legendary;


import java.util.List;
import javax.sql.DataSource;

public interface AdversaryDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the adversary table.
     */
    public void create(String name, Integer age);

    /**
     * This is the method to be used to list down
     * a record from the adversary table corresponding
     * to a passed adversary id.
     */
    public Adversary getAdversary(String name);

    /**
     * This is the method to be used to list down
     * all the records from the Adversary table.
     */
    public List<Adversary> listAdversaries();

    /**
     * This is the method to be used to delete
     * a record from the Adversary table corresponding
     * to a passed Adversary id.
     */
    public void delete(String name);

    /**
     * This is the method to be used to update
     * a record into the Adversary table.
     */
    public void update(String name, String newName, Integer age);
}

