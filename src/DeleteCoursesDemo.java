import entity.Course;
import entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
                 Session session = factory.openSession()) {



            //start transaction
            session.beginTransaction();

            //get a course
            Course tempCourse= session.find(Course.class, 10);
            System.out.println("Deleting course: " + tempCourse);
            //delete course

            session.delete(tempCourse);


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");
        }
    }
}
