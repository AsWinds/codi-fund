package com.codi.bus.core.sys.test.mock;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.codi.base.api.result.PageResult;
import com.codi.base.domain.BaseResult;
import com.codi.bus.core.sys.vo.SysNewsVo;

public class MockSysNewsTest {
	
	SysNewsVo vo1(){
		SysNewsVo vo = new SysNewsVo();
		vo.setId(1l);
		vo.setContent("这是征文");
		vo.setSource("腾讯证券");
		vo.setFromUrl("http://baidu.com");
		vo.setKeyword("老虎 QFII");
		vo.setLocation("PC");
		vo.setModifyDate(new Date());
		vo.setPublishDate(new Date());
		vo.setPublisher("admin");
		vo.setStatus("上线");
		vo.setTitle("这是标题");
		return vo;
	}
	
	@Test
	public void testPageResult(){
		Pageable pageReq = new PageRequest(0, 10);
		JsonUtils.prettyJson(new PageResult<>(new PageImpl<>(Arrays.asList(vo1()), pageReq, 1)));
	}
	
	@Test
	public void testCreateUpdate(){
		JsonUtils.prettyJson(new BaseResult(vo1()));
	}
	
	@Test
	public void testDelete(){
		JsonUtils.prettyJson(new BaseResult(1));
	}

}
