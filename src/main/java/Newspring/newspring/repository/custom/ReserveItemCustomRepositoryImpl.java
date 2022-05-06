package Newspring.newspring.repository.custom;

import Newspring.newspring.entity.AvailableDate;
import Newspring.newspring.entity.AvailableTime;
import Newspring.newspring.entity.ReserveItem;
import Newspring.newspring.entity.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReserveItemCustomRepositoryImpl implements ReserveItemCustomRepository {

    private final EntityManager em;

    @Override
    public List<AvailableDate> findAvailableDates() {
        return em.createQuery(
                        "select d " +
                                "from AvailableDate d " +
                                "where d.enabled = true", AvailableDate.class
                )
                .getResultList();
    }

    @Override
    public List<AvailableTime> findAvailableTimesByAvailableDateId(Long id) {
        return em.createQuery(
                        "select t " +
                                "from AvailableTime  t " +
                                "where t.availableDate.id = :id and t.enabled = true" , AvailableTime.class
                )
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Table> findAvailableTables() {
        return em.createQuery(
                        "select v " +
                                "from Table v " +
                                "where v.limit > 0 and v.enabled = true", Table.class
                )
                .getResultList();
    }

    @Override
    public List<ReserveItem> findAllReserveItem(){
        return em.createQuery(
                        "select distinct ri " +
                                "from ReserveItem ri " +
                                "join fetch ri.user u ",ReserveItem.class)
                .getResultList();
    }
}