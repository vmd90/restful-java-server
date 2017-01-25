package com.vmd.restfuljavaserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "talk")
public class Talk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "time", columnDefinition = "default now()")
    @Temporal(TemporalType.TIMESTAMP )
    private Date time;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talkId")
    private Collection<Message> messageCollection;

    @JoinColumn(name = "user_one", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User userOne;

    @JoinColumn(name = "user_two", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User userTwo;

    public Talk() {
    }

    public Talk(Long id, Date time, Collection<Message> messageCollection, User userOne, User userTwo) {
        this.id = id;
        this.time = time;
        this.messageCollection = messageCollection;
        this.userOne = userOne;
        this.userTwo = userTwo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    public User getUserOne() {
        return userOne;
    }

    public void setUserOne(User userOne) {
        this.userOne = userOne;
    }

    public User getUserTwo() {
        return userTwo;
    }

    public void setUserTwo(User userTwo) {
        this.userTwo = userTwo;
    }

    @Override
    public String toString() {
        return "Talk{" + "id=" + id + ", time=" + time + ", messageCollection=" + messageCollection + ", userOne=" + userOne + ", userTwo=" + userTwo + '}';
    }
}
