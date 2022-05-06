package Newspring.newspring.dto.reserve;

import Newspring.newspring.entity.ReserveItem;
import Newspring.newspring.entity.ReserveStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReserveItemWithUsernameDto {

    private Long reserveItemId;

    private String username;

    private Integer tableNum;

    private String reserveDate;

    private Integer reserveTime;

    private ReserveStatus reserveStatus;

    public ReserveItemWithUsernameDto(ReserveItem reserveItem){
        this.reserveItemId = reserveItem.getId();
        this.username = reserveItem.getUser().getName();
        this.tableNum = reserveItem.getTableNum();
        this.reserveDate = reserveItem.getReserveDate();
        this.reserveTime = reserveItem.getReserveTime();
        this.reserveStatus = reserveItem.getStatus();
    }

}