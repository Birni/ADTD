package com.adtd.web.repository;

import com.adtd.web.entity.Location;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository with Locations
 *
 * @author  Matthias Birnthaler
 */
public interface LocationRepository extends CrudRepository<Location, String> {
}
