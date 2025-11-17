package com.poly.rivo.service;

import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.FindShoeDetailRequest;
import com.poly.rivo.infrastructure.request.bill.BillSearchRequest;
import com.poly.rivo.infrastructure.response.*;

import java.util.List;

public interface ThongKeService {
    List<StatisticalDayResponse> getAllStatisticalDay();
    List<StatisticalWeeklyResponse> getAllStatisticalWeek();
    List<StatisticalMonthlyResponse> getAllStatisticalMonth();
    List<StatisticalYearlyResponse> getAllStatisticalYear();
    List<StatisticalCustomResponse> getStatisticalCustom(Long fromDate, Long toDate);
    PhanTrang<BillResponse> getStatisticalByDateRange(BillSearchRequest request);
    PhanTrang<SanPhamChiTietReponse> getNearExpiredProducts(FindShoeDetailRequest request);


}