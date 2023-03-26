# Linux

- 핀란드 헬싱키 대학생인 리누스 베네딕트 토르발스가 처음 개발한 OS
- 미닉스(MINIX)라는 교육용 운영체제를 참조하여 개발함

## VMware

---

암호

→ centos

개발자는 터미널창을 많이 사용할 것임

윈도우즈에서는 터미널창

맥북도 리눅스계열

```bash
ls -a
ls -al
ls -ll

cd 
mv 파일 옮김

```

tab키 사용시 자동완성
→ 현재 상황에서 완성될 수 있는 것들을 보여줌

틸드

→ 자신의 홈 디렉토리

```bash
mkdir # 폴더 생성
touch
mv myfile mydir # myfile이 mydir로 옮겨짐
clear  # 
ls -ld .   # -ld: -l는 롱포맷 .는 현재 폴더
rwx # r: read, w: write ,x: execute(실행) 
```

나는 centos라는 이름으로 로그인했고, 얘에 대한 권한을 확인할 수 있음 (rwx등)

`/` : 루트 디렉토리. 내가 권한을 어떻게 가지고 있는지를 볼 수  있음. 쓸 수 있는 권한이 없다면  ~

리눅스 서버에 여러사람이 접속하는 경우, 파일에 동시에 접근하면 어떻게 되나?

→ 먼저 접속 및 실행하는 쪽에서 먼저 실행이됨

- 리눅스 서버에 접속하기  위한 툴
    - putty

### 슈퍼유저

---

- 리눅스는 root라는 슈퍼유저가 존재함. su라고 치고 엔터를 치면 패스워드를 입력해야함 (비밀번호는 password)
- #프로퍼티가 있으면 슈퍼유저임
- su → 원래는 슈퍼 유저였음.
- exit를 입력하면 나가게 됨.
- 내가 슈퍼유저 권한이 필요하면 들어갔다 나왔다 하면 됨
- 슈퍼유저로 작업을 계속하면 위험성이 있으므로 항상 슈퍼유저로 작업하는 것을 권장하지는 않음
- 리눅스도 gui가 존재함.

```bash
cat  # 파일 내용 살펴봄
```

### file permission

---

매우 중요

`ls -l` : 롱 포맷으로 살펴봄

리눅스는 모든 것이 파일임

디스크도 파일, 모니터도 파일로 다룸

윈도우에도 링크가 있지만 리눅스상 링크는 크게 2가지로 나뉨

리눅스에는 파일 소유자를 표시함

파일 자체가 소유그룹이라고 하여 그룹화함

허가권은 파일과 디렉토리에 미치는 영향이 다름

디렉토리의 실행이라는 것은 cd권한을 사용할 수 없음

```bash
file
file .
file -name
```

쓰기권한 삭제시 readonly가 됨

디렉토리에는 어떤 명령어를 줄 것인가?

r권한이 없다면 파일의 내용을 볼 수 없음

파일의 내용을 보려면 캐쉬라는 내용으로 볼 수 있음

w권한은 파일을 수정할 수 있는 권한

cd+엔터

→ 자신의 홈 디렉토리로 이동

```bash
vi myshell.sh

i # insert
esc # 명령모드로 감
:wq! # 
ls # myshell.sh가 생성됨

./myshell.sh  # 허가거부
ls -l myshell.sh # 허가권이 없다는 것을 확인할 수 있음. 실행을 위해 에스?권한이 필요함
```

rwx를 세문자로 바꾸어서 표기함. 묶어서 표기할 때 rwx를 4,2,1로 환원함. 자리에 대한 값으로 입력

- w권한 추가하기

```bash
chmod 764 myshell.sh
ls -l myshell.sh # 
./myshell.sh
```

centos라는 유저가 파일을 실행할 권한이 있는지?

없다면 그 권한을 주는것은 어떻게 하는지?
이것이 실행된다는 것은 어떤 의미를 갖는지?

```bash
mkdir myfolder
ls -ld # 권한 확인
chmod 444 myfolder
ls -ld
cd myfolder # 허가거부 (실행권한. 즉 x권한이 없음)
```

디렉토리에서의 read는 내가 여기에 파일을 생성하거나 옮겨놓는 권한을 의미함

x권한(execute권한)은 change directory를 할 수 있고 없고를 결정

# 과제

---

1.    가상머신에는 어떤 제품이 있는가?

VMware
virtual machine

virtual box

2.    리눅스에서 IP주소를 확인하는 명령어는 무엇인가?

hostname -I
ip addr show
ifconfig

4.    GNU는 무엇의 약어인가?

Gnu’s not UNIX
(프리 소프트웨어 재단에 의해 개발된 유닉스 운영체제용의 프로그램)

5.    리눅스의 세 가지 구성 요소를 간단히 설명하시오.

커널
(리눅스의 핵심이며, 프로세스/메모리/파일 시스템/장치 관리를 담당함. 컴퓨터의 모든  자원 초기화 및 제어가 가능함)

쉘
(사용자 인터페이스이며 명령을 해석할 수 있음)

응용 프로그램
(각종 프로그래밍 개발 도구이자 문서 편집 도구임)

6.    비교적 잘 알려진 리눅스 배포판 종류를 기술하시오.

데비안 계열

레드헷 계열

7. 다음 명령의 의미를 기술하시오.

명령어    의미

cd ..         현재 디렉토리의 부모 디렉토리로 이동함

cd ../temp      상대경로를 사용하여 현재 디렉토리의 상위 디렉토리로 이동 후 temp 디렉토리로 이동함

cd ~user2      user2는 사용자명에 해당되며, 입력한 사용자의 홈 디렉토리로 이동함.

cd ~/temp      ~명령어를 통해 자신의 홈 디렉토리로 이동후 temp다렉토리로 이동 (홈에 있는 temp로 이동)

cd /tmp     절대경로를 사용하여 /tmp 디렉토리로 이동

8.    다음 권한을 숫자로 표현해 보시오.

①     rwxr-xr-x

755

② rw-r--r--

644

③ rw-r-----

640

④ r--r--r--

444

⑤ r-xr-xr-x

555

9.   파일의 읽기 권한과 디렉터리의 읽기 권한은 어떤 차이가 있는지 설명하시오.

파일의 읽기 권한

- 파일을 읽거나 복사할 수 있음

디렉터리의 읽기 권한

- ls 명령으로 디렉터리 목록을 볼 수 있음

10.    디렉터리에 실행 권한이 없다는 것은 어떤 의미가 있는지 설명하시오.

cd 명령어를 사용해서 해당 디렉토리로 이동하는 것이 불가능하다는 것임

# link

---

윈도우의 바로가기에 해당됨

하드링크, 심볼릭 링크가 존재

inode

→ ls -i로 확인

```bash
ln link_myfile myfilenew
ln link
```

```bash
vi myfilenew # vi에디터로 편집
cat myfilenew # 내용 확인
```

ln으로 파일을 만든것과 동일~~

```bash
rm myfilenew # 파일 삭제
ls # 파일 삭제된 것 확인
```

링크

하나를 고치면 다른 파일을 바라보는것과 동일한 내용

두개가 동일한 내용이라는 것을 inode가 같은것을 보면서 같은 파일이라고 인식함

ㅅ

### 심볼릭 링크

---

```bash
ln -s 링크대상파일명 링크파일명
```

새로운 inode2를 생성하고 데이터는 원본 파일을 연결하는 효과를 가짐

```bash
ln -s link2_myfilenew myfilenew # 
ln -s link2_myfilenew link2_myfilenew
ls -l # l이 붙어있으면 심볼릭 링크
```

심볼릭 링크는 원래  파일이 지워지면 소용이 없어짐

심볼릭 링크의 경우 아이노드가 새로 만들어지는데 이것은 링크임

## rpm 명령어

---

rpm은 redhat package manager

패키지를 관리하는 도구임

의존성을 관리함

패키지는 라이브러리라고 이해하면 됨

```bash
rpm # 이 명령어로 라이브러리나 툴들을 설치할 수 있음
```

## yum 명령어

---

rpm을 좀 더 업그레이드한 것

## dnf 명령어

---

dandified yum의 약어. (외울필요 없음)
뭔지만 알고 넘어가기

## 리눅스 파일 압축 유틸리티

---

- tar

많이 사용

한번씩은 써볼 것

c

- create

x

- extract

etc 밑에 hp라는 폴더로 만들어다가 tar로 묶겠다는 것

```bash
tar cvf my.tar /etc/hp
tar xvf my.tar # 
```

tar로 만들어진 것을 풂

```bash
tar xvf my.tar
```

tar는 하나로 똘똘 만다는 느낌. 하나로 묶어버리는 것 (압축이랑은 다른 개념. 파일을 묶어두는 개념으로 생각하기)

묶여있는지 아닌지는 tar 명령어를 가지고 아래에 있는 것들을 볼 수 있음

일반적으로 tar인지 아닌지는 잘 모름

cvf등을 통해 묶여진것이 무엇인지를 볼 수 있음

### rm -r

---

`-r`

recursive

## 백업

---

`overcopy`

윈도우상 백업 명령어

변경된 부분만 복사해줌. 변경된 부분만 백업 해줌

## 리눅스 파일 위치 검색

---

명령어마다 쓰임새가 다름

- find
    - 파일 찾아줌
    - `find link2*` → link2로 시작되는 파일 찾기
    - e 꺾쇠 슬래시 널 → 에러나는 것들은 표시하지 않고 의미있는 결과만 출력할 때 사용


위치는 실행파일의 위치를 찾아봄

find를 사용하기도 함

## vi 에디터

---

vi 에디터는 가볍게 보면 됨

개발자의 주력언어는 바뀔 수 있다. 자주 사용하지 않으면 언어를 잊어버릴 수 있다.

vi 에디터는 시작을 하고 나서는 명령모드임.

- 명령모드
    - 명령이 실행되는 환경
    - 명령어를 해석해서 행을 삭제하는 등의 여러가지 명령이 존재


```bash
ls -a
.bashrc 
```

.bashrc

- w
    - 한 단어씩 word별로 이동

- ^(커랫)
    - 맨 앞을 의미

- jquery how to find attribute using start string

- $ (딸러)
  맨 끝으로 이동

```bash
cw
cc # 전체라인 수정
x # delete
dd # 한 라인 삭제
#dd # #위치에 숫자넣으면 해당 숫자만큼의 라인을 삭제
yy # yank. 줄 복사
p # paste 한 줄을 복사해서 붙여넣고자하는 곳에 p를 입력하면 paste가 됨
3dd # 3줄이 날아감
3yy # 3줄을 복사함

```

- 검색 명령어
    - `/`
    - n
        - 다음 위치 검색
    - N
        - 이전으로 위치 검색

- man ls
    - 메뉴얼 관련 명령어

- 파일 저장관련 명령어들

## 리눅스 - 셀 환경 설정

---

한번은 알아두는 것이 좋다

사용하다보면 부팅이 되었을 때 매번하는 작업이 귀찮을 때가 있다.

환경 설정을 넣어두고 싶을 때 사용

vi에디터로 너허서 환경설정을 해야 함

## 리눅스 시스템의 부팅

---

잘 몰라도 됨

전원 on → 바이오스 단계

- 바이오스 단계
    - basic input/output system

리눅스는 부팅 과정이 결정되어있구나~ 하는 정도로 이해하면 됨

```bash
uname -a

```

### 커널 초기화 단계

```bash
ps -ef | more
```

```bash
ps -e # e: every. 모든것을 보여줌
```

## 리눅스 - 네트워크

---

nmtui

systemctl - 네트워크 설정 변경 후 변경된 내용을 시스템에 적용시키는 명령어

## 리눅스 - 프로세스 & 데몬

---

ps -ef

- 현재 ~ 가 모두 보임

kill

- 프로세스를 강제로 종료

pstree

- 부모 프로세스와 자식 프로세스를 트리 형태로 출력

리눅스는 부팅이 쭉 되면서 가장 최상위의 systemd가 만들어지면서 하위 프로세스들로 알아서 만들어주는 형태

프로세스는 만들었다가 지웠다가. ~

실제로 프로세스가 떠 있는지를 확인하고 떠있는 프로세스를 Kill로 죽이기도 하고~

금요일에 깃, 깃허브를 배울 예정

```bash
# 터미널도 하나의 프로세스이다
kill -9 번호  # 죽이고 싶은 번호 입력 (pid)
```

```bash
/etc/profile
/etc/bashrc
/etc/profile.d/*.sh # 필요하면 아래에다 집어넣으면 실행시켜줄거야. 필요하다면 여기다가 넣음 
# 필요시 설정 파일추가
```

## 사용자 환경 설정 파일

---

```bash
set # 환경변수
env # 환경변수
```

윈도우에서 set 입력시 환경변수가 나옴

환경변수가 나와있어야 ~가 제대로 수행됨

tomcat how to execute

- 환경변수 설정하는 부분들이 나올 것임
- 리눅스에서 환경 설정하려면 ~

틸드(~)는 사용자의 홈 디렉토리

로그인을 하면 ~사 ~ 사용자에 해당 되는 파일들만 실행됨

```bash
adduser myuser # 사용자 추가
```

- 리눅스는 부팅이 쭉 되면서 ~




# 참고자료

- https://www.redhat.com/ko/topics/linux/what-is-the-linux-kernel
- https://steven-life-1991.tistory.com/4
- https://shaeod.tistory.com/930
- https://dasima.xyz/linux-cd-%EC%A0%88%EB%8C%80%EA%B2%BD%EB%A1%9C-%EC%83%81%EB%8C%80%EA%B2%BD%EB%A1%9C/
- https://m.blog.naver.com/jjune095/221234277700
- https://steven-life-1991.tistory.com/7
- https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=lego7407&logNo=221519286579
- https://inpa.tistory.com/entry/LINUX-%F0%9F%93%9A-%ED%8C%8C%EC%9D%BC-%EA%B6%8C%ED%95%9C-%EC%86%8C%EC%9C%A0%EA%B6%8C%ED%97%88%EA%B0%80%EA%B6%8C-%F0%9F%92%AF-%EC%A0%95%EB%A6%AC
- https://devye.tistory.com/21
- https://psy-er.tistory.com/35
- https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=lego7407&logNo=221514601234
- https://www.google.com/search?q=%EB%A6%AC%EB%88%85%EC%8A%A4+%ED%98%84%EC%9E%AC%ED%8C%8C%EC%9D%BC%EC%97%90%EC%84%9C+%EB%AC%B8%EC%9E%90%EC%97%B4+%EA%B2%80%EC%83%89&rlz=1C5CHFA_enKR1045KR1045&oq=%EB%A6%AC%EB%88%85%EC%8A%A4+%ED%98%84%EC%9E%AC%ED%8C%8C%EC%9D%BC%EC%97%90%EC%84%9C+%EB%AC%B8%EC%9E%90%EC%97%B4+%EA%B2%80%EC%83%89&aqs=chrome..69i57.6855j0j9&sourceid=chrome&ie=UTF-8
