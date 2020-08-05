package member.model;

public class Member {
    private String id;
    private String pw;
    private String name;
    private String dept;
    private String mail;

    public Member(String id, String pw, String name, String dept, String mail) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.dept = dept;
        this.mail = mail;
    }

    public boolean matchPassword(String pwd) {
        return pw.equals(pwd);
    }

    public void changePassword(String newPwd) {
        this.pw = newPwd;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPw() {
        return pw;
    }
    public String getDept() {
        return dept;
    }
    public String getMail() {
        return mail;
    }
}
