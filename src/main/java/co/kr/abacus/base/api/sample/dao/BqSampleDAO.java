package co.kr.abacus.base.api.sample.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BqSampleDAO {

    List<Object> getSampleDataList();

}
