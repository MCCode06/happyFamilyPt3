public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.finalizer();

        human = null;
        System.gc();
    }
}
