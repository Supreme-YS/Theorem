### 목표

자바의 멀티쓰레드 프로그래밍에 대해 학습하세요.

### 학습할 것

- Thread 클래스와 Runnable 인터페이스
- 쓰레드의 상태
- 쓰레드의 우선순위
- Main 쓰레드
- 동기화
- 데드락

------

🚩9주차 과제 회고

Exception을 메서드 등의 방법으로 계속 throw하다 보면 결국 main 메서드에서 처리를 해야한다. main에서 throw하면 예외를 던지고 종료가 된다. 즉, 해당 **Thread** 는 예외를 던지고 프로그램이 종료가 된다. 

------

> 프로세스

현재 실행중인 프로그램을 뜻한다. 윈도우 기준으로 ```ctrl + alt + delete```를 사용하여 작업 관리자 창에서 프로세스 탭을 확인하면 현재 실행중인 프로그램 목록을 알 수 있다.

> 쓰레드(Thread)

- 프로세스 실행의 단위.

- 하나의 프로세스는 여러개의 쓰레드로 구성이 가능하다.
- 하나의 프로세스를 구성하는 쓰레드들은 프로세스에 할당된 메모리, 자원 등을 공유한다.
- 프로세스와 같이 실행, 준비, 대기 등의 실행 상태를 가지며, 실행 상태가 변할 때마다 **쓰레드 문맥교환**을 수행한다.
- 각 쓰레드별로 자신만의 스택과 레지스터를 가진다. 

프로세스는 **운영체제로부터 자원을 할당받는 작업의 단위**이고, 쓰레드는 **프로세스가 할당받은 자원을 이용하는 실행의 단위**이다.

> 멀티태스킹

여러개의 프로세스를 동시에 실행하는 것을 의미하며, 현재 사용하는 윈도우, 맥과 같은 OS(운영체제)에서 여러 개의 프로그램을 동시에 사용할 수 있는 이유가, 멀티태스킹 환경을 지원하고 있기 때문이다.

> 멀티쓰레드

하나의 프로세스 안에 여러개의 쓰레드가 있는 상태를 멀티쓰레드라고 한다. 하나의 프로그램을 실행하기 위해서 동시다발적으로 진행되는 작업의 흐름을 멀티쓰레드라고 한다.

- 멀티 쓰레드의 장점
  - CPU의 사용률을 향상시킨다.
  - 자원을 효율적으로 사용할 수 있다.
  - 사용자에 대한 응답성이 향상된다.
  - 작업이 분리되어 코드가 간결해진다.
- 멀티 쓰레드의 단점
  - 여러 개의 쓰레드가 같은 프로세스 내에서 자원을 공유하면서 작업하기 때문에 ```동기화```,```교착상태```와 같은 문제가 발생할 확률이 높다. 

> 정리

하나의 프로세스에 여러개의 쓰레드가 있을 수 있다. 프로세스(프로그램)를 실행하기 위해서 쓰레드는 하나의 프로세스에 할당된 자원을 공유하며 작업을 진행하는데, 이때 동기화 및 교착상태 문제가 발생할 수 있다.

------

> 쓰레드 생성하기

자바에서 쓰레드를 생성하는 방법은 2가지가 있다.

- Thread 클래스 상속받기
- Runnable 인터페이스 구현

> Thread 클래스 상속받기

```java
package javastudy;


public class ThreadExample {

    public static void main(String[] args) {

        RunThread runThread = new RunThread(); // Thread 객체 생성
        runThread.start(); // start() 메서드를 호출하면 Thread가 실행된다.
        // start() 메서드는 Thread 객체의 run() 메서드를 호출한다.
    }

    // java.lang.Thread 클래스를 상속받는다.
    static class RunThread extends Thread {

        // 이 클래스에서 상위 클래스인 Thread의 run() 메서드를 상속받아 메서드를 재정의해야 실행부분을 작성할 수 있다.
        @Override
        public void run() {
            super.run();
            System.out.println("쓰레드 실행");
        }
    }
}
```

> Runnable 인터페이스 구현

```java
package javastudy;

// 인터페이스 상속
class RunThread implements Runnable {

    @Override
    public void run() {
        System.out.println("쓰레드 실행");
    }
}

public class ThreadExampleRunnable {
    public static void main(String[] args) {
        // Runnable 인터페이스를 이용해서 쓰레드를 만들 경우
        // 객체 생성시 Thread 타입으로 객체를 생성해야 한다.
        // 실제로 Runnable 인터페이스에는 run() 메서드 밖에 없는데.
        // 이 메서드를 실행케 하는게 start() 메서드가 Thread 클래스에 있기 때문이다.
        // 따라서 Thread 타입으로 객체를 생성해야 한다.
        Thread runThread = new Thread(new RunThread());
        runThread.start();
    }
}
```

> 어떤 방법을 선호하는가?

대부분의 사람들은 Runnable 인터페이스를 구현하는 방식을 선호한다. 왜냐하면 어쨌든 Thread 클래스를 상속받아서 사용해야하고, 인터페이스를 사용해서 구현체를 따로 구성한다는 거 자체가 뭔가.. DIP, OCP 등을 최대한 지키면서 프로그래밍을 할 수 있기 때문이 아닐까..?

> start(), run() 

- start() : 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택을 생성하는 것
- run()   : start()로 생성된 호출스택에 run()이 첫 번째로 저장되는 과정

main 메서드에서 쓰레드의 start() 호출 -> start() 메서드는 해당 쓰레드가 작업을 수행하는데 필요한 호출 스택을 생성 -> 생성된 호출 스택에 run() 메서드를 호출해서 쓰레드가 작업을 수행

> Thread State

| 상태      | 열거상수      | 설명                                                         |
| --------- | ------------- | ------------------------------------------------------------ |
| 객체 생성 | NEW           | 스레드 객체가 생성, 아직 start() 메서드가 호출되지 않은 상태 |
| 실행 대기 | RUNNABLE      | 실행 상태로 언제든지 갈 수 있는 상태                         |
| 일시 정지 | WAITING       | 다른 스레드가 통지할 때까지 기다리는 상태                    |
|           | TIMED_WAITING | 주어진 시간 동안 기다리는 상태                               |
|           | BLOCKED       | 사용하고자 하는 객체의 락이 풀릴 때까지 기다리는 상태        |
| 종료      | TERMINATED    | 실행을 마친 상태                                             |

Thread 클래스에서 제공하는 메서드인 getState() 메서드를 이용하면 현재 쓰레드의 상태를 알 수 있다.

- NEW : 쓰레드 객체가 생성, 아직 start() 메서드가 호출되지 않은 상태

  ```java
  package javastudy;
  
  public class ThreadStateNew {
      public static void main(String[] args) {
          Thread threadStateNewExam = new Thread(new ThreadStateNewExam());
          System.out.println(threadStateNewExam.getState());
          threadStateNewExam.start();
      }
  
      static class ThreadStateNewExam implements Runnable {
          @Override
          public void run() {
              System.out.println("NEW 상태 !");
          }
      }
      /* 출력값
      NEW
      NEW 상태 !
       */
  }
  ```

- RUNNABLE : 실행 상태로 언제든 갈 수 있는 상태

  ```java
  package javastudy;
  
  public class ThreadStateRunnable {
      public static void main(String[] args) {
          Thread threadStateRunnableExam = new Thread(new ThreadStateRunnableExam());
          System.out.println(threadStateRunnableExam.getState());
          threadStateRunnableExam.start();
          System.out.println(threadStateRunnableExam.getState());
      }
  
      static class ThreadStateRunnableExam implements Runnable {
          @Override
          public void run() {
              System.out.println("RUNNABLE 상태 !");
          }
      }
      /* 출력값
      NEW
      RUNNABLE
      RUNNABLE 상태 !
       */
  }
  ```

  > RUNNABLE이 먼저 출력된 이유는, start()를 호출하면, 실행대기열에 저장된 후 실행된다.

- WAITING : 다른 스레드가 통지할 때까지 기다리는 상태

  ```java
  
  ```

  