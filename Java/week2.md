### 목표

- 자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법

### 학습내용

- 프리미티브 타입 종류와 값의 범위 그리고 기본 값
- 프리미티브 타입과 레퍼런스 타입
- 리터럴
- 변수 선언 및 초기화하는 방법
- 변수의 스코프와 라이프타임
- 타입 변환, 캐스팅 그리고 타입 프로모션
- 1차 및 2차 배열 선언하기
- 타입 추론, var

1. 프리미티브 타입 종류와 값의 범위 그리고 기본 값
   기본형에는 모두 8개의 자료형(타입)이 있으며, 크게 논리형, 문자형, 정수형, 실수형 4가지로 구분된다.

   - 논리형 - True / False 중 하나를 값으로 가지며, 조건식과 논리적 계산에 활용한다.

   - 문자형 - 문자를 저장하는데 사용하며, 변수 당 하나의 문자만 저장할 수 있다.

   - 정수형 - 정수의 값을 저장하는데 사용된다. 주로 int와 long을 사용/ byte는 이진데이터를 다루는데 사용/ short는 C언어와의 호환을 위해 추가

   - 실수형 - 실수의 값을 저장하는데 사용된다. float와 double 두 가지가 존재한다.
     4개의 정수형(byte, short, int, long)중에서 int형이 기본(default) 자료형(data type)이며, 실수형(float, double) 중에서는 double이 기본 자료형

   - | 종류/크기 | 1 byte  | 2 byte | 4 byte  | 8 byte     |
     | :-------: | ------- | ------ | ------- | ---------- |
     |           |         |        |         |            |
     |  논리형   | Boolean |        |         |            |
     |  문자형   |         | Char   |         |            |
     |  정수형   | Byte    | Short  | **Int** | Long       |
     |  실수형   |         |        | Float   | **Double** |

2. 프리미티브 타입과 레퍼런스 타입
   프리미티브 타입(기본형 타입)

   - 총 8가지 기본형 타입을 미리 정의하여 제공한다.
   - 기본값이 있기 때문에 Null값을 제공하지 않는다. 만약 기본형 타입에 Null 값을 넣고 싶다면 **래퍼 클래스**를 활용한다. 
   - 실제 값을 저장하는 공간으로 **스택(Stack) 메모리**에 저장된다.
   - 만약 컴파일 시점에 담을 수 있는 크기를 벗어나면 에러를 발생시키는 <u>컴파일 에러</u>가 발생한다.

   레퍼런스 타입(참조형 타입)

   - 기본형 타입을 제외한 타입이 모두 참조형 타입이다.
   - 빈 객체를 의미하는 Null이 존재한다.
   - 값이 저장되어 있는 곳의 주소값을 저장하는 공간으로 **힙(Heap) 메모리**에 저장된다.
   - 문법상으로는 에러가 없지만 실행시켰을 때 에러가 나는 <u>런타입 에러</u>가 발생한다.

3. 리터럴

   - 그 자체로 데이터인 것을 '리터럴(literal)'이라고 한다. 예를 들어 'A', "ABC", 123은 리터럴이다. 
   - 리터럴은 상수(constant)와 의미가 같지만, **프로그래밍에서는 상수**를 '**값을 한 번 지정하면 변경할 수 없는 저장공간'으로 정의**하기 때문에 이와 구분하기 위해 '리터럴'이라는 용어를 사용한다.
   - Long 타입의 리터럴에는 접미사 'L' 또는 'l'을 반드시 붙여야한다. 리터럴에 접미사가 붙어있지 않으면 int 타입으로 간주한다. Float형 리터럴에는 접미사 f가 사용되고, double형 리터럴에는 d가 사용된다.
   - 정수형에서는 int가 기본 자료형인 것처럼 실수형에서는 double이 기본 자료형이다. 그래서 접미사를 생략하면 double형 리터럴로 간주된다.

4. 변수 선언 및 초기화하는 방법

   - 변수를 사용하기 위해서는 먼저 변수를 선언해야 한다. 변수가 선언되면 메모리에 변수의 타입에 알맞은 크기의 저장공간이 확보되고, 값을 저장할 준비가 되는 것이다.

     ```java
     /* 변수타입 변수이름; */
     int number; // 정수형 변수 number를 선언한다.
     ```

   - 변수를 선언할 때는 변수의 타입과 이름을 함께 써주어야 한다. 변수타입은 변수에 담을 값의 종류와 범위를 충분히 고려하여 결정해야 한다.

   - 변수를 선언한 후부터는 변수를 사용할 수 있으며, 변수를 사용하기에 앞서 적절한 값을 저장해주는 것이 필요하다. 이것을 **<u>변수의 초기화</u>**라고 한다.

     ```java
     /* 정수형 변수 number를 선언하고 변수의 값을 10으로 초기화한다.*/
     int number = 10;
     
     /* 위와 동일한 코드 */
     int number; // 정수형 변수 number를 선언하고
     number = 10; // 변수 number에 10을 저장한다.     
     ```

5. 변수의 스코프와 라이프타임

   - 변수의 스코프 : 프로그램에서 사용되는 변수는 사용 가능한 범위를 가진다. 그 범위를 변수의 스코프라고 한다. 변수가 선언된 블럭이 그 변수의 사용 범위이다.

     ```java
     public class ValableScopeTest{
       int globalScope = 10; // 인스턴스 변수
       public void scopeTest(int value){
         int localScope = 10;
       }
     }
     ```

     클래스의 속성으로 선언된 변수 globalScope의 사용 범위는 클래스 전체이다.

     매개변수로 선언된 int value는 블럭 바깥에 존재하지만, 메서드 선언부에 존재하므로 사용범위는 해당 메서드 블럭 내이다. 메서드 블럭 내에서 선언된 localScope 변수의 사용범위는 메서드 블럭 내이다. 

   - 라이프타임
     - 전역 변수 - 클래스 내의 모든 영역에서 사용 가능한 변수로 클래스 변수와 인스턴스 변수로 나뉜다.
     - 클래스 변수 - 정적 변수라고 부르며, 프로그램이 실행될 때 클래스와 함께 메모리에 로드되는 변수로 프로그램 종료시 삭제 된다.
     - 인스턴스 변수 - 객체를 생성함에 따라 각각의 인스턴스마다 변수의 복사본을 가질 수 있는 변수이며, 객체가 소멸되기 전까지 존재한다.
     - 지역 변수 - 메서드, 반복문, 생성자 등에서 선언된 변수로 해당 영역 내에서 사용 가능한 변수로, 해당 범위를 벗어날 경우 사용 불가능하다.

6. 타입 변환, 캐스팅 그리고 타입 프로모션
   타입 변환 (명시적 형변환, 캐스팅)
   변수 또는 리터럴의 타입을 다른 타입으로 변환하는 것이다.

   - 형변환 방법 : 기본형과 참조형 모두 형변환이 가능하지만, 기본형가 참조형 사이에는 형변환이 성립되지 않는다. 기본형은 기본형으로만 참조형은 참조형으로만 형변환이 가능하다. 형변환 방법은 매우 간단한데, 형변환하고자 하는 변수나 리터럴 앞에 변환하고자하는 타입을 괄호와 함께 붙여주기만 하면 된다.

     ```java
     int score = (int) 92.4; // double형 값을 int형으로 변환하여 scoredp 85가 저장된다.
     byte b = (byte) score; // score에 저장된 값을 byte형으로 변환하고 b에 저장된다.
     ```

   - 타입 프로모션 (자동 형변환)
     원칙적으로는 모든 형변환에 캐스트연산자를 이용한 형변환이 이루어져야하지만, 값의 표현범위가 작은 자료형에서 큰 자료형의 변환은 값의 손실이 없으므로 캐스트 연산자를 생략하는 것을 허용한다. 생략한다고 해서 형변환이 이루어지지 않는 것은 아니며, 캐스트 연산자를 생략한 경우에도 JVM의 내부에서 자동적으로 형변환이 수행된다.
   - 기본형의 자동 형변환이 가능한 방향
     byte -> short, char -> int -> long -> float -> double
     화살표방향으로의 변환, 즉 왼쪽에서 오른쪽으로의 변환은 캐스트 연산자를 사용하지 않아도 자동 형변환이 되며, 그 반대 방향으로의 변환은 반드시 캐스트 연산자를 이용한 형변환을 해야 한다.

7. 1차 및 2차 배열 선언하기
   원하는 타입의 변수를 선언하고 변수 또는 타입에 배열임을 의미하는 대괄호[]를 붙이면 된다. 대괄호[]는 타입 타입 뒤에 붙여도 되고 변수이름 뒤에 붙여도 되지만 가능하면 대괄호[]를 타입의 뒤에 붙이도록 하자.

   ```java
   /* 1차원 배열 */
   int[] score = new int[5]; // 5개의 int 값을 저장할 수 있는 배열을 생성한다.
   
   /* 2차원 배열 */
   int[][] score = new int[5][3]; // 5행 3열의 2차원 배열을 생성한다.
   ```

8. 타입 추론, var
   타입이 정해지지 않은 변수의 타입을 컴파일러가 유추하는 기능. 자바에서는 일반 변수에 대해 타입 추론을 지원하지 않기 때문에 자바에서의 타입 추론은 제네릭과 람다에 대한 타입 추론을 말한다.

   ```java
   // Java 5 : 제네릭 메서드 타입 추론
   List<String> list = Collections.<String>emptyList();
    
   // Java 7 : 다이아몬드 연산자(<>)
   Map<String, List<String>> map = new HashMap<String,List<String>>();
    
   // Java 8 : 람다식 인자 타입
   Predicate<String> predicate = (String x) -> x.length() > 0;
   ```

   자바10 에서 var를 도입하여 암시적 타이핑을 지원하게 되었다. var는 keyword(ex.abstract)가 아니라 reserved type name이라서 변수, 함수 이름으로도 사용할 수 있다. 추가로 var의 도입으로 dynamic type을 지원하는 것은 아니다. 컴파일러가 알아서 타입을 추론해서 컴파일해주는 것이다.

   ```java
   // Java 10 이전
   Map<User, List<String>> map = new HashMap<>();
    
   // Java 10
   var map = new HashMap<User, List<String>>();
   ```