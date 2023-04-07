var device;
var drawing = false;
var canvas;
var context;
var rect;
var drawColor = "black";
function setColor(color) {
    drawColor = color;
}

/* 초기상태로 되돌림 */
function initialize() {
    context.clearRect(0, 0, 580, 450);
    context.beginPath();
    context.rect(0, 0, 580, 450);
    context.strokeStyle = "silver";
    context.fillStyle = "LightGoldenrodYellow";
    context.fill();
    context.lineWidth = 0.5;
    for (i = 1; i <= 8; i++) {
        context.moveTo(5, i * 50);
        context.lineTo(575, i * 50);
    }
    context.stroke();
}
function startDrawing(e) {
    drawing = true;
    context.beginPath();
    context.strokeStyle = drawColor;
    context.lineWidth = 1;
    context.arc(e.clientX - rect.left, e.clientY - rect.top, 3, 0, 2 * Math.PI)
    context.stroke();
    context.fillStyle = drawColor;
    context.fill();
    context.closePath();

    context.beginPath();
    context.moveTo(e.clientX - rect.left, e.clientY - rect.top);
    context.lineCap = "round";
    context.lineWidth = 6;
}

function keepDrawing(e) {
    if (drawing) {
        var x, y;
        if (device == "mobileDevice") {
            x = e.targetTouches[0].pageX;
            y = e.targetTouches[0].pageY;
        }
        else {
            x = e.clientX;
            y = e.clientY;
        }
        context.lineTo(x - rect.left, y - rect.top);
        context.stroke();
    }
}

function stopDrawing() {
    if (drawing) {
        context.stroke();
        drawing = false;
    }
}

function save() {
    alert(canvas.toDataURL());  // toDataURL: 캔버스태그에 그려진 데이터형식을 url 형식으로 변환해줌
    window.localStorage.setItem("memocanvas", canvas.toDataURL());  // 로컬스토리지객체에 저장 (윈도우 생략 가능)
}

function restore() {
    const img = new Image(); // 빈 이미지 객체 생성
    img.src = window.localStorage.memocanvas;     // 데이터 URL 형식 지정
    img.onload = function () {   // load 이벤트는 window 객체에 주로 등록하나 여기서는 이미지 객체에 등록함
        context.drawImage(img, 0, 0);
    }
}

function getDeviceType() {
    const str = navigator.userAgent;
    if (str.match(/(ipad)|(iphone)|(ipod)|(android)|(webos)/i))
        device = "mobileDevice";
    else
        device = "desktopPC";
}

function startMemo() {
    canvas = document.getElementById("myCanvas");
    context = canvas.getContext("2d");
    rect = canvas.getBoundingClientRect();
    initialize();
}

getDeviceType();
document.body.onload = startMemo;

dom = document.getElementById("myCanvas");

//for mobile devices
if (device == "mobileDevice") {
    dom.ontouchstart = startDrawing;
    dom.ontouchmove = keepDrawing;
    dom.ontouchend = stopDrawing;
} else {
    // for desktop PC
    dom.onmousedown = startDrawing;
    dom.onmousemove = keepDrawing;
    dom.onmouseup = stopDrawing;
}



