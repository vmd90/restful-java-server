
package com.vmd.restfuljavaserver.repos;

import com.vmd.restfuljavaserver.models.Message;
import com.vmd.restfuljavaserver.models.Talk;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author victor
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    
    /**
     * Finds all unread messages by using the talkId as a search criteria
     * @param talkId
     * @return A list of unread messages
     */
    //@Query("SELECT M FROM Message M WHERE M.is_read = FALSE AND M.talk_id = :talkId")
    //public List<Message> findAllUnreadByTalkId(@Param("talkId") Long talkId);
    
    public List<Message> findByIsReadFalseAndTalkId(Talk talkId);
}
