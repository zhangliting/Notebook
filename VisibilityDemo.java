public class VisibilityDemo {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //并不能使runner线程退出，因为可见性问题，就像是缓存。
        //主线程写入的quit值并不能立刻被子线程可见。

        runner.shutdown();
        System.out.println("Shut down!");
    }
}

class Runner extends Thread{
    //volatile 可以解决可见性问题。
    private boolean quit = false;

    @Override
    public void run() {
        while(!quit){
//            System.out.println("------working-----");
        }
        System.out.println("Done!");
    }

    public void shutdown(){
        quit = true;
    }
}


