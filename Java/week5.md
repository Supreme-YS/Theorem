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