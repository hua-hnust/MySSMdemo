import org.junit.Test;

/**
 * Created by hua on 2018-04-12.
 * Describe:
 */
public class PathDemo {

    @Test
    public void pathDemo(){
        String path = this.getClass().getResource("/").getPath();
        String proPath = System.getProperty("user.dir");
        String str = System.getProperty("file.separator");
        System.out.println(path);
        System.out.println(proPath);
        System.out.println(str);
    }

}
