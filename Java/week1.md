### 목표 

- 자바 소스 파일(.java)을 JVM으로 실행하는 과정 이해

### 학습내용

- JVM이란 무엇인가
- 컴파일하는 방법 및 원리
- 실행하는 방법 및 원리
- 바이트코드란 무엇인가
- JIT 컴파일러란 무엇이며 어떻게 동작하는지
- JVM 구성 요소
- JDK와 JRE의 차이

1. JVM이란 무엇인가
   **J**AVA **V**irtual **M**achine, **자바 가상 머신**의 약자를 따서 줄여 부르는 용어이다.
   여기서 **가상 머신**이란 프로그램을 실행하기 위해 물리적 머신과 유사한 머신을 소프트웨어로 구현한 것이다. 또한, JVM은 **스택 기반의 가상 머신**이다.

   JVM의 역할

   - 자바 애플리케이션을 클래스 로더를 통해 읽어 들여 JAVA API와 함께 **실행**
   - JAVA와 OS사이에서의 **중개자** 역할로 OS에 구애받지 않고 재사용 가능(**W**rite **O**nce, **R**un **A**nywhere!)
   - **메모리 관리, Garbage Collection** 수행

2. 컴파일하는 방법
   **컴파일**이란 인간이 보기 편하게 만든 소스코드를 컴퓨터가 이해할 수 있는 기계어 구조로 변환하는 일련의 과정이다.

   ```java
   /* javac 명령어를 통한 java 파일을 컴파일한다 */
   javac <Class Name>.java
   /* <Class Name>.class가 생성되며, java 명령어로 실행 */
   java <Class Name>
   ```

3. 실행하는 방법과 원리

   - 소스코드를 작성 -> java 확장자의 소스 파일 생성
   - 컴파일러(javac.exe)가 바이트코드로 변환 -> class 확장자의 소스 파일 생성
   - 런처(java.exe)로 자바 가상 머신을 구동
   - 자바 가상 머신이 바이트 코드를 해석하여 자바 프로그램 실행

4. 바이트 코드란 무엇인가

   - 운영체제에 **종속적이지 않게 만들기 위해** 만드는 코드로써 0과 1로 이루어졌다. 

   * 자바 바이트 코드(Java bytecode)란 자바 가상 머신이 이해할 수 있는 언어로 변환된 자바 소스 코드를 의미
   * 자바 컴파일러에 의해 변환되는 코드의 명령어 크기가 1바이트라서 자바 바이트 코드라고 불리며, 이러한 자바 바이트 코드의 확장자는 .class
   * 자바 바이트 코드는 자바 가상 머신만 설치되어 있으면, 어떤 운영체제에서라도 실행될 수 있습니다. -> 확장성 용이

5. JIT 컴파일러 개념 및 동작 원리

   - <바이트 코드 변환> 이라는 추가 과정이 있기 때문에 속도 저하가 발생 -> 이를 빠르게 하기 위해 만든 것이 JIT 컴파일러!

   - **J**ust **I**n **T**ime 컴파일러의 약자로 JVM의 표준 구현인 **바이트 코드를 해석하면 실행 속도가 느린 점**을 보완하고 성능을 향상시키기 위해 만든 것
   - **J**ava **R**untime **E**nvirionmen의 구성요소인 실행 엔진 내부에서 동작합니다.

6. JVM 구성 요소

   - 인터프리터 : 바이트 코드를 해당 하드웨어의 환경에 맞게 변환하여 **운영체제에 종속적인 상태를 종속적이지 않은 상태로 변환**
   - 클래스 로더 : 컴파일러가 내부에 만든 .class(바이트 코드)를 읽는 행위를 일컫는 말
   - 실행 엔진 (JIT 컴파일러 포함) : 클래스 로더에 존재하는 클래스를 읽으며 static 유/무를 판단, 만약 static이 없다면 자바는 종료
   - 가비지 컬렉터 (GC) : 더이상 사용하지 않는 메모리를 자동으로 회수

7. JDK와 JRE의 차이

   - **J**ava **D**eveloper **K**it 의 약자로 자바를 개발하기 위해 만든 툴로 JDK는 JRE를 포함한다.
   - **J**ava **R**untime **E**nvironment 의 약자로 자바를 실행할 수 있는 실행환경이 들어있다. JRE는 JVM을 포함한다.
   - JDK > JRE > JVM

### 보충 키워드

- 스택 기반의 가상 머신 ?