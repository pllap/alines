/*
 * Author : Hyeokwoo Kwon
 * Filename : LineService.java
 * Desc :
 */

package com.pllap.alines.line;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LineService {

    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Transactional
    public Line createLine(String content) {
        Line line = Line.builder()
                .content(content)
                .createdDateTime(LocalDateTime.now())
                .updatedDateTime(LocalDateTime.now())
                .build();
        return lineRepository.save(line);
    }

    @Transactional
    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    @Transactional
    public Line updateLine(String hash, String content) {
        Line line = lineRepository.findByHash(hash).orElseThrow();
        line.setContent(content);
        line.setUpdatedDateTime(LocalDateTime.now());
        return lineRepository.save(line);
    }

    @Transactional
    public void deleteLine(String hash) {
        Line line = lineRepository.findByHash(hash).orElseThrow(); //TODO: throw and handle exception
        lineRepository.delete(line);
    }
}
