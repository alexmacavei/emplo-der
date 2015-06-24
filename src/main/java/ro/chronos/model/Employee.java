package ro.chronos.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Employee model from the H2 database.
 * <p>
 * Created by Alex Macavei on 6/23/15.
 */
@Entity
@Table(name = "EMP")
public class Employee implements Serializable {
    private static final long serialVersionUID = -7245824973423630558L;

    @Id
    @Column(name = "EMPNO")
    private Long id;

    @Column(name = "ENAME")
    private String name;

    @Column(name = "JOB")
    private String job;

    @Column(name = "MGR")
    private Long managerCode;

    @Column(name = "HIREDATE")
    private LocalDate hireDate;

    @Column(name = "SAL")
    private BigDecimal salary;

    @Column(name = "COMM")
    private BigDecimal commission;

    @Column(name = "DEPTNO")
    private Integer departmentId;

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public Employee setJob(String job) {
        this.job = job;
        return this;
    }

    public Long getManagerCode() {
        return managerCode;
    }

    public Employee setManagerCode(Long managerCode) {
        this.managerCode = managerCode;
        return this;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Employee setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Employee setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public Employee setCommission(BigDecimal commission) {
        this.commission = commission;
        return this;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Employee setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return new EqualsBuilder()
                .append(id, employee.id)
                .append(name, employee.name)
                .append(job, employee.job)
                .append(managerCode, employee.managerCode)
                .append(hireDate, employee.hireDate)
                .append(salary, employee.salary)
                .append(commission, employee.commission)
                .append(departmentId, employee.departmentId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(job)
                .append(managerCode)
                .append(hireDate)
                .append(salary)
                .append(commission)
                .append(departmentId)
                .toHashCode();
    }
}
