package notice.model;

public class NoticeContent {
    private Integer number;
    private String content;

    public NoticeContent(Integer number, String content) {
        super();
        this.number = number;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Integer getNumber() {
        return number;
    }

}
