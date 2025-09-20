package Repository;

import Entity.Payroll;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PayrollRepository {

    public Payroll create(Payroll payroll) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(payroll);
            transaction.commit();
            return payroll;

        }catch (Exception e){
            e.printStackTrace();
        }
        return payroll;
    }
    public Payroll find(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (Payroll) session.get(Payroll.class, id);
        }
    }
    public Payroll update(Payroll payroll) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(payroll);
            transaction.commit();
            return payroll;
        }  catch (Exception e){
            e.printStackTrace();
        }
        return payroll;
    }
    public Payroll delete(Payroll payroll) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(payroll);
            transaction.commit();
            return payroll;
        }catch (Exception e){
            e.printStackTrace();
        }
        return payroll ;
    }
    public HashMap<Long, Payroll> findAll() {
        Transaction transaction = null;
        HashMap<Long, Payroll> payrolls = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            payrolls = (HashMap<Long, Payroll>) session.createQuery("from Payroll", Payroll.class);
            transaction.commit();
            return payrolls;
        }catch (Exception e){
            e.printStackTrace();
        }
        return payrolls;
    }
    public HashMap<Long, Payroll> findAllHibernate(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return (HashMap<Long, Payroll>) session.createQuery("FROM Client");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
