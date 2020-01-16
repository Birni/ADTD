package com.adtd.web.repository;

import com.adtd.web.entity.Node;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository with Nodes
 *
 * @author  Matthias Birnthaler
 */
public interface NodeRepository extends CrudRepository<Node, Long> {

}
