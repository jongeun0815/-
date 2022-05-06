package Newspring.newspring.dto.table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableReserveDto {
    private Long id; // 아이디
    private String tableNum; // 테이블 번호
}