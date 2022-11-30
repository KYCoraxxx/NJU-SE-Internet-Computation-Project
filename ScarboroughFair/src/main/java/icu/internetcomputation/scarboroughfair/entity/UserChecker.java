package icu.internetcomputation.scarboroughfair.entity;

public class UserChecker {
    public boolean isUserExist;
    public boolean isPasswordRight;

    public UserChecker(boolean isUserExist,boolean isPasswordRight)
    {
        this.isUserExist = isUserExist;
        this.isPasswordRight = isPasswordRight;
    }
}
