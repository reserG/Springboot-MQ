package com.mq.rabbitmq;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyMessage {
//	private MiaoshaUser user;
//	private long goodsId;
//	public MiaoshaUser getUser() {
//		return user;
//	}
//	public void setUser(MiaoshaUser user) {
//		this.user = user;
//	}
//	public long getGoodsId() {
//		return goodsId;
//	}
//	public void setGoodsId(long goodsId) {
//		this.goodsId = goodsId;
//	}

	public MyMessage(String msg) {
		this.msg = msg;
	}

	private String msg;
}
