package Util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try{
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Entity.Department.class)
                    .addAnnotatedClass(Entity.Employee.class)
                    .addAnnotatedClass(Entity.LeaveRequest.class)
                    .addAnnotatedClass(Entity.OvertimeRate.class)
                    .addAnnotatedClass(Entity.Payroll.class)
                    .buildSessionFactory();
        }catch(Exception e){
            System.err.println("Failed to create Hibernate SessionFactory: " + e.getMessage());
            e.printStackTrace();
            ExceptionInInitializerError error = new ExceptionInInitializerError("Failed to initialize Hibernate SessionFactory");
            error.initCause(e);
            throw error;
        }
    }
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}









