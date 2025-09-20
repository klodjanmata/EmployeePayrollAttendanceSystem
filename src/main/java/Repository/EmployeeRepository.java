package Repository;

import Entity.Employee;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;

public class EmployeeRepository {
    public Employee create(Employee employee){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
            return employee;
    } catch (Exception e){
            e.printStackTrace();
        }
        return employee;
}
public Employee find(Long id) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.get(Employee.class, id);
    }
}
public Employee update(Employee employee){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
}
public void delete(Employee employee){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<Long, Employee> findAll(){
        Transaction transaction = null;
        HashMap <Long,Employee> employees = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            employees = (HashMap<Long, Employee>) session.createQuery("from Employee", Employee.class).list();
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employees;
    }
}
