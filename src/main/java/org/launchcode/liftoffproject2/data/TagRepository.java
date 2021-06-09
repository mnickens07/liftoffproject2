package org.launchcode.liftoffproject2.data;

import org.launchcode.liftoffproject2.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
}
