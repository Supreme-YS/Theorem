### Java 용어 정리

1. 컴파일 (Compile) : 사람이 이해하는 언어를 컴퓨터가 이해할 수 있는 기계어로 바꾸는 과정

2. 바이너리코드, 바이트코드 : 0과 1 두 개로 이루어진 것, 운영체제 별로 다르다.

3. 컴파일러 : 컴파일을 해주는 프로그램 

4. JVM : 자바 가상 머신

5. 원래는, OS 마다 다른 '컴파일러'가 필요하지만 JAVA는 JVM이 0과 1을 OS에 맞게 번역해 준다. 즉, 똑같은 JAVA 바이트 코드를 OS마다 다르게 해석해준다.

6. JDK > JRE > JVM 와 같은 포함관계를 가진다.

7. JRE : Java Runtime Environment / JRE = JVM + 자바 프로그램 실행에 필요한 라이브러리 파일 등

8. JDK : Java Development Kit / JDK = JRE + 개발을 위한 도구 / 컴파일러, 디버그 도구 등이 포함 / JDK는 버전과 종류가 있다.

9. LTS 버전 : Long Time Support은 더 길게 사용할 수 있는 버전

10. Oracle JDK : 오라클에서 만든 JDK, 개인에게 무료

11. Open JDK : Oracle JDK와 비슷한 성능, 언제나 무료

12. 빌드 : 소스 코드 파일을 컴퓨터에서 실행할 수 있는 독립 SW 가공물(Artifact)로 변환시키는 과정, 인터프리터 언어는 컴파일이 필요가 없다. 

    * 빌드 세분화 과정

    1. 소스 코드를 컴파일 한다
    2. 테스트 코드를 컴파일 한다
    3. 테스트 코드를 실행한다
    4. 테스트 코드 리포트를 작성한다
    5. 기타 추가 설정한 작업들을 진행한다
    6. 패키징을 수행한다
    7. 최종 SW 결과물을 만들어 낸다

13. 빌드 툴 : 소스코드의 빌드 과정을 자동으로 처리해주는 프로그램, 외부 소스 (외부 라이브러리) 자동 추가, 관리

    - 빌드 툴의 종류

    1. Ant : 설정을 위해 xml을 사용한다. 간단하고 사용하기 쉽다. 복잡한 처리를 하려 하면 빌드 스크립트가 장황해서 관리가 어렵다. 외부 라이브러리를 관리하는 구조가 없다. 거의 안씀
    2. Maven : 설정을 위해 xml을 사용한다. 외부 라이브러리를 관리할 수 있다. 즉, Ant가 가지고 있는 단점들을 대부분 극복. 지금도 쓰지만 신규 프로젝트에선 쓰지 않는다.
    3. Gradle : 설정을 위해 groovy 언어를 사용한다. 외부 라이브러리를 관리할 수 있다. 유연하게 빌드 스크립트를 작성할 수 있다. 성능이 뛰어나다. 가장 최근 java 빌드 툴

