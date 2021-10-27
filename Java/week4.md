### 목표

자바가 제공하는 제어문 학습

### 학습내용

- 선택문
- 반복문
- JUnit5로 테스트 코드 작성하는데 익숙해지기
- 대시 보드를 만드는 코드 작성
  - 깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.
  - 참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.
  - [Github 자바 라이브러리](https://github-api.kohsuke.org/)를 사용하면 편리합니다.
  - 깃헙 API를 익명으로 호출하는데 제한이 있기 때문에 본인의 깃헙 프로젝트에 이슈를 만들고 테스트를 하시면 더 자주 테스트할 수 있습니다.
- LinkedList 구현
  - LinkedList에 대해 공부하세요.
  - 정수를 저장하는 ListNode 클래스를 구현하세요.
  - ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
  - ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
  - boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.
- Stack 구현
  - int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
  - void push(int data)를 구현하세요.
  - int pop()을 구현하세요.
- ListNode를 사용한 Stack구현
  - ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
  - void push(int data)를 구현하세요.
  - int pop()을 구현하세요.
- Queue 구현
  - 배열을 사용해서 한번
  - ListNode를 사용해서 한번

1. 선택문

   주어진 조건 값의 결과에 따라 프로그램이 다른 명령을 수행하도록 하는 일종의 조건문이다.

   - if문은 모든 값, 범위를 기반으로 판단, 선택문은 정수값이나 열거된 값, 문자, 문자열만을 사용할 수 있다.
   - 컴파일러를 통해 실행 경로를 설정하는 점프 테이블이 만들어지며, **많은 조건을 비교할 때는 if else 문법보다 더 빠른 성능**을 보인다.
   - 좋은 가독성
   - switch~case 문법
   - 

2. 반복문

   어떠한 명령을 일정 횟수만큼 반복하여 수행하도록 하는 명령문, 반복문에는 for문, while문, do-while문, for-each(향상된 for 문), Iterator가 있다.

   - for문 ```for(초기화; 조건문; 증감식)```

     ```java
     for (int i=0; i<10; i++){
       // do-something
     }
     ```

   - while문 `while(조건문) 조건문이 True면 { }안의 내용 실행`

     ```java
     int i=0;
     while(i<10){
       // 10회 반복
       i++; // 증감식을 통해 유한루프 조건
     }
     ```

   - do-while문 `do{} while(조건)`

     - while문은 처음에 조건을 확인하고 실행, **do-while문의 경우 먼저 구문을 실행한 후 마지막에 조건을 확인함으로써 반드시 한번은 실행한다**

     ```java
     int i=0;
     do {
       // 코드 10회 반복
       i++;
     } while(i<10);
     ```

   - for-each문 `for( 객체를 담을 변수 : 반복할 객체(리스트) )`

     ```java
     import java.util.ArrayList;
     import java.util.List;
     
     public class ListTest {
         public static void main(String[] args) {
             List<Integer> list = new ArrayList<>(); // List 객체를 생성하여 list 참조변수에 할당
     
             for(int i=0;i<5;i++){
                 list.add(i);
             }
             System.out.println(list); // [0, 1, 2, 3, 4] 출력
     
             for(int num : list){
                 // 1부터 5를 list에 하나씩 가져와 출력
                 System.out.print(num);
                 System.out.print(" "); // 0 1 2 3 4 출력
             }
         }
     }
     ```

   - Iterator문 `Iterator()`

     - Iterator는 Java Collection에 저장되어 있는 데이터를 읽어오는 방법을 표준화한 기술이다.
     - hasNext(), next(), remove() 메서드를 이용해 데이터를 핸들링할 수 있다.

     ```java
     import java.util.HashSet;
     import java.util.Iterator;
     import java.util.Set;
     
     /* Collection 인터페이스를 기반으로 구현한 클래스에는 List와 Set이 있다.
     List 클래스는 선형 자료구조를 구현한 클래스, Set은 비선형 자료를 구현한 클래스이다.
     Set 클래스 안에 HashSet, TreeSet, LinkedHashSet이 있는데 HashSet이 가장 성능이 좋다.*/
     
     public class IteratorTest {
         public static void main(String[] args) {
             Set<String> set = new HashSet<>(); // Set 클래스내에 성능이 좋은 HashSet으로 set 참조변수에 객체 생성
             set.add("데이터1"); // add 메서드를 활용한 데이터 추가
             set.add("데이터2");
             set.add("데이터3");
     
             Iterator<String> iter = set.iterator();
             while(iter.hasNext()) { // 객체내에 요소가 없다면 False 반환
                 System.out.print(iter.next()); // 요소 출력 이후 다음 요소 반환
                 System.out.print(" "); // 출력값 : 데이터3, 데이터2, 데이터1
                 iter.remove(); // 요소 삭제
             }
         }
     }
     ```

3. 과제 0. JUnit 5 학습

- @BeforeAll : @Test 메서드들이 실행되기 전에 실행
- @BeforeEach : 각각의 @Test 메서드가 실행되기 전에 실행
- @AfterEach : 각각의 @Test 메서드가 실행된 후에 실행
- @AfterAll : @Test 메서드들이 실행된 후에 실행

