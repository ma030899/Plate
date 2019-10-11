package ccit.mly.page;

import java.io.Serializable;
/**
 * page工具类
 * @author mly
 *
 */
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pageNow=1;//当前所在页数
	private Integer pageSize=4;//每一页显示记录的条数
	private Integer totalCount;//总记录条数
	private Integer totalPageCount;//总页数
	private Integer startPos; // 页数开始位置，从0开始
	public Page() {
		super();
	}
	//构造函数(传入参数为总记录数和当前所在页面)
	public Page(Integer totalCount,Integer pageNow) {
		this.totalCount=totalCount;
		this.pageNow=pageNow;
	}
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPageCount() {
		totalPageCount = getTotalCount() / getPageSize();//总页数=总记录数/每页记录数
		return (totalCount % pageSize == 0) ? totalPageCount : totalPageCount + 1;
	}
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	//记录初始位置
	public Integer getStartPos() {
		return (pageNow - 1) * pageSize;
	}
	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}
	@Override
	public String toString() {
		return "Page [pageNow=" + pageNow + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPageCount=" + totalPageCount + ", startPos=" + startPos + "]";
	}
	
}
