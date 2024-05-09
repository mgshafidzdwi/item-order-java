package id.test.api.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.test.api.persistence.model.Items;

@Repository
public interface ItemsDao extends JpaRepository<Items, Long> {

}
