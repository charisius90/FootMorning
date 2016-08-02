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
import com.footmorning.app.service.ClubMemberService;
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
	@Autowired
	private ClubMemberService clubMemberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MyclubController.class);
	
	@RequestMapping("myclubMain")
	public void myclubMain(HttpServletRequest req, Model model, int no) throws NumberFormatException, Exception{
		MemberDTO memberDto = (MemberDTO)WebUtils.getSessionAttribute(req, "USER_KEY");
		
		ClubDTO club = service.getWithNo(no);
		MemberDTO master = memberService.getWithNo(Integer.parseInt(club.getClub_master()));
		
		WebUtils.setSessionAttribute(req, "CLUB_KEY", club);
		
		List<ClubMemberDTO> list = clubMemberService.listRequest(no);
		model.addAttribute("MASTER", master);
		model.addAttribute("REQUEST", list);
	}
	
	@RequestMapping("myclubRecord")
	public void myclubRecord(){
		
	}
	
	@RequestMapping("myclubCashBook")
	public void myclubCashBook(HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			List<MyclubCashBookDTO> list = myclubCashBookService.listAllWithClubNo(Integer.parseInt(club.getClub_no()));
			model.addAttribute("BOOK", list);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("myclubCashBookMgr")
	public void myclubCashBookMgr(HttpServletRequest req, Model model){
		try {
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			List<MyclubCashBookDTO> list = myclubCashBookService.listAllWithClubNo(Integer.parseInt(club.getClub_no()));
			model.addAttribute("BOOK", list);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="myclubCashBookMgr", method=RequestMethod.POST)
	public @ResponseBody List myclubCashBookMgrComplete(@RequestBody List<Map<String, Object>> list, String cmd, HttpServletRequest req){
		List<MyclubCashBookDTO> listAll = null;
		try {
			if(cmd.equals("update")){
				logger.info("UPDATE - CASHBOOK LIST : " + list);
				MyclubCashBookDTO dto = null;
				for(Map map : list){
						int cashbook_no = Integer.parseInt((String)map.get("cashbook_no"));
						// map에서 값을 꺼내 세터로 저장 후 업데이트
//						String cashbook_index = (String)map.get("cashbook_index");
						String cashbook_amount = (String)map.get("cashbook_amount");
						String cashbook_balance = (String)map.get("cashbook_balance");
						String cashbook_content = (String)map.get("cashbook_content");
						String cashbook_date = (String)map.get("cashbook_date");
						String cashbook_type = (String)map.get("cashbook_type");
						dto = myclubCashBookService.getWithNo(cashbook_no);
//						dto.setCashbook_index(cashbook_index);
						dto.setCashbook_amount(cashbook_amount.isEmpty() ? null : cashbook_amount);
						dto.setCashbook_balance(cashbook_balance.isEmpty() ? null : cashbook_balance);
						dto.setCashbook_content(cashbook_content.isEmpty() ? null : cashbook_content);
						dto.setCashbook_date(cashbook_date.isEmpty() ? null : cashbook_date);
						dto.setCashbook_type(cashbook_type.isEmpty() ? null : cashbook_type);
						
						myclubCashBookService.update(dto);
				}
			}
			else if(cmd.equals("add")){
				logger.info("ADD - CASHBOOK LIST : " + list);
				String club_no = (String)(list.get(0).get("club_no"));
				MyclubCashBookDTO dto = new MyclubCashBookDTO();
				dto.setClub_no(club_no);
				
				myclubCashBookService.insert(dto);
			}
			else if(cmd.equals("del")){
				logger.info("DEL - CASHBOOK LIST : " + list);
				int cashbook_no = Integer.parseInt((String)(list.get(0).get("cashbook_no")));
				
				myclubCashBookService.delete(cashbook_no);
			}
			
			ClubDTO club = (ClubDTO)WebUtils.getSessionAttribute(req, "CLUB_KEY");
			listAll = myclubCashBookService.listAllWithClubNo(Integer.parseInt(club.getClub_no()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listAll;
	}

}
