package co.kr.abacus.base.api.sample.controller;

import co.kr.abacus.base.api.common.CommonResponseDTO;
import co.kr.abacus.base.api.sample.dao.BqSampleDAO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@Tag(name = "1. Sample", description = "tloSample")
@RequiredArgsConstructor
public class BqSampleController {

    private final BqSampleDAO bqSampleDAO;

    public CommonResponseDTO getTaSampleData() {
        List<Object> dList = bqSampleDAO.getSampleDataList();
        log.info(dList.toString());
        return new CommonResponseDTO("20000000");
    }
}
