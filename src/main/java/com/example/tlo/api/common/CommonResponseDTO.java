package com.example.tlo.api.common;

import com.example.tlo.config.logging.filter.TloHttpLoggingFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponseDTO {
    /**
     * 이 resultCode는 {@link TloHttpLoggingFilter#responseBodyLogging} 에서 TLO 로그의 RESULT_CODE 부분을 세팅할 때 사용하는 값이다.
     */
    private String resultCode;
}
