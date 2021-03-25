### 우분투 서버에 Jupyter Notebook으로 서버 개발하기

1. EC2 인스턴스 만들기
2. 리눅스 18.04 버전으로 생성
3. 키 페어 새로 생성 --> 관리자 권한으로만 서버 접근이 가능하기 때문에 보안 속성 변경 필요
4. 서버 연결



#### 업데이트

sudo apt-get update

sodo apt-get install python3-pip



#### 주피터 노트북 설치하기

sudo pip3 install notebook



#### 서버 보안을 위해 주피터 비밀번호 설정 및 접속 설정을 위해 환경 설정 파일 생성

python3 이후 프롬프트 창

from notebook.auth import passwd

passwd()

비밀번호 설정한 뒤에 SHA1 값 기록해 놓기



#### 주피터 비밀번호 설정 및 접속 설정 하기

jupyter notebook --generate-config

sudo vi /home/ubuntu/.jupyter/jupyter_notebook_config.py

주피터 노트북을 이용해 서버를 개방할 때는 IP 주소 및 포트 번호를 설정해야 하기 때문에 ip 주소를 환경 설정 파일에 입력해줘야 합니다.



c = get_config()

c.NotebookApp.password = u'sha1:{해시 값}'

c.NotebookApp.ip = '{내부 아이피}'

c.NotebookApp.notebook_dir = '/home/ubuntu' 

내부 아이피로는 SSH로 접속했을 때 콘솔 창에 나오는 아이피를 입력하기



#### 주피터 노트북 실행하기

sudo jupyter-notebook --allow-root



#### 방화벽 설정하기

8888번 포트 개방하기



#### 백그라운드 실행

sudo jupyter-notebook --allow-root

[Ctrl] + Z 입력하여 실행 종료하기 bg

disown -h



#### 포트 찾아서 죽이기

netstat -nap|grep 8888

sudo kill $(sudo lsof -t -i:8888)

netstat -nap|grep 8888