package com.bigbear.payment.service;

import com.bigbear.commons.entity.Payment;
import com.bigbear.payment.dao.PaymentDao;
import org.springframework.stereotype.Service;

/**
 * @author wuyd
 * 2021/9/22 9:27
 */

public interface IPaymentService {

    long insert(Payment payment);

    Payment getById(long id);

}
