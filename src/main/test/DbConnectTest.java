import com.mchange.v2.c3p0.util.IsValidOnlyConnectionTester;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by hua on 2018-07-03.
 * Describe:
 */
public class DbConnectTest extends IsValidOnlyConnectionTester{

    @Test
    public void dbConnectTest(){
        ArrayList list = new ArrayList();
//        list.forEach();

    }

    @Override
    protected int getIsValidTimeout() {
        return 30;
    }



}
