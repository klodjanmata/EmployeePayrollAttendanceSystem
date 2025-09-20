package Repository;

import Entity.LeaveRequest;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;

public class LeaveRequestRepository {

    public LeaveRequest create(LeaveRequest leaveRequest){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(leaveRequest);
            transaction.commit();
            return leaveRequest;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leaveRequest;
    }
    public LeaveRequest find(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(LeaveRequest.class, id);
        }
    }
    public LeaveRequest update(LeaveRequest leaveRequest){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(leaveRequest);
            transaction.commit();
            return leaveRequest;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leaveRequest;
    }
    public LeaveRequest delete(LeaveRequest leaveRequest) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(leaveRequest);
            transaction.commit();
            return leaveRequest;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leaveRequest;
    }
    public HashMap<Long, LeaveRequest> findAll() {
        Transaction transaction = null;
        HashMap<Long, LeaveRequest> leaveRequests = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL query to fetch all leave requestat records
            leaveRequests = (HashMap<Long, LeaveRequest>) session.createQuery("Leave Request", LeaveRequest.class);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return leaveRequests;
    }
    public HashMap<Long, LeaveRequest> findAllHibernate(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return (HashMap<Long, LeaveRequest>) session.createQuery("FROM LeaveRequest");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
