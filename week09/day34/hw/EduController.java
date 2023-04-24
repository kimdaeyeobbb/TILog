package week09.day34.hw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {
    @RequestMapping("/educontroller")
    public ModelAndView proc(@RequestParam(value="name", defaultValue = "없음") String name,
                             @RequestParam(value="avgScore", defaultValue = "없음") int avgScore){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", name);
        mav.addObject("avgScore", avgScore);
        System.out.println(avgScore);
        if (avgScore>= 90){
            mav.setViewName("gradeA");
        } else if (avgScore >= 80){
            mav.setViewName("gradeB");
        } else if (avgScore >= 70){
            mav.setViewName("gradeC");
        } else {
            mav.setViewName("gradeD");
        }
        return mav;
    }
}