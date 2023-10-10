package org.example.test;

public class MyRunnable implements Runnable {
    private int counter;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (this) {
                counter++;
                System.out.println("Luồng " + Thread.currentThread().getId() + " - Giá trị counter: " + counter);
            }
            try {
                Thread.sleep(1000); // Dừng 1 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        // Tạo một đối tượng của lớp triển khai Runnable
        Runnable myRunnable = new MyRunnable();

        // Tạo và khởi chạy các luồng
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);

        thread1.start();
        thread2.start();
    }
}