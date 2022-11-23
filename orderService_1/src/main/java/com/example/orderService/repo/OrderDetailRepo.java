package com.example.orderService.repo;


import com.example.orderService.entity.Order;
import com.example.orderService.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderDetailRepo extends CrudRepository<OrderDetail, Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into t_order_detail values (:order_id, :product_id, :count_product)", nativeQuery = true)
     OrderDetail create(@Param(value = "order_id") Order order_id, @Param(value = "product_id") Long product_id, @Param(value = "count_product") int count_product);

    @Query(value = "select * from t_order_detail where order_id = :order_id", nativeQuery = true)
    List<OrderDetail> getOrderDetailByOrderId(@Param(value = "order_id") Long order_id);
}
