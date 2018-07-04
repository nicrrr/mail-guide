package yougo.core.mapper;

import org.apache.ibatis.annotations.Mapper;

import yougo.core.entity.SystemPropertyPO;

public interface SystemPropertyMapper {
    /**
     *
     * @mbg.generated 2018-06-22
     */
    int insert(SystemPropertyPO record);

    /**
     *
     * @mbg.generated 2018-06-22
     */
    int insertSelective(SystemPropertyPO record);
    
    SystemPropertyPO queryByKey(SystemPropertyPO record);
}