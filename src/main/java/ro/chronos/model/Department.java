package ro.chronos.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Department model from H2 database.
 * <p>
 * Created by Alex Macavei on 6/23/15.
 */
@Entity
@Table(name = "DEPT")
public class Department implements Serializable {
    private static final long serialVersionUID = 2959404650122675237L;

    @Id
    @Column(name = "DEPTNO")
    private Long id;

    @Column(name = "DNAME")
    private String name;

    @Column(name = "LOC")
    private String location;

    public Long getId() {
        return id;
    }

    public Department setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Department setLocation(String location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(name, that.name)
                .append(location, that.location)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(location)
                .toHashCode();
    }
}
