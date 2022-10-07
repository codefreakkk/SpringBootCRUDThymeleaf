package com.example.springcrudharsh.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public EmpEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmpEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public EmpEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
