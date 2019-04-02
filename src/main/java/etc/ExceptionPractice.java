package etc;

public class ExceptionPractice {
    public static void main(String[] args) {
        System.out.println(hello());
    }

    public static String hello() {
        System.out.println("123");

        try {
            System.out.println("try문 시작");
            return "try hello";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally문 시작");
        }

        return "finally hello";

    }
}
