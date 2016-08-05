package com.footmorning.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footmorning.app.domain.MatchDTO;
import com.footmorning.app.service.ChallengeService;
import com.footmorning.app.service.MatchService;

@Controller
public class MyclubGameScheduleController {

	@Inject
	private MatchService service;

	@RequestMapping("/myclub/myclubGameSchedule")
	public String myclubGameSchedule(Model model, int club_no) throws Exception {
		System.out.println("클럽번호: " + club_no);
		// model.addAttribute("myList", service.myMatchListWithClubNo(club_no));
		// model.addAttribute("yourList",
		// service.yourMatchListWithClubNo(club_no));

		model.addAttribute("list", service.matchListWithClubNo(club_no));
		model.addAttribute("nullList", service.matchListWithClubNoThird(club_no));

		List<MatchDTO> list = service.matchListWithClubNoThird(club_no);
		System.out.println("리스트 받아옴");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번쨰 : " + list.get(i).toString());
		}
		return "/myclub/myclubGameSchedule";
	}

	@RequestMapping("/myclub/myclubCancleGame")
	public String myclubCancleGame(HttpServletRequest req) throws Exception {
		int game_no = Integer.parseInt(req.getParameter("game_no"));
		System.out.println("게임번호: " + game_no);

		service.matchDelete(game_no);
		req.setAttribute("result", true);

		return "/myclub/json/myclubCancleGameJson";
	}

	@RequestMapping("/myclub/myclubEditGame")
	public String myclubEditGame(HttpServletRequest req) throws Exception {
		int game_no = Integer.parseInt(req.getParameter("game_no"));
		String game_date = req.getParameter("game_date");
		String game_time = req.getParameter("game_time");
		String game_addr = req.getParameter("game_addr");
		int club_ability = Integer.parseInt(req.getParameter("club_ability"));

		System.out.println(game_no + "," + game_date + "," + game_time + "," + game_addr + "," + club_ability);

		return "";
	}

	@RequestMapping(value = "/myclub/myclubEditGame", method = RequestMethod.POST)
	public String myclubEditGame(MatchDTO dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		String club_no = req.getParameter("club_no");
		// System.out.println(dto.toString());

		service.editHome(dto);
		service.editAway(dto);

		rttr.addAttribute("msg", "EDITCOMP");

		return "redirect:/myclub/myclubGameSchedule?club_no=" + club_no;
	}
}
