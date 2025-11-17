package com.poly.rivo.service;

import com.poly.rivo.entity.Bill;
import com.poly.rivo.entity.BillHistory;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.BillClientRequest;
import com.poly.rivo.infrastructure.request.bill.BillRequest;
import com.poly.rivo.infrastructure.request.bill.BillSearchRequest;
import com.poly.rivo.infrastructure.response.BillResponse;
import com.poly.rivo.infrastructure.response.StatisticBillStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface BillService {
    PhanTrang<BillResponse> getAll(BillSearchRequest request);
    Bill getOne(Long id);
    Bill create();
    Bill update(Long id, BillRequest request);
    List<Bill> getNewBill(BillSearchRequest request);
    Bill orderBill(Long id, BillRequest request);
    Bill changeStatus(Long id, String note, Boolean isCancel, Boolean isVnpay);

    Bill findByCode(String code);
    Bill changeInfoCustomer(Long id, BillRequest request);
    List<BillHistory> getBillHistory(Long billId);

    Bill updateVoucher(Long billId, Long newVoucherId);

    List<StatisticBillStatus> statisticBillStatus();
    List<StatisticBillStatus> statisticBillStatusByDateRange(LocalDateTime fromDate, LocalDateTime toDate);

}
