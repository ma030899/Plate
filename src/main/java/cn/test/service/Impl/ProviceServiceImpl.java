package cn.test.service.Impl;


import java.util.List;

import javax.annotation.Resource;

import org.easypr.FastJsonUtil;
import org.easypr.ProviceUtil;
import org.springframework.stereotype.Service;

import cn.test.entity.Provice;
import cn.test.mapper.ProviceMapper;
import cn.test.service.ProviceService;
@Service("proviceService")
public class ProviceServiceImpl implements ProviceService {
	@Resource
	private ProviceMapper proviceMapper;

	public List<Provice> showProvices() {
		// TODO Auto-generated method stub
		return proviceMapper.showProvices();
	}

	public void insertRecord(Provice provice) {
		provice.setProvice_id(null);
		if(provice.getName()==null) {
			provice.setName("MLY");
		}
		ProviceUtil.JSCount(FastJsonUtil.allCarNum, "苏");
		provice.setJiangsu(ProviceUtil.JSCount);
		ProviceUtil.BJCount(FastJsonUtil.allCarNum, "京");
		provice.setBeijing(ProviceUtil.BJCount);
		ProviceUtil.SHCount(FastJsonUtil.allCarNum, "沪");
		provice.setShanghai(ProviceUtil.SHCount);
		ProviceUtil.GDCount(FastJsonUtil.allCarNum,"粤");
		provice.setGuangdong(ProviceUtil.GDCount);
		
		proviceMapper.insertRecord(provice);
		
	}

}
