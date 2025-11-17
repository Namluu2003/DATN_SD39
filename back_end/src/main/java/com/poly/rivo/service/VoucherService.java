


package com.poly.rivo.service;

import com.poly.rivo.entity.Voucher;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.VoucherRequest;
import com.poly.rivo.infrastructure.response.VoucherResponse;

public interface VoucherService {
    PhanTrang<VoucherResponse> getAll(VoucherRequest request);
    Voucher getOne(Long id);

    Voucher add(VoucherRequest voucher);

    Voucher update(Long id, VoucherRequest voucher);

    String delete(Long id);

    boolean isVoucherCodeExists(String code);
    void updateStatusVoucher();

    Voucher updateEndDate(Long id);



    void createScheduledVoucher();
}
