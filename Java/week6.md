### 목표

자바의 상속에 대해 학습하세요

### 학습할 것

- 자바 상속의 특징
- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
- 추상 클래스
- final 키워드
- Object 클래스

------

1. 자바 상속의 특징

   상속은 객체지향 프로그래밍의 핵심적인 특징 중 하나이다. 프로그래밍에서의 상속은 부모 클래스가 자신의 기능을 자식 클래스에게 물려주는 것을 말한다. 상속에는 여러 종류가 있지만 자바에서는 단일 상속만을 지원한다.

   단일 상속이란 자식 클래스가 하나의 부모클래스로부터 기능을 물려받는 것을 말한다.

   다중 상속이란 자식 클래스가 여러개의 부모클래스로부터 기능을 물려받는 것인데, C에서는 다중 상속을 지원하지만 자바에서는 지원하지 않는다. 

   자바의 상속을 선언하기 위해서 ```extends``` 키워드를 사용한다. 

   ```java
   class A {
     public void read() {...}
   }
   
   class B extends A {
     @Override
     public void read() {...}
     public void write() {...}
   }
   ```

   🚩자바 상속의 특징 요약

   | **부모 클래스는 자식 클래스에게 필드와 메소드를 모두 물려준다.** |
   | ------------------------------------------------------------ |
   | **자식 클래스의 생성자를 호출하는 경우 부모 클래스의 생성자와 초기화 블록도 같이 호출된다.** |
   | **하나의 부모 클래스가 여러개의 자식 클래스에게 상속받는 것이 가능하다.** |
   | **상속을 받은 클래스가 부모 클래스가 되어 자식 클래스에게 상속해주는 계층적 상속이 가능하다.** |

2. ```super``` 키워드

   Super 키워드는 부모 클래스를 참조할 때 사용하는 키워드이다. 5주차에서 학습한 this 키워드가 객체 자신을 나타내는 키워드였다면, super 키워드는 반대로 부모를 나타내는 키워드라 생각하면 된다.

   super 키워드는 **부모 클래스의 인스턴스 변수를 참조하는 경우, 부모 클래스의 메소드를 호출하는 경우, 부모 클래스 생성자를 호출하는 경우**에 사용된다. 이 세가지 경우를 코드로 분할하여 비교해보도록 하자

   * 부모 클래스의 인스턴스 변수를 참조하는 경우
     * 클래스 A를 상속하고 있는 클래스 B의 read() 메소드를 호출하였을 때 첫번째 출력문은 객체 자신의 read를 참조하지만 2번째 출력문은 super키워드를 통해 부모 클래스인 A의 read 변수를 참조한다.

   ```java
   class A {
     int time = 10;
     public void read() {
       System.out.println("Read");
     }
   }
   
   class B extends A {
     int time = 20;
     public void read() {
       System.out.println("B read" + time); // time = 20
       System.out.println("B read" + super.time); // time = 10
       super.read(); 
     }
   }
   ```

   * 부모 클래스의 메소드를 호출하는 경우
     * 클래스 A를 상속하고 있는 클래스 B에서 클래스 A의 read() 메소드를 호출하고 싶은 경우에 super 키워드를 이용해 호출해준다.

   ```java
   class A {
     int time = 10;
     public void read() {
       System.out.println("Read");
     }
   }
   
   class B extends A {
     int time = 20;
     public void read() {
       System.out.println("B read" + time); 
       System.out.println("B read" + super.time); 
       super.read(); // 클래스 A의 read() 메소드 출력
     }
   }
   ```

   - 부모 클래스 생성자를 호출하는 경우
     - 클래스 A를 상속하고 있는 클래스 B의 인스턴스가 생성되면 자바에서 자동으로 컴파일 시에 super()메소드를 이용해 클래스 A의 생성자 또한 호출한다.
     - 하지만, 클래스 A의 생성자가 파라미터가 있거나, 명시된 생성자라면 자식 클래스의 생성자에 super(파라미터)와 같은 형식으로 생성자를 반드시 호출해야한다.

   ```java
   class A {
     int time = 10;
     /* public A() {} */ // 명시된 생성자
     public A(int time) {
       this.time = time;
     }
     public void read() {
       System.out.println("read");
     }
   }
   
   class B extends A {
     int time = 20;
     
     // 파라미터를 갖는 생성자가 있는 경우(부모 클래스)
     public B(int time) {
       // 반드시 명시 필요
       super(time);
     }
     
     public void read() {
       System.out.println("B read"+time);
       System.out.println("B read"+super.time);
       super.read();
     }
   }
   ```

3. 메소드 오버라이딩

   메소드 오버라이딩은 부모클래스를 상속하는 자식 클래스가 부모 클래스의 메소드의 기능을 무시하고 새롭게 정의하는 것을 의미한다.

   **자식 클래스에서 오버라이딩한 메소드에서 부모 클래스의 메소드를 호출하고자 한다면 super키워드를 이용해 호출**한다.

   **부모 클래스 타입의 참조 변수를 통해 자식 클래스 타입의 인스턴스를 참조하는 경우 부모 클래스의 메소드만 호출이 가능**하다.

   

