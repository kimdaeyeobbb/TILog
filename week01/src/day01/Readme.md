# Linux

- 핀란드 헬싱키 대학생인 리누스 베네딕트 토르발스가 처음 개발한 OS
- 미닉스(MINIX)라는 교육용 운영체제를 참조하여 개발함

## 특징

- 서버용 OS로 많이 사용됨
- 편리한 GUI 환경을 제공함
- 공개 S/W이며 무료로 사용할 수 있음
- 유닉스와의 호환성을 유지함

## 리눅스 구조

### 1. 커널

- OS의 가장 핵심적인 역할을 하는 부분
- CPU, 메모리, 프로세스, 파일시스템, 입출력 등 주요 자원을 관리
- 최초 기동시(부팅시) 메모리에 로드됨

### 2. 쉘

- OS 커널과 사용자 간의 인터페이스 역할(다리 역할)을 수행하는 텍스트 기반의 명령어 해석기
- 주요기능
  - 명령어 해석 (Command Line Interface)
  - 프로그래밍 기능 (쉘 스크립트)
  - 사용자 환경 설정 기능 (쉘 변수, 환경 변수)


<br>

## 리눅스 실습 환경

### 1. Virtual PC

### 2. Virtual BOX

### 3. VMware

- Windows 가장 머신 중 가장 사용하기 쉬운 것 

# 리눅스 기본 명령어

```bash
pwd   # Print Working Directory. 현재 경로에 어떤 폴더가 있는지 출력
ls   # List. 폴더 파일목록 출력
ls -a   # ls -all.
ls -al   # ls -all longformat
ls -ld .   # -ld: -l는 롱포맷 .는 현재 폴더
cd   # Change Director.   현재 폴더 변경
cp   # Copy.   파일 또는 폴더 복사
touch   # 파일 생성 또는 수정시간 변경
mv   # Move. 파일이나 폴더의 위치 변경, 이름 변경
mv myfile mydir # myfile이 mydir로 옮겨짐
mkdir # make directory.   폴더 생성
rmdir   # Remove directory.  폴더 삭제(비어 있어야 함)
cat   # Catch. 파일 내용 출력
head   # 파일의 첫 10행 출력
tail   # 파일의 마지막 10행 출력
file   # 파일의 종류를 표시
clear   # 화면을 지움
man   # manual. 명령어 help
rwx # r: read, w: write ,x: execute(실행) 
```


- 루트 디렉토리
  - 내가 권한을 어떻게 가지고 있는지를 볼 수  있음.
```java
/
``` 


# 리눅스 서버에 여러사람이 접속하는 경우, 파일에 동시에 접근하면 어떻게 되나?

-  먼저 접속 및 실행하는 쪽에서 먼저 실행이됨

# 리눅스 사용자 & 그룹

- 리눅스는 기본적으로 `root`라는 슈퍼유저(Superuser)가 존재하며, 모든 작업을 할 수 있는 권한을 가짐
- 

## 슈퍼유저

- `#프로퍼티`가 있으면 슈퍼유저임
- su(원래는 슈퍼유저 였음)라고 치고 엔터를 치면 패스워드를 입력해야함 (비밀번호는 password)
- exit를 입력하면 나가게 됨.
- 내가 슈퍼유저 권한이 필요하면 들어갔다 나왔다 하면 됨
- 슈퍼유저로 작업을 계속하면 위험성이 있으므로 항상 슈퍼유저로 작업하는 것을 권장하지는 않음



# file permission

- 리눅스는 모든 것이 파일이다. 디스크도 파일, 모니터도 파일로 취급한다.
- 리눅스에서는 파일 소유자를 표시하며, 파일 자체가 소유그룹이라고 하여 그룹화함

- 파일의 내용을 보려면 캐쉬라는 내용으로 볼 수 있음

## 접근 권한 표시 방법

- rwx를 세문자로 바꾸어서 표기함. 묶어서 표기할 때 rwx를 4,2,1로 환원함. 자리에 대한 값으로 입력

|접근권한|환산| 의미                                                                  |
|:---|:---|:--------------------------------------------------------------------|
|r|4| read<br> 파일의 내용을 볼 수 있는 권한                                          |
|w|2| write<br> 파일을 수정/이동/삭제할 수 있는 권한<br> 쓰기권한 삭제시 readonly가 됨            |
|r|1| execute<br> 파일을 실행할 수 있는 권한  <br> cd 명령어를 사용해서 디렉토리로 이동하거나 복사할 수 있음 |


# link
 
- 윈도우에도 링크가 있지만 리눅스상 링크는 크게 2가지로 나뉨

## 1. 하드 링크

```bash
ln  링크대상파일이름 링크파일이름
```

- 하드링크 생성시 '하드 링크 파일'만 하나 생성됨 & 같은 inode1을 사용함

## 2. 심볼릭 링크 (소프트링크)


```bash
ln -s 링크대상파일명 링크파일명
```

- 새로운 inode2를 생성하고 데이터는 원본 파일을 연결하는 효과를 가짐

```bash
ln -s link2_myfilenew myfilenew 
ln -s link2_myfilenew link2_myfilenew
ls -l # l이 붙어있으면 심볼릭 링크
```

- 심볼릭 링크는 원래  파일이 지워지면 소용이 없어짐

- 심볼릭 링크의 경우 새로운 아이노드가 생성됨 (얘는 링크에 해당됨)



# rpm 명령어

- redhat package manager
- 패키지를 관리하는 도구
- 의존성을 관리함

```bash
rpm # 이 명령어로 라이브러리나 툴들을 설치할 수 있음
```

# yum 명령어

- rpm을 좀 더 업그레이드한 것 (rpm 명령의 패키지 의존성 문제를 해결)

# dnf 명령어

- dandified yum


# 리눅스 파일 압축 유틸리티

## tar

- tar는 하나로 똘똘 만다는 느낌으로 하나로 묶어버리는 것 (압축이랑은 다른 개념. 파일을 묶어두는 개념으로 생각하기)

- 묶여있는지 아닌지는 tar 명령어를 가지고 아래에 있는 것들을 볼 수 있음

- 일반적으로 tar인지 아닌지는 잘 모름 (cvf등을 통해 묶여진것이 무엇인지를 볼 수 있음)


## tar의 동작

### 1. c

- create

### 2. x

- extract

### 예제
```bash
tar cvf my.tar /etc/hp
tar xvf my.tar 

# etc 밑에 hp라는 폴더로 만들어다가 tar로 묶겠다는 것
```


```bash
tar xvf my.tar
# tar로 만들어진 것을 풂
```



# 리눅스 파일 위치 검색

- find
    - 파일 찾아줌
    - `find link2*` → link2로 시작되는 파일 찾기

# vi 에디터

- vi 에디터는 시작을 하고 나서는 명령모드임

- 명령모드
    - 명령이 실행되는 환경
    - 명령어를 해석해서 행을 삭제하는 등의 여러가지 명령이 존재

- w
    - 한 단어씩 word별로 이동

- ^(커랫)
    - 맨 앞을 의미

- $ (달러)
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
