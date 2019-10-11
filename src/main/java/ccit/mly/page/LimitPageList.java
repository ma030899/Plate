package ccit.mly.page;

import java.util.List;

public class LimitPageList {
	private Page page;
	private List<?> pageList;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<?> getPageList() {
		return pageList;
	}
	public void setPageList(List<?> pageList) {
		this.pageList = pageList;
	}
	@Override
	public String toString() {
		return "LimitPageList [page=" + page + ", pageList=" + pageList + "]";
	}
	
}
