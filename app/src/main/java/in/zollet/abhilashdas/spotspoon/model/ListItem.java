package in.zollet.abhilashdas.spotspoon.model;

/**
 * Created by abhilashdas on 09/06/17.
 */

public class ListItem {

    private String title;
    private String timesAgo;
    private String detail;
    private String url;

    public ListItem(){

    }

    public ListItem(String title, String timesAgo, String detail,String url){
        this.title = title;
        this.timesAgo = timesAgo;
        this.detail = detail;
        this.url = url;

    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimesAgo() {
        return timesAgo;
    }

    public void setTimesAgo(String timesAgo) {
        this.timesAgo = timesAgo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
