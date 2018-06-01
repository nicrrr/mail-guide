package yougo.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 
 * description:DAO 基础类
 * @param <T>
 * date: 2018年5月31日 下午2:55:14
 * @author nicr
 */
@Repository
public interface BaseDao<T> {

    /**
     * 
     * @Description: 数据插入
     * @param  t 插入实体对象
     * @return int 返回影响条数
     * @throws Exception
     */

    public int insert(T t) throws Exception;

    /**
     * 
     * @Description: 批量数据插入
     * @param  t 插入集合数据
     * @return int 影响条数
     * @throws Exception
     */

    public int batchInsert(List<T> t) throws Exception;

    /**
     * 
     * @Description: 根据实体跟新数据
     * @param  t 跟新数据
     * @return int 影响条数
     * @throws Exception
     */

    public int update(T t) throws Exception;


    /**
     * 
     * @Description: 根据主键删除数据
     * @param  id 主键
     * @return int 影响条数
     * @throws Exception
     */

    public int delete(Object id) throws Exception;


    /**
     * 
     * @Description: 根据Map对象查询分页集合
     * @param map 条件集合
     * @param List<T> 结果集合
     * @throws Exception
     */

    public List<T> queryListByMap(Map<String, Object> map) throws Exception;


    /**
     * 
     * @Description: 根据主键查询单条数据
     * @param  id 主键
     * @return  T 查询对象结果实体
     * @throws Exception
     */

    public T queryById(Object id) throws Exception;

    /**
     * 
     * @Description: 根据参数查询单条数据
     * @param  t 查询对象条件实体
     * @return List<T> 结果集合
     * @throws Exception
     */

    public List<T> queryListByEntity(T t) throws Exception;

}
