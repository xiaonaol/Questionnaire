package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.OptionEntityMapper;
import com.example.dao.entity.OptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionEntityMapper optionEntityMapper;

    public List<OptionEntity> queryOptionList(OptionEntity optionEntity){
        List<OptionEntity> result = optionEntityMapper.queryOptionList(optionEntity);
        return result;
    }

    public int insert(OptionEntity optionEntity){
        optionEntity.setId(UUIDUtil.getOneUUID());
        int result = optionEntityMapper.insert(optionEntity);
        if (result != 0)
            return 3;
        else
            return result;
    }

    public int updateByPrimaryKeySelective(OptionEntity optionEntity){
        int result = optionEntityMapper.updateByPrimaryKeySelective(optionEntity);
        return result;
    }

    public int deleteOptionById(OptionEntity optionEntity){
        int result = optionEntityMapper.deleteOptionById(optionEntity);
        return result;
    }
}
