package com.poly.rivo.service.impl;

import com.poly.rivo.entity.Bill;
import com.poly.rivo.entity.BillHistory;
import com.poly.rivo.entity.PaymentMethod;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.converter.PaymentMethodConvert;
import com.poly.rivo.infrastructure.request.PaymentMethodRequest;
import com.poly.rivo.infrastructure.response.PaymentMethodResponse;
import com.poly.rivo.repository.IBillHistoryRepository;
import com.poly.rivo.repository.IBillRepository;
import com.poly.rivo.repository.IPaymentMethodRepository;
import com.poly.rivo.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private IPaymentMethodRepository repository;
    @Autowired
    private PaymentMethodConvert paymentMethodConvert;
    @Autowired
    private IBillRepository billRepository;
    @Autowired

    private IBillHistoryRepository billHistoryRepository;
    @Override
    public List<PaymentMethodResponse> getByBill(Long idBill) {
        return repository.getByBill(idBill);
    }

    @Override
    public ResponseObject create(PaymentMethodRequest request) {
        PaymentMethod paymentMethod = repository.save(paymentMethodConvert.convertRequestToEntity(request));
        List<PaymentMethod> paymentMethods = repository.findByBillIdAndType(request.getBill(), request.getType());
        Bill bill = billRepository.findById(request.getBill()).orElse(null);
        Double totalPayment = 0.0;
        for (PaymentMethod x: paymentMethods) {
            totalPayment+=x.getTotalMoney().doubleValue();
        }
        if (BigDecimal.valueOf(totalPayment).compareTo(bill.getTotalMoney().add(bill.getMoneyShip())) >= 0) {
            BillHistory history1 = new BillHistory();
//            history1.setBill(bill);
//            history1.setStatus(BillStatusConstant.XAC_NHAN_THONG_TIN_THANH_TOAN);
            history1.setNote("Đã thanh toán đủ tiền");
            billHistoryRepository.save(history1);
        }

        return new ResponseObject(paymentMethod);
    }
}

