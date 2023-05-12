package week11.day46.course.ex06;

import com.example.springedu.domain.FriendDTO;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
	public FriendDTO get(int num) {
		FriendDTO vo = null;
		if (num == 10) {
			vo = new FriendDTO();
			vo.setPhoneNum("010-1111-2222");
			vo.setName("Dooly");			
		}
		return vo;
	}
}
