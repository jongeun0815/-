package Newspring.newspring.dto.reserve;

import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReserveItemRequestDto {
    private Integer tableNum;
    private Long reserveDateId;
    private Long reserveTimeId;
}