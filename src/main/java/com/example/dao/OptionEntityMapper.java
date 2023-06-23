package com.example.dao;

import com.example.dao.entity.OptionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OptionEntityMapper {
    List<OptionEntity> queryOptionList(OptionEntity optionEntity);
    int insert(OptionEntity optionEntity);
    int updateByPrimaryKeySelective(OptionEntity optionEntity);
    int deleteOptionById(OptionEntity optionEntity);
}
