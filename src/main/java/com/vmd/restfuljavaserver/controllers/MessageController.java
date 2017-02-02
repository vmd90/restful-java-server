
package com.vmd.restfuljavaserver.controllers;

import com.vmd.restfuljavaserver.ResponseJson;
import com.vmd.restfuljavaserver.models.Message;
import com.vmd.restfuljavaserver.models.Talk;
import com.vmd.restfuljavaserver.models.User;
import com.vmd.restfuljavaserver.repos.MessageRepository;
import com.vmd.restfuljavaserver.repos.TalkRepository;
import com.vmd.restfuljavaserver.repos.UserRepository;

import java.util.Date;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author victor
 */
@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {
    
    private MessageRepository messageRepo;
    private TalkRepository talkRepo;
    private UserRepository userRepo;

    @Autowired
    public MessageController(MessageRepository messageRepo, TalkRepository talkRepo, UserRepository userRepo) {
        this.messageRepo = messageRepo;
        this.talkRepo = talkRepo;
        this.userRepo = userRepo;
    }
    
    // GET /message/all
    @RequestMapping(path = "/all", method = GET)
    public List<Message> getAll() {
        return messageRepo.findAll();
    }
    
    // GET /message?id={id}
    @RequestMapping(path = "", method = RequestMethod.GET)
    public Message getById(@RequestParam("id") long id) {
        return messageRepo.findOne(id);
    }

    // GET /message/unread
    @RequestMapping(path = "/unread", method = GET)
    public List<Message> getAllUnreadByTalkId(@RequestParam Long tid) {
        Talk talk = talkRepo.findOne(tid);
        List<Message> list = messageRepo.findByIsReadFalseAndTalkId(talk);
        list.stream().forEach( e -> e.setIsRead(true) );
        messageRepo.save(list);
        return list;
    }
    
    // POST /message/add
    @RequestMapping(value = "/add", method = POST)
    public ResponseEntity<?> add(@RequestBody MessageWrapper wrapper) {
        try {
            User user = userRepo.findOne(wrapper.getUserId());
            Talk talk = talkRepo.findOne(wrapper.getTalkId());
            Message message = new Message(null, new Date(), wrapper.getText(), false);
            message.setTalkId(talk);
            message.setUserId(user);

            messageRepo.save(message);
            System.out.println("Adding message "+ message);
        } catch(Exception e) {
            return ResponseJson.getError(e.getMessage());
        }
        return ResponseJson.getOk();
    }
    
    // GET /message/delete?id={id}
    @RequestMapping(value = "/delete", method = GET)
    public ResponseEntity<?> delete(@RequestParam Long id) {
        Message message = messageRepo.findOne(id);
        if(message == null) {
            System.out.println("Message not found");
            return ResponseJson.getError("Message not found");
        }
        System.out.println("Deleting message "+ id);
        messageRepo.delete(message);
        return ResponseJson.getOk();
    }
    
}
