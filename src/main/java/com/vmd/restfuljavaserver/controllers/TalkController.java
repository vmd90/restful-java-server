
package com.vmd.restfuljavaserver.controllers;

import com.vmd.restfuljavaserver.repos.TalkRepository;
import com.vmd.restfuljavaserver.repos.UserRepository;
import com.vmd.restfuljavaserver.ResponseJson;
import com.vmd.restfuljavaserver.models.Talk;
import com.vmd.restfuljavaserver.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author victor
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/talk")
public class TalkController {
    
    private final TalkRepository talkRepo;
    private final UserRepository userRepo;
    
    @Autowired
    public TalkController(TalkRepository talkRepo, UserRepository userRepo) {
        this.talkRepo = talkRepo;
        this.userRepo = userRepo;
    }
    
    // POST /talk/add
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Talk talk) {
        
        System.out.println("Saving talk: "+talk.toString());
        talkRepo.save(talk);
        return ResponseJson.getOk();
    }
    
    // GET /talk/all
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Talk> getAll() {
        return talkRepo.findAll();
    }

    // GET /talk/user?id={id}
    @RequestMapping(value = "/user", method = GET)
    public List<Talk> getAllByUserId(@RequestParam Long id) {
        User user = userRepo.findOne(id);
        List<Talk> list1 = talkRepo.findByUserOne(user);
        List<Talk> list2 = talkRepo.findByUserTwo(user);
        list1.addAll(list2);
        System.out.println(list1);
        return list1;
    }
    
    // GET /talk/delete?id={id}
    @RequestMapping(value = "/delete", method = GET)
    public ResponseEntity delete(@RequestParam Long id) {
        Talk talk = talkRepo.findOne(id);
        if(talk == null) {
            System.out.println("Talk not found");
            return ResponseJson.getError("Talk not found");
        }
        System.out.println("Deleting talk "+ id);
        talkRepo.delete(talk);
        return ResponseJson.getOk();
    }
}
