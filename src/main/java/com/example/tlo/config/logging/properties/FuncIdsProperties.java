package com.example.tlo.config.logging.properties;

import com.example.tlo.config.logging.vo.FuncIdVO;
import lombok.Data;

import java.util.List;

@Data
public class FuncIdsProperties {
    private List<FuncIdVO> permitAllFuncIds;
}
