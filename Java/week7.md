### 목표

자바의 패키지에 대해 학습하세요.

### 학습할 것

- package 키워드
- import 키워드
- 클래스 패스
- CLASSPATH 환경 변수
- -classpath 옵션
- 접근지시자

------

### Package 목적

어떤 기능들을 묶어서 용도나 목적에 맞춰서 분리 한 것을 의미한다. ArrayList 클래스는 java.util이라는 패키지 안에 있다. 자바에서 제공하는 유용한 도구들이 있는 패키지라고 이해할 수 있다. 따라서, 프로그램을 작성할 때, 기업의 고유정보등을 이용하여 패키지를 작성하면 클래스의 이름이 충돌하는 것을 방지할 수 있다.

### Package 작성 관례

- 클래스의 이름과 구분이 되도록 패키지의 이름은 전부 소문자.
- 인터넷 도메인 이름의 역순으로 패키지 이름을 구성. 
- 패키지 이름의 끝에 클래스를 정의한 주체 또는 팀을 구분하는 이름을 추가.

예. supreme-ys.tistory.com인 회사의 blog 팀에서 개발한 클래스를 묶을 패키지 이름을 위의 관례를 적용하면 다음과 같다. ```com.tistory.supreme-ys.blog``` 

### Package 선언

패키지를 선언하는 이유는 컴파일 시 생기는 class 파일을 어디다가 배치 할 것인가를 정하기 때문이다. 

### Import 

같은 패키지 안에서 만들어진 클래스들을 대상으로 하는 인스턴스를 생성하는 상황이라면 클래스 이름만으로 사용할 수 있다.  **JVM 내부에 있는 부트스트랩 클래스로더**라는 최상단에 존재하는 것이 있다. 클래스로더의 메커니즘은 내가 읽고자 하는 클래스가 부모에게 있는지 물어보고 있으면 쓰고 없으면 자신이 읽는다. 

### 접근 제어자 (클래스, 메소드 인스턴스 및 클래스 변수)

- public : 누구나 접근 가능
- Protected : 같은 패키지 내에 있거나 상속받은 경우에만 접근 가능
- (default) : 같은 패키지 내에 있을 때만 접근 가능
- Private : 같은 클래스에서만 접근 가능

### CLASSPATH 환경변수

JVM이 클래스 파일(*.class)을 찾는 경로이다.

자바 가상머신은 프로그램의 실행 과정에서 클래스 파일을 찾을 때, CLASSPATH라는 것을 기준으로 찾는다. 따라서, CLASSPATH를 잡아주면, 위 경로를 루트 디렉토리나, 현재 디렉토리로부터 접근해서 찾는 것이 아니라. ```Users/supreme-ys/src/main/java/```경로에서 찾게 하여 import 문을 수행하게 한다.

### 환경 변수

운영체제 상에서 동작하는 응용프로그램들이 참조하기 위한 설정이다. 개발환경을 설정할 때 셋팅하는 환경변수 중 하나가 CLASSPATH 환경변수이다.

### CLASSPATH를 환경변수로 만드는 이유

자바 어플리케이션이 실행 될 때, 클래스 로더가 참조하여 라이브러리 클래스들을 로드해야 할 때의 용도로 사용된다.

### -CLASSPATH 옵션

-cp 옵션이라고도 하며, java 명령어 또는 javac 명령어 실행시 클래스패스를 지정할 수 있는 옵션이다. A 위치에 있는 클래스를 컴파일을 하기위해서 필요한 클래스들이 B 에 존재하다면 다음과 같이 명령어를 사용할 수 있다. ```javac - classpath B A```

만약 필요한 클래스들이 다른 위치에 더 있다면 다음과 같이 작성할 수 있다. ```javac -classpath .;B;A;C A```





