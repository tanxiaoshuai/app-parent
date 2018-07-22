package cn.wodesh.util;

import cn.wodesh.entity.BasePage;
import com.github.pagehelper.PageInfo;

/**
 * Created by TS on 2018/7/22.
 */
public class PageUtils {

    /**
     * 返回分页类格式化
     * @param pageInfo
     * @return
     */
    public static BasePage pageFormat(PageInfo pageInfo){
        BasePage page = new BasePage();
        page.setCurrentPage(pageInfo.getPageNum());
        page.setNextPage((long) pageInfo.getNextPage());
        page.setPages((long) pageInfo.getPages());
        page.setPageSize(pageInfo.getPageSize());
        page.setTotal(pageInfo.getTotal());
        page.setList(pageInfo.getList());
        return page;
    }
}
