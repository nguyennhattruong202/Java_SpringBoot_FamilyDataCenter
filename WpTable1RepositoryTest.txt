package com.nnt.fdcweb;

import com.nnt.fdcweb.model.WpTable1;
import com.nnt.fdcweb.repository.WpTable1Repository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@Disabled
public class WpTable1RepositoryTest {

    @Autowired
    private WpTable1Repository wpTable1Repository;

    @Test
    public void WpTable1InsertTest() {
        WpTable1 wpTable1 = new WpTable1();
        wpTable1.setFullname("nguyennhattruong2");
        WpTable1 newWptable1 = this.wpTable1Repository.save(wpTable1);
        Assertions.assertThat(newWptable1).isNotNull();
        Assertions.assertThat(newWptable1.getId()).isGreaterThan(0);
    }

    @Test
    public void WpTable1SelectAllTest() {
        Iterable<WpTable1> wpTable1 = this.wpTable1Repository.findAll();
        Assertions.assertThat(wpTable1).hasSizeGreaterThan(0);
        for (WpTable1 wp : wpTable1) {
            System.out.println(wp.toString());
        }
    }

    @Test
    public void WpTable1FindByIdTest() {
        Optional<WpTable1> wp = this.wpTable1Repository.findById(1);
        Assertions.assertThat(wp).isPresent();
        System.out.println(wp.get());
    }

    @Test
    public void WpTable1UpdateTest() {
        int wpTable1Id = 1;
        String valueUpdate = "nguyennhattruongABC";
        Optional<WpTable1> wp = this.wpTable1Repository.findById(wpTable1Id);
        Assertions.assertThat(wp).isPresent();
        WpTable1 p = wp.get();
        p.setFullname(valueUpdate);
        this.wpTable1Repository.save(p);
        System.out.println("Saved");
        Optional<WpTable1> wpUpdate = this.wpTable1Repository.findById(wpTable1Id);
        Assertions.assertThat(wpUpdate).isPresent();
        Assertions.assertThat(wpUpdate.get().getFullname()).isEqualTo(valueUpdate);
        System.out.println(wpUpdate.get());
        System.out.println("Update finished");
    }

    @Test
    public void WpTable1DeleteTest() {
        int wpTable1Id = 3;
        this.wpTable1Repository.deleteById(wpTable1Id);
        Optional<WpTable1> p = this.wpTable1Repository.findById(wpTable1Id);
        Assertions.assertThat(p).isNotPresent();
        System.out.println("Deleted");
    }
}
