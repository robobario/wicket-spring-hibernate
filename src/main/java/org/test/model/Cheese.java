package org.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cheese {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    public Cheese(){
        //constructor for hibernate
    }

    public Cheese(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cheese cheese = (Cheese) o;

        if (id != null ? !id.equals(cheese.id) : cheese.id != null) return false;
        if (name != null ? !name.equals(cheese.name) : cheese.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
