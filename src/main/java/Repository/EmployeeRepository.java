package Repository;

import Entity.Employee;
import Util.HibernateUtil;
import dbConnection.DatabaseConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        HashMap<Long, Employee> employees = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employees = (HashMap<Long, Employee>) session.createQuery("from Employee", Employee.class);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employees;
    }

    public HashMap<Long, Employee> findAllHibernate() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (HashMap<Long, Employee>) session.createQuery("FROM Employee");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(Employee employee) {
        try (Connection con = DatabaseConnection.dbConnection()) {
            PreparedStatement statement = con.prepareStatement("Insert into employee values (?,?,?,?,?,?)");
            statement.setLong(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getEmail());
            statement.setDate(4, Date.valueOf(employee.getHireDate()));
            statement.setLong(5, employee.getDepartmentId().getId());
            statement.setDouble(6, employee.getBaseSalary());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public HashMap<String, Employee> findAll() {
//        try (Connection con = DatabaseConnection.dbConnection()) {
//            PreparedStatement statement = con.prepareStatement("SELECT * FROM cemployee");
//            ResultSet resultSet = statement.executeQuery();
//            HashMap<String, Employee> employees = new HashMap<>();
//            while (resultSet.next()) {
//                Employee employee = new Employee();
//                employee.setId(resultSet.getLong("id"));
//            }
//
//            System.out.println("Successfully read employees from the database");
//            return employees;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
