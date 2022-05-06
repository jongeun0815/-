package Newspring.newspring.entity;

import lombok.Getter;

@Getter
public enum ReserveStatus {

    COMPLETE("예약완료"), CANCEL("예약취소");

    private String description;

    ReserveStatus(String description) {
        this.description = description;
    }
}