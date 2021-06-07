### The Basics of Git & GitHub 

- Git & GitHub 버전관리(형상관리)

- 두 명의 개발자가 함께 개발하는 상황을 가정하자.
  1. 각자 이름의 폴더를 만들고 각자 개발하다가 매주 일요일에 메일로 보내서 합친다.
  2. 혹시 에러날 수 있으니 백업본을 만들어둔다.(source_200101.zip / source_200102.zip)
  3. 상대방이 작업중인 파일을 고치고 싶으면 메일에 따로 적어준다.
  4. 코드를 합칠 때 이를 확인해서 내 코드에도 반영

-- > 따로 조금씩 작업하다 내가 원할 때 코드를 합칠 수 있는 방법 = Git



- 만일, 다수의 사람이 버전 관리를 해야 한다면?
  1. 개발자 A : 페이지1~3 작성해 버전 'A1' 저장
  2. 개발자 B : 버전 'A1' 다운받아서 페이지 4~6 작성후 버전 'B1' 저장
  3. 개발자 A  : 페이지 2 수정 후 버전 'A2' 저장
  4. 개발자 B  : 버전 'A2'와 내 'B1' 비교해(diff) 최근에 페이지 2가 바뀌어 있는걸 확인 -> 내 버전에 반영 후 -> 버전 'B2' 저장

-> 개발자 A의 최종 버전에 있는 페이지 : 1, 2(수정본)

-> 개발자 B의 최종 버전에 있는 페이지 : 1, 2(수정본), 3, 4



- Git Summary

1. 원하는 시점마다 깃발을 꽂고(버전을 만들고) 이들 간에 자유롭게 돌아다닐 수 있다. 
2. 내가 만든 버전 뿐 아니라 동료가 만든 버전으로 이동할 수 있고, 동료와 내 버전을 비교해서 최신본으로 코드를 업데이트 할 수 있다.
3. 개인 컴퓨터 , USB, 회사 서버, 클라우드와 같은 저장할 공간만 있다면 어디서나 사용 가능.
4. Command Line Interface / Graphic User Interface 두 가지 방법으로 깃 사용 가능



- GitHub에 코드를 올리는 과정

1. 내 컴퓨터 프로젝트 폴더에 '여기에서 Git을 쓰겠다!' 라고 명령 ```git init```
2. 코딩(Coding)
3. 내가 변경한 파일 중 올리길 원하는 것만 선택 ```git add```
4. 선택한 파일들을 하나의 덩어리로 만들고 설명 적어주기 ```git commit -m "메시지"```
5. GitHub 사이트에서 프로젝트 저장소 만들기(블로그랑 유사)
6. 내 컴퓨터 프로젝트 폴더에 GitHub 저장소 주소 알려주기 ```git remote add 저장소 주소```
7. 내 컴퓨터에 만들었던 덩어리 GitHub에 올리기 ```git push```



### The Details of Git & GitHub

- 로컬 폴더에서 Git 으로 버전관리를 하는 법

1. 원하는 폴더에서 Git 초기화를 하면 그때부터 가능( git init )
2. Git 초기화를 하면 .git 이라는 숨겨진 폴더가 생성된다. **이게 로컬 저장소**
3. 로컬 저장소에 내가 만든 버전 정보, 원격 저장소 주소 등이 저장된다.
4. 원격 저장소에서 내 컴퓨터로 코드를 받아오면 로컬 저장소가 자동으로 생긴다.
5. **한 폴더에 하나의 로컬 저장소만 유지해야 한다.**



- 로컬 저장소에 ```git init``` 해보기

1. git bash 실행
2. 'Boxiting-cat'이라는 이름의 폴더 생성
3. git bash 터미널 창에서 cd /{Boxiting-cat의 위치} 로 디렉토리 변경
4. git init 명령어를 통해 선언
5. ls -al 리눅스 명령어를 통해 숨겨진 .git 폴더 확인 가능
6. ```git config --global user.name "{사용자명}"```
   ```git config --global user.email {이메일 주소}```



- Commit (커밋) : 하나의 버전, 커밋은 기차처럼 쌓인다.

1. 커밋은 **'의미 있는 변동사항'**을 묶어서 만든다.
2. 예를 들어, 버튼 클릭 버그를 고치는데 5가지 파일을 수정했다면 그 5가지를 묶어서 하나의 커밋으로 만든다.
3. 동료 개발자가 '버튼 클릭 버그'를 고치는데 어떤 파일을 수정했는지 손쉽게 파악 가능
4. 커밋 메세지 적는게 귀찮아도 정확히 적어주는 것이 중요하다. (알아보기가 편해지기 때문)

![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/capture_images/deeecfd2016941a38fae22981546aebe/2fadda79-d428-48a0-860b-311010608740.png)



- Add(애드) : 커밋으로 만들길 원하는 파일만 선택



- 버전 생성 실습

1. VS Code를 통해 해당 폴더에 README.md, index.html 파일 생성
2. 원하는 파일만 선택 ( 예. README.md 파일만 커밋 )
   ```git add README.md ```
3. 메세지를 달아 커밋으로 만들기
   ```git commit -m "프로젝트 설명 파일 추가"```
4. 생성한 커밋 보기
   ```git log```



- 만든 버전 GitHub에 코드 올리기

1. 깃헙에서 Boxiting 레파지토리를 생성
2. 내 컴퓨터 boxiting-cat 폴더에 GitHub 저장소 주소 알려주기
   ```git remote add origin https://github.com/{사용자 명}/{레파지토리 이름}.git```
3. 만든 커밋 Push 하기
   ```git push origin master```


- 다른 사람이 만든 저장소 받아오기

1. Clone(클론)
   - 원격 저장소에 A가 커밋을 올린 것을 B가 본인 컴퓨터에 받아오고 싶을 때 사용하는 방법
   - Clone을 하면 원격 저장소의 코드를 받아오며, 로컬 저장소도(.git) 자동으로 생긴다.
2. Pull(풀)
   - 개발자 A가 원격 저장소(Github)에 코드를 Update 했다면, 개발자 B는 Clone을 통해 생성했던 로컬 저장소에서 Pull 명령어를 통해 업데이트 된 코드를 가져올 수 있다.
3. 개발자 B의 Push
   - 개발자 B 또한 개발자 A의 원격저장소에 Push 할 수 있다. 하지만 푸시 권한이 있을 때만 가능하다. (너무도 당연한 얘기- A의 저장소에 B가 수정한 파일을 업로드한다? -> A가 권한을 부여해야만 가능할 것 같다는 추측을 할 수 있다.)



* Clone 실습
  * 내 컴퓨터에 새로운 폴더 Boxiting-oct 생성
  * 터미널(git bash) 에서 Boxiting-oct로 이동 -> ls -al 명령어 입력 -> 빈 폴더
  * git clone https://github.com/Supreme-YS/Boxiting.git . (공백 .(점)) 을 입력해준다. 띄어쓰기 + . 의 의미는 **현재 폴더에 풀어라**

**※만일 .(공백 + 점)을 하지 않으면 폴더 안에 폴더가 생기는 형태로 생성된다.**

![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/deeecfd2016941a38fae22981546aebe/0f649309-365e-4a1c-9ba2-c602b3f23869.png)

- - Boxiting-oct 폴더에서 app.js 파일을 생성
  - ```git add app.js```
  - ```git commit -m "oct의 commit"```
  - ```git push origin master```



* Pull 실습

![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/deeecfd2016941a38fae22981546aebe/2425514a-f50d-4989-9700-b8fe3cb53b9b.png)

![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/deeecfd2016941a38fae22981546aebe/346e7fe4-cecd-403f-80cd-b9a8c7f115e5.png)

- - 현재 Boxiting-cat은 A개발자, Boxiting-oct는 B개발자라고 해보자.
  - A가 만든 깃헙에서 아래와 같이 B가 올린 app.js가 확인된다. 

![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/deeecfd2016941a38fae22981546aebe/fcea3edc-bf69-41c7-9580-56140174e926.png)

- - A는 B가 올린 파일을 가져오기 위해 Pull 명령어를 사용한다

![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/deeecfd2016941a38fae22981546aebe/645801ad-5076-4096-ba30-42d5580a0bc6.png)

![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/deeecfd2016941a38fae22981546aebe/84237d38-d93d-4c07-ad7e-fd794bb649f2.png)

- - git pull origin master 명령어를 통해 성공적으로 app.js 파일을 가져온 것을 확인할 수 있으며, 실제 로컬 폴더에도 저장되어 있음을 알 수 있다.



- 협업 시나리오 가정

1. 해커톤에 참가한 개발자 A는 개발자 B와 짝이 된다.
2. 개발자 A가 git init으로 로컬 저장소를 생성한다.
3. A는 메인 페이지 제작을 맡아 진행했고, ```git add```한 다음 ```git commit -m "메인 페이지 생성"``` 이라는 커밋을 생성했다.
4. GitHub에 원격 저장소를 만들어 그 주소를 로컬 저장소에 알려준 후 (```git remote add origin {저장소 주소}```) 원격 저장소에 푸시 (```git push origin master```)
5. B도 개발을 시작하기 위해 A가 올려준 원격 저장소를 본인 컴퓨터에 가져온다. (```git clone {저장소 주소}```)
6. B는 디테일 페이지 제작을 맡았다. A는 GitHub 저장소에 B 계정을 Collaborator로 추가(Push 권한을 받기 위해)한 후 새 커밋을 푸시한다.
   - GitHub -> 해당 레파지토리 -> Settings 탭 -> Manage Access 탭 -> 개발자 B의 깃헙 계정 아이디 입력 -> B에게 자동으로 메일 전송 후 -> 승인추가 완료
7. collaborator로 권한이 생긴 B는 디테일 페이지를 원격 저장소에 Push 한다.
8. A는 B가 Push 한 내용(B가 제작한 디테일 페이지)을 가져오기 위해 Pull 명령어를 사용한다 (```git pull origin master```)