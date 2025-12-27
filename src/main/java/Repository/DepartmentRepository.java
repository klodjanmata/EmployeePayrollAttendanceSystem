package Repository;

import Entity.Department;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public HashMap<Long, Department> findAll(){
        Transaction transaction = null;
        List<Department> departments = null;
        HashMap<Long, Department> departmentsMap = new HashMap<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            departments = session.createQuery("From Department", Department.class).list();
            transaction.commit();
            for(Department d : departments){
                departmentsMap.put(d.getId(), d);
            }
        } catch(Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return departmentsMap;
    }
}
