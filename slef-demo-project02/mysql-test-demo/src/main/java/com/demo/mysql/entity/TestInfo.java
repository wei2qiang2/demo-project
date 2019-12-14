package com.demo.mysql.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wq
 * @since 2019-11-15
 */
@TableName("test_info")
public class TestInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 测试名称
     */
    @TableField("testName")
    private String testName;
    /**
     * 测试类型
     */
    @TableField("testType")
    private String testType;
    /**
     * 消耗时间
     */
    @TableField("useTime")
    private Long useTime;
    /**
     * 开始时间
     */
    @TableField("startTime")
    private Date startTime;
    /**
     * 结束时间
     */
    @TableField("endTime")
    private Date endTime;

    public TestInfo() {
    }

    public static TestInfo getInstance(String testName, String testType, Long useTime, Date startTime, Date endTime) {
        TestInfo testInfo = new TestInfo();
        testInfo.testName = testName;
        testInfo.testType = testType;
        testInfo.useTime = useTime;
        testInfo.startTime = startTime;
        testInfo.endTime = endTime;

        return testInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public Long getUseTime() {
        return useTime;
    }

    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "TestInfo{" +
        ", id=" + id +
        ", testName=" + testName +
        ", testType=" + testType +
        ", useTime=" + useTime +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        "}";
    }
}
