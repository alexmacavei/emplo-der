package ro.chronos.util;

import org.jinq.jpa.JPAQueryLogger;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.chronos.model.Department;
import ro.chronos.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Map;

/**
 * Jinq provider bean for querying.
 * <p>
 * Created by Alex Macavei on 6/23/15.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class JinqSource {
    private JinqJPAStreamProvider streams;

    private static final Logger LOGGER = LoggerFactory.getLogger(JinqSource.class);

    @PersistenceUnit
    public void setEntityManagerFactory(
            EntityManagerFactory emf) throws Exception {
        streams = new JinqJPAStreamProvider(emf);

        // Configure Jinq to output the queries it executes
        streams.setHint("queryLogger", new JPAQueryLogger() {
            @Override
            public void logQuery(String query, Map<Integer, Object> positionParameters,
                                 Map<String, Object> namedParameters) {
                LOGGER.info("  " + query);
            }
        });
    }

    // Wrapper that passes through Jinq requests to Jinq
    public <U> JinqStream<U> streamAll(
            EntityManager em, Class<U> entity) {
        return streams.streamAll(em, entity);
    }

    public JinqStream<Employee> employees(EntityManager em) {
        return streams.streamAll(em, Employee.class);
    }

    public JinqStream<Department> departments(EntityManager em) {
        return streams.streamAll(em, Department.class);
    }
}
