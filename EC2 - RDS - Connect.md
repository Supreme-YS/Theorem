#### EC2 - RDS - Connect

1. EC2 인스턴스 생성(Ubuntu 18.04 ver) 및 server connect

- key name : ec2_rds_lambda_key
- key attribute 보안 설정 --> Users가 포함된 값 삭제 --> 관리자만 접근이 가능하도록 한다. *보안성 확보
- AWS 콘솔 창에서 Connect를 통해 SSH 값 복사
- 윈도우 터미널 (cmd , powershell, xshell...etc)을 활용해서 key.pem 파일이 있는 경로로 이동
- 복사한 SSH 값 입력 후 서버 진입



2. Before EC2 -RDS Connect

- 먼저, 만든 EC2와 RDS가 AWS의 같은 VPC ID에 포함되야 EC2와 RDS가 연결이 된다. 여기서 VPC는 Virtual Private Cloud의 약자로, **사용자의 AWS 계정 전용 가상 네트워크**이다.
- 따라서, EC2의 **VPC ID**와 **보안 그룹**을 확인하고 메모장에 기록한다. EC2를 통해서만 DB(RDS)에 접근이 가능하도록 보안그룹을 새로 만든다. (인바운드 규칙 MYSQL/Aurora, 사용자 지정 : 메모한 보안그룹 선택 )
- RDS 콘솔로 들어가서 데이터베이스를 생성하기 전에 DB Subnet Group을 만든다.
  - Subnet이란? 서브넷은 실제로 리소스가 생성되는 물리적인 공간인 가용존Available Zone과 연결된다. VPC가 논리적인 범위를 의미한다면, 서브넷은 VPC 안에서 실제로 리소스가 생성될 수 있는 네트워크라고 생각할 수 있다. 
  - 서브넷을 만들지 않을 수 있지만, VPC 하나만으로는 아무것도 할 수 없다. 일반적으로 사용할 수 있는 가용존을 고려해서 적절한 크기의 서브넷들을 가용존 수만큼 생성해서 사용한다. 서브넷을 만들어서 리소스를 분산하면 재해 대응 측면에서도 유리하다.
- DB Subnet Group을 만들고 VPC란에 메모장에 적어놓은 VPC ID 값과 일치하는 식별자를 선택한다.



3. Make DataBase

- DB Instance 생성 -> DB선택(Mysql) -> DB 식별자 입력 -> 마스터 사용자 이름 & 비밀번호 입력 -> EC2 VPC ID와 일치하는 값으로 VPC 설정 -> 서브넷 그룹 ( 이전 프로세스에서 만들었던 서브넷 그룹 ) 선택 -> **퍼블릭 액세스 가능 ( "아니요" 체크)** - 어떤 외부 프로그램에서도 접근하지 않고 오직 EC2에서만 접근하기 위함
- VPC 보안 그룹 선택 ( 이전 프로세스에서 만들었던 EC2 보안 그룹 선택)
  - RDS 콘솔의 서브넷 그룹이 db subnet group이 되어 있는지
  - vpc 가 available 한지
  - 보안 그룹의 인바운드 규칙의 소스가 EC2의 값과 일치하는지
  - vpc 가 EC2의 vpc와 일치하는지 체크하면 된다.



4. Server에 Mysql 설치 및 연결

- ```sudo apt-get install mysql-client-core-{version}```
- ```sudo apt-get update```
- DB instance의 엔드포인트가 호스트 이름이다.

- 따라서 EC2 서버에서 접속이 되는지 확인이 필요하다
  - mysql -u {user_id} -p --host {RDS 인스턴스의 엔드포인트 값}
  - Enter password : {설정한 비밀번호 입력}
  - SELECT VERSION(); 을 통해 설치된 mysql 버전을 확인한다.