- 현재 사용하고 있는 포트 ( 주피터 노트북 상에 ubuntu 서버를 구축했기 때문에 확실한 shut down을 위함)

```sudo netstat - nap | grep {포트번호}```

- 명령어를 통해 확실하게 서버를 닫기

```sudo kill -9 {포트번호}```

- https 를 적용하기 - 사설 인증서를 이용

```pwd```: 현재 위치 확인을 위한 명령어

```mkdir ssl``` : 통신 보안을 위한 도구 + (**공개키 기반 구조**에 대해 공부 필요)

![image-20210323234040882](C:\Users\1234\AppData\Roaming\Typora\typora-user-images\image-20210323234040882.png)

인증서와 개인 키 파일이 생성된 것을 확인할 수 있다.

![image-20210323234203611](C:\Users\1234\AppData\Roaming\Typora\typora-user-images\image-20210323234203611.png)

- 이후 다시 주피터 환경 설정 파일 열기

```~$ sudo vi /home/ubuntu/.jupyter/jupyter_notebook_config.py```

