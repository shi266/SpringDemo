package sanqi.com.Page;

public class BasePage {
    //分页时输入的参数
    private int page = 1; //当前页
    private int limit = 10; //一页显示的行数
    private  int pageCount;  //写分页时sql需要的条件由输入参数计算  (总页数)
    private int begin;  //当前页的起始行
    private int rows;  //计算总行数

    @Override
    public String toString() {
        return "BasePage{" +
                "page=" + page +
                ", limit=" + limit +
                ", pageCount=" + pageCount +
                ", begin=" + begin +
                ", rows=" + rows +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
        //用于计算总页数
    public int getPageCount() {
        if(this.rows % limit == 0){
            this.pageCount= this.rows / limit;
        }else{
            this.pageCount = (this.rows / limit)+1;
        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    //每页的开始行
    public int getBegin() {
        begin = (page-1)*limit;
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
