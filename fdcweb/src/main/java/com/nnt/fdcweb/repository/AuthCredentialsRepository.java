package com.nnt.fdcweb.repository;

import com.nnt.fdcweb.entity.AuthCredentials;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthCredentialsRepository extends JpaRepository<AuthCredentials, Long> {

    Optional<AuthCredentials> findByPhone(String phone);
}
