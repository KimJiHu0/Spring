package com.mvc.spring.model.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.spring.model.biz.BoardBiz;
import com.mvc.spring.model.dto.BoardDto;

// Controller이라고 알려주는 Annotation
@Controller
public class BoardController {
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);

	// biz(Service)와 연결하는 Annotation
	@Autowired
	private BoardBiz biz;
	
	// index.jsp에서 list.do라는 요청이 들어왔고
	// HandlerMapping이 list.do와 메소드를 연결해준다.
	// 크게봐서 HandlerMapping이랑 DispatcherServlet와 똑같다고 볼 수 있다.
	// 들어온 요청에 따라 어떤 Controller을 연결해줄지 찾아준다.
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		System.out.println("[ Print selectList ]");
		
		List<BoardDto> list = biz.selectList();
		
		model.addAttribute("list", list);
		
		return "boardlist";
	}
	
	
	// 제목을 클릭했을 때 넘어온 값 detail.do를 HandlerMapping을 통해서
	// 요청에 해당하는 값과 Controller과 연결해준다.
	@RequestMapping("detail.do")
	public String detailList(Model model, int myno) {
		System.out.println("[ Print detail ]");
		// dto에 selectOne을 한 결과를 담아줬다.
		// selectOne의 return type는 dto다.
		BoardDto dto = biz.selectOne(myno);
		
		// dto를 model객체에 담아서 view로 보내줄거다.
		model.addAttribute("dto", dto);
		// boarddetail로 페이지로 보내줄거다.
		return "boarddetail";
	}
	
	
	// 글작성 눌렀을 때 가는 jsp
	@RequestMapping("insertform.do")
	public String insertForm() {
		return "insertform";
	}
	
	// 작성완료를 눌렀을 떄 들어온 값과 Mapping된 값과 동일한 메소드를 연결해준다.
	@RequestMapping("insertres.do")
	public String insertRes(Model model, BoardDto dto) {
		System.out.println("[ Print insert ]");
		int res = biz.insert(dto);
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:/list.do";
		} else {			
			return "redirect:/insertform.do";
		}
	}
	
	// 수정버튼을 눌렀을 때 요청된 updateform.do값을 HandlerMapping을 통해 맞는 메소드와 연결
	@RequestMapping("updateform.do")
	// 여기서는 하나의 값을 가져와야하기 때문에 myno로 selectOne을 해주고 model객체에 담아서 보내준다.
	public String updateForm(Model model, int myno) {
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		
		return "updateform";
	}
	
	// 수정완료 버튼을 누르면 updateres.do라는 요청이 들어오고 HandlerMapping을 통해서
	// 요청에 맞는 Controller를 연결해준다.
	@RequestMapping("updateres.do")
	public String updateRes(Model model, BoardDto dto) {
		System.out.println("[ Print update ]");
		
		int res = biz.update(dto);
		if(res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getMyno()));
			return "boarddetail";
		} else {
			return "updateform";			
		}
	}
	
	// 삭제버튼을 클릭하게 되면 넘어오면 값 delete.do를 HandlerMapping을 통해서 현재 메소드와 연결해준다.
	@RequestMapping("delete.do")
	public String deleteList(Model model, int myno) {
		
		int res = biz.delete(myno);
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		} else {
			return "boarddetail";
		}
	}
	
	// index.jsp에서 test를 클릭하게 되면 넘어오는 값을 받아서 HandlerMapping을 통해
	// 현재 메소드와 연결해준다.
	@RequestMapping("test.do")
	public String transactionTest() {
		logger.info("[ test.do ]");
		
		biz.transactionTest();
		
		return "redirect:list.do";
	}
	
}
