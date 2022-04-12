package sanqi.com.entity;


import java.util.Date;

public class RecruitmentInformation {

    private long id;
    private String recruitmenttopic;
    private String recruitmentcompany;
    private String companylocation;
    private String url;
    private Date created;

    @Override
    public String toString() {
        return "RecruitmentInformation{" +
                "id=" + id +
                ", recruitmenttopic='" + recruitmenttopic + '\'' +
                ", recruitmentcompany='" + recruitmentcompany + '\'' +
                ", companylocation='" + companylocation + '\'' +
                ", url='" + url + '\'' +
                ", created=" + created +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecruitmenttopic() {
        return recruitmenttopic;
    }

    public void setRecruitmenttopic(String recruitmenttopic) {
        this.recruitmenttopic = recruitmenttopic;
    }

    public String getRecruitmentcompany() {
        return recruitmentcompany;
    }

    public void setRecruitmentcompany(String recruitmentcompany) {
        this.recruitmentcompany = recruitmentcompany;
    }

    public String getCompanylocation() {
        return companylocation;
    }

    public void setCompanylocation(String companylocation) {
        this.companylocation = companylocation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
