/*
 * Author : Hyeokwoo Kwon
 * Filename : LineService.java
 * Desc :
 */

package com.pllap.alines.line;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LineService {
    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Transactional
    public Optional<Line> save(String content) {
        Line line = Line.builder()
                .content(content)
                .createdDateTime(LocalDateTime.now())
                .updatedDateTime(LocalDateTime.now())
                .build();
        Line savedLine = lineRepository.save(line);
        return Optional.of(savedLine);
    }
}
