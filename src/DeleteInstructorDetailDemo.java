import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
             Session session = factory.openSession()) {


            //start transaction
            session.beginTransaction();

            //get the instructor detail
            int theId = 6;
            InstructorDetail tempInsructorDetail = session.get(InstructorDetail.class,  theId);

            //print detail
            System.out.println("tempInsrtuctorDetail: " + tempInsructorDetail);

            //print the assotiated insrtuctor

            System.out.println("the associated insrtuctor : " + tempInsructorDetail.getInstructor());

            //delete the insructor detail
            System.out.println("Deleting tempInsructorDetail: " + tempInsructorDetail);

            tempInsructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInsructorDetail);

            System.out.println("Done!");
            //commit transaction
            session.getTransaction().commit();
        }
    }
}
