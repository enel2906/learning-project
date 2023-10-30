package org.example.app.thread.user;
import org.example.app.util.Util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Test extends  Thread{
    private static long x;

    public void run(){
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Util.sleep(10000);
        LocalDateTime localDateTime2 = LocalDateTime.now();
        Duration duration = Duration.between(localDateTime1, localDateTime2);

        x = duration.getSeconds();
        System.out.println(x);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();

    }
}
