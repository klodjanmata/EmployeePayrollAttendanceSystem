package Repository;

import Entity.Department;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DepartmentRepository {

    public Department create(Department department){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(department);
            transaction.commit();
            return department;

        }catch(Exception e){
            e.printStackTrace();
        }
        return department;
    }

    public Department find(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Department.class, id);
        }
    }
    public Department update (Department department){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(department);
            transaction.commit();
            return department;
        }catch(Exception e){
            e.printStackTrace();
        }
        return department;
    }
    public Department delete(Department department){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(department);
            transaction.commit();
            return department;
        }catch(Exception e){
            e.printStackTrace();
        }
        return department;
    }
    public HashMap<Long,Department> findAll(){
        Transaction transaction = null;
        HashMap<Long, Department> departments = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            departments = (HashMap<Long, Department>) session.createQuery("from Department", Department.class).list();
            transaction.commit();
            return departments;
        } catch(Exception e){
            e.printStackTrace();
        }
        return departments;
    }
}
