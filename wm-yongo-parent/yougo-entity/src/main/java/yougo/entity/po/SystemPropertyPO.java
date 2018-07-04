package yougo.entity.po;

public class SystemPropertyPO {
    /**
     * key值，唯一索引
     */
    private String sysKey;

    /**
     * 
     */
    private String sysValue;

    /**
     * 
     */
    private String sysName;

    /**
     * 
     */
    private String remark;

    /**
     * key值，唯一索引
     * @return sys_key key值，唯一索引
     */
    public String getSysKey() {
        return sysKey;
    }

    /**
     * key值，唯一索引
     * @param sysKey key值，唯一索引
     */
    public void setSysKey(String sysKey) {
        this.sysKey = sysKey == null ? null : sysKey.trim();
    }

    /**
     * 
     * @return sys_value 
     */
    public String getSysValue() {
        return sysValue;
    }

    /**
     * 
     * @param sysValue 
     */
    public void setSysValue(String sysValue) {
        this.sysValue = sysValue == null ? null : sysValue.trim();
    }

    /**
     * 
     * @return sys_name 
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * 
     * @param sysName 
     */
    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}