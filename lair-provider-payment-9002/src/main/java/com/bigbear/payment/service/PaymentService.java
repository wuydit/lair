package com.bigbear.payment.service;

import com.bigbear.payment.dao.PaymentDao;
import com.bigbear.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
