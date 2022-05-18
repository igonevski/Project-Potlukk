package dev.group1.Potlukk.dtos;

public class UserInfo {

    private int uId;
    private String username;

    public UserInfo(){}

    public UserInfo(int uId, String username){
        this.uId = uId;
        this.username = username;
    }

    public int getUId(){
        return uId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
