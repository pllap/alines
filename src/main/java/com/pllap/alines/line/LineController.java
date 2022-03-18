package com.pllap.alines.line;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("line")
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping
    public LineDto createLine(@RequestBody LineContent lineContent) {
        return new LineDto(
                lineService.createLine(lineContent.getContent())
        );
    }

    @GetMapping
    public List<LineDto> findAllLines() {
        return lineService.findAll()
                .stream()
                .map(LineDto::new)
                .collect(Collectors.toList());
    }

    @PutMapping
    public LineDto updateLine(@RequestBody LineContent lineContent) {
        return new LineDto(
                lineService.updateLine(
                        lineContent.getHash(),
                        lineContent.getContent())
        );
    }

    @DeleteMapping
    public boolean deleteLine(@RequestBody LineContent lineContent) {
        lineService.deleteLine(lineContent.getHash());
        return true;
    }
}
