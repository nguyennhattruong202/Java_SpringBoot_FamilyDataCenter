package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.model.WpTable1;
import com.nnt.fdcweb.repository.WpTable1Repository;
import com.nnt.fdcweb.services.WpTable1Service;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class WpTable1ServiceImplement implements WpTable1Service {

    @Autowired
    private WpTable1Repository wpTable1Repository;

    @Override
    public Iterable<WpTable1> findAll() {
        return this.wpTable1Repository.findAll();
    }

    @Override
    public WpTable1 findById(Integer id) {
        Optional<WpTable1> wpTable1Otp = this.wpTable1Repository.findById(id);
        return wpTable1Otp.get();
    }

    @Override
    public void insert(WpTable1 wpTable1) {
        wpTable1.setCreatedDate(LocalDateTime.now());
        wpTable1.setUpdatedDate(LocalDateTime.now());
        this.wpTable1Repository.save(wpTable1);
    }

    @Override
    public void update(WpTable1 wpTable1) {
        wpTable1.setUpdatedDate(LocalDateTime.now());
        this.wpTable1Repository.save(wpTable1);
    }

    @Override
    public void deleteById(Integer Id) {
        this.wpTable1Repository.deleteById(Id);
    }

    @Override
    public List<WpTable1> findByFullname(String fullname) {
        return this.wpTable1Repository.findByFullname(fullname);
    }
}
