package com.codi.bus.core.sys.test.mock;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.codi.base.api.result.PageResult;
import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.vo.SysAfficheVo;

public class MockSysAfficheTest {
	
	SysAfficheVo buildVO1(){
		SysAfficheVo vo = new SysAfficheVo();
		vo.setContent("测试内容");
		vo.setEndTime(new Date(System.currentTimeMillis() + 3600l * 24 * 7));;
		vo.setId(1l);;
		vo.setIsUp(true);
		vo.setLocation("PC");
		vo.setPublisher("admin");
		vo.setPublishTime(new Date());
		vo.setTitle("测试数据有内容");
		return vo;
	}
	
	SysAfficheVo buildVO2(){
		SysAfficheVo vo2 = new SysAfficheVo();
		vo2.setEndTime(new Date(System.currentTimeMillis() + 3600l * 24 * 7));
		vo2.setId(2l);
		vo2.setIsUp(false);
		vo2.setLink("http://baidu.com");
		vo2.setLocation("APP");
		vo2.setPublisher("admin");
		vo2.setPublishTime(new Date());
		vo2.setTitle("测试数据单link");
		return vo2;
	}
	
	@Test
	public void mockSysAfficheData(){
		PageImpl<SysAfficheVo> page = new PageImpl<>(Arrays.asList(buildVO1(), buildVO2()), new PageRequest(0, 2), 2);
		JsonUtils.prettyJson(new PageResult<>(page));
	}
	
	@Test
	public void mockCreateUpdateResult(){
		JsonUtils.prettyJson(new BaseResult(buildVO1()));
	}
}
