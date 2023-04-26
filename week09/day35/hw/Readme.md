# 과제 리뷰

## 과제1

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        div {
            display: inline-block;
            width: 120px;
            height: 120px;
        }

        img {
            width: 100px;
            height: 100px;
        }

        .shadow img {
            transition: .5s ease;
        }

        .shadow img:hover {
            box-shadow: 1px 1px #d9d9d9, 2px 2px #d9d9d9, 3px 3px #d9d9d9, 4px 4px
            #d9d9d9, 5px 5px #d9d9d9, 6px 6px #d9d9d9;
            transform: translateX(-3px);
            transition: .5s ease;
        }
    </style>
</head>
<body>
<h1>Lotto Game</h1>
<div><a href="/lotto?lottoNum=1" class ="shadow"><img src="images/1.png" alt="1"></a></div>
<div><a href="/lotto?lottoNum=2" class ="shadow"><img src="images/2.png" alt="2"></a></div>
<div><a href="/lotto?lottoNum=3" class ="shadow"><img src="images/3.png" alt="3"></a></div>
<div><a href="/lotto?lottoNum=4" class ="shadow"><img src="images/4.png" alt="4"></a></div>
<div><a href="/lotto?lottoNum=5" class ="shadow"><img src="images/5.png" alt="5"></a></div>
<div><a href="/lotto?lottoNum=6" class ="shadow"><img src="images/6.png" alt="6"></a></div>
</body>
</html>
```
위 폴더를 보아하니 매핑명은 `/lotto`가 되어야 함<br>
GET 방식인 경우 `/lotto?lottoNum=1`처럼 쿼리문자열을 붙여서 작성<br>

### LottoDTO

```java
package com.example.springedu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LottoDTO {
    private int lottoNum;
    
    /*  컨트롤러가 뷰에게 응답할 때 전달할 정보를 담을 멤버변수 - data transfer object*/
    private String result;
    private String imgName;
}
```

- DTO에 변수가 담겨서 컨트롤러에게 전달하면 lottoNum을 따로 받을 필요가 없음<br>

- 클라이언트로부터 전송되는 문자열을 추출하는 용도
- LottoDTO에 보관된 객체에 result, imageName 등의 정보를 넣어줌으로써 view에게 정보를 전달할 수 있음
- view에게 전달되는 데이터를 담는 용도
- 쿼리문자열만 생각하면 lottoNum을 매개변수로 해도됨.
- 도메인객체(커멘드객체)로 전달하는 이유는 쿼리가 여러개 오는데 한덩어리로 받고자 위함임
- 쿼리문자열이 하나인 경우에는 도메인 클래스를 이용할 필요가 없다


### LottoController.java


```java
package com.example.springedu.controller;

import com.example.springedu.domain.LottoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("count")  // count가 sessionAttribute의 성격을 갖도록함
public class LottoController {
    @ModelAttribute("count")
    public int[] createCount(){
        System.out.println("count 배열생성");
        return new int[1];
    }
    @RequestMapping("/lotto")
    public String lottoProcess(@ModelAttribute("count")int arry[], LottoDTO vo){
        // LottoDTO 형의 매개변수 
        // 디스패처서블릿은 똑똑하다 (많은일을 해준다)
        // LottoDTO -> modelAttribute를 이용해서 객체생성할 필요가 없음 (디스패처 서블릿이 알아서 생성해줌)
        
        if(arry[0] >= 3){
            vo.setResult("로또 응모는 낙첨된 경우에 한하여 3번까지만 가능합니다.<br>브라우저를 재기동한 후에 응모한 후에 응모해 주세요");
            vo.setImgName("snow.png");
        } else {
            Random rand = new Random();
            if(rand.nextInt(6)+1 == vo.getLottoNum()){
                vo.setResult("추카추카!!");
                vo.setImgName("sun.png");
                arry[0] = 3;
            } else {
                vo.setResult("아쉽네요... 다음 기회를!!");
                System.out.println(arry + ":" + arry[0]);
                vo.setImgName("rain.png");
                arry[0]++;  // 응모횟수 1증가시켜줌
            }
        }
        
        return "lottoView";  // lottoView라는 이름을 가지고 리턴 -> 스프링에 의해 lottoView라는 이름의 템플릿을 찾아서 응답하게 만듦
        // 스프링은 타임리프기반의 템플릿을 사용함
        // template 폴터에가서 lottoView.html 파일이 응답하게 만듦
    }
}
```

### lottoView.html

```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>LottoView</title>
</head>
<body>
    <h1>로또 결과</h1>
    <hr>
    <h2 style="..." th:utext = "${lottoDTO.result}"></h2>
    <img th:src="${'/images/'+lottoDTO.imgName}" width="100">
    <img th:src="@{l/images/${lottoDTO.imgName}|}" width="100">
    <img th:src="@{'/images/'+${lottoDTO.imgName}}" width="100">
    <hr>
    <a th:href='${ #request.getHeader("referer") }' th:if="${lottoDTO.imgName == 'rain.png'}">재시도....</a>
</body>
</html>
```


- 쿼리문자열을 전달할 경우에는 `url 표현식`을 사용하는게 좋다 
  - context path명을 자동으로 붙여주기 때문


- 컨트롤러가 상황에 따라서 이미지 이름만 전달


- `${...}`
  - 변수 표현식
  - 변수 이름에 해당되는 데이터를 꺼내어서 식을 수행하고 그 결과를 사용함
  


- `@{...}`
  - URL 표현식
  - 주어진 내용을 가지고 URL 문자열을 만들어줌
  - 어떤 이름으로 보관되어 있는 데이터를 꺼내는 기능은 가지고 있지 않음 (꺼내고 싶을 경우 변수 표현식 사용)
  - 여기서는 request 객체에서 원하는 데이터를 꺼내야하므로 변수 표현식을 사용할 것



- 어떤 내용으로 uri가 만들어져 왔는지를 확인하는것이 중요


## 과제2

### MyTeamController.java

```java
package com.example.springedu.controller;

import com.example.springedu.domain.TeamDTO;
import com.example.springedu.domain.TeamMemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;


@Controller
public class MyTeamController {
    TeamMemberVO mem1 = new TeamMemberVO("김대엽", "Danny", "치킨");
    TeamMemberVO mem2 = new TeamMemberVO("박주희", "노랑콩", "꿔바로우");
    TeamMemberVO mem3 = new TeamMemberVO("김민성", "도라이", "칼국수");
    TeamMemberVO mem4 = new TeamMemberVO("홍승희" , "별명" , "음식");

    // 클라이언트에게 요청할 때 사용하는 매핑명
    @RequestMapping(value="/myteam", produces = "application/json; charset=utf-8")
    // value: 연결할 URL
    // produces: 기본값이 application/json 혹은 와일드카드로 값이 전달됨.
    
    @ResponseBody // 얘가 붙은것은 템플릿을 거치지 않고 컨트롤러가 리턴하는 것을 그대로 클라이언트에게 줌
    // 템플릿을 거치지 않고 직접 responsebody를 꾸미겠다는 것
    // http 통신은 응답 header와 응답 body가 있음
    public TeamDTO teamMember(){
        ArrayList<TeamMemberVO> teamMemberVOList = new ArrayList<>();

        teamMemberVOList.add(mem1);
        teamMemberVOList.add(mem2);
        teamMemberVOList.add(mem3);
        teamMemberVOList.add(mem4);

        TeamDTO myteam = new TeamDTO();
        myteam.setTeamName("T-KO");
        myteam.setTeamMember(teamMemberVOList);

        return myteam;
    }
}
```