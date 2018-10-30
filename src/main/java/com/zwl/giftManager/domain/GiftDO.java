package com.zwl.giftManager.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-30 16:11:40
 */
public class GiftDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//主标题
	private String giftMainTitle;
	//副标题
	private String giftViceTitle;
	//购买最低要求
	private Integer minRequirement;
	//产品主图
	private String giftMainImg;
	//产品附图1
	private String giftViceImg1;
	//产品附图2
	private String giftViceImg2;
	//产品附图3
	private String giftViceImg3;
	//价格
	private Integer price;
	//快递费
	private Integer expressFee;
	//库存
	private Integer stock;
	//
	private String giftDesc;
	//是否推荐，0不推荐，1推荐
	private String isRecommend;
	//是否展示，0不展示，1展示
	private String isShow;
	//
	private Date createTime;
	//
	private Date modifyTime;
	//
	private Integer available;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：主标题
	 */
	public void setGiftMainTitle(String giftMainTitle) {
		this.giftMainTitle = giftMainTitle;
	}
	/**
	 * 获取：主标题
	 */
	public String getGiftMainTitle() {
		return giftMainTitle;
	}
	/**
	 * 设置：副标题
	 */
	public void setGiftViceTitle(String giftViceTitle) {
		this.giftViceTitle = giftViceTitle;
	}
	/**
	 * 获取：副标题
	 */
	public String getGiftViceTitle() {
		return giftViceTitle;
	}
	/**
	 * 设置：购买最低要求
	 */
	public void setMinRequirement(Integer minRequirement) {
		this.minRequirement = minRequirement;
	}
	/**
	 * 获取：购买最低要求
	 */
	public Integer getMinRequirement() {
		return minRequirement;
	}
	/**
	 * 设置：产品主图
	 */
	public void setGiftMainImg(String giftMainImg) {
		this.giftMainImg = giftMainImg;
	}
	/**
	 * 获取：产品主图
	 */
	public String getGiftMainImg() {
		return giftMainImg;
	}
	/**
	 * 设置：产品附图1
	 */
	public void setGiftViceImg1(String giftViceImg1) {
		this.giftViceImg1 = giftViceImg1;
	}
	/**
	 * 获取：产品附图1
	 */
	public String getGiftViceImg1() {
		return giftViceImg1;
	}
	/**
	 * 设置：产品附图2
	 */
	public void setGiftViceImg2(String giftViceImg2) {
		this.giftViceImg2 = giftViceImg2;
	}
	/**
	 * 获取：产品附图2
	 */
	public String getGiftViceImg2() {
		return giftViceImg2;
	}
	/**
	 * 设置：产品附图3
	 */
	public void setGiftViceImg3(String giftViceImg3) {
		this.giftViceImg3 = giftViceImg3;
	}
	/**
	 * 获取：产品附图3
	 */
	public String getGiftViceImg3() {
		return giftViceImg3;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * 设置：快递费
	 */
	public void setExpressFee(Integer expressFee) {
		this.expressFee = expressFee;
	}
	/**
	 * 获取：快递费
	 */
	public Integer getExpressFee() {
		return expressFee;
	}
	/**
	 * 设置：库存
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	/**
	 * 获取：库存
	 */
	public Integer getStock() {
		return stock;
	}
	/**
	 * 设置：
	 */
	public void setGiftDesc(String giftDesc) {
		this.giftDesc = giftDesc;
	}
	/**
	 * 获取：
	 */
	public String getGiftDesc() {
		return giftDesc;
	}
	/**
	 * 设置：是否推荐，0不推荐，1推荐
	 */
	public void setIsRecommend(String isRecommend) {
		this.isRecommend = isRecommend;
	}
	/**
	 * 获取：是否推荐，0不推荐，1推荐
	 */
	public String getIsRecommend() {
		return isRecommend;
	}
	/**
	 * 设置：是否展示，0不展示，1展示
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否展示，0不展示，1展示
	 */
	public String getIsShow() {
		return isShow;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：
	 */
	public void setAvailable(Integer available) {
		this.available = available;
	}
	/**
	 * 获取：
	 */
	public Integer getAvailable() {
		return available;
	}
}
