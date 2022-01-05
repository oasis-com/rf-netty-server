package com.oasis.protobuf.protocol;

import com.oasis.protobuf.ProtoMsg;

public class User
{

    String uid;
    String devId;
    String token;
    String nickName;
    PLATTYPE platform;

    // windows,mac,android, ios, web , other
    public enum PLATTYPE
    {
        WINDOWS, MAC, ANDROID, IOS, WEB, OTHER;
    }

    private int sessionId;

    public int getSessionId()
    {
        return sessionId;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getDevId()
    {
        return devId;
    }

    public void setDevId(String devId)
    {
        this.devId = devId;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public PLATTYPE getPlatform()
    {
        return platform;
    }

    public void setPlatform(PLATTYPE platform)
    {
        this.platform = platform;
    }

    public void setPlatform(int platform)
    {
        PLATTYPE[] values=   PLATTYPE.values();
        for (int i = 0; i < values.length; i++)
        {
            if(values[i].ordinal()==platform)
            {
                this.platform = values[i];
            }
        }

    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "uid='" + uid + '\'' +
                ", devId='" + devId + '\'' +
                ", token='" + token + '\'' +
                ", nickName='" + nickName + '\'' +
                ", platform=" + platform +
                '}';
    }

    public static User build(ProtoMsg.LoginRequest info)
    {
        User user = new User();
        user.uid = new String(info.getUid());
        user.devId = new String(info.getDeviceId());
        user.token = new String(info.getToken());
        user.setPlatform(info.getPlatform());

        return user;

    }

    public void setSessionId(int sessionId)
    {
        this.sessionId = sessionId;
    }


}
