package com.bigbear.payment.dao;

import com.bigbear.payment.entity.Payment;
import org.apache.ibatis.annotations.*;

/**
 * @author wuyd
 * 2021/9/18 16:29
 */
@Mapper
public interface PaymentDao {

    /**
     * 保存
     * @param payment payment
     * @return id
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into payment (serial) values (#{serial})")
    int insert(Payment payment);

    /**
     * 根据Id获取
     * @param id id
     * @return payment
     */
    @Select("select * from payment where id = #{id}")
    Payment getById(@Param("id") long id);
}
