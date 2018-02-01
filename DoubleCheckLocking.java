import java.util.Date;

public class DoubleCheckLocking {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(() -> {
                System.out.println(Singleton.getInstance().getDate());
            }).start();
        }
    }
}

class Singleton {
    private static volatile Singleton instance = null;
    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    private Singleton() {

    }

    //线程A创建对象后，还没有从synchronized退出来，
    //线程B执行instance != null,直接返回instance，
    //这个时候无法保证date的可见性，所以需要volatile。
    //但是volatile的代价和直接使用synchronized差不多。
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
