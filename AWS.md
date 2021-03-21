[→ Open in Slid](https://slid.cc/vdocs/000107006c4943b3b770d72b4693060a)


---


* 클라우드 : 서버의 구매, 구축, 운영을 대행해주는 서비스, 웹 호스팅과 유사, 가상화 기술, 탄력적인 인프라 운영, 사용한 만큼 과금(종량제)


* EC2 ( Elastic Compute Cloud ) : 독립적인 컴퓨터 한 대, Linux, Window 운영체제 제공, 웹서버, 에플리케이션 서버로 주로 사용된다.


* S3 ( Simple Storage Service ) : 파일 서버 역할, S3가 무제한으로 데이터를 저장해주는 특성이 있기 떄문에 EC2도 저장이 되지만 S3를 주로 쓴다. 스케일은 아마존 인프라가 담당, 


* RDS ( Relational Database Service ) : Mysql, Oracle, SQL Server 지원, 백업, 리플리케이션을 아마존 인프라가 자동으로 제공


* ELB ( Elastic Load Balancing ) : EC2로 유입되는 트래픽을 여러대의 EC2로 분산, 장애가 발생한 EC2를 감지해서 자동으로 배제, Auto Scaling 기능을 이용해서 EC2를 자동으로 생성, 삭제

## 인프라 확장 시나리오


 1. 한 대의 머신이 단독으로 웹 서버, 애플리케이션 서버, 데이터베이스, 파일 서버의 역할을 모두 수행
 2. 트래픽 증가로 한 대의 EC2로 처리 어려움 --&gt; 하드웨어 성능 향상(Scale up)<br>
 3. 트래픽이 더 증가한다면 --&gt; S3(파일서버)/RDS(데이터베이스서버)/웹서버, 애플리케이션 서버로 분산<br>
 4. 더 트래픽이 증가한다면 -&gt; Auto Scaling을 이용해서 시스템의 부하에 따라서 자동으로 EC2가 증감하게 한다(ELB를 앞에 배치)<br>

![](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/capture_images/000107006c4943b3b770d72b4693060a/b45bc764-98b6-4455-815c-1110de003118.png "AWS image")

## 데이터베이스 확장 시나리오


 1. 트래픽이 증가한다면 RDS를 1개의 Master(쓰기) 서버와 여러개의 Slave(읽기) 서버로 분산한다.
 2. 기능에 따라서 물리적으로 시스템을 분산 - shading
 3. NoSQL 사용 - DynamoDB&nbsp;

![](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/capture_images/000107006c4943b3b770d72b4693060a/4aaa888b-d335-471b-a8f3-f6afca65ac85.png "AWS image")

## EC2( Elastic Compute Cloud )&nbsp;


* 한 대의 컴퓨터를 임대 해주는 것


* 인터넷을 통해서만 접속을 할 수 있고, 주문 후 1분 안에 생성되고, 삭제 즉시 제거된다.


* 초기 구입비가 전혀 없고, 사용한 만큼 비용을 지불하면 된다.

## EBS( Elastic Block Store )


* SSD, HDD와 같은 저장 장치, EC2의 인스턴스에 장착


* 종량제


* 스냅샷 기능을 제공해서 EBS의 현재 상태 그대로 보존 할 수 있다.


* CloudWatch를 통해서 EBS의 통계를 열람할 수 있다.


* EC2 인스턴스를 제거해도 EBS는 독립적이기 때문에 데이터가 유지된다.


* Volume : EBS로 생성한 디스크 하나 하나를 볼륨이라고 한다. (EC2의 인스턴스와 EBS의 볼륨과 같은 개념이라고 보면 된다.)

## AMIs( Amazon Machine Images )&nbsp;


* EC2 인스턴스를 그대로 저장해서 재사용 할 수 있도록 만든 것


* private, public, Marketplace 와 같은 세 가지 형태로 구성되어 있다.


* private : 비공개 이미지로 자기 자신만이 사용할 수 있다.


* public : 공개된 이미지로 누구나 이용할 수 있다.


* Marketplace : 일종의 앱스토어와 같은 개념으로 이미지를 판매하고 구매할 수 있는 마켓이다.

## ELB ( Elastic Load Balancing )&nbsp;


* 한 대의 성능 개선하는 것 (Scale Up = 수직 향상)


* 확장 시나리오 부하 분산(Scale Out)


* 즉, 트래픽을 분산 시켜주는 서비스


* 자동 확장


* 인스턴스의 상태를 자동 감지해서 오류가 있는 시스템은 배제


* 사용자 세션을 특정 인스턴스에 고정


* SSL 암호화 지원, IPv4, IPv6 지원


* CloudWatch를 통해서 모니터링



