### 목표

자바의 인터페이스 학습하기

### 학습할 것

인터페이스 정의하는 방법

인터페이스 구현하는 방법

인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

인터페이스 상속

인터페이스의 기본 메소드 (Default Method), 자바 8

인터페이스의 static 메소드, 자바 8

인터페이스의 private 메소드, 자바 9



1. 인터페이스 정의하는 방법

인터페이스를 작성하는 것은 클래스를 작성하는 것과 같다. 키워드로 interface를 사용한다.

```java
interface 인터페이스_명 {
  public static final 타입 상수명 = 값;
  public abstract 메서드명(매개변수);
}
```

인터페이스 멤버들은 제약사항이 있다.

- 모든 멤버 변수는 ```public static final``` 이어야 하며, 이를 생략할 수 있다.

- 모든 메서드는 ```public abstract``` 이어야 하며, 이를 생략할 수 있다.

- 인터페이스 vs 추상 클래스

- | 추상 클래스              | 인터페이스                |
  | ------------------------ | ------------------------- |
  | 일반 메소드 포함 가능    | 모든 메서드는 추상 메서드 |
  | 다중상속 불가능          | 다중상속 가능             |
  | 상수, 변수 필드 포함가능 | 상수필드만 포함가능       |


2. 인터페이스 구현하는 방법

인터페이스 그 자체로는 인스턴스를 생성할 수 없으며, 추상 클래스가 상속을 통해 추상메서드를 완성하는 것처럼 인터페이스를 구현해주는 클래스를 생성하여 추상 메소드를 구현하여 사용할 수 있다.

```java
public class Hyundai implements Car {
  @Override
  public void move(){
    // 구현코드
  }
  
  @Override
  public void stop(){
    // 구현코드
  }
}
```

3. 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

인터페이스 타입의 참조 변수로 이를 구현한 클래스의 인스턴스를 참조할 수 있으며, 인터페이스 타입으로의 형변환도 가능하다.

```java
interface Car {
		// 소스코드
}

class Hyundai implements Car {
  // 구현코드
}

class Kia implements Car {
  // 구현코드
}

class Tesla implements Car {
  // 구현코드
}

public class Main {
  public static void main(String[] args) {
    Car Hyundai = new Hyundai(); // 인터페이스 타입
    Car Kia = new Kia();
    Car Tesla = new Tesla();
    
    Car[] cars = new Car[3];
    cars[0] = hyundai;
    cars[1] = kia;
    cars[2] = tesla;
  }
}
```

이를 이용하여 서버 쪽의 변경 가능성이 있는 코드가 있더라도 해당 코드를 인터페이스 타입으로 선언하면 클라이언트의 코드에는 영향을 주지 않고 서버 쪽에서 구현체만 바꿔주면 되기 때문에 효율적으로 프로그램을 작성할 수 있다.