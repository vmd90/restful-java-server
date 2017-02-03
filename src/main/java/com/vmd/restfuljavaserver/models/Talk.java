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
@Table(name = "mytalk")
public class Talk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "lastDate")
    @Temporal(TemporalType.TIMESTAMP )
    private Date lastDate;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Message> messageCollection;

    @JoinColumn(name = "user1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    //@JsonIgnore
    private User user1;

    @JoinColumn(name = "user2", referencedColumnName = "id")
    @ManyToOne(optional = false)
    //@JsonIgnore
    private User user2;

    public Talk() {
    }

    public Talk(Long id, Date lastDate, User user1, User user2) {
        this.id = id;
        this.lastDate = lastDate;
        this.user1 = user1;
        this.user2 = user2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getlastDate() {
        return lastDate;
    }

    public void setlastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    public User getuser1() {
        return user1;
    }

    public void setuser1(User user1) {
        this.user1 = user1;
    }

    public User getuser2() {
        return user2;
    }

    public void setuser2(User user2) {
        this.user2 = user2;
    }

    @Override
    public String toString() {
        return "Talk{" + "id=" + id + ", lastDate=" + lastDate + ", messageCollection=" + messageCollection + ", user1=" + user1 + ", user2=" + user2 + '}';
    }
}
