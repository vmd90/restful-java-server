
package com.vmd.restfuljavaserver.models;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "myuser")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name", unique = true)
    private String name;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;

    private String status;

    private String phoneNumber;

    private Blob picture;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Message> messageCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user1")
    private Collection<Talk> talkCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user2")
    private Collection<Talk> talkCollection1;

    public User() {
    }

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String pn) {
        this.phoneNumber = pn;
    }

    public Blob getPicture() {
        return this.picture;
    }

    public void setPicture(Blob p) {
        this.picture = p;
    }

    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    public Collection<Talk> getTalkCollection() {
        return talkCollection;
    }

    public void setTalkCollection(Collection<Talk> talkCollection) {
        this.talkCollection = talkCollection;
    }

    public Collection<Talk> getTalkCollection1() {
        return talkCollection1;
    }

    public void setTalkCollection1(Collection<Talk> talkCollection1) {
        this.talkCollection1 = talkCollection1;
    }
    
}
