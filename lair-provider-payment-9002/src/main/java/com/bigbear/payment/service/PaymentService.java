package com.bigbear.payment.service;

import com.bigbear.payment.dao.PaymentDao;
import com.bigbear.commons.entity.Payment;
import org.springframework.stereotype.Service;

/**
 * @author wuyd
 * 2021/9/22 9:27
 */
@Service
public class PaymentService {

    private final PaymentDao paymentDao;

    public PaymentService(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public long insert(Payment payment){
        return paymentDao.insert(payment);
    }

    public Payment getById(long id){
        return paymentDao.getById(id);
    }
}
