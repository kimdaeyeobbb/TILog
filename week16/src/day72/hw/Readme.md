# 실습 참고사항


## 사용해야 하는 명령어

- 컨테이너가 기동될때가 아닌 이미지가 빌드될 떄 디렉토리가 만들어져야함 => RUN 명령어 사용



- FROM
- WORKDIR
- COPY
- EXPOSE
- ENTRYPOINT




- 9000번 포트번호는 호스트의 포트번호


<br>


# 실습 수행과정



2. 다음 내용을 반영하여 Dockerfile 을 생성

```shell
# base 이미지 설정
FROM nginx

# 현재 디렉토리 위치를 /usr/share/nginx/html로 변경
WORKDIR /usr/share/nginx/html

# images 디렉토리 생성
RUN mkdir images

# 호스트 머신의 docker.png를 images 폴더에 복사
COPY docker.png images/

# 호스트 머신의 my.html을 현재 디렉토리에 복사
COPY my.html .

# 80번 포트로 리스닝 설정
EXPOSE 80

# nginx 서버 기동 및 -g와 daemon off; 설정
CMD ["nginx", "-g", "daemon off;"]
```


3. 2번에서 완성된 Dockerfile을 가지고 도커 이미지 new_xxxnginx 를 생성

```shell
docker build -t new_kdynginx . 
```



4.  9000 포트번호로 컨테이너를 기동시키고 my.html 을 요청

```shell
docker build -t new_kdynginx .
```