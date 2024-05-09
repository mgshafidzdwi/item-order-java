package id.test.api.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import id.test.api.persistence.model.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Long> {

    List<Orders> findByOrderNo(String orderNo);

    @Modifying
    @Query("DELETE FROM #{#entityName} o WHERE o.orderNo = :orderNo")
    void deleteByOrderNo(String orderNo);

}
