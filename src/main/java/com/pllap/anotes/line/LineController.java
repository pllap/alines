/*
 * Author : Hyeokwoo Kwon
 * Filename : LineController.java
 * Desc :
 */

package com.pllap.anotes.line;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("line")
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping
    public LineDto newData(@RequestBody Map<String, String> contentMap) {
        return lineService.save(contentMap.get("content"))
                .map(LineDto::new)
                .orElseThrow(() -> new RuntimeException(""));
    }
}
