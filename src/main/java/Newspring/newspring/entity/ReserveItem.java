package Newspring.newspring.entity;

import Newspring.newspring.entity.ReserveStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * USER의 예약서
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reserve_item")
@Getter
public class ReserveItem extends BaseEntity {

    @Column(name = "reserve_item_id")
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Enumerated(value = EnumType.STRING)
    private ReserveStatus status = ReserveStatus.COMPLETE;

    @Column(nullable = false)
    private Integer tableNum;
    @Column(nullable = false)
    private String reserveDate;
    @Column(nullable = false)
    private int reserveTime;

    @Builder(builderMethodName = "createReserveItem")
    public ReserveItem(
            User user, Restaurant restaurant, ReserveStatus status, String reserveDate, int reserveTime, int tableNum) {
        this.user = user;
        this.restaurant = restaurant;
        this.status = status;
        this.reserveTime = reserveTime;
        this.reserveDate = reserveDate;
        this.tableNum = tableNum;
        this.createAt = LocalDateTime.now();
    }

    //==비즈니스 로직==//
    //예약 날짜 및 예약 시간 update
    public void updateDateAndTime(String reserveDate,int reserveTime){
        this.reserveDate=reserveDate;
        this.reserveTime=reserveTime;
    }
}