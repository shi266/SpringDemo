package sanqi.com.entity;

public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String address;


    public UserInfo(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public    UserInfo(){
        super();
    }
    public void testInfo(int a,String b){
        System.out.println("反射调用我:"+a+"\t "+b);
    }
    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
