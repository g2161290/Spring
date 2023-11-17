package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
	// 단건조회 : URI -boardInfo / PARAMETER - BoardVO / RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoard(boardVO);
		model.addAttribute("BoardInfo", findVO);
		return "board/boardInfo";
	}
	
	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String insertBoardInfoPage() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리	: URI - boardInsert / RETURN - BoardVO / RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String insertBoardInfoProcess(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
		return "redirect:boardList";
	}
	
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO / RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String updateBoardPage(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoard(boardVO);
		model.addAttribute("BoardInfo", findVO);
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO / RETURN - 수정결과 데이터(Map)
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> updateBoardProcess(@RequestBody BoardVO boardVO){
		return boardService.updateBoard(boardVO);
	}
	
	// 삭제 - 처리 : URI - boardDelete / PARAMETER - Integer / RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String deleteBoardProcess(@RequestParam Integer bno, RedirectAttributes ratt) {
		int result = boardService.deleteBoard(bno);
		String msg = null;
		if(result == 1) {
			msg = "정상적으로 삭제되었습니다.";
		} else {
			msg = "정상적으로 삭제되지 않았습니다.";
		}
		ratt.addFlashAttribute("msg",msg);
		return "redirect:boardList";
	}
}
