package Repository;

import Entity.OvertimeRate;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;

public class OvertimeRateRepository {
    public OvertimeRate create(OvertimeRate overtimeRate){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(overtimeRate);
            transaction.commit();
            return overtimeRate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overtimeRate;
    }
    public OvertimeRate find(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(OvertimeRate.class,id);
        }
    }
    public OvertimeRate update(OvertimeRate overtimeRate){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(overtimeRate);
            transaction.commit();
            return overtimeRate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overtimeRate;
    }
    public OvertimeRate delete(OvertimeRate overtimeRate){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(overtimeRate);
            transaction.commit();
            return overtimeRate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overtimeRate;
    }
    public static HashMap<Long, OvertimeRate> findAll(){
        Transaction transaction = null;
        HashMap <Long, OvertimeRate> overtimeRates = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            overtimeRates = (HashMap<Long, OvertimeRate>) session.createQuery("Overtime Rates", OvertimeRate.class);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return overtimeRates;
    }
    public HashMap<Long, OvertimeRate> findAllHibernate(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return (HashMap<Long, OvertimeRate>) session.createQuery("FROM Client");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
