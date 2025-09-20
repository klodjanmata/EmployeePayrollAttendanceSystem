package Repository;

import Entity.Attendance;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttendanceRepository {

    public  Attendance create(Attendance attendance){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(attendance);
            transaction.commit();
            return attendance;
        }catch(Exception e){
            e.printStackTrace();
        }
        return attendance;
    }
    public Attendance find(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Attendance.class, id);
        }
    }
    public Attendance update(Attendance attendance){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(attendance);
            transaction.commit();
            return attendance;
        }catch(Exception e){
            e.printStackTrace();
        }
        return attendance;
    }
    public Attendance delete(Attendance attendance){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(attendance);
            transaction.commit();
            return attendance;
        }catch(Exception e){
            e.printStackTrace();
        }
        return attendance;
    }
    public static HashMap<Long, Attendance> findAll(){
        Transaction transaction = null;
        HashMap<Long, Attendance> attendances = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            attendances = (HashMap<Long, Attendance>) session.createQuery("from Attendance", Attendance.class);

            transaction.commit();
            return attendances;
        }catch(Exception e){
            e.printStackTrace();
        }
        return attendances;
    }
    public HashMap<Long, Attendance> findAllHibernate(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return (HashMap<Long, Attendance>) session.createQuery("FROM Attendance");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
