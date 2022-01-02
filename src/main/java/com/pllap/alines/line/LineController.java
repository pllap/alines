/*
 * Author : Hyeokwoo Kwon
 * Filename : LineController.java
 * Desc :
 */

package com.pllap.alines.line;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("line")
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping
    public LineDto createLine(@RequestBody LineContent lineContent) {
        return lineService.save(lineContent.get())
                .map(LineDto::new)
                .orElseThrow(() -> new RuntimeException(""));
    }
}
