package com.vmd.restfuljavaserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 *
 * @author victor
 */
@Entity
@Table(name = "mymessage")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "text")
    private String text;

    private boolean isRead;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    //@JsonIgnore
    private Talk talkId;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    //@JsonIgnore
    private User userId;

    public Message() {
    }

    public Message(Long id, Date createdDate, String text, boolean isRead) {
        this.id = id;
        this.createdDate = createdDate;
        this.text = text;
        this.isRead = isRead;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Talk getTalkId() {
        return talkId;
    }

    public void setTalkId(Talk talkId) {
        this.talkId = talkId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message[ id=" + id + " ]";
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

}
