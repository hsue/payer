package beams;

/**
 * Created by hsue on 12/11/18.
 */
public class Paging {
  int page;
  int total;
  int page_size;
  int pages;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getPage_size() {
    return page_size;
  }

  public void setPage_size(int page_size) {
    this.page_size = page_size;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

}
