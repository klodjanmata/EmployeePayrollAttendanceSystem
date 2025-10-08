package Repository;

import Entity.Employee;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeRepository {
    public Employee create(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public Employee find(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    public Employee update(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void delete(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<Long, Employee> findAll() {
        Transaction transaction = null;
        Session session = null;
        List<Employee> employees = null;
        HashMap<Long, Employee> employeesMap = new HashMap<>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            employees = session.createQuery("From Employee", Employee.class).list();
            transaction.commit();

            for(Employee e : employees){
                employeesMap.put(e.getId(), e);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return employeesMap;
    }
    }



