package yougo.user.dao;

import yougo.entity.po.UcsUserPO;

public interface UcsUserMapper {
    /**
     *
     * @mbg.generated 2018-06-04
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-04
     */
    int insert(UcsUserPO record);

    /**
     *
     * @mbg.generated 2018-06-04
     */
    int insertSelective(UcsUserPO record);

    /**
     *
     * @mbg.generated 2018-06-04
     */
    UcsUserPO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-04
     */
    int updateByPrimaryKeySelective(UcsUserPO record);

    /**
     *
     * @mbg.generated 2018-06-04
     */
    int updateByPrimaryKey(UcsUserPO record);
}