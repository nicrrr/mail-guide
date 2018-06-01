package yougo.user.dao;

import yougo.entity.po.UserPO;

public interface UserMapper {
    /**
     *
     * @mbg.generated 2018-06-01
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-01
     */
    int insert(UserPO record);

    /**
     *
     * @mbg.generated 2018-06-01
     */
    int insertSelective(UserPO record);

    /**
     *
     * @mbg.generated 2018-06-01
     */
    UserPO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2018-06-01
     */
    int updateByPrimaryKeySelective(UserPO record);

    /**
     *
     * @mbg.generated 2018-06-01
     */
    int updateByPrimaryKey(UserPO record);
}