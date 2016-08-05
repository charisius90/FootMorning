package com.footmorning.app.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.ChallengeDTO;
import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.service.ChallengeService;
import com.footmorning.app.service.MatchService;

@Controller
public class ChallengeController {
	
	@Inject
	private ChallengeService service;
	
	@Inject
	private MatchService matchService;
	
	   @RequestMapping(value="/challenge/register",method=RequestMethod.POST)
	   public String ChallengeRegister(HttpServletRequest req,RedirectAttributes rttr) throws Exception{

	      int user_club_no = Integer.parseInt(req.getParameter("receiver_club_no"));
	      int club_no = Integer.parseInt(req.getParameter("sander_club_no"));
//	      int game_no = Integer.parseInt(req.getParameter("game_no"));
	      
	      System.out.println("DATA Called...:"+user_club_no+","+club_no);
	      
	      ChallengeDTO dto2 = new ChallengeDTO();
	      dto2.setReceiver_club_no(user_club_no);
	      dto2.setSender_club_no(club_no);
	      
	      if(req.getParameter("game_no")!=null){
	            int game_no = Integer.parseInt(req.getParameter("game_no"));
	            dto2.setGame_no(game_no);
	         }
//	      dto2.setGame_no(game_no);
	      
	      
//	      System.out.println("sender:...."+dto.toString());
	      //보내는 클럽넘버와 받는 클럽넘버가 같을때
//	      System.out.println("클럽넘버 받아옴?....:"+service.validateClubMo(club_no));
	      if(user_club_no==club_no){
	         req.setAttribute("result", "SAMECLUB");
	         return "/matching/json/reslutJson";
	      }
	      //이미 도전장을 보낸경우
	      else if(service.validateUserClubNo(dto2).size()>0){
	         req.setAttribute("result", "SAMENAME");
	         return "/matching/json/reslutJson";
	      }
	      else{
	    	  req.setAttribute("HOME_NAME", service.myClubName(user_club_no));
	          req.setAttribute("AWAY_NAME", service.myClubName(club_no));
	         return "/matching/json/reslutJson";
	      }
	   }
   @RequestMapping(value="/challenge/registercomp")
   public String ChallengeRegisterComplete(ChallengeDTO dto,RedirectAttributes rttr) throws Exception{
      
      service.ChallengeRegister(dto);
      rttr.addFlashAttribute("msg", "SUCCESS");
      return "redirect:/matching/main";
   }
	
	@RequestMapping(value="/challenge/invite",method=RequestMethod.POST)
	public String ChallengeInvite(HttpServletRequest req, RedirectAttributes rttr, MatchDTO dto) throws Exception{
		System.out.println("invite 컨트롤러");
		int game_no = Integer.parseInt(req.getParameter("checkbox"));
		System.out.println("게임번호 : "+game_no);
		
		MatchDTO matchDto = matchService.matchWithGameNo(game_no);
		ChallengeDTO challengeDto = new ChallengeDTO();
		challengeDto.setSender_club_no(matchDto.getClub_no());
		challengeDto.setReceiver_club_no(Integer.parseInt(req.getParameter("yourclubNo")));
		challengeDto.setChallenge_content(req.getParameter("challenge_content"));
		challengeDto.setGame_no(game_no);
		challengeDto.setGame_flag(matchDto.getGame_flag());
		challengeDto.setClub_ability(matchDto.getClub_ability());
		challengeDto.setChallenge_flag("INVITE");
		System.out.println("만든 초대장: " + challengeDto.toString());
		
		service.ChallengeRegister(challengeDto);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/club/clubList";
	}
	
   @RequestMapping(value="/challenge/thirdregister",method=RequestMethod.POST)
   public String ChallengeThirdWay(ChallengeDTO dto,RedirectAttributes rttr) throws Exception{
      
      //sender접속해있는 유저,receiver=club_no
      //game_no 받아와서 1추가
      Integer gameMaxNo=matchService.gameNoMax();

      if(gameMaxNo.equals(null)){
         dto.setGame_no(gameMaxNo=0);
      }
      else if(gameMaxNo>0){
         dto.setGame_no(gameMaxNo+1);
      }
      System.out.println("called...dto:"+dto.toString());
      //일단도전장부터보냄
      System.out.println(matchService.gameNoMax()); 
      //sender
      service.ChallengeRegister(dto);
      //receiver
      //도전장 보내는동시에 게임생성
      MatchDTO matDto= new MatchDTO();
      matDto.setClub_ability(dto.getClub_ability());
      matDto.setClub_no(dto.getSender_club_no());
      matDto.setGame_flag(dto.getGame_flag());
      matDto.setGame_no(dto.getGame_no());
      System.out.println("도전장 보내는쪽 매치생성....:"+matDto.toString());
//	      matchService.matchRegister(matDto);
      MatchDTO mat2Dto= new MatchDTO();
      //클럽어빌리티는 지금설정불가..
      mat2Dto.setClub_no(dto.getReceiver_club_no());
      mat2Dto.setGame_flag("HOME");
      mat2Dto.setGame_no(matDto.getGame_no());
      matchService.matchRegister(mat2Dto);
      System.out.println("도전장 받는쪽...매치생성...:"+mat2Dto.toString());
   
      return "redirect:/club/clubList";
   }
}
