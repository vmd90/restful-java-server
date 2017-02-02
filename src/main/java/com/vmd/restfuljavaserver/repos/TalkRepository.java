
package com.vmd.restfuljavaserver.repos;

import com.vmd.restfuljavaserver.models.Talk;
import com.vmd.restfuljavaserver.models.User;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author victor
 */
@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {
    
    public List<Talk> findByUser1(User user);

    public List<Talk> findByUser2(User user);
}
