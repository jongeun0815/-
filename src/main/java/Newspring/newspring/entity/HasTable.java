package Newspring.newspring.entity;

import Newspring.newspring.exception.table.NotEnoughStockException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "db_table")
@Getter
public class HasTable extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "table_num",nullable = false)
    private Integer tableNum;

    @Column(nullable = false)
    private Integer limit;

    public void cancel() {
        this.enabled=true;
    }

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Type(type="yes_no")
    private boolean enabled = true;

    public void setEnabled(boolean flag) {
        this.enabled = flag;
    }

    @Builder(builderMethodName = "createTable")
    public HasTable(Integer tableNum, Integer limit) {
        this.tableNum = tableNum;
        this.limit = limit;

        this.createAt = LocalDateTime.now();
    }

}