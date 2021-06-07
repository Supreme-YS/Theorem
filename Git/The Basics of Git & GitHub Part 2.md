### The Basics of Git & GitHub Part 2

- Source Tree 설치 : https://uxgjs.tistory.com/181 를 참고하여 설치 진행



- Source Tree 사용 이유 : 버튼 클릭으로 Git 명령을 실행할 수 있는 도구, Git 개념을 그래프를 통해 가시적으로 볼 수 있어 편리합니다.



- Git 에서의 Commit 이란?

  - 변경사항의 모음 (X) ---> **하나의 최종 코드 모음 (O)**
  - 기존 커밋과 비교해서 변경된 파일이 아니면 **' 변경되지 않았다'고 저장**하기 때문에 용량이 무겁지 않습니다. 
  - 다른 형상 관리 프로그램인 **SVN은** 변경 사항만 저장한다. 그래서 커밋당 용량은 Git 보다 가볍지만, 하나의 버전을 보려면 맨 처음 커밋부터 계산해야 하므로 속**도가 느린 단점**이 있습니다.
  - 하지만 **Git은** 바로 이전 커밋만 보면 되기 때문에 **속도가 빠릅니다.** 

  

- 로컬 저장소 생성( ```git init```) 이후 add - commit - push 세부 프로세스
  - ```git add``` 를 통해 Stage 공간에 올림 ( 깃 로컬 저장소(.git)가 **'stage 됨'** 이라고 적어놓습니다.)
  - ```commit```을 통해 **"수정 없음"**으로 돌아갑니다.
  - push로 원격 저장소에 올립니다.
  - 파일이 수정되었다면? ---> ```add```를 통해 stage 됨으로 변경되고,  ```commit```을 하면 기존 커밋에서 **"수정없음"** 상태로 돌아가게 됩니다.



- Git으로 추적하는 파일의 4가지 상태
  - ```Untracked``` : 추적안됨 - 깃에 한번도 올리지 않았던 파일
  - ```Tracked``` : 깃에 올린파일들의 상태 (```수정없음``` / ```수정함``` / ```스테이지됨``` )
  - 작업공간에 있는 ```수정함```/ ```추적안됨``` 파일을 스테이지로 올려서 ```스테이지 됨```으로 변경합니다. 
  - 커밋을 하면 수정없음 상태로 돌아가서 다시 파일을 수정할 수 있습니다.



- 실습 예제를 통한 화면 탐색

  - 상황 : GUI로 add, commit, push, pull 진행

    ​		  먼저, README.md, index.html 파일을 수정합니다.

    ​		  소스트리 화면에서 스테이지에 올라가지 않은 파일들을 확인할 수 있습니다.

- 
  ![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/38046e66-a2ba-40b8-9d1e-00177d016515.png)

- 물음표(?) 표시는 : ```Untracked``` 상태

- README.md : ```바뀜``` 상태
- ![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/6a101be2-a2d9-4656-ba75-f6aa6a3a3c58.png)

- 위처럼, 스테이지에 올라가지 않은 파일들을 우측의 플러스 버튼(+)을 통해 스테이지에 올리고 하단에 커밋 메시지 창에 커밋 내용을 입력합니다. 위 그림은 스테이지에 올린 상태입니다.
- 이후 우측 하단에 **커밋 버튼을 클릭** ---> 아래와 같이 "커밋메시지"와 함께 커밋이 된 것을 확인할 수 있습니다.
- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/8611c8b0-c74c-4a03-b535-34256c2f1335.png)

- master ( 로컬에 있는 코드 )
- origin/master ( 원격 저장소에 있는 코드 )
- 즉, 원격 저장소에는 현재 **oct의 commit**만 있으며, 현재 내 로컬 저장소에는 **'커밋 메시지'**의 커밋이 있는 상태입니다. 따라서, 원격 저장소로의 동기화를 위해 Push 버튼을 클릭합니다.
- ![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/46b2abe1-43b3-4297-8694-203cf73baedd.png)

- 위 그림처럼 , master(로컬), origin/master(원격)에 성공적으로 동기화 된 것을 확인할 수 있습니다.
- 실제로 깃헙(원격 저장소)에 업로드 확인이 가능합니다.
- ![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/0f8b40ae-8239-4bf8-bc66-8a5736736398.png)



- 지금까지의 상황을 정리해보겠습니다. 
- 로컬 저장소 명 : **Boxiting-cat( = 개발자 A )**  ---> README.md, index.html 파일 수정해서 현재 '커밋 메시지'라는 커밋 내용으로, 원격에 업로드 한 상태입니다.
- 로컬을 Clone 한 저장소 명 : **Boxiting-oct ( = 개발자 B )**

- 이 후 원활한 설명을 위해 **개발자 A, 개발자 B**라는 용어로도 사용한다는 점을 인지하시길 바랍니다.



- 이제 방금 추가한 코드들(README.md, index.html)을 개발자 B가 Clone 한 폴더 ( Boxiting-oct )에 Pull 을 해봅시다.
- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/99948005-d219-4c60-b0a2-eb0544ed0192.png)

- Boxiting-oct 창에서 Pull 버튼을 통해 Boxiting-cat에서 파일을 업데이트하고, 커밋과 푸쉬를 통해 원격에 업로드 했던 사항들을 가져옵니다. ( * 여기서 origin/HEAD는 현재 내가 작업하고 있는 위치를 나타내주는 포인터 역할을 합니다.)
- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/a4db85ee-c9f0-41be-adfa-a1c4e6bd39c2.png)

- 위의 그림에서 알 수 있듯이, 개발자 A(Boxiting-cat)가 **'커밋 메세지'**로 커밋했던 사항들이 Clone 된 폴더인 개발자 B(Boxiting-oct) 폴더로 Pull 된 것을 알 수 있습니다.



### Branch (브랜치)

- 평행세계 나누기 - 보통 새로운 기능을 만들 때 브랜치를 두고 작업을 진행합니다.
- 사용하는 이유 : 한 줄로 커밋을 쌓으면 개발자 A, B가 겹칠 수 있는 상황이 발생합니다. ( 코드 충돌, 똑같은 코드를 동시에 고칠 가능성이 발생) 따라서, N개의 줄로 쌓고 나중에 Merge 하는 과정을 진행하는 것입니다.
- ```git branch {브랜치 명}``` : {브랜치 명}으로 현재 시점에 브랜치를 만들어!
- ```git checkout {브랜치 명} ```: {브랜치 명} 브랜치로 이동해!
- master 브랜치는 아직 과거 커밋을 {브랜치 명} 브랜치는 새로운 커밋을 가리킵니다.
- master 브랜치의 최신 시점으로 checkout 명령어를 통해 돌아가서 새로운 {브랜치 명 2}을 생성합니다.
- 현재까지의 상황 정리
  - 개발자 A가 master이며, master의 최신 시점에서 {브랜치 1}을 생성하여 개발 진행
  - 개발자 B는 master 브랜치의 최신 시점에서 {브랜치 2}로 분기하여 개발 진행

![image-20210402181014603](C:\Users\dudtj\AppData\Roaming\Typora\typora-user-images\image-20210402181014603.png)

- 개발 상황 가정 
  - 개발자 A ( Boxiting-cat ) : main-page 제작
  - 개발자 B ( Boxiting-oct ) : comment(댓글) 기능 제작
- 소스트리에서 브랜치 버튼을 클릭한 후 feat/main-page 브랜치를 생성합니다.
- ![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/faa14a75-7cbe-42a3-a59e-96a99e2b9adf.png)

- 이 곳에 새로운 커밋을 추가하기 위해 코드를 간단하게 수정합니다. (**index.html 파일 수정**) 

  아래의 그림처럼 Visual Studio Code에서도 GUI를 통해 커밋을 할 수 있습니다. 

- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/c1ec1308-fe1a-451d-856d-fbf79f81cea5.png)

- 플러스(+)을 통해 Stage로 옮기고 Stage에 올라간 것을 Commit Message와 함께 적고 체크 박스 버튼을 클릭하면 커밋이 완료됩니다.

- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/fdfedb59-15fe-4d7c-bd9d-cddc951bd7d5.png)

- 아래의 그림과 같이 소스트리에서 ```Fetch``` 버튼(=새로고침)을 클릭해서 **update index** 라는 커밋 메시지를 확인 할 수 있습니다.

- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/9ff900c9-aa61-4852-9218-58f1de7ee407.png)

- 현재까지의 상황 정리
  - master 03 (최신 시점) 시점에서 feat/main-page 브랜치를 만든 상태
  - index.html 파일 수정해서 update index라는 커밋 메시지로 커밋
  - ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/120b289c-270a-4173-a210-ef4fc9f51afd.png)
  - 원격저장소에 Push를 진행합니다.
  - 위 그림처럼 ```origin/feat/main-page```라는 원격 경로가 확인되는 것을 알 수 있습니다.



- 변경사항이 발생했으니, 개발자 B(Boxiting-oct)의 시점에서 확인을 해봅시다.
- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/d9238332-6ccf-45f2-9c35-64308332d27d.png)

- 위 그림처럼 개발자 A(Boxiting-cat)가 만들었던 브랜치 ```feat/main-page```를 확인할 수 있습니다.
  - 추가로, 현재 개발자 B에서 작업을 진행하고 있으므로 origin/HEAD (포인터)를 확인할 수 있습니다.
- 원격 저장소의 변동사항(개발자 A가 커밋하고 브랜치 만든 것들)을 가져오기 위해 원격 저장소에서 Pull을 진행합니다.
- 이후 개발자 B는 Comment(댓글) 기능 개발을 위해 **feat/comment 브랜치**를 생성합니다.
- feat/comment 브랜치에서 개발이 완료되어, comment.js 파일을 만들어서 커밋을 시도합니다.
- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/375719ff-8f1d-439e-b87e-6cd7b7f0eb90.png)

- 위 그림과 같이 개발이 완료된 comment.js를 스테이지에 올리기 위해 add하고 commit 을 위해 커밋 메시지에 "Develop comment function" 을 적고 커밋을 진행합니다.
- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/7ab14c4d-1520-4f19-a99b-a31962e24eaf.png)

- 개발자 B(Boxiting-oct) 의 브랜치(feat/comment)에서 작업을 마치고 원격 저장소에 push를 완료한 모습입니다.



### Merge (머지)

- feat 브랜치에서 작업을 마치고, 이제 master에 합치고 싶다면? 
- 현재까지의 상황
  - **master 03 시점에서 두 개의 브랜치를 만듦** 
  - A 개발자 : Boxiting-cat 로컬 저장소 , 메인 페이지 개발 담당 , feat/main-page 브랜치로 작업완료 한 상태
  - B 개발자 : Boxiting-oct 로컬 저장소, 댓글 기능 개발 담당, feat/comment 브랜치로 작업완료 한 상태

- 이제 master 브랜치의 최신 커밋(master 03 시점)에 개발자 B 브랜치의 최신 커밋(compare)을 합쳐봅시다.
  - 1. 먼저 master 브랜치의 최신 커밋 시점(master 03) 브랜치로 이동합니다.
    2. ```git merge {브랜치 명}``` 명령어를 통해 Merge 합니다.
    3. 합쳐진 결과는 개발자 B의 브랜치이고 master 브랜치도 개발자 B의 브랜치로 변경된 것을 알 수 있습니다.
- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/image_upload/f42624e8344041e7841606f1f5ee78c5/b1501e19-df86-4961-821f-ae43dcf7cdc8.png)

- 이해를 돕기위한 추가 설명
  - 왼쪽 브랜치 창에서 master 탭을 더블 클릭해서 master 브랜치로 이동합니다.
  - 그래프에서 세번째 ```origin/master```가 가장 최신(master03)이었습니다.
  - 하지만 우리의 목적은 브랜치로 개발해서 master에 merge를 하는 것입니다.
  - 따라서, merge하면 브랜치였던 것이 자동적으로 master로 변경이 된 것을 확인할 수 있습니다.
  - 즉, 가장 최신 버전이 된 것입니다.
  - 최신 버전의 master 04 ( 댓글 기능이 추가된 프로그램 )가 된 것 입니다. 
  - 이후, master로 머지를 했으니 master로 push하면 원격 저장소와의 동기화도 완료됩니다.



### Conflict (충돌)

- Conflict는 Merge 과정 중 발생하는 문제점 중 하나입니다. Conflict가 발생하는 상황은 아래의 그림과 같습니다.
- ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/capture_images/f42624e8344041e7841606f1f5ee78c5/dde989b7-7ce0-4b0c-95ea-a49da8690975.png)

- Fast-Forward
  - 1번 그림 예시) 좌측 master, 우측 master에서 뻗은 브랜치( master + 개발 완료한 코드) 이 둘이 합쳐지면 우측 master에서 뻗은 브랜치와 똑같습니다. 그래서 우측 master와 결과물이 다를게 없으니 빠르게 처리가 되고 '빠르게 감겼다'라는 표현을 씁니다. 그게 fast forward입니다.
- Merge-Commit 
  - 2번 그림 예시) **위 소스트리에서 B 개발자가 master 브랜치로 된 것 기억하시죠?** 그 상황에서 A 개발자가 메인 페이지를 추가적으로 개발을 더 진행하여 B 개발자 master 브랜치에 합칠 때 master 브랜치는 새로운 master 브랜치를 생성하고 합쳐지게 됩니다. 이게 Merge-Commit 입니다.
  - ![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/capture_images/f42624e8344041e7841606f1f5ee78c5/ac24bebd-af26-40e6-87dd-975adf2a1b0d.png)

- Conflict 
  - 3번 그림 예시) 개발자 A와 개발자 B가 개발을 마치고 Merge를 하는 과정에서 똑같은 부분을 개발했을 때 새로 생기는 master 브랜치는 어떤 코드를 사용해야 할지 알 수 없습니다.
  - 따라서 아래 그림처럼 Code 가 Conflict(충돌)했다는 오류를 발생시킵니다.
  - ![img](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/capture_images/f42624e8344041e7841606f1f5ee78c5/a5d30aed-6b83-42a5-8533-cc489707c9ea.png)
  - ![screen captures](https://slid-capture.s3.ap-northeast-2.amazonaws.com/public/capture_images/f42624e8344041e7841606f1f5ee78c5/47c824fa-8506-4cbe-87ac-657857c99726.png)
  - 이렇게 충돌이 발생할 때는 개발자 A와 B가 소통을 통해 합의된 결과를 도출하고 충돌이 나지 않게 코드를 수정해줌으로써 해결할 수 있습니다.



### Fork (포크)

- 개발 상황 가정
  - 개발자 A, B가 만든 프로그램을 살펴보던 **개발자 C가 '새로운 기능'을 추가**하고 싶습니다. 단, 저장소의 Push 권한은 개발자 A와 개발자 B만 가지고 있습니다.
- 그렇다면 오픈소스에 기여하기 위해선 반드시 Collaborator를 등록하는 방법이 있을 수 있습니다. 하지만 모두에게 그런 권한을 주는 건 Git log 상 관리가 어렵게 만들 수 있습니다.  따라서, **Fork 기능**을 사용하면 해결할 수 있습니다.
- 방법
  - 저장소를 통째로 개발자 C의 계정에 복제해와서 그 저장소(C의 저장소)에 자유롭게 커밋, 푸시를 하고, 내 저장소(C의 저장소)의 브랜치와 A,B의 저장소의 브랜치를 머지해달라고 A와 B에게 요청하면 됩니다.



### Branch vs Fork

- 공통점
  - 코드를 협업하기 위해 분기점을 나누는 방식입니다.
- 브랜치
  - 하나의 원본저장소(master)에서 분기를 나눕니다. 하나의 원본저장소에서 코드 커밋 이력을 편하게 볼 수 있다는 장점, 다만 다수의 사용자가 다수의 브랜치를 만들면 관리하기 힘듭니다.
  - 작은 프로젝트에 사용하기 적합
- 포크
  - 여러 원격저장소를 만들어 분기를 나눕니다. 원본저장소에 영향을 미치지 않으므로 마음껏 코드를 수정할 수 있습니다. 다만 원본저장소의 이력을 보려면 따로 주소를 추가해줘야 합니다.
  - 오픈 소스에서 주로 사용하기 적합



### Pull Request(PR)

- 개요 : 포크 이후 개발을 완료해서 원본에 머지하고 싶을 때

- 개발 상황 가정
  - 개발자 C가 포크한 저장소에서 기능 개발을 마치고 개발자 A, B의 원본 저장소에 머지해 달라고 하고 싶습니다. 하지만 개발자 C는 원본 저장소에 코드를 올릴 권한이 없을 때 사용합니다.
  - A, B야! 이 커밋이랑 저 커밋을 합치는 걸 허락해주겠니? ( Pull Request )
- 사용방법
  - 1. 머지하고 싶은 두 브랜치를 선택합니다.
    2. 어떤 변경을 했는지 제목과 내용에 씁니다.
    3. 단일 저장소에서 보낼 수도 있고, 포크한 저장소에서도 보낼 수 있습니다.
    4. 개발자 A의 request 승인으로 인해 머지가 성공하면, base 저장소(개발자 A)의 소스트리에서 pull을 통해 원격과 로컬을 동기화 시켜주면 됩니다.
- 사용 Tips
  - 코드를 함께 작성하는 팀원이 있다면, 직접 머지는 지양 -> 모든 머지를 풀 리퀘스트를 통해 진행
  - 동료가 내 풀 리퀘스트(PR)을 보고 코드를 리뷰할 수 있습니다.
  - 동료가 PR에 수정이 필요하면 댓글을 달아 Change request를 보낼 수 있습니다.
  - 오픈 소스에 PR을 보낼 땐 '기여 안내문서(contribution guideline)을 반드시 참고해야 합니다.



### Amend

- 개요 : 커밋 후 간단한 수정이 필요할 때

- 개발 상황 가정
  - 커밋을 완료했는데 깜박하고 수정 못한 파일이 있다. 정말 약간의 수정 사항 및 추가 사항이 있을 때 사용합니다
- 방법
  - 소스트리 상 커밋옵션에서 **마지막 커밋 수정**을 통해 가능합니다.



### Stash

- 개요 : 개발 도중 커밋하기 애매한 상황이 발생했을 때

- 개발 상황 가정
  - 개발자 A가 B의 부탁을 받고 A가 개발하던 것을 잠시 제쳐두고 B 가 요청한 작업을 먼저 진행해야 할 때, 개발자 A는 진행하던 개발을 **커밋하기엔 애매하다고 판단**하고 개발자 B의 개발을 도와줘야 할 때 잠시 A의 개발을 중단해야 할 때 사용하는 것이 Stash입니다.
  - 이후 개발자 A는 B의 부탁을 해결하고 , Stash 되어있던 개발 파일을 pop을 통해 꺼내와서 개발을 이어갈 수 있습니다.
- 즉, 변경사항을 서랍에 넣어두는 것이라고 생각하면 됩니다. 소스트리에서 스태시(stash)버튼을 클릭해서 메시지를 입력하고, 다른 브랜치에서 작업을 진행할 수 있습니다. 



### Reset

- 개요 : 커밋을 이전의 버전으로 초기화 할 때

- 개발 상황 가정
  - 개발 요구사항이 바뀌었습니다. "싫어요 버튼은 빼고 좋아요 버튼까지만 만들어 주세요"
- 방법
  - 소스트리에서 원하는 버전에서 **master를 이 버전으로 초기화 버튼** 클릭
  - ```soft``` / ```mixed```/ ```hard``` 선택 사항 중 하나를 선택해서 초기화를 진행할 수 있습니다.
    - soft : 모든 로컬 변경사항을 유지
    - mixed : 리셋을 하지만 이 후 변경사항은 로컬에 저장해두고 버리는 것 - 작업 상태는 그대로 두지만 인덱스는 리셋
    - hard : 모든 작업 상태 내 변경 사항을 버림
- 원격 저장소에 리셋된 버전을 올리기 위해선 Push를 해야하겠죠? 하지만 에러가 발생합니다.
- 에러를 무시하고 push 하기 위해 force - push가 필요합니다.
- 소스트리 상에서 **도구 - > 옵션 -> Git 탭 -> 강제 푸시를 허용으로 설정 변경**합니다.
- 소스트리 상에서 push 할 시 **강제 푸시**라는 체크 박스가 생기고, 체크 표시 후 다시 푸시 작업하면 성공적으로 reset 된 것을 원격에 Push 할 수 있습니다.



### Revert

- 개요 : 이 커밋의 변경사항을 되돌리고 싶을 때

- 개발 상황 가정
  - master에 잘못된 커밋을 올려버렸습니다. reset하고 force push하면 다른 사람들 히스토리에 영향을 줄 수 있습니다. 그래서 revert하는 커밋을 새로 만드는 방법을 활용할 수 있습니다.
- 방법
  - 소스트리에서 커밋 된 사항에서 커밋 되돌리기 버튼을 클릭



### Cherry-Pick

- 개요 : 원하는 커밋 하나만 떼서 지금 브랜치에 붙이고 싶을 때 
- 개발 상황 가정
  - 어제 릴리즈한 latest 브랜치에 버그가 있습니다. 일단 fix/text-bug 브랜치에서 버그를 고쳐서 master에 머지했습니다.
  - 하지만 master에 다른 수정사항도 너무 많아서 latest랑 당장 머지할 수 없습니다.
  - 그래도 릴리즈된 latest 브랜치에 버그 수정 커밋은 들어가야만 합니다.
  - 따라서 고친 코드가 있는 버그 수정 커밋을 latest에 똑 떼내어 붙이는 과정을 체리픽이라고 합니다.
- 방법
  - 소스트리의 그래프에서 해당 커밋을 우클릭 후 체리픽 버튼을 클릭



