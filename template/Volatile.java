public class Volatile {

    private volatile int volatileCount = 0;
    private int count = 0;

    public static void main(String[] args) {

        Volatile volatileTest = new Volatile();

        volatileTest.increase();
        volatileTest.decrease();

    }

    private void decrease() {
        this.count--;
    }

    private void increase() {
        this.volatileCount++;
    }
}
