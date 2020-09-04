package com.mvc.upgrade.model.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class BoardController {
	
	// 컨트롤러로 객체를 만들었고 boardBizImpl와 연결되어있는거야.
	
	@Autowired
	private BoardBiz boardBiz;
	
	// index에서 Go List를 클릭했을 때 요청되는 값 list.do를
	// HandlerMapping을 통해 해당 요청에 맞는 메소드를 연결해줘.
	// Model model은 보여줄 view에 값을 담아서 보내주는 객체이고
	// controller에서 service로 갔다가 repository에서 dbcp를 통해
	// 값을 가져온 다음에 repository에서 selectList를 실행해줘.
	// 그리고 service에서 그 값을 가져와 return하면 controller로 보내지게 돼.
	// 가져온 값을 model에 담아서 boardlist라는 jsp로 뿌려줘.
	@RequestMapping("/list.do")
	public String boardList(Model model) {
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		list = boardBiz.selectList();
		
		model.addAttribute("list", list);
		
		return "boardlist";
	}
	
	// 글작성 버튼을 누르면 단순 페이지 이동이기 때문에
	// return에 원하는 페이지 이름만 작성해주면 돼.
	@RequestMapping("/insertform.do")
	public String insertform() {
		return "boardinsertform";
	}
	
	// 작성완료버튼을 누르면 컨트롤러 -> 서비스 -> 리파지토리 -> db에 값을 저장하고 list를 뽑아올거야.
	// 그걸 리파지토리 -> 서비스 -> 컨트롤러로 다시 가져와서 값을 담아서 보내줄거야.
	// 지금 이건 forward방식이야. insert가 된 후에 url을 보면 /insertres.do 야
	// 만약 거기서 새로고침을 다시 하게된다면 insertres.do가 다시 요청되서
	// 다시 insert되고 다시 list를 뽑아서 boardlist를 보여주게 돼.
	@RequestMapping("insertres.do")
	public String insertres(Model model, BoardDto dto) {
		
		/*
		-- forward방식 --
		int res = boardBiz.insert(dto);
		if(res > 0) {
			model.addAttribute("msg", "작성이 완료되었습니다.");
			model.addAttribute("list", boardBiz.selectList());
			return "boardlist";
		} else {
			model.addAttribute("msg", "작성에 실패했습니다.");
			return "boardinsertform";
		}
		*/
		int res = boardBiz.insert(dto);
		if(res > 0) {
			model.addAttribute("msg", "작성이 완료되었습니다.");
			model.addAttribute("list", boardBiz.selectList());
			return "redirect:/list.do";
		} else {
			return "redricet:/insertform.do";
		}
		
	}
	
	// 제목 클릭하면 넘어오는 메소드야
	// 그래서 selectOne을 실행해줘서 dto에 담고 그걸 model에 dto라는 이름으로 담을거야.
	@RequestMapping("detail.do")
	public String detailform(Model model, int myno) {
		
		BoardDto dto = boardBiz.selectOne(myno);
		model.addAttribute("dto", dto);
		
		return "boarddetail";
	}
	
	// 수정 버튼을 클릭했을 때 하나의 dto를 보여줘야하기 때문에 selectOne을 사용해서 model에 담아서 보내주었다.
	@RequestMapping("updateform.do")
	public String updateform(Model model, int myno) {
		BoardDto dto = boardBiz.selectOne(myno);
		model.addAttribute("dto", dto);
		return "boardupdateform";
	}
	
	// 수정 완료되면 넘어오는 메소드
	@RequestMapping("updateres.do")
	public String updateres(Model model, BoardDto dto) {
		int res = 0;
		
		res = boardBiz.update(dto);
		if(res > 0) {
			model.addAttribute("dto", boardBiz.selectOne(dto.getMyno()));
			return "boarddetail";
		} else {
			return "boardupdateform";
		}
	}
	
	@RequestMapping("delete.do")
	public String deleteList(Model model, int myno) {
		int res = 0;
		
		res = boardBiz.delete(myno);
		if(res > 0) {
			model.addAttribute("list", boardBiz.selectList());	
			return "boardlist";
		} else {
			return "boarddetail";			
		}
	}
}
