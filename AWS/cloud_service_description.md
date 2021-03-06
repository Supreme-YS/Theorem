### Cloud Computing



#### Cloud Service 종류

- IaaS : IT 기본 자원만 제공, Server, Storage, Network, 새로 컴퓨터 하나 구매 하는 개념

- SaaS : 모든 기능이 동작하는 SW를 제공

- PaaS : IaaS에 OS, Middleware, Runtime 추가한 형태, 코드 개발만 해서 올릴 수 있는 상태, AWS Elastic Beanstalk, Google App Engine



#### Cloud Service Deployment Model

- 클라우드를 실제 어떠한 형태로 구축하는지에 대한 View를 나타낸다.
- Public Cloud, Private Cloud , Hybrid Cloud, Community Cloud로 구분이 된다. 

![image-20210317234944730](C:\Users\dudtj\AppData\Roaming\Typora\typora-user-images\image-20210317234944730.png)



#### Cloud Computing Service 주요 용어

- Data center : 수많은 서버들을 한 데 모아 네트워크로 연결해 놓은 시설
  - IDC – internet Data center
  - CDC – Cloud Data center
  - Server hotel이라고도 불린다.
  - Cloud의 토대, Cloud 산업이 커질수록 더 많은 Data Center가 구축 되는 중이다.

- Rack : 서버 또는 네트워크 장비들이 들어가는 프레임
  - 랙 마운트형 서버 : 랙 안의 층들이 하나의 서버로 공간을 효율적으로 사용 가능
  - 주요 관리 포인트 : **발열 관리** / NAVER의 NAMU 기술
- Region : 데이터 센터가 위치한 지역 
- Availability Zone : 하나의 Region은 두 개 이상의 AZ로 구성된다. 가용영역 이라고도 불린다. AZ에 서비스를 분산하여 높은 가용성 확보 가능
- Virtualization(가상화) : 소프트웨어로 가상의 하드웨어를 생성하는 기술, 가상의 하드웨어는 VM(virtual machine) Cloud 서비스에서 서버를 사용할 때, 일반적으로 물리적인 하나의 서버가 아닌 가상화 된 서버를 제공 받음, Server / Bare Metal Server ( 물리적 서버 ) 



#### Cloud Service Provider

- Amazon Web Service (AWS) : 국내 IaaS 시장 압도적인 점유, 많은 기업들이 사용중이고, AWS 학습은 취업을 위해서도 효과적
  - EC2 – 가상서버
  - S3 – Object 스토리지, 파일을 올리고 전달하는 공간
  - RDS – 관계형 DB 서비스, MySql, Oracle
  - VPC – 가상 사설 네트워크
  - IAM – 사용자 인증 및 권한 관리
  - 이 외에도 다양한 플랫폼을 제공하고 있다. 공부가 필요한 부분)

- Azure(Microsoft) : PaaS 서비스 및 DevOps(개발과 운영을 동시에 하는) 서비스에 집중됨

- Google Cloud Platform(GCP) : 빅데이터와 인공지능과 관련된 서비스가 강점



#### 데이터 형태별 서비스 활용

- 정형 데이터
  - DBMS : 스키마를 읽어 가시적 데이터 세트 형태로 제공 -> DBMS 활용
  - 이진파일(Binary) : 이진화한 데이터를 해석해 가시적 데이터 세트 형태로 제공 -> 응용소프트웨어 활용
- 반정형 데이터
  - 스크립트파일 : 스크립트 형태의 파일을 브라우저나 응용소프트웨어가 해석해 가시적 데이터 형태로 제공 -> 응용소프트웨어 활용
- 비정형 데이터
  - 스크립트파일, 이진파일 : 이진화한 형태의 데이터를 해석해 인지적(음성, 영상, 텍스트 등)데이터 형태로 제공 -> 응용소프트웨어 활용



#### 수집 방법 종류

- 정형 데이터 (예. red shift)
  - DBMS : DBMS 벤더가 제공하는 API를 통해 정형 데이터에 접근
  - 이진파일 : FTP 프로토콜을 사용해 파일을 수집 시스템에 다운로드, 해당 파일의 API를 통해 데이터 처리
- 반정형 데이터
  - 스크립트파일 : http 프로토콜을 사용해 파일의 텍스트를 스크랩, 데이터의 저장된 메타 정보를 읽어 파일을 파싱하여 데이터 처리
  - 이진파일 : 스트리밍을 사용해 파일의 텍스트를 스크랩, 데이터에 저장된 메타정보를 읽어 파일을 파싱하여 데이터 처리
- 비정형 데이터(예. AWS의 EMR)
  - 이진파일 : FTP 프로토콜을 사용해 파일을 수집 시스템에 다운로드, 해당 파일의 API를 통해 데이터 처리
  - 스크립트파일 : http 프로토콜을 사용해 파일의 텍스트를 스크랩, 데이터의 저장된 메타 정보를 읽어 파일을 파싱하여 데이터 처리



#### 데이터 종류별 연동 방법

- DBMS : 연동방법 - 소켓, 내부처리 - 저장
- 반정형 이진파일 : 연동방법 - 스트리밍, 내부처리 - 저장
- 비정형 이진파일 : 연동방법 - FTP, 내부처리 - 저장, 파싱
- 스크립트파일 : 연동방법 - http, 내부처리 - 저장, 파싱



#### 수집 기술의 종류

- http 수집 
  - 웹 스크래핑 : 크롤링
  - Open API : 네이버 지도, 구글 맵, 오픈 스트리트맵 등, 대한민국 정부 주관 공공 데이터 포탈
- **로그/센서 수집** (  실제 실무에서 사용함 , 중요도 높음 )
  - 로그 수집 : 시스템 로그, 이벤트 로그, 웹 서버 로그, DB 로그, 트랜잭션 로그, 클릭 로그, 보안 로그 등 다양한 로그 데이터가 존재 / 시스템에서 에이전트를 통해 각종 로그를 수집하여 분석에 활용
  - 센서 데이터 수집 : IoT 기기로부터 각종 센서 데이터 수집 가능
- **DBMS 수집** (  실제 실무에서 사용함 , 중요도 높음 )
  - DB 시스템으로부터 특정 테이블 컬럼을 선택하여 정형 데이터 수집 가능, 레코드 단위로 수집해 분산파일시스템으로 전송 가능, 기존에 운영되는 DBMS의 연결만으로 쉽게 데이터 수집 가능
- FTP 수집
  - TCP/IP 프로토콜을 활용하는 인터넷 서버로부터 각종 파일들이 송수신, 파일 전송에 최적화되어 있어서 대용량 데이터 수집에 사용
  - 보통 기업 간 협업 시에 사용한다.

