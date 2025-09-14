package Repository;

import Entity.Payroll;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
    public List<Payroll> findAll() {
        Transaction transaction = null;
        List<Payroll> payrolls = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            payrolls = session.createQuery("from Payroll", Payroll.class).list();
            transaction.commit();
            return payrolls;
        }catch (Exception e){
            e.printStackTrace();
        }
        return payrolls;
    }
}
