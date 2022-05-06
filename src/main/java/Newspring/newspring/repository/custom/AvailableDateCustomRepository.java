package Newspring.newspring.repository.custom;

import Newspring.newspring.entity.AvailableDate;

public interface AvailableDateCustomRepository {

    AvailableDate findAvailableDateByDate(String date);
}