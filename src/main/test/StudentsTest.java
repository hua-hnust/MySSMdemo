import model.Students;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentsService;

/**
 * Created by hua on 2018-03-20.
 * Describe:
 */
public class StudentsTest {
   @Autowired
    private StudentsService studentsService;

    @Before
    public void ac() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        studentsService = (StudentsService) applicationContext.getBean("studentsService");
        System.out.println(studentsService.toString());
        System.out.println("--------------------测试----------------------");
    }

    @Test
    public void test(){
     //   ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("-----------------查询-------------------");
          Students students = studentsService.getStudentsByName("小丽");

        System.out.println(students.getName());
        System.out.println(students.getAge());
        System.out.println(students.getSex());

    }

}
