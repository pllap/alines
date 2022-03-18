package com.pllap.alines.line;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LineRepository extends JpaRepository<Line, Long> {

    @Override
    <S extends Line> S save(S entity);

    @Override
    List<Line> findAll();

    Optional<Line> findByHash(String hash);

    @Override
    void delete(Line entity);
}
