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

    @RequestMapping(value="/myteam", produces = "application/json; charset=utf-8")
    // value: 연결할 URL
    // produces: 기본값이 application/json 혹은 와일드카드로 값이 전달됨.
    @ResponseBody // 얘가 붙은것은 템플릿을 거치지 않고 컨트롤러가 리턴하는 것을 그대로 클라이언트에게 줌
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
