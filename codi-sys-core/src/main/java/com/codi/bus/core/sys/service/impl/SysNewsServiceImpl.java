package com.codi.bus.core.sys.service.impl;

import com.codi.bus.core.sys.dao.SysNewsDao;
import com.codi.bus.core.sys.domain.SysNews;
import com.codi.bus.core.sys.service.SysNewsService;
import com.codi.bus.core.sys.vo.SysNewsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;

@Service
public class SysNewsServiceImpl implements SysNewsService {

	@Autowired
	private SysNewsDao snDao;

	public static Converter<SysNews, SysNewsVo> do2vo = new Converter<SysNews, SysNewsVo>() {

		@Override
		public SysNewsVo convert(SysNews source) {
			SysNewsVo vo = new SysNewsVo();
			BeanUtils.copyProperties(source, vo);
			return vo;
		}
	};

	public static Converter<SysNewsVo, SysNews> vo2do = new Converter<SysNewsVo, SysNews>() {

		@Override
		public SysNews convert(SysNewsVo source) {
			SysNews dobj = new SysNews();
			BeanUtils.copyProperties(source, dobj);
			return dobj;
		}
	};

	@Override
	public Page<SysNewsVo> findAll(Pageable pageable) {
		Page<SysNews> page = snDao.findAll(pageable);
		return page.map(do2vo);
	}

	@Override
	public SysNewsVo createSysNews(SysNewsVo vo) {
		Assert.isNull(vo.getId());
		SysNews news = new SysNews();
		BeanUtils.copyProperties(vo, news);
		news.setModifyDate(new Date());
		snDao.insert(news);
		SysNewsVo res = new SysNewsVo();
		BeanUtils.copyProperties(news, res);
		return res;
	}

	@Override
	public SysNewsVo updateSysNews(SysNewsVo vo) {
		Assert.notNull(vo.getId());
		SysNews news = new SysNews();
		BeanUtils.copyProperties(vo, news);
		news.setModifyDate(new Date());
		snDao.updateByPrimaryKeyWithBLOBs(news);
		SysNewsVo res = new SysNewsVo();
		BeanUtils.copyProperties(news, res);
		return res;
	}

	@Override
	public int delete(Long id) {
		return snDao.deleteByPrimaryKey(id);
	}

	@Override
	public Page<SysNewsVo> search(String keyword, Pageable pageable) {
		Page<SysNews> res = snDao.search(keyword, pageable);
		return res.map(do2vo);
	}

	@Override
	public Page<SysNewsVo> listNews(String location, String status, Pageable pageable) {
		Page<SysNews> page = snDao.listSysNews(location, status, pageable);
		return page.map(do2vo);
	}

    /**
     * 根据资讯ID取得资讯详情
     *
     * @param id
     * @return
     */
    @Override
    public SysNewsVo getNewsById(Long id) {
        SysNewsVo newsVo = new SysNewsVo();
        SysNews news = snDao.selectByPrimaryKey(id);
        if (news == null) {
            return null;
        }
        BeanUtils.copyProperties(news, newsVo);
        return newsVo;
    }


}
