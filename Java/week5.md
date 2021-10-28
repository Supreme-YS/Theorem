### 목표

자바의 Class에 대해 학습하세요.

### 학습할 것

* 클래스 정의하는 방법
* 객체 만드는 방법 (new 키워드 이해하기)
* 메소드 정의하는 방법
* 생성자 정의하는 방법
* this 키워드 이해하기

### 과제

- int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
- int value, Node left, right를 가지고 있어야 합니다.
- BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.
- DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.



1. 클래스 정의하는 방법

   자바에서 클래스란 객체를 정의하는 틀 또는 설계도라고 한다. 자바에서는 이러한 설계도인 클래스를 기반으로 여러 객체를 생성하여 사용하게 된다. 클래스는 객체의 상태를 나타내는 필드(field)와 객체의 행위를 나타내는 메서드(method)로 구성이 된다.

   * 필드 : 객체지향 개념에서 속성에 해당하는 것으로 멤버 변수라고도 한다.

     ```java
     /* 한정자 / 자료형 / 변수명 */
     private String name; 
     ```

   - 메서드 : 객체지향 개념에서 행위에 해당하는 것으로, 클래스를 사용하여 실행하는 동작이다. 

     ```java
     /* 한정자 / 리턴값 / 함수명(매개변수..) */
     public int add(int a, int b) {
       return a + b;
     }
     ```

2. 객체 만드는 방법 (new 키워드 이해하기)

   클래스를 이용하여 객체를 생성하게 되는데, 객체를 new 키워드로 할당하게 되면 인스턴스가 생성되어진다. 인스턴스가 생성이 됐다는 말은 메모리에 올라간 상태이다.

   ```java
   /* 클래스 / 참조변수 / 생성자 */
   Student student = new Student();
   ```

   생성자는 클래스나 인스턴스를 생성할 때 호출하는 특수한 목적의 메서드이다. 일반적으로 변수를 초기화하거나 필요한 다른 개체를 생성하는 작업을 처리한다. new 키워드를 사용하여 객체를 생성하는 시점에 호출되며, 클래스는 하나 이상의 생성자를 가질 수 있다.

   ```java
   public class Test {
       public static void main(String[] args) {
           Car car = new Car(); // new 키워드를 통해 객체를 생성
           car.carName = "911";
           car.carBrand = "Porche";
           car.carHp = 1000;
           
           car.car_info();
       }
   }
   
   class Car {
       String carName;
       String carBrand;
       int carHp;
   
       public void car_info() {
           System.out.println(carName);
           System.out.println(carBrand);
           System.out.println(carHp);
       }
   }
   ```

3. 메서드를 정의하는 방법

   return 타입 -> void (없음) 이거나 return 할 타입

   ```접근지정자 return타입 method 명(Parameter타입 parameter이름)```

   ```java
   public class Test {
       public static void main(String[] args) {
           Car car = new Car();
           car.setCarName("911");
           car.setCarBrand("Porche");
           car.setCarHp(1000);
           car.car_info();
       }
   }
   
   class Car {
       private String carName;
       private String carBrand;
       private int carHp;
   
       // private 접근 지정자는 외부에서 값을 넣어줄 수 없기 때문에
       // setter 메서드를 생성하여 외부에서 값을 넣어줄 수 있게 만든다.
       public void setCarName(String carName) {
           this.carName = carName;
       }
   
       public void setCarBrand(String carBrand) {
           this.carBrand = carBrand;
       }
   
       public void setCarHp(int carHp) {
           this.carHp = carHp;
       }
   
       public void car_info() {
           System.out.println(carName);
           System.out.println(carBrand);
           System.out.println(carHp);
       }
   }
   ```

4. 생성자 정의하는 방법

   private 접근 지정자로 설정하면 무조건 setter 메서드를 만들어서 초기 값을 세팅해야 하는 것은 아니다. 생성자를 통해 초기값을 세팅할 수 있다.

   ```java
   public class Test {
       public static void main(String[] args) {
           Car car = new Car("911", "Porche", 1000);
       }
   }
   
   class Car {
   
       public Car() {
           System.out.println("기본 생성자");
       }
   
       public Car(String carName, String carBrand, int carHp) {
           carName = carName;
           carBrand = carBrand;
           carHp = carHp;
   
           System.out.println(carName);
           System.out.println(carBrand);
           System.out.println(carHp);
       }
   }
   ```

   **오버로딩이란** 다음과 같다.

   오버 로딩(Overloading)은 메서드의 이름은 하나만 주고 매개변수(parameter)를 다르게 함으로써 메서드를 여러 개 만드는 것을 말한다. 오버 로딩(Overloading) 메서드의 구별은 매개변수의 개수 및 매개변수의 데이터 타입으로 구분한다. 메서드의 리턴 타입은 구분하지 않는다.

5. this 키워드 이해하기

   this는 객체 자신을 의미한다. this는 생략이 가능하며 생성자와 메서드에서 받는 매개변수 이름과 class 내부의 필드와 동일한 경우 어떤 필드가 class의 필드인지 명시하기 위해 사용한다. 