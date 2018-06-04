package yougo.user.dao;

import yougo.entity.po.UcsUser;

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
    int insert(UcsUser record);

    /**
     *
     * @mbg.generated 2018-06-04
     */
    int insertSelective(UcsUser record);

    /**
     *
     * @mbg.generated 2018-06-04
     */
    UcsUser selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-04
     */
    int updateByPrimaryKeySelective(UcsUser record);

    /**
     *
     * @mbg.generated 2018-06-04
     */
    int updateByPrimaryKey(UcsUser record);
}