package org.launchcode.liftoffproject2.data;

import org.launchcode.liftoffproject2.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository//because EventRepository is extending CrudRepository, I am able to use findById, findAllById, findAll and save methods
@Transactional
public interface EventRepository extends CrudRepository<Event, Integer> {//CrudRepository<class that we are storing in database, data type of the primekey>
}
