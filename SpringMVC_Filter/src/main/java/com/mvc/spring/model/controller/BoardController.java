package com.mvc.spring.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.spring.model.biz.BoardBiz;
import com.mvc.spring.model.dto.BoardDto;

// 현재 class가 controller이라는 걸 명시해준다.
@Controller
public class BoardController {
	
	// service에서 controller로 연결해주는 Annotation이라고 볼 수 있다.
	@Autowired
	private BoardBiz biz;
	
	// index.jsp에서 Go List를 클릭 했을 때 요청되는 값 list.do를
	// HandlerMapping를 통해서 메소드와 연결해준다.
	@RequestMapping("list.do")
	public String selectList(Model model) {
		// 위에서 연결된 biz에서 selectList의 결과값을 가지고와서 값을 담아 전달해주는 Model에 담아서
		// return에 작성해준 jsp로 보내준다.
		List<BoardDto> list = biz.selectList();
		model.addAttribute("list", list);
		
		return "boardlist";
	}
	
	// boardlist.jsp에서 글작성 버튼을 눌러서 넘어온 값 insertform.do를 HandlerMapping을 통해서
	// 메소드와 연결해준 후에 바로 jsp로 보내준다.
	@RequestMapping("insertform.do")
	public String insertForm() {
		return "insertform";
	}
	
	// insertform.jsp에서 작성완료버튼을 누르면 insertres.do라는 값이 넘어온다.
	// 그럼 HandlerMapping을 통해서 메소드와 연결해준다.
	@RequestMapping("insertres.do")
	public String insertRes(Model model, BoardDto dto) {
		
		int res = 0;
		
		// res는 biz에서 insert한 결과값 (성공했으면 1 , 실패했으면 0)을 담아준다.
		res = biz.insert(dto);
		// 만일 res가 0보다 크다면. 즉, insert에 성공했따면
		if(res > 0) {
			// model객체에 값을 담는데 list라는 이름으로 biz에서 selectList를 한 결과값을 담아서 보낸다.
			model.addAttribute("list", biz.selectList());
			// redirect는 요청 값을 보낼 수 있다. 평소처럼 jsp를 보내지 않아도 된다.
			// return "원하는jsp명"; 으로 작성할 경우에는 URL에 그대로 요청한 값이 그대로 남게된다.
			// 예를들면 localhost:8787/springMVC/insertres.do 가 계속 남아있어서 새로고침하게되면 무한 insert된다.
			// 이를 방지하기 위해서 사용한다.
			return "redirect:list.do";
		} else {
			// 실패했다면 다시 insertform으로 돌려보내준다.
			return "redirect:insertform.do";			
		}
	}
	
	// boardlist.jsp에서 제목을 클릭하면 넘어온 값 detail.do를 HandlerMapping을 통해서 해당 메소드와 연결해준다.
	// 하나의 값을 가져와야하기 때문에 selectOne을 사용할 것이다.
	@RequestMapping("detail.do")
	public String detailDto(Model model, int myno) {
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		return "boarddetail";
	}
	
	// boarddetail.jsp에서 수정하기 버튼을 클릭하면 내가 보고있던 selectOne이 그대로 나와야한다.
	// 그래서 selectOne을 다시한번 해줌으로써 수정하기 버튼을 눌러도 내가 작성한 그대로 나오게끔 만들어준다.
	// 그 값을 model 객체에 담아주고 updateform이라는 jsp로 보내준다.
	@RequestMapping("updateform.do")
	public String updateForm(Model model, int myno) {
		model.addAttribute("dto", biz.selectOne(myno));
		return "updateform";
	}
	
	// updateform.jsp에서 수정을 한 후에 수정완료버튼을 누르면 updateres.do를 보내주는데 HandlerMapping을 통해서
	// 현재 메소드와 연결해준다.
	@RequestMapping("updateres.do")
	public String updateRes(Model model, BoardDto dto) {
		
		int res = 0;
		res = biz.update(dto);
		
		if(res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getMyno()));
			return "boarddetail";
		} else {
			return "updateform";
		}
	}
	// boarddetail.jsp에서 삭제하기 버튼을 클릭하면 넘어오는 값 delete.do를 HandlerMapping을 통해서
	// 현재 메소드와 연결해준다.
	@RequestMapping("delete.do")
	public String delete(Model model, int myno) {
		
		int res = 0;
		// biz.delete는 결과값이 int이고, 성공하면 1, 실패하면 0 을 return
		res = biz.delete(myno);
		
		// 만일 성공했다면
		if(res > 0) {
			// list라는 이름으로 list뽑을 것을 담아서 model에 담아준 다음에 boardlist로 보내준다.
			model.addAttribute("list", biz.selectList());
			return "boardlist";
			// 그렇지 않으면 boarddetail로 보내준다.
		} else {
			return "boarddetail";
		}
	}

}
