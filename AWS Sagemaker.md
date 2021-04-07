### Sagemaker

머신러닝 개발 플랫폼 - Web base IDE

- Prepare -> Build -> Train & Tune -> Deploy & Manage
- 개발환경 / 학습환경 / 추상환경을 나눠서 작업하여 작업의 효율성을 높일 수 있다.



#### 라벨링(Labeling)

- Annotating 관련해서 User가 원하는 형태로 할 수도 있고, 자동으로 작업을 할 수도 있다.



#### 모델개발(Build)

- Notebook instance
  - RDS와 유사
  - Jupyter 환경으로 개발 가능
- SageMaker Studio(협업)
  - SSO 로그인  : 사용자에게 초대 메일 발송, 초기 로그인 시 패스워드 세팅
  - IAM 로그인 : 전용URL로 접속



#### 학습과 최적화 (Train & Tune)

- SageMaker의 내부 구조
  - 도커 & 컨테이너 이미지로 구성이 되어있다.
  - 트레이닝이 필요하면 S3로부터 Training 데이터를 가져온다.
  - ECR에서 Algorithm 가져온다.
  - 모델을 생성한다.
  - 모델이 생성되면 새로운 모델은 S3로 Export, 사용했던 리소스는 Release 된다
  - 위와 같이 학습(Training)을 마치면 추상화를 위한 Predict를 준비한다.
  - ![image-20210407184035354](C:\Users\dudtj\AppData\Roaming\Typora\typora-user-images\image-20210407184035354.png)
  - ![image-20210407184151015](C:\Users\dudtj\AppData\Roaming\Typora\typora-user-images\image-20210407184151015.png)
  - Model Artifacts (학습을 통해 만들어진 모델) + Inference Algorithm을 갖고아ㅗ서 EndPoint를 생성한다. 이를 통해 서비스를 제공하게 된다. ( 미래 예측, 분류 서비스 )
  - ![image-20210407184418399](C:\Users\dudtj\AppData\Roaming\Typora\typora-user-images\image-20210407184418399.png)

- Built-in Algorithm : SageMaker가 자체적으로 제공하는 알고리즘만을 사용하는 방식(17종류) 
- Custom script on supported framework : Framework는 AWS가 제공, 그 위에 스크립트 코드를 탑재해서 사용하는 방법 , Apache, Tensorflow, Pytorch를 쓸 때 주로 사용한다.
- BYO algorithm and framework : 컨테이너 자체를 직접 구성해서 사용하는 방식, SageMaker는 관리 목적으로만 사용(자동으로 리소스가 Release된다던가...)
- AWS Marketplace algorithms : 마켓 플레이스에서 제공하는 것, 어떻게 보면 Built-in algorithm과 비슷한 개념, 과금차이 



- SageMaker RL(강화학습) - 연속적인 결과 도출이 필요할 때 , 실시간 ( 추천 시스템 등 )
- Deep Graph Libarary - 그래프 자체를 신경망의 Input으로 사용할 때 처리
- Automatic Model Tuning (HPO) : 하이퍼파라미터 조정할 때 병렬적으로 수행할 수 있기 때문에 작업 효율성이 증가한다. Bayesian Optimization 으로 최적의 파라미터를 좀 더 빠르게 찾을 수 있다. 알아서 하이퍼 파라미터를 조정해서 Try 하기 때문



- AutoPilot : 자동으로 모델을 생성하는 Auto ML 기능
  - Data Exploration notebook : Data 통계값, Data 의 특징들을 보여주는 파이썬 파일이 자동으로 생성
  - Candidate Generation Notebook : 하이퍼파라메터를 자동으로 추천해준다. 값을 가지고 자동으로 Generate해서 복붙해서 따로 써도되고, 클라우드 상에서 Run 시켜도 된다.
  - 생각보다 성능이 괜찮다고 한다.



- Experiments : 다양한 실험들에 대한 결과를 비교하고 검토할 수 있는 기능

  - 예) 내가 만든 모델로 성능 측정 vs AutoPilot을 통해 만든 모델로 성능 측정 vs 다른 사람이 만든 모델로 성능 측정 등의 비교가 가능해짐

    

- Preprocessing : Null 값 제거, 중복값 제거, One-hot 인코딩, 수치값 Scaling 을 해주는 도구



- Debugger : 트레이닝을 실행할 때, 그 트레이닝을 모니터링하는 도구 



- Spot Training : Flag 설정으로 작업 관리



#### 배포 관리 (Deployment & Management)

- Batch Transform 
- Endpoint 
  - ![image-20210407190914931](C:\Users\dudtj\AppData\Roaming\Typora\typora-user-images\image-20210407190914931.png)
- Neo : 경량화 작업
- Model Monitor



#### 통합 (Integration)

- A2I ( Amazon Augmented AI )
  - Amazon Rekognition : 이미지에 대한 라벨링, 태그 작업을 Return
  - Amazon Textract : OCR 을 통해 텍스트 문서를 Return 
  - 또한, 유저의 Inspection을 수정 가능
- IoT Edge deployment
  - 클라우드에서 트레이닝, 트레이닝 된 결과를 오프라인 사이트에 줄 수 있다.
  - Greengrass : 로컬, 로컬 리소스 액세스, 보안 등등
- EMR ( Elastic Map Reduce )
- CI/CD ( 지속 통합, 지속 개발 ) with CodePipeline