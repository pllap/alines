/*
 * Author : Hyeokwoo Kwon
 * Filename : LineRepository.java
 * Desc :
 */

package com.pllap.anotes.line;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<Line, Long> {
    @Override
    <S extends Line> S save(S entity);
}
