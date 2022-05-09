package Newspring.newspring.repository.custom;

import Newspring.newspring.entity.HasTable;

public interface TableCustomRepository {

    HasTable findTable(Integer tableNum);

    HasTable findTableDisabled(Integer tableNum);
}