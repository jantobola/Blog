package cz.jantobola.blog.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class PageInfo implements Pageable {
	
	private int pageNumber;
	private int pageSize;
	
	private String sortColumn = "id";
	private Direction direction = Direction.ASC;
	
	public PageInfo() {
		
	}
	
	public PageInfo(Direction direction) {
		this.direction = direction;
	}
	
	public PageInfo(Direction direction, String sortColumn) {
		this.direction = direction;
		this.sortColumn = sortColumn;
	}
	
	@Override
	public int getPageNumber() {
		return pageNumber;
	}
	
	@Override
	public int getPageSize() {
		return pageSize;
	}
	
	@Override
	public int getOffset() {
		return pageNumber * pageSize;
	}
	
	@Override
	public Sort getSort() {
		return new Sort(direction, sortColumn);
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
