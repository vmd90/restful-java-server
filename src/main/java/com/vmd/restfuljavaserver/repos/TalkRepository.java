
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
    
    public List<Talk> findByUserOne(User user);

    public List<Talk> findByUserTwo(User user);
}
