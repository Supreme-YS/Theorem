### IAM ( Identify and Access Management )

- AWS 리소스를 사용하는 그룹, 유저, 사용권한 등을 전체적으로 관리하는 서비스
- 모든 서비스에 걸쳐 영향을 미치기 때문에 팀 작업 및 공동 작업시에 필수적으로 알아야 하는 서비스



- Group 탭
  - 그룹을 추가, 삭제 하고, 그룹마다 세부적인 리소스 사용권한을 부여하고, 유저들을 그룹별로 묶어 관리할 수 있습니다.
  - 그룹에 소속된 유저는 자동으로 그룹이 가지고 있는 권한을 부여받게 됩니다.

- User 탭

  - 유저를 추가, 삭제하고 유저를 그룹에 소속시키거나, 특정 유저에게만 권한을 부여할 수 있습니다.
  - Access Type : < Programmatic Access > < AWS management Console Access > 
    - Programmatic Access : AWS API 나 AWS CLI 를 통해서 접속하는 것을 의미, user가 개발자라면 필수적으로 체크해줘야 한다.
    - AWS management Console Access : 관리자 , 프로젝트 매니저, 서버 관리자 역할에게 체크를 통해 부여하며, 불필요한 접근을 제한할 수 있다.
    - 이메일을 통해 생성된 아이디와 비밀번호로 루트 유저가 아닌 생성한 유저 아이디와 비밀번호로 AWS에 접속할 수 있다.

- Roles 탭

  - AWS의 리소스에 권한을 부여하는 개념
  - 예) EC2 인스턴스는 Lambda 리소스의 함수를 호출할 수 없다. 그 이유는 EC2 인스턴스는 Lambda를 사용할 수 있는 권한이 없기 때문이다. 이때, Roles 탭에서 EC2 리소스에 Lambda 사용권한을 부여하게 되면, Lambda 서비스에 접근할 수 있게 된다.

- Policy

  - 그룹, 유저, Role에 부여되는 권한들을 보다 세부적으로 관리
  - 예) EC2의 Nano2 의 인스턴트만 실행할 수 있도록한다. 
          S3에 특정 버켓만 읽기전용으로 접근하도록 한다.와 같은 권한들을 설정할 수 있다.

  

※ 현재 멀티캠퍼스 작업 상황을 기반으로 IAM 정리

![image-20210407201137956](C:\Users\dudtj\AppData\Roaming\Typora\typora-user-images\image-20210407201137956.png)

- **multi-k1** 루트 계정에서 **Users 탭의 Add**를 통해 lab01-ai-c / lab02-ai-c 라는 유저 ID와 각각의 Password를 등록
- 1번 , 2번 user는 같은 팀이기 때문에 같은 그룹으로 묶여있으며 같은 개발자 권한을 가진다.
- 현재 총 4개의 서버 운용 중( 서버이름 :  [AI]V-Lab-c1 ~ c4)
- 따라서, 각 팀에 해당하는 서버만 접근이 가능하도록 4개의 그룹으로 나뉘어 있을 것
- 그 그룹별로 팀에 해당하는 팀원들이 Group 별 User로 등록 및 개발자 권한이 부여된 상태

