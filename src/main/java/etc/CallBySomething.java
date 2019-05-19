package etc;

import org.junit.Test;

import java.util.Objects;

public class CallBySomething {

    /*
    기본 자료형 변수는 저장하고 있는 값을 그 '값 자체'로 판단하고,
    참조 변수는 저장하고 있는 값을 '주소'로 판단한다고 이해해보자

    However, Objects are not passed by reference.
    A correct statement would be 'Object references' are passed by value.

    Java works exactly like C. You can assign a pointer, pass the pointer to a method, follow the pointer in the method and change the data that was pointed to.
    However, you cannot change where that pointer points.

    전달되는 참조변수는 참조변수의 주소값을 값으로 전달한다
    그래서 그 주소값을 기반으로 해당 주소 Object의 상태를 변경할 수 있지만,
    주소값을 새로운 주소값으로 대치한다고 해서 Object가 다시 새로운 주소를 참조하는 것은 아님

     */

    @Test
    public void test(){
        int a = 10;
        int b = a;

        System.out.println(a);
        System.out.println(b);

        a = 20;

        System.out.println(a);
        System.out.println(b);

        b = 30;

        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test2() {
        Person a = new Person();
        Person b = a;
//
//        System.out.println(a);
//        System.out.println(b);

//        a.age = 50;
//
//        System.out.println(a.age);
//        System.out.println(b.age);
//
//        a.age = 10;
//        b.age = 20;
//
//        System.out.println(a.age);
//        System.out.println(b.age);
//
//        System.out.println("--------------------");
//        a = new Person();
//
//        System.out.println(a);
//        System.out.println(b);
//
//        System.out.println("--------------------");
//        System.out.println("메소드 호출 전 : " + b);
//        changePerson(b);
//
//        System.out.println("메소드 호출 후 : " + b);
//
//        System.out.println("--------------------");
//        System.out.println("메소드 호출 전 : " + a.age);
//        changeAge(a);
//
//        System.out.println("메소드 호출 후 : " + a.age);


//        Person sam = new Person();
//        sam.age = 29;
//        changeAge(sam);
//
//        System.out.println(sam.age);

        Person sam = new Person();
        System.out.println(sam);

        changePerson(sam);

        System.out.println(sam);


    }

    private void changePerson(Person p) {
        p = new Person();
    }

    private void changeAge(Person p) {
        p.age = 30;
    }

    private class Person {
        private int age;

    }

}
