import entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
                 Session session = factory.openSession()) {



            //start transaction
            session.beginTransaction();

            //get the insructor from db
          //  int theId=1;
            Instructor tempInstructor=session.find(Instructor.class, 1);

            System.out.println("DEBUG:   Instructor: " + tempInstructor);

            //get course fot the instructor
            System.out.println("DEBUG:   Courses: " + tempInstructor.getCourses());

            //commit transaction
            session.getTransaction().commit();

            System.out.println("DEBUG:  Done!!!");
        }
    }
}
