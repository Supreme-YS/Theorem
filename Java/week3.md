### 목표

자바가 제공하는 다양한 연산자에 대한 학습

### 학습내용

- 산술 연산자
- 비트 연산자
- 관계 연산자
- 논리 연산자
- instanceof (객체 타입 확인)
- 대입 연산자 assignment(=) operator
- 화살표(->) 연산자
- 삼항 연산자
- 연산자 우선 순위
- (optional) Java 13. switch 연산자

1. 산술 연산자
   산술 연산자는 수학적인 계산에 사용되는 연산자

   "+" : 더하기 / "-" : 빼기 / "*" : 곱하기 / "/" : 나누기 / "%" : 나머지

   ```java
   class Main {
   
     public static void main(String[] args) {
         // result 의 값은 3
         int result = 1 + 2;
         System.out.println(result);
   
         // result 의 값은 2
         result = result - 1;
         System.out.println(result);
   
         // result 의 값은 4
         result = result * 2;
         System.out.println(result);
   
         // result 의 값은 2
         result = result / 2;
         System.out.println(result);
   
         // result 의 값은 10
         result = result + 8;
         // result 의 값은 3
         result = result % 7;
         System.out.println(result);
   
         String firstString = "This is";
         String secondString = " a concatenated string.";
         String thirdString = firstString+secondString;
         System.out.println(thirdString);
     }
   }
   ```

2. 비트 연산자
   비트 연산은 두 개의 이진수에 대해서 연산하는 것을 말한다. [0] [0] [1] [0] <-- 각 자리수를 공간이라고 생각하면 4개의 공간을 사용하고 있다.

   컴퓨터는 이 공간하나를 bit라고 정의해서 연산을 하고 있다. 위의 2를 표현한 이진수는 4bit로 표현했다고 말할 수 있다. 일반적으로 컴퓨터는 8bit의 공간을 기준으로 사용한다. 

   * & (AND) 연산 : 두 수의 각 자리수에 대해 둘다 1일 경우 1로 변환하는 것
   * | (OR) 연산 : 두 수의 각 자리수가 하나만 1일 경우 1로 변환하는 것
   * ^ (XOR) 연산 : 두 수의 각 자리수가 다른 경우 1로 변환하는 것
   * ~ (NOT) 연산 : 각 자리수를 반대로 변환하는 것
   * ">>, <<" (SHIFT) 연산 : 각 자리를 왼쪽(<), 오른쪽(>)으로 N칸 이동하는 연산
     * 3 << 2 (3을 2칸 좌측 shift 하라) ----> 3 * 2^2 = 12
     * 16 >> 3 (16을 3칸 우측 shift 하라) ----> 16 / 2^3 = 2

3. 관계 연산자
   관계 연산자의 결과값은 True / False 와 같은 boolean 자료형으로 반환된다. 

   | 연산자 | 기능                                                         | 연산 예   |
   | ------ | ------------------------------------------------------------ | --------- |
   | ">"    | 왼쪽 항이 크면 참을, 아니면 거짓을 반환                      | num > 3;  |
   | "<"    | 왼쪽 항이 작으면 참을 아니면 거짓을 반환                     | num < 3;  |
   | ">="   | 왼쪽 항이 오른쪽 항보다 크거나 같으면 참을, 아니면 거짓을 반환 | num >= 3; |
   | "<="   | 왼쪽 항이 오른쪽 항보다 작거나 같으면 참을, 아니면 거짓을 반환 | num <= 3; |
   | "=="   | 두 개 항이 같으면 참, 아니면 거짓을 반환                     | num == 3; |
   | "!="   | 두 개 항이 다르면 참, 아니면 거짓을 반환                     | num != 3; |

4. 논리 연산자
   논리 연산자는 AND(&&), OR(||), NOT(!) 세가지의 연산자가 있으며 관계연산자와 같이 사용 되는 경우가 많다. 논리 연산자 역시 연산의 결과가 true 혹은 false로 반환된다.

   | 연산자         | 기능                                                         | 연산 예                            |
   | -------------- | ------------------------------------------------------------ | ---------------------------------- |
   | && (논리 곱)   | 두 항이 모두 참인 경우에만 결과값이 참이다. 그렇지 않은 경우는 모두 거짓이다. | booleanval = (5 > 3) && (5 > 2);   |
   | \|\| (논리 합) | 두 항 중 하나의 항만 참이면 결과 값은 참이다. 두 항이 모두 거짓이면 결과 값은 거짓이다. | booleanval = (5 > 3) \|\| (5 < 2); |
   | ! (부정)       | 단항 연산자. 참인 경우는 거짓으로 바꾸고, 거짓인 경우는 참으로 바꾼다. | booleanval = !(5 > 3);             |

5. Instanceof (객체 타입 확인)
   객체 타입을 확인하는 연산자
   형변환 가능여부를 확인하며 true/false로 결과를 반환한다. 주로 상속 관계에서 부모 객체인지 자식 객체인지 확인하는데 사용된다.
   "**객체 instance of 클래스**" 형태로 사용한다.

   ```java
   class Parent{}
   
   class Child extends Parent{}
   
   public class InstanceofTest {
   
       public static void main(String[] args){
   
           Parent parent = new Parent();
   
           Child child = new Child();
   
           System.out.println( parent instanceof Parent );  // true
   
           System.out.println( child instanceof Parent );   // true
   
           System.out.println( parent instanceof Child );   // false
   
           System.out.println( child instanceof Child );   // true
       }
   }
   ```

   instanceof는 해당 클래스가 자기 집이 맞는지 확인해주는 것이라는 설명이 이해가 잘되었다. 위의 예제에서 하나씩 살펴보자.

   - 첫번째로 부모는 부모집을 찾았으니 True 출력
   - 두번째는 자식이 부모님께 상속받은 부모집을 찾았으니 True 출력
   - 세번째는 부모가 자식집을 찾았으니 False 출력 ( 자식집은 자식의 집이다 )
   - 네번째는 자식이 자식집을 찾았으니 True 출력

6. 대입 연산자 (Assignment operator)
   대입 연산자는 변수에 값을 대입할 때 사용하는 이항 연산자이며, 피연산자들의 결합 방향은 오른쪽에서 왼쪽

   또한, 자바에서는 대입 연산자와 다른 연산자를 결합하여 만든 다양한 복합 대입 연산자를 제공

   | 대입 연산자 | 설명                                                         |
   | ----------- | ------------------------------------------------------------ |
   | =           | 왼쪽의 피연산자에 오른쪽의 피연산자를 대입함.                |
   | +=          | 왼쪽의 피연산자에 오른쪽의 피연산자를 더한 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |
   | -=          | 왼쪽의 피연산자에서 오른쪽의 피연산자를 뺀 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |
   | *=          | 왼쪽의 피연산자에 오른쪽의 피연산자를 곱한 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |
   | /=          | 왼쪽의 피연산자를 오른쪽의 피연산자로 나눈 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |
   | %=          | 왼쪽의 피연산자를 오른쪽의 피연산자로 나눈 후, 그 나머지를 왼쪽의 피연산자에 대입함. |
   | &=          | 왼쪽의 피연산자를 오른쪽의 피연산자와 비트 AND 연산한 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |
   | \|=         | 왼쪽의 피연산자를 오른쪽의 피연산자와 비트 OR 연산한 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |
   | "^="        | 왼쪽의 피연산자를 오른쪽의 피연산자와 비트 XOR 연산한 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |
   | "<<="       | 왼쪽의 피연산자를 오른쪽의 피연산자만큼 왼쪽 시프트한 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |
   | ">>="       | 왼쪽의 피연산자를 오른쪽의 피연산자만큼 부호를 유지하며 오른쪽 시프트한 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |
   | ">>>="      | 왼쪽의 피연산자를 오른쪽의 피연산자만큼 부호에 상관없이 오른쪽 시프트한 후, 그 결괏값을 왼쪽의 피연산자에 대입함. |

7. 화살표("->") 연산자
   화살표 연산자는 JAVA 8 버전 이후 추가된 기능으로, 람다 표현식과 함께 사용된다. 람다 표현식은 일종의 익명 함수(Anonymous Function)이라고 할 수 있다. 먼저, 익명 함수를 이해하기 위해 익명 클래스에 대해 알아보자.

   - 익명 클래스?

     익명 클래스란 클래스 instantiation(인스턴스화)과 동시에 클래스를 정의하는 클래스를 의미한다. 특정 클래스가 여러번 호출되지 않거나, 클래스 내부에 필드나 여러개의 메소드를 정의할 필요가 있는 경우 익명클래스로 정의해 사용할 수 있다.

   함수의 정의를 따로 만들지 않고 실제 사용되는 코드 부분에서 함수를 정의하여 사용하는 것

   ```java
   /* 기존 자바 문법 */
   new Thread(new Runnable() {
      @Override
      public void run() { 
         System.out.println("Welcome"); 
      }
   }).start();
   
   /* 람다식 문법 */
   (매개변수) -> {함수 실행문}
   new Thread(()->{
         System.out.println("Welcome");
   }).start();
   ```
   
8. 삼항 연산자

   ```java
   /* IF ELSE */
   int a;
   if(5<4) {
       a = 50;
   }else {
       a = 40;
   }
   System.out.println(a); //결과 = 40 
   		
   /* 삼항 연산자 */
   /* ( 조건문 ) ? 참일때 : 거짓일 때 ; */
   int b = (5 < 4) ? 50 : 40; 
   System.out.println(b); //결과 = 40
   ```

   단, 삼항 연산자를 썼다고 해서 연산 속도가 개선되는 것은 아님!

   삼항 연산자를 중복으로 사용한다면 코드 가독성이 떨어질 수 있으므로 중복처리는 피하는 것이 좋다!

9. 연산자 우선 순위
   기본적으로 연산자에는 우선순위가 있으며, 괄호의 우선순위가 제일 높고, 산술 > 비교 > 논리 > 대입의 순서이며, 단항 > 이항 > 삼항의 순서이다.
   연산자의 연산 진행방향은 왼쪽에서 오른쪽으로 수행되며, 단항 연산자와 대입 연산자의 경우에는 오른쪽에서 왼쪽으로 수행된다.

10. JAVA 13 Switch 연산자
    기존 switch 문의 break 문 없이도 아래로 떨어지는걸 방지, JAVA 13 버전 이후로 업데이트 되었다.

    ```java
    public enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; }	
    int numLetters = 0;
    Day day = Day.WEDNESDAY; 
    switch (day) { case MONDAY: 
                  case FRIDAY: 
                  case SUNDAY: 
                  numLetters = 6; 
                  break; 
                  case TUESDAY: 
                  numLetters = 7; 
                  break;
                  case THURSDAY: 
                  case SATURDAY: 
                  numLetters = 8; 
                  break;
                  case WEDNESDAY: 
                  numLetters = 9; 
                  break; 
                  
                  default: 
                  throw new IllegalStateException("Invalid day: " + day);
                 }
    System.out.println(numLetters);
    ```

    numLetters 변수 대신를 사용하지 않고 바로 반환하기 위해, 그리고 break 넘어가는걸 방지하기위해 사용하지 않도록 한다.

    ```java
    Day day = Day.WEDNESDAY;
    System.out.println(
      switch (day) { case MONDAY, FRIDAY, SUNDAY -> 6; 
                    case TUESDAY -> 7; 
                    case THURSDAY, SATURDAY -> 8; 
                    case WEDNESDAY -> 9; 
                    default -> throw new IllegalStateException("Invalid day: " + day);
                   } 
    );
    ```

    case의 label에 매치가 되면 -> 이후의 코드를 실행시키고 switch문을 빠져 나간다. 

    그럼 -> 다음의 코드는 switch 표현식의 값이다. 아래는 변수에 값을 할당시키는 예제이다.

    ```java
    int numLetters = 0;
    Day day = Day.WEDNESDAY;
    switch (day) { case MONDAY, FRIDAY, SUNDAY -> numLetters = 6; 
                    case TUESDAY -> numLetters = 7; 
                    case THURSDAY, SATURDAY -> numLetters = 8; 
                    case WEDNESDAY -> numLetters = 9; 
                    default -> throw new IllegalStateException("Invalid day: " + day);
                   };
    System.out.println(numLetters);
    ```

    Yield를 사용한 코드

    yield 는 한개의 인자를 받아와서 switch 표현식의 값으로 제공한다.

    ```java
    int numLetters = switch (day) { 
      case MONDAY, FRIDAY, SUNDAY -> { System.out.println(6); yield 6; }
      case TUESDAY -> { System.out.println(7); yield 7; }
      case THURSDAY, SATURDAY -> { System.out.println(8); yield 8; }
      case WEDNESDAY -> { System.out.println(9); yield 9; } 
      default -> { throw new IllegalStateException("Invalid day: " + day);
                 } 
    };
    ```

    

