import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
                 Session session = factory.openSession()) {


            //get the insructor from db
            int theId=1;
            Instructor tempInstructor=session.get(Instructor.class, theId);


            //create some courses
 //           Course tempCourse1 = new Course("Drink beer, dark and light");
        //    Course tempCourse2 = new Course("Table tennis also good");

            //add courses to instructor
      //      tempInstructor.add(tempCourse1);
       //     tempInstructor.add(tempCourse2);
            //save the courses
         //   session.save(tempCourse1);
         //   session.save(tempCourse2);
            //start transaction
            session.beginTransaction();

            //commit transaction
            session.getTransaction().commit();
        }
    }
}
