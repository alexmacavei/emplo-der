package ro.chronos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.chronos.model.Employee;
import ro.chronos.util.JinqSource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

/**
 * DAO repository for retrieving employees.
 * <p>
 * Created by Alex Macavei on 6/23/15.
 */
@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JinqSource source;

    public Optional<Employee> findByName(String aSearchedName) {
        return Optional.of(source
                .employees(em)
                .where(e -> e.getName().equals(aSearchedName))
                .getOnlyValue());
    }

    public Collection<Employee> findForManager(String aManagerName) {
        Long managerId = findByName(aManagerName).get().getId();

        return source
                .employees(em)
                .where(e -> e.getManagerCode().longValue() == managerId)
                .toList();
    }
}
