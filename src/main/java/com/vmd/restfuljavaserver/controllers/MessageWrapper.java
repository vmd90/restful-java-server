package com.vmd.restfuljavaserver.controllers;

/**
 * MessageWrapper
 */
public class MessageWrapper {

    private String text;
    private Long talkId;
    private Long userId;

    public MessageWrapper () {
    }

    public String getText() {
        return text;
    }

    public Long getTalkId() {
        return talkId;
    }

    public Long  getUserId() {
        return userId;
    }

    public void setText(String t) {
        text = t;
    }

    public void setTalkId(Long id) {
        talkId = id;
    }

    public void setUserId(Long id) {
        userId = id;
    }
}