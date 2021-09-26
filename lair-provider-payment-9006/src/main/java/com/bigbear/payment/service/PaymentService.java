package com.bigbear.payment.service;

import com.bigbear.payment.dao.PaymentDao;
import com.bigbear.commons.entity.Payment;
import org.springframework.stereotype.Service;

/**
 * @author wuyd
 * 2021/9/22 9:27
 */
@Service
public class PaymentService implements IPaymentService{

    private final PaymentDao paymentDao;

    public PaymentService(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public long insert(Payment payment){
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getById(long id){
        return paymentDao.getById(id);
    }
}
