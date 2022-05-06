package Newspring.newspring.Controller;

import Newspring.newspring.dto.reserve.AvailableDateDto;
        import Newspring.newspring.dto.reserve.AvailableTimeDto;
        import Newspring.newspring.dto.reserve.ReserveItemRequestDto;
        import Newspring.newspring.dto.reserve.ReserveItemSimpleDto;
        import Newspring.newspring.dto.security.PrincipalDetails;
        import Newspring.newspring.dto.table.TableReserveDto;
        import Newspring.newspring.service.reserve.ReserveItemService;
        import lombok.RequiredArgsConstructor;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.security.core.annotation.AuthenticationPrincipal;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.mvc.support.RedirectAttributes;

        import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/reserve")
public class ReserveController {

    private final ReserveItemService reserveItemService;

    /**
     * 예약가능날짜 조회 및 선택
     */
    @GetMapping("/dates")
    public String getAvailableDates(Model model) {
        //예약가능날짜 조회
        List<AvailableDateDto> availableDates = reserveItemService.getAvailableDates();
        model.addAttribute("dates", availableDates);

        return "reserveDateSelectForm";
    }

    /**
     * 예약가능시간 조회 및 선택
     */
    @GetMapping("/times")
    public String getAvailableTimes(
            @RequestParam(name="date") Long selectedDateId, Model model) {
        // 선택한 예약날짜의 pk로 예약가능시간 조회
        List<AvailableTimeDto> times = reserveItemService.getAvailableTimes(selectedDateId);
        model.addAttribute("date", selectedDateId);
        model.addAttribute("times", times);
        return "reserveTimeSelectForm";
    }

    /**
     * 예약가능테이블 조회 및 선택
     */
    @GetMapping("/table")
    public String selectTable(@RequestParam(name = "tableNum") Integer table,
                                @RequestParam(name = "date") Long selectedDateId,
                                @RequestParam(name = "time") Long selectedTimeId, Model model) {

        List<TableReserveDto> Tables = reserveItemService.getAvailableTableList();

        model.addAttribute("tables", table);
        model.addAttribute("date", selectedDateId);
        model.addAttribute("time", selectedTimeId);

        return "reserveTableSelectForm";
    }

    /**
     * 예약처리
     */
    @PostMapping
    public String reserve(
            @AuthenticationPrincipal PrincipalDetails principal,
            @ModelAttribute ReserveItemRequestDto reserveItemRequestDto,
            RedirectAttributes redirectAttributes) {
        log.info("tableNum = {}", reserveItemRequestDto.getTableNum());
        log.info("reserveDateId = {}", reserveItemRequestDto.getReserveDateId());
        log.info("reserveTimeId = {}", reserveItemRequestDto.getReserveTimeId());

        String username = principal.getUsername();
        log.info("username = {}", username);

        Long savedUserId = reserveItemService.reserve(
                username,
                reserveItemRequestDto.getTableNum(),
                reserveItemRequestDto.getReserveDateId(),
                reserveItemRequestDto.getReserveTimeId()
        );

        return "redirect:/reserve";
    }

    /**
     * 예약조회
     */
    @GetMapping
    public String reserveResult(@AuthenticationPrincipal PrincipalDetails principal, Model model) {
        String username = principal.getUsername();
        log.info("username = {}", username);

        ReserveItemSimpleDto reserveResult = reserveItemService.getReserveResult(username);
        model.addAttribute("reserveResult", reserveResult);
        return "ReserveResult";
    }

    /**
     * 예약취소
     */
    @GetMapping("/{reserveItemId}/cancel")
    public String cancel(@PathVariable Long reserveItemId) {
        reserveItemService.cancelReserveItem(reserveItemId);

        return "redirect:/";
    }
}