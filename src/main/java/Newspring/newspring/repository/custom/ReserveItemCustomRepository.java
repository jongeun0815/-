package Newspring.newspring.repository.custom;

import Newspring.newspring.entity.AvailableDate;
import Newspring.newspring.entity.AvailableTime;
import Newspring.newspring.entity.ReserveItem;
import Newspring.newspring.entity.Table;

import java.util.List;

public interface ReserveItemCustomRepository {

    /**
     * 예약가능 날짜 조회
     */
    List<AvailableDate> findAvailableDates();

    /**
     * 예약가능 시간 조회
     */
    List<AvailableTime> findAvailableTimesByAvailableDateId(Long id);


    /**
     * 예약가능 테이블 조회
     */
    List<Table> findAvailableTables();

    /**
     * 예약 현황 조회
     */
    List<ReserveItem> findAllReserveItem();


}