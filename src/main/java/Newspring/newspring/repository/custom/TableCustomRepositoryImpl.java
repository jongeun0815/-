package Newspring.newspring.repository.custom;

import Newspring.newspring.entity.HasTable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Slf4j
@RequiredArgsConstructor
@Repository
public class TableCustomRepositoryImpl implements TableCustomRepository{

    private final EntityManager em;

    @Override
    public HasTable findTable(Integer tableNum) {
        return em.createQuery(
                        "select b " +
                                "from Table b" +
                                "where b.tableNum = :tableNum and b.enabled = true", HasTable.class
                )
                .setParameter("tableNum", tableNum)
                .getSingleResult();
    }

    @Override
    public HasTable findTableDisabled(Integer tableNum) {
        return em.createQuery(
                        "select v " +
                                "from Table v" +
                                "where v.tableNum = :tableNum", HasTable.class
                )
                .setParameter("tableNum", tableNum)
                .getSingleResult();
    }
}