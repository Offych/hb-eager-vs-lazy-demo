import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
                 Session session = factory.openSession()) {



//            create the Objects
            Instructor tempInstructor = new Instructor("Alexadro", "smotrikOff", "ofidj@tu2t.by");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://youtube.com/Offydj", "Drink vhiskey");

            //associate objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start transaction
            session.beginTransaction();



            System.out.println("Saving instructor: " + tempInstructor);

            session.save(tempInstructor);


            System.out.println("Saving Instructor : " + tempInstructor);
            session.save(tempInstructor);
            session.getTransaction().commit();
        }
    }
}
