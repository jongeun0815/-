package Newspring.newspring.repository;

import Newspring.newspring.entity.ReserveItem;
import Newspring.newspring.dto.reserve.ReserveItemSimpleDto;
import Newspring.newspring.repository.custom.ReserveItemCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReserveItemRepository extends JpaRepository<ReserveItem, Long>, ReserveItemCustomRepository {

    @Query("select new Newspring.newspring.dto.reserve.ReserveItemSimpleDto(ri.id, ri.tableNum, ri.reserveDate, ri.reserveTime, ri.status) " +
            "from ReserveItem  ri " +
            "where ri.user.id = :userId")
    Optional<ReserveItemSimpleDto> findByUserId(Long userId);
}