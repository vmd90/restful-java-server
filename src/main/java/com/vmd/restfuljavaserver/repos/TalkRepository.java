
package com.vmd.restfuljavaserver.repos;

import com.vmd.restfuljavaserver.models.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author victor
 */
@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {
    
}
