// 캔버스 요소 선택
const canvas = document.querySelector('canvas');

// 캔버스 컨텍스트 설정
const ctx = canvas.getContext('2d');


/* 그리기 */
function draw() {
    // 바탕화면
    ctx.clearRect(0, 0, 580, 450);
    ctx.beginPath();
    ctx.rect(0, 0, 580, 450);
    ctx.strokeStyle = "silver";
    ctx.fillStyle = "white";
    ctx.fill();


    // 머리 그리기
    ctx.fillStyle = 'rgb(234 179 8)';
    ctx.beginPath();
    ctx.arc(200, 100, 80, 0, 2 * Math.PI);
    ctx.fill();

    // 눈 그리기
    ctx.fillStyle = 'rgb(255, 255, 255)';
    ctx.beginPath();
    ctx.arc(160, 80, 20, 0, 2 * Math.PI);
    ctx.arc(240, 80, 20, 0, 2 * Math.PI);
    ctx.fill();

    // 눈동자 그리기
    ctx.fillStyle = 'rgb(0, 0, 0)';
    ctx.beginPath();
    ctx.arc(160, 80, 8, 0, 2 * Math.PI);
    ctx.arc(240, 80, 8, 0, 2 * Math.PI);
    ctx.fill();

    // 코 그리기
    ctx.fillStyle = 'rgb(0, 0, 0)';
    ctx.beginPath();
    ctx.arc(200, 120, 10, 0, 2 * Math.PI);
    ctx.fill();

    // 입 그리기
    ctx.strokeStyle = 'rgb(255, 0, 0)';
    ctx.lineWidth = 5;
    ctx.beginPath();
    ctx.arc(200, 120, 50, 0.2 * Math.PI, 0.8 * Math.PI);
    ctx.stroke();

    // 몸통 그리기
    ctx.fillStyle = 'rgb(255, 255, 0)';
    ctx.fillRect(100, 180, 200, 150);

    // 팔 그리기
    ctx.fillStyle = 'rgb(234 179 8)';
    ctx.fillRect(60, 180, 80, 60);
    ctx.fillRect(260, 180, 80, 60);

    // 다리 그리기
    ctx.fillStyle = 'rgb(0,0,0)';
    ctx.fillRect(130, 330, 40, 80);
    ctx.fillRect(230, 330, 40, 80);
}

/* 저장 */
function save() {
    alert(canvas.toDataURL());  // toDataURL: 캔버스태그에 그려진 데이터형식을 url 형식으로 변환해줌
    window.localStorage.setItem("memocanvas", canvas.toDataURL());  // 로컬스토리지객체에 저장 (윈도우 생략 가능)
}


/* 읽어오기 */
function load() {
    const dataURL = localStorage.getItem("memocanvas");
    if (dataURL) {
        const img = new Image();
        img.onload = () => {
            ctx.drawImage(img, 0, 0);
        };
        img.src = dataURL;
    }
}


/* 삭제 */
/* 초기상태로 되돌림 */
function remove() {
    ctx.clearRect(0, 0, 580, 450);
    ctx.beginPath();
}

/* 데이터 영구 삭제 */
function removeEver() {
    ctx.clearRect(0, 0, 580, 450);
    ctx.beginPath();
    window.localStorage.removeItem("memocanvas");
}