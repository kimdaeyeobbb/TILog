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