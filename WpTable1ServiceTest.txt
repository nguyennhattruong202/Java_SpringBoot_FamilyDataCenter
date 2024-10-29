package com.nnt.fdcweb;

import com.nnt.fdcweb.model.WpTable1;
import com.nnt.fdcweb.services.WpTable1Service;
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
public class WpTable1ServiceTest {

    @Autowired
    private WpTable1Service wpTable1Service;

    @Test
    public void findAllTest() {
        Iterable<WpTable1> wp = this.wpTable1Service.findAll();
        Assertions.assertThat(wp).hasSizeGreaterThan(0);
        for (WpTable1 wpfor : wp) {
            System.out.println(wpfor);
        }
    }

    @Test
    public void findByIdTest() throws Exception {
        Integer wpTable1Id = 1;
        WpTable1 wpTable1 = this.wpTable1Service.findById(wpTable1Id);
        Assertions.assertThat(wpTable1).isNotNull();
        Assertions.assertThat(wpTable1.getId()).isEqualTo(wpTable1Id);
        System.out.println(wpTable1);
    }

    @Test
    public void deleteByIdTest() {
        try {
            Integer id = 28;
            this.wpTable1Service.deleteById(id);
            System.out.println("Delete compeleted id: " + id);
        } catch (Exception e) {
            System.out.println("An exception occurred during delete: " + e.getMessage());
        }
    }

    @Test
    public void updateTest() {
        Integer id = 5;
        String fullname = "ok";
        WpTable1 wpTable1 = this.wpTable1Service.findById(id);
        wpTable1.setFullname(fullname);
        this.wpTable1Service.update(wpTable1);
        WpTable1 wpTableCheck = this.wpTable1Service.findById(id);
        Assertions.assertThat(wpTableCheck.getFullname()).isEqualTo(fullname);
        System.out.println(wpTableCheck);
    }
}
