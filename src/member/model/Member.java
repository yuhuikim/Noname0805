package member.model;

public class Member {
    private int id;
    private String pw;
    private String name;
    private String dept;
    private String mail;

    public Member(int id, String pw, String name, String dept, String mail) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.dept = dept;
        this.mail = mail;
    }

    public boolean matchPassword(int pwd) {
        return pw.equals(pwd);
    }

    public void changePassword(String newPwd) {
        this.pw = newPwd;
    }

    public int getId() {
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
