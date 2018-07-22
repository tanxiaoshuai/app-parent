package cn.wodesh.entity;


import java.util.List;

/**
 * Created by TS on 2018/7/21.
 */
public class Page<T> extends BasePage<T>{

    //当前对象
    private T fields;
    //时间范围
    private TimeRanges timeRanges;
    //排序
    private List<OrderBy> sort;

    public T getFields(Class<T> c) {
        if(fields == null){
            try {
                fields = c.newInstance();
            } catch (Exception e) {
                throw new NullPointerException("创建分页条件类失败");
            }
        }
        return fields;
    }

    public void setFields(T fields) {
        this.fields = fields;
    }

    public TimeRanges getTimeRanges() {
        return timeRanges == null ? new TimeRanges() : timeRanges;
    }

    public void setTimeRanges(TimeRanges timeRanges) {
        this.timeRanges = timeRanges;
    }

    public List<OrderBy> getSort() {
        return sort;
    }

    public void setSort(List<OrderBy> sort) {
        for(OrderBy o : sort){
            if(o.getParam() == null || "".equals(o.getParam())){
                throw new NullPointerException("排序参数不能为空");
            }
            if(o.getType() == null || "".equals(o.getType())){
                throw new NullPointerException("排序规则不能为空");
            }
            if(!"DESC".equals(o.getType()) && !"ASC".equals(o.getType())){
                throw new NullPointerException("排序规则错误");
            }
        }
        this.sort = sort;
    }
}
