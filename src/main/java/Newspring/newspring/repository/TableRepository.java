package Newspring.newspring.repository;

import Newspring.newspring.entity.HasTable;
import Newspring.newspring.repository.custom.TableCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.Optional;

public interface TableRepository extends JpaRepository<HasTable, Long>, TableCustomRepository {

}