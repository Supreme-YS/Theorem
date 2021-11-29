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

```java
package ch8;

public class Ex8_6 {
    public static void main(String[] args) {
        try {
            Exception e = new Exception("고의로 발생시킨 에러");
            throw e; // 예외를 발생시킴
        } catch (Exception e) {
            System.out.println("에러 메세지 : " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료");

        // Exception 인스턴스를 생성할 때, 생성자에 String을 넣어주면
        // String이 Exception 인스턴스 메시지로 저장된다.
    }
}

```

```java
package ch8;

public class Ex8_7 {
    public static void main(String[] args) {
        throw new Exception(); // Exception을 고의로 발생
        // 하지만 컴파일이 안됨. 그 이유는 Exception 클래스와 그 자손들이 발생한 가능성이 있는 문장들에 대해 예외처리를 해줘야 하기 떄문이다.
    }
}
```

```java
package ch8;

public class Ex8_8 {
    public static void main(String[] args) {
        throw new RuntimeException(); // RuntimeException을 고의로 발생
        // RuntimeException클래스와 그 자손에 해당되는 예외는 프로그래머가 실수로 발생하는 것이기 때문에
        // 예외처리를 강조하지 않는 것
    }
}
```

> 메서드에 예외 선언하기

```java
void method() throws Exception1, Exception2, ...ExceptionN {
	메서드 내용
}
```

```java
package ch8;

public class Ex8_9 {
    public static void main(String[] args) throws Exception {
        method1(); // 같은 클래스내의 static 멤버 이므로 객체 생성없이 직접 호출가능
    }

    static void method1() throws Exception {
        method2();
    }

    static void method2() throws Exception {
        throw new Exception();
    }
}

```

```java
	Exception in thread "main" java.lang.Exception
	at ch8.Ex8_9.method2(Ex8_9.java:12)
	at ch8.Ex8_9.method1(Ex8_9.java:8)
	at ch8.Ex8_9.main(Ex8_9.java:5)
```

- 예외가 발생했을 때, 모두 3개의 메서드가 호출 스택에 있었고,
- 예외가 발생한 곳은 제일 위줄에 있는 method2() 라는 것
- Main 메서드가 method1()을, 그리고 method1()은 method2()를 호출했다는 것을 알 수 있다.
- 즉, 메서드에서 예외를 처리하지 않고 넘겨줄 수 있지만, 예외가 처리된 것이 아닌 단순 전달인 것.. 어느 한 곳에서는 try-catch문으로 예외처리를 해주어야 한다.

```java
package ch8;

import java.io.*;

public class Ex8_10 {
    public static void main(String[] args) {

        try {
            File f = createFile(args[0]);
            System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 다시 입력 해주세요.");
        }
    }

    static File createFile(String fileName) throws Exception {
        if (fileName == null || fileName.equals("")) throw new Exception("파일 이름이 유효하지 않습니다.");
        File f = new File(fileName); // File 클래스의 객체를 만든다.
        // File 객체의 createNewFile 메서드를 이용해서 실제 파일을 생성한다.
        f.createNewFile();
        return f;
    }
}
```

- createFile()에 예외 선언 -> 예외는 main()으로 전달 -> main의 try-catch문에 의해 처리
- 만약에 createFile()에서 try-catch문을 넣으면 main은 예외가 발생한지도 모른다.

> Finally 키워드

```java
try {
  // 예외가 발생할 가능성이 있는 문장 삽입
} catch (Exception1 e1) {
  // 예외 처리를 위한 문장 적기
} finally {
  // 예외의 발생여부에 관계없이 항상 수행되어야 하는 문장 삽입
  // finally 블럭은 try-catch 문의 맨 마지막에 위치해야 한다.
}
```

> 사용자 정의 예외 만들기

```java
class MyException extends Exception {
  MyException(String msg) { // 문자열을 매개로 받는 생성자
    super(msg); // 조상인 Exception클래스의 생성자를 호출한다.
  }
}
```

