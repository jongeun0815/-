package Newspring.newspring.repository.custom;

import Newspring.newspring.entity.Table;

public interface TableCustomRepository {

    Table findTable(Integer tableNum);

    Table findTableDisabled(Integer tableNum);
}