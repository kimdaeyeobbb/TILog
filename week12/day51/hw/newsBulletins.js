/* 뉴스 게시판 버튼 클릭시 이벤트 핸들러  */
const showNewsBulletins = () => {
  /* 뉴스 게시판 목록 보여주기 */

  document.getElementById("newsTable").style.display = "table";

  /* 뉴스 작성 폼 숨기기 */
  document.getElementById("InsertNewsFormContainer").style.display = "none";
};

/* 뉴스 작성 버튼 클릭시 이벤트 핸들러 */
function makeNews() {
  /* 게시판 목록 숨기기 */
  document.getElementById("newsTable").style.display = "none";

  /* 뉴스 작성 폼 보여주기 */
  document.getElementById("InsertNewsFormContainer").style.display = "block";
}


const resetForm = () => {
  document.getElementById("insertwriter").value = "";
  document.getElementById("inserttitle").value = "";
  document.getElementById("insertcontent").value = "";
};

const confirmUpdateForm = () => {
  document.getElementById("newsTable").style.display = "table";
};



/* 뉴스 검색 */

// 초기 로딩 시 뉴스 검색 입력창 숨김
// window.onload = function () {
//   document.getElementById("newsSearch").style.display = "none";
// };

function searchNews()  {
  console.log("뉴스 검색 버튼 클릭");
  document.getElementById("InsertNewsFormContainer").style.display = "none";
  document.getElementById("UpdateNewsFormContainer").style.display = "none";
};
