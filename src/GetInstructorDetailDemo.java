import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
             Session session = factory.openSession()) {


            //start transaction
            session.beginTransaction();

            //get the instructor detail
            int theId = 6;
            InstructorDetail tempInsructor = session.find(InstructorDetail.class,  theId);

            //print detail
            System.out.println("tempInsrtuctorDetail: " + tempInsructor);

            //print the assotiated insrtuctor

            System.out.println("the associated insrtuctor : " + tempInsructor.getInstructor());


            //commit transaction
            session.getTransaction().commit();
        }
    }
}
