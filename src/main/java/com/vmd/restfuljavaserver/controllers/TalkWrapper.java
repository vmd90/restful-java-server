package com.vmd.restfuljavaserver.controllers;

public class TalkWrapper {
    private Long user1;
    private Long user2;

    public TalkWrapper() {
    }

    public String toString() {
        return "TalkWrapper{"+user1+", "+user2+"}";
    }

    public void setUser1(Long u) {
        user1 = u;
    }

    public void setUser2(Long u) {
        user2 = u;
    }

    public Long getUser1() {
        return user1;
    }

    public Long getUser2() {
        return user2;
    }
}