package org.launchcode.liftoffproject2.data;

import org.launchcode.liftoffproject2.models.TypeOfEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfEventRepository extends CrudRepository<TypeOfEvent, Integer> {
}
