package Newspring.newspring.dto.table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableDto {
    private Long tableNum; // 테이블 번호
    private Integer limit;  // 테이블 수용 인원
}
