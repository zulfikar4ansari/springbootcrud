package com.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 1
// Employee class to represent the employee entity in the database.
// @Entity: Marks this class as a JPA entity, meaning it will be mapped to a table in the database.

@Entity
public class Employee
{
    @Id // @Id: Specifies the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue: Defines the strategy for generating primary key values automatically.
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
