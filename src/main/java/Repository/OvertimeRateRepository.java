package Repository;

import Entity.OvertimeRate;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
            session.merge(overtimeRate);
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
    public HashMap<Long, OvertimeRate> findAll(){
        Transaction transaction = null;
        List<OvertimeRate> overtimeRates = null;
        HashMap <Long, OvertimeRate> overtimeRatesMap = new HashMap<>();

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            overtimeRates = session.createQuery("From OvertimeRate", OvertimeRate.class).list();
            transaction.commit();
            for(OvertimeRate o : overtimeRates){
                overtimeRatesMap.put(o.getId(), o);
            }
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return overtimeRatesMap;
    }
}
