package com.footmorning.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.footmorning.app.domain.ClubAuthDTO;
import com.footmorning.app.domain.ClubConfigDTO;
import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.ClubMemberDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.domain.MyclubCashBookDTO;
import com.footmorning.app.service.ClubAuthService;
import com.footmorning.app.service.ClubConfigService;
import com.footmorning.app.service.ClubMemberService;
import com.footmorning.app.service.ClubService;
import com.footmorning.app.service.MemberService;
import com.footmorning.app.service.MyclubCashBookService;
import com.footmorning.app.service.MyclubNoticeService;

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
	@Autowired
	private ClubConfigService clubConfigService;
	@Autowired
	private ClubAuthService clubAuthService;
	@Autowired
	private MyclubNoticeService myclubnoticeservice;
	
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
		
		model.addAttribute("list", myclubnoticeservice.listNotice(Integer.parseInt(club.getClub_no())));
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
			
			// 클럽의 등급별 회원권한정보
			int no = Integer.parseInt(club.getClub_no());
			Map<String, ClubAuthDTO> map = new HashMap<>();
			map.put("AUTH_MASTER", clubAuthService.getAuthMaster(no));
			map.put("AUTH_MGR", clubAuthService.getAuthMgr(no));
			map.put("AUTH_STAFF", clubAuthService.getAuthStaff(no));
			map.put("AUTH_MEMBER", clubAuthService.getAuthMember(no));
			map.put("AUTH_USER", clubAuthService.getAuthUser(no));
			model.addAllAttributes(map);
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
	public @ResponseBody String myclubCashBookMgrComplete(@RequestBody List<Map<String, Object>> list, String cmd, HttpServletRequest req){
		try {
			if(cmd.equals("update")){
				logger.info("UPDATE - CASHBOOK LIST : " + list);
				MyclubCashBookDTO dto = null;
				for(Map map : list){
					int cashbook_no = Integer.parseInt((String)map.get("cashbook_no"));
					// map에서 값을 꺼내 세터로 저장 후 업데이트
//					String cashbook_index = (String)map.get("cashbook_index");
					String cashbook_amount = (String)map.get("cashbook_amount");
					String cashbook_balance = (String)map.get("cashbook_balance");
					String cashbook_content = (String)map.get("cashbook_content");
					String cashbook_date = (String)map.get("cashbook_date");
					String cashbook_type = (String)map.get("cashbook_type");
					dto = myclubCashBookService.getWithNo(cashbook_no);
//					dto.setCashbook_index(cashbook_index);
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
			List<MyclubCashBookDTO> listAll = myclubCashBookService.listAllWithClubNo(Integer.parseInt(club.getClub_no()));
			StringBuilder result = new StringBuilder("0");
			for(MyclubCashBookDTO book : listAll){
				result.append(" " + book.getCashbook_no());
			}
			return result.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	/**
	 * 클럽 가입신청 파이널 변수
	 * @Author 박수항
	 */
	public static final String CLUB_MEM_FLAG_DEFAULT = "FALSE"; // 이게 가입 신청서라는 표시를 하는 플래그
	/**
	 * @Author 박수항, 김소영
	 * 가입신청 테스트용(컨트롤러 위치 변경해야함)
	 */
	@RequestMapping(value="clubRequest", method=RequestMethod.POST)
	public String requestPOST(ClubMemberDTO dto, RedirectAttributes rttr){
		System.out.println(dto);
		try{
			ClubMemberDTO clubMember = clubMemberService.getWithMemno(Integer.parseInt((dto.getMem_no())));
			if(clubMember!=null){
				if(clubMember.getClub_mem_flag().equals("TRUE")){
					rttr.addFlashAttribute("msg", "이미 가입된 회원입니다.");
				}
				else{
					rttr.addFlashAttribute("msg", "이미 가입신청 중인 회원입니다.");
				}
			}
			else{
				SimpleDateFormat fm = new SimpleDateFormat("yy-mm-dd");

				String mem_birth = dto.getMem_birth();
				Date birthDate = fm.parse(mem_birth);
				
				ClubConfigDTO clubConfig = clubConfigService.getWithClubNo(Integer.parseInt((dto.getClub_no())));
				System.out.println("clubRequest : " + clubConfig.toString());
				Date birthFrom = fm.parse(clubConfig.getConfig_birth_from());
				Date birthTo = fm.parse(clubConfig.getConfig_birth_to());
				
				Date today = new Date();
				Date rejectFrom = fm.parse(clubConfig.getConfig_reject_from());
				Date rejectTo = fm.parse(clubConfig.getConfig_reject_to());

				if(today.getTime() > rejectFrom.getTime() && today.getTime() < rejectTo.getTime()){
					rttr.addFlashAttribute("msg", "현재는 가입신청을 받지 않는 기간입니다.");
				}
				else if(birthDate.getTime() < birthFrom.getTime() || birthDate.getTime() > birthTo.getTime()){
					rttr.addFlashAttribute("msg", "가입조건에 맞지 않는 연령입니다.");
				}
				else if(!clubConfig.getConfig_gender().equals("BOTH") && !dto.getMem_gender().toUpperCase().equals(clubConfig.getConfig_gender())){
					rttr.addFlashAttribute("msg", "가입조건에 맞지 않는 성별입니다.");
				}
				else{
					dto.setClub_mem_flag(CLUB_MEM_FLAG_DEFAULT);
					clubMemberService.insert(dto);
					rttr.addFlashAttribute("msg", "가입신청이 완료되었습니다.");
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/myclub/myclubMain?no=" + dto.getClub_no();
		
	}
}
