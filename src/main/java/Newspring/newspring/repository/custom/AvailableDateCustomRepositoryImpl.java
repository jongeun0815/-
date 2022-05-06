package Newspring.newspring.repository.custom;

import Newspring.newspring.entity.AvailableDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class AvailableDateCustomRepositoryImpl implements AvailableDateCustomRepository{

    private final EntityManager em;

    @Override
    public AvailableDate findAvailableDateByDate(String date) {
        return em.createQuery(
                        "select d " +
                                "from AvailableDate d " +
                                "where d.date = :date", AvailableDate.class
                )
                .setParameter("date", date)
                .getSingleResult();

    }

}