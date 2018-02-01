public class ReorderDemo {
    public static void main(String[] args) {
        final Something obj = new Something();

        new Thread(() -> {
            obj.write();
        }).start();

        // 由于编译器优化，指令重排，可能存在x<y的情况。
        new Thread(() -> {
            obj.read();
        }).start();
    }
}

class Something {
    private int x = 0;
    private int y = 0;

    public void write() {
        x = 100;
        y = 50;
    }

    public void read() {
        System.out.println(x == y ? "x==y" : x>y? "x>y":"x<y");
    }

}
