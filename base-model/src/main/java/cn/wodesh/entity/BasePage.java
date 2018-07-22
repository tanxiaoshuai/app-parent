package cn.wodesh.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TS on 2018/7/21.
 */
public class BasePage<T> implements Serializable{
    //当前页码
    private Integer currentPage = 1;
    //页面数量
    private Integer pageSize = 20;
    //总条数
    private Long total;
    //总页码数
    private Long pages;
    //下一页
    private Long nextPage;
    //集合对象
    private List<T> list;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getNextPage() {
        return nextPage;
    }

    public void setNextPage(Long nextPage) {
        this.nextPage = nextPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
