package com.goodee.proj.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paging {
	
	
	private String keyword;
	private String category;
	// 전체 게시글 개수
	private Long totalData;
	// 전체 페이지 개수
	private Long totalPage;
	// 페이징바
	private Long pageBarSize = 5L;
	private Long pageBarStart;
	private Long pageBarEnd;
	
	//현재 페이지
	private Long nowPage = 1L;
	// 한 페이지당 게시글의 개수
	private Long numPerPage = 10L;
	// LIMIT 시작 번호
	private Long limitPageNo;
	
	//이전, 다음 여부
	private boolean prev = true;
	private boolean next = true;
	
	public Long getTotalData() {
		return totalData;
	}
	public void setTotalData(Long totalData) {
		this.totalData = totalData;
		calcPaging();
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public Long getPageBarSize() {
		return pageBarSize;
	}
	public void setPageBarSize(Long pageBarSize) {
		this.pageBarSize = pageBarSize;
	}
	public Long getPageBarStart() {
		return pageBarStart;
	}
	public void setPageBarStart(Long pageBarStart) {
		this.pageBarStart = pageBarStart;
	}
	public Long getPageBarEnd() {
		return pageBarEnd;
	}
	public void setPageBarEnd(Long pageBarEnd) {
		this.pageBarEnd = pageBarEnd;
	}
	public Long getNowPage() {
		return nowPage;
	}
	public void setNowPage(Long nowPage) {
		this.nowPage = nowPage;
	}
	public Long getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(Long numPerPage) {
		this.numPerPage = numPerPage;
	}
	public Long getLimitPageNo() {
		return limitPageNo;
	}
	public void setLimitPageNo(Long limitPageNo) {
		this.limitPageNo = limitPageNo;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	private void calcPaging() {
		// 현재 페이지를 기준으로 건너뛸 데이터의 개수
		limitPageNo = (nowPage-1)*numPerPage;
		// 전체 게시글 개수를 기준으로 페이지 개수 계산
		totalPage = (long)Math.ceil((double)totalData/numPerPage);
		// 페이징바의 시작 번호 계산
		pageBarStart = ((nowPage-1)/pageBarSize)*pageBarSize +1;
		// 페이징바의 끝 번호 계산
		// 만일 끝번호가 전체 페이지 개수보다 크면 재할당
		pageBarEnd = pageBarStart + pageBarSize -1;
		if(pageBarEnd > totalPage) pageBarEnd = totalPage;
		// 이전, 이후 버튼이 보이는지 여부 계산
		if(pageBarStart == 1) prev = false;
		if(pageBarEnd >= totalPage) next = false;
	} 
} 