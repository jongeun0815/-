package Newspring.newspring.service.reserve;

import Newspring.newspring.dto.reserve.AvailableDateDto;
import Newspring.newspring.dto.reserve.AvailableTimeDto;
import Newspring.newspring.dto.reserve.ReserveItemSimpleDto;
import Newspring.newspring.dto.table.TableReserveDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReserveItemService {

    List<AvailableDateDto> getAvailableDates();

    List<AvailableTimeDto> getAvailableTimes(Long selectedDateId);

    List<TableReserveDto> getAvailableTableList();

    Long reserve(String username, Integer tableNum, Long dateId, Long timeId);

    ReserveItemSimpleDto getReserveResult(String username);

    void cancelReserveItem(Long reserveItemId);
}