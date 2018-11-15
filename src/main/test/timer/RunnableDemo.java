package timer;

import java.util.TimerTask;

/**
 * Created by xhua on 2018-11-05.
 * Describe:
 */
public class RunnableDemo extends TimerTask{

    public RunnableDemo(int i){
        System.out.println(i);
    }

    @Override
    public void run() {

    }
}
