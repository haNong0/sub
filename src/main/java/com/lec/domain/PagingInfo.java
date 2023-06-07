package com.lec.domain;

public class PagingInfo {
	
	private int curPage = 1;		//현재페이지 번호
	private int rowSizePerPage = 1; // 한 페이지당 레코드수(기본10)
	private int pageSize = 1;		// 페이지 리스트에서 보여줄 페이지 갯수(기본 10page)
	private int totalRowCount = 1;  // 총 레코드수 
	private int firstRow = 1;		// 시작 레코드수
	private int lastRow = 1;		// 마지막 레코드 수
	private int totalPageCount = 1; // 총 페이지수
	private int startPage = 1; 		// 페이지리스트에서 시작페이지번호
	private int endPage = 1;		// 페이지리스트에서 마지막페이지 번호
	private String searchType ;		// 검색유형(제목, 내용 등)
	private String searchWord ;		// 검색단어
	
	
	// 페이지 계산
	public void pageSetting() {
		totalPageCount = (totalRowCount-1) / rowSizePerPage + 1;
		firstRow = (curPage-1) * rowSizePerPage;
		lastRow = firstRow + rowSizePerPage;
		if(lastRow > totalRowCount) lastRow = totalRowCount;
		startPage = (curPage-1) / pageSize + pageSize + 1;
		endPage = startPage + pageSize - 1;
		if(endPage > totalPageCount) endPage = totalPageCount;

	}
}
