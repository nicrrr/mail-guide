package yougo.entity.po;

public class UcsUserPO {
    /**
     * 用户id
     */
    private String id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 
     */
    private String phoneNo;

    /**
     * 0:女,1:男
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 地址信息，用于定位服务
     */
    private String address;

    /**
     * 会员等级：00普通用户，01普通会员，02超级会员
     */
    private String grade;

    /**
     * 00消费者01商家
     */
    private String type;

    /**
     * 
     */
    private String idCardType;

    /**
     * 用户id
     * @return id 用户id
     */
    public String getId() {
        return id;
    }

    /**
     * 用户id
     * @param id 用户id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户姓名
     * @return name 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 用户姓名
     * @param name 用户姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return phone_no 
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 
     * @param phoneNo 
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    /**
     * 0:女,1:男
     * @return sex 0:女,1:男
     */
    public String getSex() {
        return sex;
    }

    /**
     * 0:女,1:男
     * @param sex 0:女,1:男
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    /**
     * 地址信息，用于定位服务
     * @return address 地址信息，用于定位服务
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址信息，用于定位服务
     * @param address 地址信息，用于定位服务
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 会员等级：00普通用户，01普通会员，02超级会员
     * @return grade 会员等级：00普通用户，01普通会员，02超级会员
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 会员等级：00普通用户，01普通会员，02超级会员
     * @param grade 会员等级：00普通用户，01普通会员，02超级会员
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    /**
     * 00消费者01商家
     * @return type 00消费者01商家
     */
    public String getType() {
        return type;
    }

    /**
     * 00消费者01商家
     * @param type 00消费者01商家
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 
     * @return id_card_type 
     */
    public String getIdCardType() {
        return idCardType;
    }

    /**
     * 
     * @param idCardType 
     */
    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType == null ? null : idCardType.trim();
    }
}