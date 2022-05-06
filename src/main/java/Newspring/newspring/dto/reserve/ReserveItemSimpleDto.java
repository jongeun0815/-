package Newspring.newspring.dto.reserve;

import Newspring.newspring.entity.ReserveStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveItemSimpleDto {

    private Long reserveItemId;

    private Integer tableNum;

    private String reserveDate;

    private Integer reserveTime;

    private ReserveStatus reserveStatus;
}