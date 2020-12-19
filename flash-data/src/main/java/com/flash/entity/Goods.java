package com.flash.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * SPU表
 * </p>
 *
 * @author weiqiang
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    private String goodsId;

    /**
     * 销售类别(0:批发,1:零售)
     */
    private Boolean saleType;

    /**
     * 商品分类Id
     */
    private Long cateId;

    /**
     * 品牌Id
     */
    private Long brandId;

    /**
     * 商品标题
     */
    private String goodsName;

    /**
     * 商品副标题
     */
    private String goodsSubtitle;

    /**
     * SPU编码
     */
    private String goodsNo;

    /**
     * 内部SPU编码
     */
    private String innerGoodsNo;

    /**
     * 计量单位
     */
    private String goodsUnit;

    /**
     * 商品种类名称
     */
    private String goodsCateName;

    /**
     * 商品主图片
     */
    private String goodsImg;

    /**
     * 商品视频
     */
    private String goodsVideo;

    /**
     * 商品重量
     */
    private BigDecimal goodsWeight;

    /**
     * 商品体积
     */
    private BigDecimal goodsCubage;

    /**
     * 单品运费模板id
     */
    private Long freightTempId;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 供货价
     */
    private BigDecimal supplyPrice;

    /**
     * 建议零售价
     */
    private BigDecimal retailPrice;

    /**
     * 商品类型，0：实体商品，1：虚拟商品
     */
    private Boolean goodsType;

    /**
     * 划线价
     */
    private BigDecimal linePrice;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 上下架时间
     */
    private LocalDateTime addedTime;

    /**
     * 商品来源，0供应商，1商家
     */
    private Integer goodsSource;

    /**
     * 删除标识,0:未删除1:已删除
     */
    private Integer delFlag;

    /**
     * 上下架状态,0:下架1:上架2:部分上架
     */
    private Integer addedFlag;

    /**
     * 规格类型,0:单规格1:多规格
     */
    private Integer moreSpecFlag;

    /**
     * 设价类型,0:按客户1:按订货量2:按市场价
     */
    private Integer priceType;

    /**
     * 订货量设价时,是否允许sku独立设阶梯价(0:不允许,1:允许)
     */
    private Boolean allowPriceSet;

    /**
     * 按客户单独定价,0:否1:是
     */
    private Integer customFlag;

    /**
     * 叠加客户等级折扣，0:否1:是
     */
    private Integer levelDiscountFlag;

    /**
     * 店铺标识
     */
    private Long storeId;

    /**
     * 商品门类名称
     */
    private String cateName;

    /**
     * 公司信息ID
     */
    private Long companyInfoId;

    /**
     * 商家名称
     */
    private String supplierName;

    /**
     * 提交审核时间
     */
    private LocalDateTime submitTime;

    /**
     * 审核状态,0:未审核1 审核通过2审核失败3禁用中
     */
    private Integer auditStatus;

    /**
     * 审核原因
     */
    private String auditReason;

    /**
     * 商品详情
     */
    private String goodsDetail;

    /**
     * 商品描述
     */
    private String goodsDescription;

    /**
     * 商品描述详情
     */
    private String goodsDescriptionDetails;

    /**
     * 移动端图文详情
     */
    private String goodsMobileDetail;

    /**
     * 自营标识
     */
    private Integer companyType;

    /**
     * 商品评论数
     */
    private Long goodsEvaluateNum;

    /**
     * 商品收藏量
     */
    private Long goodsCollectNum;

    /**
     * 商品销量
     */
    private Long goodsSalesNum;

    /**
     * 商品好评数量
     */
    private Long goodsFavorableCommentNum;

    /**
     * 订阅状态 0、否 1、是
     */
    private Integer subscriptionStatus;

    /**
     * 基础规格
     */
    private Long baseSpec;

    /**
     * sku最低订阅价
     */
    private BigDecimal minSubscriptionPrice;

    /**
     * sku最低价格
     */
    private BigDecimal minMarketPrice;

    /**
     * 平均评分
     */
    private BigDecimal avgEvaluateScore;

    /**
     * 是否允许销售0：不允许1：允许
     */
    private Integer saleableFlag;

    /**
     * shop端是否展示0：不展示1：展示
     */
    private Integer displayFlag;

    /**
     * weshare主键id
     */
    private Long weShareId;


}
