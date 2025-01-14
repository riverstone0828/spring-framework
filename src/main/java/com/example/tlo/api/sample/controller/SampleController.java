package com.example.tlo.api.sample.controller;

import com.example.tlo.api.common.CommonResponseDTO;
import com.example.tlo.api.sample.dto.SampleDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "1. Sample", description = "tloSample")
@RequiredArgsConstructor
public class SampleController {

    @PostMapping("/set-log-key-header")
    public CommonResponseDTO setLogKeyHeader(
            @RequestHeader("x-logkey") String logKey) {
        return new CommonResponseDTO("20000000");
    }

    @PostMapping("/write-me-tlo")
    public CommonResponseDTO writeMeTlo() {
        return new CommonResponseDTO("20000000");
    }

    @PostMapping("/dont-write-me-tlo")
    public CommonResponseDTO dontWriteMeTlo() {
        return new CommonResponseDTO("20000000");
    }

    @PostMapping("/create-session")
    public CommonResponseDTO createSession(@RequestBody SampleDTO sampleDTO, HttpSession session) {
        String userId = sampleDTO.getUserId();
        session.setAttribute("userId", userId);
        return new CommonResponseDTO("20000000");
    }

    @PostMapping("/result-code-fail")
    public CommonResponseDTO resultCodeFail() {
        return new CommonResponseDTO("40000000");
    }
}
