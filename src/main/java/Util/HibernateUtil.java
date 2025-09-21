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
                    .addAnnotatedClass(Entity.Attendance.class)
                    .addAnnotatedClass(Entity.Department.class)
                    .addAnnotatedClass(Entity.Employee.class)
                    .addAnnotatedClass(Entity.LeaveRequest.class)
                    .addAnnotatedClass(Entity.OvertimeRate.class)
                    .addAnnotatedClass(Entity.Payroll.class)
                    .buildSessionFactory();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
   // public static SessionFactory openSessionFactory() {
     //   return sessionFactory;
   // }


    public static void shutdown() {
        sessionFactory.close();
    }

}