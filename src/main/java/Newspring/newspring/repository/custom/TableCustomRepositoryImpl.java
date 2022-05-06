package Newspring.newspring.repository.custom;

import Newspring.newspring.entity.Table;
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
    public Table findTable(Integer tableNum) {
        return em.createQuery(
                        "select b " +
                                "from Table b" +
                                "where b.tableNum = :tableNum and b.enabled = true", Table.class
                )
                .setParameter("tableNum", tableNum)
                .getSingleResult();
    }

    @Override
    public Table findTableDisabled(Integer tableNum) {
        return em.createQuery(
                        "select v " +
                                "from Table v" +
                                "where v.tableNum = :tableNum", Table.class
                )
                .setParameter("tableNum", tableNum)
                .getSingleResult();
    }
}