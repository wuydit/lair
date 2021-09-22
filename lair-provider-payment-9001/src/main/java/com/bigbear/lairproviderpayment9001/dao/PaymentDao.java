package com.bigbear.lairproviderpayment9001.dao;

import com.bigbear.commons.entity.Payment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author wuyd
 * 2021/9/18 16:29
 */
@Mapper
@Component
public interface PaymentDao {

    /**
     * 保存
     * @param payment payment
     * @return id
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into payment (serial) values (#{serial})")
    long insert(Payment payment);

    /**
     * 根据Id获取
     * @param id id
     * @return payment
     */
    @Select("select * from payment where id = #{id}")
    Payment getById(@Param("id") long id);
}
