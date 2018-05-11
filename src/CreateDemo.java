import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
             Session session = factory.openSession()) {

//Instructor tempInstructor1 = new Instructor("Alexander", "Offych", "off1@gmail.by");
//InstructorDetail tempInstructorDetail1 = new InstructorDetail(
//"http://youtube.com/Poffych", "Alchogol");

//            create the Objects
            Instructor tempInstructor = new Instructor("Alexader", "sOff", "of1f@tu2t.by");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://youtube.com/pOffych", "Table Tennis2");

            //associate objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);
      //      tempInstructor1.setInstructorDetail(tempInstructorDetail1);

            //start transaction
            session.beginTransaction();


            //Save the Instructor , it will ALSO save the details object
            //because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);

            session.save(tempInstructor);

            //because of CascadeType.ALL
            System.out.println("Saving Instructor : " + tempInstructor);
            session.save(tempInstructor);
            session.getTransaction().commit();
        }
    }
}
