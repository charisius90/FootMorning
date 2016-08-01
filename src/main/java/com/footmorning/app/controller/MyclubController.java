package com.footmorning.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.ClubMemberDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.domain.MyclubCashBookDTO;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.service.MyclubCashBookService;

/**
 * 
 * @author 김소영
 *
 */
@Controller
@RequestMapping("/myclub/*")
public class MyclubController {
	@Autowired
	private ClubService service;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MyclubCashBookService myclubCashBookService;
	
	private static final Logger logger = LoggerFactory.getLogger(MyclubController.class);
	
	@RequestMapping("myclubMain")
	public void myclubMain(HttpServletRequest req, Model model, int no) throws NumberFormatException, Exception{
		MemberDTO memberDto = (MemberDTO)WebUtils.getSessionAttribute(req, "USER_KEY");
		
		ClubDTO club = service.getWithNo(no);
		MemberDTO master = memberService.getWithNo(Integer.parseInt(club.getClub_master()));
		
		WebUtils.setSessionAttribute(req, "CLUB_KEY", club);
		model.addAttribute("MASTER", master);
	}
	
	@RequestMapping("myclubRecord")
	public void myclubRecord(){
		
	}
	
	@RequestMapping("myclubCashBook")
	public void myclubCashBook(Model model){
		try {
			List<MyclubCashBookDTO> list = myclubCashBookService.listAll();
			model.addAttribute("BOOK", list);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("myclubCashBookMgr")
	public void myclubCashBookMgr(Model model){
		try {
			List<MyclubCashBookDTO> list = myclubCashBookService.listAll();
			model.addAttribute("BOOK", list);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="myclubCashBookMgr", method=RequestMethod.POST)
	public @ResponseBody List myclubCashBookMgrComplete(@RequestBody List<Map<String, Object>> list, String cmd){
		if(cmd.equals("update")){
			System.out.println("myclubController cashbook POST TEST : " + list);
			MyclubCashBookDTO dto = null;
			for(Map map : list){
				try {
					dto = myclubCashBookService.getWithNo(Integer.parseInt((String)map.get("cashbook_no")));
					// map에서 값을 꺼내 세터로 저장 후 업데이트
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else if(cmd.equals("add")){
			
		}
		
		return null;
	}
//	
//	@RequestMapping(value="myclubMgrMember", method=RequestMethod.POST)
//	public @ResponseBody List myclubMgrMemberComplete(@RequestBody List<Map<String, Object>> list){
//        
//		ClubMemberDTO dto = null;
//		MemberDTO member = null;
//		for(Map map : list){
//			try {
//				// club_member 테이블 grade 수정
//				dto = clubMemberService.getWithMemno(Integer.parseInt((String)map.get("mem_no")));
//				dto.setMem_grade((String)map.get("mem_grade"));
//				clubMemberService.update(dto);
//				
//				// member 테이블 grade 수정
//				member = memberService.getWithNo(Integer.parseInt((String)map.get("mem_no")));
//				member.setMem_grade((String)map.get("mem_grade"));
//				memberService.updateMember(member);
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//        return list;
////		return "redirect:/myclubMgr/myclubMgrMember";
//	}
//	
}
