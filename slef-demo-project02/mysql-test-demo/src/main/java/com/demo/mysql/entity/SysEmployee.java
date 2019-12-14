package com.demo.mysql.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author wq
 * @since 2019-11-15
 */
@TableName("sys_employee")
public class SysEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 添加时间
     */
    @TableField(value = "addTime", fill = FieldFill.INSERT)
    private Date addTime;
    /**
     * 添加人
     */
    @TableField(value = "addEmployee", fill = FieldFill.INSERT)
    private Long addEmployee;
    /**
     * 最后修改时间
     */
    @TableField(value = "lastModifyTime", fill = FieldFill.UPDATE)
    private Date lastModifyTime;
    /**
     * 最后修改人
     */
    @TableField(value = "lastModifyEmployee", fill = FieldFill.UPDATE)
    private Long lastModifyEmployee;
    /**
     * 状态(1-删除，0-正常)
     */
    @TableField(value = "isDelete", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDelete;
    /**
     * 备注
     */
    private String remark;
    /**
     * 编码
     */
    private String code;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 用户名
     */
    private String account;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 密码盐
     */
    private String salt;
    /**
     * 姓名
     */
    @TableField("realName")
    private String realName;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 工号
     */
    @TableField("cardId")
    private String cardId;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 手机号码
     */
    @TableField("phoneNum")
    private String phoneNum;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * QQ号码
     */
    private String qq;
    /**
     * 登录时间
     */
    @TableField("loginTime")
    private Date loginTime;
    /**
     * 上次登录时间
     */
    @TableField("lastLoginTime")
    private Date lastLoginTime;
    /**
     * 登录次数
     */
    @TableField("loginCount")
    private Integer loginCount;
    /**
     * 所属单位ID
     */
    @TableField("unitId")
    private Long unitId;
    /**
     * 直接上级部门ID
     */
    @TableField("directDeptId")
    private Long directDeptId;
    /**
     * 主要部门ID
     */
    @TableField("majorDeptId")
    private Long majorDeptId;
    /**
     * 头像
     */
    @TableField("userHead")
    private String userHead;
    /**
     * 租户ID
     */

    @TableField(value = "tenantId", fill = FieldFill.INSERT)
    private String tenantId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getAddEmployee() {
        return addEmployee;
    }

    public void setAddEmployee(Long addEmployee) {
        this.addEmployee = addEmployee;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getLastModifyEmployee() {
        return lastModifyEmployee;
    }

    public void setLastModifyEmployee(Long lastModifyEmployee) {
        this.lastModifyEmployee = lastModifyEmployee;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getDirectDeptId() {
        return directDeptId;
    }

    public void setDirectDeptId(Long directDeptId) {
        this.directDeptId = directDeptId;
    }

    public Long getMajorDeptId() {
        return majorDeptId;
    }

    public void setMajorDeptId(Long majorDeptId) {
        this.majorDeptId = majorDeptId;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "SysEmployee{" +
        ", id=" + id +
        ", addTime=" + addTime +
        ", addEmployee=" + addEmployee +
        ", lastModifyTime=" + lastModifyTime +
        ", lastModifyEmployee=" + lastModifyEmployee +
        ", isDelete=" + isDelete +
        ", remark=" + remark +
        ", code=" + code +
        ", sort=" + sort +
        ", account=" + account +
        ", password=" + password +
        ", salt=" + salt +
        ", realName=" + realName +
        ", sex=" + sex +
        ", cardId=" + cardId +
        ", tel=" + tel +
        ", phoneNum=" + phoneNum +
        ", email=" + email +
        ", qq=" + qq +
        ", loginTime=" + loginTime +
        ", lastLoginTime=" + lastLoginTime +
        ", loginCount=" + loginCount +
        ", unitId=" + unitId +
        ", directDeptId=" + directDeptId +
        ", majorDeptId=" + majorDeptId +
        ", userHead=" + userHead +
        ", tenantId=" + tenantId +
        "}";
    }
}
