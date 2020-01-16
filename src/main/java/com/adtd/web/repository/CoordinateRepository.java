package com.adtd.web.repository;

import com.adtd.web.entity.Coordinate;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository with Coordinates
 *
 * @author  Matthias Birnthaler
 */
public interface CoordinateRepository extends CrudRepository<Coordinate, Long> {
}
