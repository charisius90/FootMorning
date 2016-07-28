package com.footmorning.app.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	  private int totalCount;
	  private int startPage;
	  private int endPage;
	  private boolean prev;
	  private boolean next;

	  private int displayPageNum = 10;

	  private Criteria cri;

	  public void setCri(Criteria cri) {
	    this.cri = cri;
	  }

	  public void setTotalCount(int totalCount) {
	    this.totalCount = totalCount;

	    calcData();
	  }

	  private void calcData() {

	    endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);

	    startPage = (endPage - displayPageNum) + 1;

	    int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));

	    if (endPage > tempEndPage) {
	      endPage = tempEndPage;
	    }

	    prev = startPage == 1 ? false : true;

	    next = endPage * cri.getPerPageNum() >= totalCount ? false : true;

	  }

	  public int getTotalCount() {
	    return totalCount;
	  }

	  public int getStartPage() {
	    return startPage;
	  }

	  public int getEndPage() {
	    return endPage;
	  }

	  public boolean isPrev() {
	    return prev;
	  }

	  public boolean isNext() {
	    return next;
	  }

	  public int getDisplayPageNum() {
	    return displayPageNum;
	  }

	  public Criteria getCri() {
	    return cri;
	  }

	  public String makeQuery(int page) {

	    UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
	        .queryParam("perPageNum", cri.getPerPageNum()).build();

	    return uriComponents.toUriString();
	  }
	  
	  // 리스트 페이지에서 단일 게시글 클릭하면 페이징, 검색 정보를 가지고 URI문자열을 만들어서 조회페이지로 이동한다.
	  // 그러면 조회페이지에서 페이징, 검색정보를 유지하고 있기 떄문에 다시 리스트 페이지로 이동할 때 원레 page와 검색 조건의 리스트로 이동할 수 있다.
	  public String makeSearch(int page){
	    
	    UriComponents uriComponents =
	              UriComponentsBuilder.newInstance()
	              .queryParam("page", page)
	              .queryParam("perPageNum", cri.getPerPageNum())
	              .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
	              .queryParam("keyword", ((SearchCriteria)cri).getKeyword())
	              .build();             
	    
	    return uriComponents.toUriString();
	  } 
}
