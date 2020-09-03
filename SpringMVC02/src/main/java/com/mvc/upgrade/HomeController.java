package com.mvc.upgrade;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardBiz biz;
	
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// 리스트 출력 jsp
	// HandlerMapping을 해준다.
	// index.jsp에서 list.do를 요청했을 때 이 메소드를 호출하게 연결해준다.
	// Model은 view를 보여줄 때 값을 넘겨주는 역할을 한다.
	// Controller에서 Service를 갔다가 Repository를 간 후에
	// 그 곳에서 mapper와 연결되어 mybatis를 통해 List를 뽑아낸다.
	// 그 후에 다시 Service를 간 후에 이곳 Controller로 온다.
	// 가져온 list값을 list라는 이름으로 model객체에 담아준다.
	// return할 때 mvclist는 servlet-context.xml에서 prefix와 suffix를 통해서
	// 앞 뒤에 경로르 붙여준 후에 해당 경로에 있는 jsp를 응답해준다.
	// 응답해줄 때 model객체에 담긴 값을 가지고 간다.
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		System.out.println("[Print List]");
		
		// view에 값을 넘겨줄 때 담아줄 객체 model
		model.addAttribute("list", biz.selectList());
		
		return "mvclist";
	}
	
	// 글 작성 jsp
	// 글작성 버튼을 클릭했을 때 넘어온 값 insertform.do를
	// HandlerMapping을 통해 해당 메소드와 연결을 해준다.
	// 이곳에서는 딱히 값을 보낸 필요가 없기 때문에 return에 내가 보내줄 jsp이름인
	// mvcinsert만 작성해줘도 된다.
	@RequestMapping("/insertform.do")
	public String insertForm() {
		System.out.println("[insertform 성공]");
	
		return "mvcinsert";
	}
	
	// 글작성form에서 완료버튼을 클릭했을 때 들어오는 메소드
	// 글작성 완료버튼을 클릭하게 되면 넘어온 action에서 넘어온 값 insertres.do를
	// HnadlerMapping를 통해서 현재 메소드와 연결해준다.
	@RequestMapping("/insertres.do")
	// 파라미터 값으로는 내가 작성한 myname, mytitle, mycontent를 받아주었고
	// 보여줄 view에게 값을 보내줄 Model객체도 함께 선언했다.
	public String insertres(Model model, String myname, String mytitle, String mycontent) {
		
		// insert는 return type이 int이기 때문에 int res를 지정해준다.
		// controller에서 service를 들렀다 repository를 가서 mapper를 실행해주고 그 값을 다시
		// service로 보낸 후 return이 dao.insert(dto)이기 때문에 controller에 그대로 값을 전달해준다.
		// 만일 결과가 성공했다면 1을 return할거고 실패했다면 0을 return할거다.
		// 내가 입력한 값들을 parameter 3개받는 생성자에 넣어준 후에 insert해준다.
		int res = biz.insert(new BoardDto(myname, mytitle, mycontent));
		
		// 결과가 성공적이라면 model객체에 성공한 후에 selectList를 뽑아주어 list라는 이름으로
		// model객체에 담아서 mvclist라는 jsp에 보내준다.
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "mvclist";
		} else {
			// 만일 실패했다면 mvcinsert로 다시 보내준다.
			return "mvcinsert";
		}
	}
	
	// mvclist.jsp에서 제목을 클릭했을 때 들어오는 메소드
	// detail.do라는 값을 보내줬고 HandlerMapping를 통해 메소드와 연결해준다.
	@RequestMapping("/detail.do")
	// 요청할 때 보내준 myno를 같이 받아준 후에
	public String detail(Model model, int myno) {
		
		// dto라는 객체에 내가 원하는 하나의 selectOne을 뽑아준다.
		// 순서 : controller -> service -> repository -> service -> controller
		BoardDto dto = biz.selectOne(myno);
		
		// 성공적으로 가져온 결과값을 model객체에 dto라는 이름으로 dto를 담아준 후에
		// mvcdetail이라는 jsp로 보내준다.
		model.addAttribute("dto", dto);
		return "mvcdetail";
	}
	
	// 삭제버튼을 눌렀을 때 요청값과 동일하게 HandlerMapping을 통해 메소드와 연결하고
	@RequestMapping("/delete.do")
	// 삭제완료 후 list로 보내기 위해 값을 담는 model객체를 같이 parameter로 받아준다.
	public String delete(Model model, int myno) {
		
		// insert, update, delete는 return type이 int이기 때문에
		// int res = 거쳐서거쳐서 dao.delete를 실행해준 결과값을 res에 담아준다.
		// 만일 성공했다면 list를 뽑아준 후 list라는 이름으로 Model객체에 담아줘서 mvclist를 return한다,
		// 만일 성공에 실패했다면 다시 mvcdetatil로 넘겨준다
		int res = biz.delete(myno);
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "mvclist";
		} else {
			return "mvcdetail";
		}
	}
	
	// updateform으로 넘어온다. 여기서는 내가 원하는 하나의 dto를 원하기 때문에
	// selectOne을 진행에 필요한 myno를 받아주고 값을 담아줄 Model을 선언한다.
	@RequestMapping("/updateform.do")
	public String updateform(Model model, int myno) {
		// selectOne을 해준 결과값을 dto에 담고
		// model에 담아서 mvcupdate로 보내준다.
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		return "mvcupdate";
	}
	
	// 수정완료 버튼을 누르게 되면 이 메소드로 들어온다.
	@RequestMapping("/updateres.do")
	public String updateres(Model model, BoardDto dto) {
		
		// 결과타입이 int이기 때문에 update한 결과값을 res에 담아주고
		int res = biz.update(dto);
		
		// 만일 성공했다면  selectOne을 담아서 dto라는 이름으로 model에 담아서 mvcdetail로 보내준다.
		if(res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getMyno()));
			return "mvcdetail";
			// 그렇지 않다면 mvcupdate를 다시 요청한다.
		} else {
			return "mvcupdate";			
		}	
	}
}
