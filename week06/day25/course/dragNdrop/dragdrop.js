var source, drop;
function initiate() {
  source = document.getElementById('image');
  // 이미지에 대한 DOM 객체를 가져와서 source 변수에 담음

  source.addEventListener('dragstart', dragged, false);


  drop = document.getElementById('dropbox');
  drop.addEventListener('dragover', function (e) { e.preventDefault(); }, false);
  // 모든 HTML 태그는 DROP이 일어나지 않게하는 이벤트 핸들러를 가지고 있으므로 정상 DROP 처리를 위해 e.preventDefault()를 호출해주어야 함

  drop.addEventListener('drop', dropped, false);
}
function dragged(e) {
  var code = '<img src="' + source.getAttribute('src') + '">';


  e.dataTransfer.setData('Text', code);
}
function dropped(e) {
  e.preventDefault();
  // drop이 불가능하게 만드는 기본 이벤트 핸들러 해제 

  drop.innerHTML += e.dataTransfer.getData('Text');
}
window.addEventListener('load', initiate, false);