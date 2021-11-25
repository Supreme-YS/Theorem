목표

자바의 예외 처리에 대해 학습하세요.

학습할 것 (필수)

- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바가 제공하는 예외 계층 구조
- Exception과 Error의 차이는?
- RuntimeException과 RE가 아닌 것의 차이는?
- 커스텀한 예외 만드는 방법

------

자바의 정석을 기반으로 한 예외처리 학습

------

- 컴파일 에러 : 컴파일 할 때 발생하는 에러, 자바 컴파일러가 실행될 때 발생하는 에러, 실행할 수 없음

- 런타임 에러 : 실행할 때 발생하는 에러, 실행은 되나 프로그램이 죽는 경우
- 논리적 에러 : 작성 의도와 다르게 동작, 잘 동작은 하나 의도대로 동작하지 않는 경우 

------

> Java의 런타임 에러 종류 2 가지

- 에러는 어쩔 수 없지만, 예외는 처리하자!

> > Error 와 Exception의 차이 
>
> > 에러 (error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류 예) OutOfMemory
> >
> > 예외 (Exception) : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류

* 예외처리의 정의 : 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것
* 예외처리의 목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것

------

> 예외 클래스의 계층 구조

> Object
>
> > Throwable
> >
> > > Exception : 미약한 오류, 처리가 가능한 오류
> > >
> > > > RuntimeException
> > > >
> > > > IOException
> > > >
> > > > ....
> > >
> > > Error : 심각한 오류, 코드로 처리할 수 없는 심각한 오류
> > >
> > > > ....
> > > >
> > > > OutOfMemoryError

* Exception과 그 자손들(클래스들) : 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외 예) IOException, ClassNotFoundException..
* RuntimeException과 그 자손들(클래스들) : 프로그래머의 실수로 발생하는 예외 예) ArithmeticException, NullPointerException, IndexOutOfBoundsException..

------

> 자바에서 예외 처리 방법

```java
try{
  // 예외가 발생할 가능성이 있는 문장들을 넣는다.
} catch (Exception1 e1) {
  // Exception1이 발생했을 경우, 이를 처리하기 위한 문장들을 넣는다.
} catch (Exception2 e2) {
  // Exception2이 발생했을 경우, 이를 처리하기 위한 문장들을 넣는다.
} catch (ExceptionN eN) {
  // ExceptionN이 발생했을 경우, 이를 처리하기 위한 문장들을 넣는다.
}   // catch 블록은 여러개 삽입이 가능하다.
```

- try-catch 문에서의 흐름

> Try 블럭 내에서 예외가 발생한 경우

1. 발생한 예외와 일치하는 catch 블럭이 있는지 확인
2. 일치하는 catch 블럭을 찾게 되면, 그 catch 블럭 내의 문장들을 수행 후, 전체 try-catch문을 빠져나가서 그 다음 문장을 계속해서 수행한다. 만일, 일치하는 catch 블럭을 찾지 못하면, 예외는 처리되지 못한다.

> Try 블럭 내에서 예외가 발생하지 않는 경우

1. Catch 블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.

```java
package ch8;

public class Ex8_1 {
    public static void main(String args[]) {
        System.out.println(1);
        try {
            System.out.println(2);
            System.out.println(3);
        } catch (Exception e)    { // 에러 발생하지 않음
            System.out.println(4); // 내부 구문이 실행되지 않음
        }
        System.out.println(5);
        // 1
        // 2
        // 3
        // 5 출력!
    }
}
```

```java
package ch8;

public class Ex8_2 {
    public static void main(String args[]) {
        System.out.println(1);
        try {
            System.out.println(0/0); // ArithmeticException 에러! 0으로 나눌 수 없음.
            System.out.println(2); 	// 실행되지 않는다.
        } catch (ArithmeticException ae) { // 에러 발생했으니 catch문 실행
            System.out.println(3);
        }	// try-catch의 끝
        System.out.println(4);
    }	// main메서드의 끝
    // 1
    // 3
    // 4 출력!
}
```

```java
package ch8;

public class Ex8_4 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0/0); // ArithmeticException 에러 발생
            System.out.println(4);
        } catch (ArithmeticException ae) {
            if (ae instanceof ArithmeticException) { // ae 참조 변수가 ArithmeticException의 객체인지 확인 true 값 반환
                System.out.println("true");
                System.out.println("ArithmeticException");
            }
        } catch (Exception e) {
            System.out.println("Exception");
        } // try-catch의 끝
        System.out.println(6);
    } // main 메서드의 끝
    /**
     * 1
     * 2
     * 3
     * true
     * ArithmeticException
     * 6
     */
}
```

```java
package ch8;

public class Ex8_5 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0/0); // 예외발생!!!
            System.out.println(4);   // 실행되지 않는다.
        } catch (ArithmeticException ae)	{
            ae.printStackTrace();
            System.out.println("예외메시지 : " + ae.getMessage());
        }	// try-catch의 끝

        System.out.println(6);
    }	// main메서드의 끝
}
```

