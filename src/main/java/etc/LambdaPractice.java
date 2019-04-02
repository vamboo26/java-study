package etc;

import java.util.List;

@FunctionalInterface
interface Comparable {
    int max(int a, int b);
}

@FunctionalInterface
interface Printable {
    void printVar(String name, int b);
}

@FunctionalInterface
interface MyFunction {
    void run();
}

public class LambdaPractice {
    public static void main(String[] args) {

        Comparable f1 = (int a, int b) -> {
            return a > b ? a : b;
        };

        Comparable f2 = (int a, int b) -> a > b ? a : b;

        Comparable f3 = (a, b) -> a > b ? a : b;

        System.out.println(f1.max(3,5));
        System.out.println(f2.max(3,5));
        System.out.println(f3.max(3,5));

        Printable p1 = (String name, int i) -> {
            System.out.println(name + "=" + i);
        };

        Printable p2 = (name, i) -> {
            System.out.println(name + "=" + i);
        };

        Printable p3 = (name, i) -> System.out.println(name + "=" + i);

        p1.printVar("name", 5);
        p2.printVar("name", 5);
        p3.printVar("name", 5);


        MyFunction mf1 = () -> System.out.println("f1.run()");
        MyFunction mf2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };
        MyFunction mf3 = getMyFunction();

        mf1.run();
        mf2.run();
        mf3.run();

        excute(mf1);
        excute(mf2);
        excute(mf3);
        excute(() -> System.out.println("nameless mf.run()"));
        excute(() -> System.out.println("other nameless mf.run()"));
        excute(() -> System.out.println("another nameless mf.run()"));


        //람다식의 타입과 형변환

        MyFunction nf = () -> {};  //앞에 (MyFunction) 형변환 생략돼있음
        Object obj = (MyFunction) (() -> {});
        String str = ((Object)(MyFunction) (() -> {})).toString();

        System.out.println(nf);
        System.out.println(obj);
        System.out.println(str);

//        System.out.println(()->{}); 불가능
        System.out.println((MyFunction)(()->{})); //가능
//        System.out.println((MyFunction)(()->{}).toString()); 불가능
        System.out.println(((Object)(MyFunction)(()->{})).toString()); //가능

        //람다식 -> 함수형 인터페이스 -> Object타입
        //람다식 자체를 바로 Object타입으로 형변환 할 수 없다
        //함수형 인터페이스 자체를 바로 .toString() 할 수 없다 (Object타입 상속받지 않았기 때문에?)
    }


    static void excute(MyFunction f) {
        f.run();
    }

    static MyFunction getMyFunction() {
        return () -> System.out.println("f3.run()");
    }
}










class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        inner.method(100);
    }
}

class Outer {
    int val = 10;

    class Inner {
        int val = 20;

        void method(int i) {
            int val = 30;
//            i = 10; (람다식에서 참조하는 지역변수는 final로 간주되기 때문에 변경하면 람다식에서 오류가 난다.)

            MyFunction f = () -> {
                System.out.println("i : " + i);
                System.out.println("val : " + val);
                System.out.println("inner val : " + ++this.val);
                System.out.println("outer val : " + ++Outer.this.val);
            };

            f.run();
        }
    }
}










class LambdaExCodesquad {

    // 코드스쿼드에서 했던 예제

    @FunctionalInterface
    interface Sumable {
        //왜 Integer를 인자로 받을까? int면...?
        boolean isTrue(Integer number);
    }

    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

//		for문도 중복이다. for문을 가지고 있는 forEach메서드 + 람다 사용
//		numbers.forEach(System.out::println);
//		람다는 메서드의 인자와 body 사이에 ->

//        numbers.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

//        numbers.forEach((Integer integer) -> {
//                    System.out.println(integer);
//                }
//        );

//        numbers.forEach(integer -> {
//                    System.out.println(integer);
//                }
//        );

//        numbers.forEach(integer -> System.out.println(integer));

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
    }

    private static int sum(List<Integer> numbers, Sumable sumable) {
        int total = 0;
        for (int number : numbers) {
            if (sumable.isTrue(number)) {
                total += number;
            }
        }
        return total;
    }

    public static int sumAll(List<Integer> numbers) {
//        int total = 0;
//        for (int number : numbers) {
//            if (true) {
//                total += number;
//            }
//        }

//        return sum(numbers, new Sumable() {
//            @Override
//            public boolean isTrue(Integer number) {
//                return true;
//            }
//        });

        return sum(numbers, number -> true);
    }


    public static int sumAllEven(List<Integer> numbers) {
//        int total = 0;
//        for (int number : numbers) {
//            if (number % 2 == 0) {
//                total += number;
//            }
//        }
//        return total;
//
//
        return sum(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
//        int total = 0;
//        for (int number : numbers) {
//            if (number > 3) {
//                total += number;
//            }
//        }
//        return total;
//    }
//
        return sum(numbers, number -> number > 3);
    }
}


