package icu.internetcomputation.scarboroughfair.entity;

public class UserChecker {
    public boolean isExist;
    public boolean isPwdRight;

    public UserChecker(boolean isExist,boolean isPwdRight)
    {
        this.isExist = isExist;
        this.isPwdRight = isPwdRight;
    }
}
