package com.footmorning.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.footmorning.app.domain.ChallengeDTO;
import com.footmorning.app.domain.ClubDTO;
import com.footmorning.app.domain.FirstLineupDTO;
import com.footmorning.app.domain.FormationDTO;
import com.footmorning.app.domain.FormationListDTO;
import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.domain.MemberDTO;
import com.footmorning.app.domain.SubLineupDTO;
import com.footmorning.app.service.ChallengeService;
import com.footmorning.app.service.MatchService;
import com.footmorning.app.service.MyclubGamePrepareService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MyclubGamePrepareController {
	@Inject
	private MyclubGamePrepareService service;
	
	@Inject
	private MatchService matchService;
	
	public static final String EMPTY_OBJECT = "{}";
	public static final String EMPTY_ARRAY = "[]";
	
	@RequestMapping(value = "/myclub/myclubGamePrepare")
	public String GamePrepareMain(String game_no, String game_flag, Model model, HttpServletRequest req) throws Exception {
		model.addAttribute("game_no", game_no);
		model.addAttribute("game_flag", game_flag);
		MatchDTO matchDto = new MatchDTO();
		matchDto.setGame_no(Integer.parseInt(game_no));
		matchDto.setGame_flag(game_flag);
		WebUtils.setSessionAttribute(req, "GAME_KEY", matchService.matchWithGameNoAndGameFlag(matchDto));
		
		String lineup_no = service.checkLineupNo(matchDto);
		if(lineup_no != null){
			System.out.println("불러와야함");
			//선발 멤버 번호
			FirstLineupDTO firstLineupDto = service.firstLineupWithLineupNo(lineup_no);
			//후보 멤버 번호
			SubLineupDTO subLineupDto = service.subLineupWithLineupNo(lineup_no);
			//포메 (DB용)
			FormationDTO formationDto = service.formationWithLineupNo(lineup_no);
			//포메 (뿌리기용)
//			FormationListDTO formationListDto = formationDto.
			req.setAttribute("result", "LOAD");
	         
		}else{
			System.out.println("새로생성함");
			req.setAttribute("result", "NEW");
		}
		
		return "/myclub/myclubGamePrepare";
	}
	
//	@RequestMapping(value = "/myclub/myclubGamePrepareCheck")
//	public String GamePrepareCheck(Model model, HttpServletRequest req) throws Exception {
//		MatchDTO matchDto = (MatchDTO)WebUtils.getSessionAttribute(req, "GAME_KEY");
//		
//		String lineup_no = service.checkLineupNo(matchDto);
//		if(lineup_no != null){
//			System.out.println("불러와야함");
//			req.setAttribute("result", "LOAD");
//	         
//		}else{
//			System.out.println("새로생성함");
//			req.setAttribute("result", "NEW");
//		}
//		return "/myclub/json/myclubGamePrepareFlagJson";
//	}
	
	@RequestMapping(value = "/myclub/myclubGamePrepareMember")
	public String GamePrepareMember(Model model, int club_no) throws Exception {
		model.addAttribute("memberList", service.listMemberWithClubNo(club_no));
		List<MemberDTO> list =  service.listMemberWithClubNo(club_no);
		for(int i=0; i<list.size(); i++){
			System.out.println(i+"번쨰 : " +list.get(i).toString());
		}
		return "/myclub/json/myclubGamePrepareJson";
	}
	
//	@RequestMapping(value = "/myclub/myclubGamePrepareLoad")
//	public String GamePrepareLoad(Model model, int club_no) throws Exception {
//		System.out.println("로딩 컨트롤러");
//		return "/myclub/myclubGamePrepare";
//	}
	
	@RequestMapping(value = "/myclub/myclubGamePrepareRegister")
	public String GamePrepareRegister(@RequestBody Map<String, List<Object>> json, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		MatchDTO matchDto = (MatchDTO)WebUtils.getSessionAttribute(req, "GAME_KEY");
		int game_no = matchDto.getGame_no();
		String game_flag = matchDto.getGame_flag();
		String lineup_no = service.checkLineupNo(matchDto);
		System.out.println("라인업번호 : " + lineup_no);
		
		if(lineup_no != null){
			rttr.addFlashAttribute("msg", "EXIST");
			System.out.println("이미 존재함");
			
			service.deleteFormation(lineup_no);
			service.deleteSubLineup(lineup_no);
			service.deleteFirstLineup(lineup_no);
		}
		
		System.out.println(json.get("firstLineUp"));
		System.out.println(json.get("subLineUp"));
		System.out.println(json.get("formation"));
		
		FirstLineupDTO firstDto = new FirstLineupDTO();
		firstDto.setFirstlineup_list(convertCollectionToStringJson(json.get("firstLineUp")));
		firstDto.setGame_no(game_no);
		firstDto.setGame_flag(game_flag);
		service.registerFirstLineup(firstDto);
		System.out.println("선발 성공");
		
		lineup_no = service.checkLineupNo(matchDto);
		
		SubLineupDTO subDto = new SubLineupDTO();
		subDto.setSublineup_list(convertCollectionToStringJson(json.get("subLineUp")));
		subDto.setLineup_no(lineup_no);
		service.registerSubLineup(subDto);
		System.out.println("후보 성공");
		
		FormationDTO formationDto = new FormationDTO();
		formationDto.setFormation_list(convertCollectionToStringJson(json.get("formation")));
		formationDto.setLineup_no(lineup_no);
		service.registerFormation(formationDto);
		System.out.println("포메 성공");
		
		//db저장
//		System.out.println("firststring : " +convertCollectionToStringJson(json.get("firstLineUp")));
//		System.out.println("substring : " +convertCollectionToStringJson(json.get("subLineUp")));
//		System.out.println("formationstring : " +convertCollectionToStringJson(json.get("formation")));
	
		//db로드
//		System.out.println("firstlist : " +convertJsonStringToList(Integer.class, convertCollectionToStringJson(json.get("firstLineUp")))) ;
//		System.out.println("sublist : " +convertJsonStringToList(Integer.class, convertCollectionToStringJson(json.get("subLineUp")))) ;
//		System.out.println("formationlist : " +convertJsonStringToList(FormationListDTO.class, convertCollectionToStringJson(json.get("formation")))) ;
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "/myclub/myclubGameSchedule";
	}
	
	// DB 넣을 때 : list -> string
	public String convertCollectionToStringJson(Collection<?> collection) {
		if(collection == null || collection.size() <= 0) {
			return EMPTY_ARRAY;
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			return objectMapper.writeValueAsString(collection);
		} catch (IOException e) {
		}
		System.out.println("완성: " + EMPTY_ARRAY);
		return EMPTY_ARRAY;
	}
	
	// DB 빼올 때 : string -> list
	public List convertJsonStringToList(Class clazz, String jsonStr) {
		List lists = new ArrayList<>();
		if (jsonStr == null || "".equals(jsonStr)) {
			return lists;
		}

		if (clazz != null) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				lists = objectMapper.readValue(jsonStr, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
				return lists;
			} catch (Exception e) {
			}
		}
		return lists;
	}
}
