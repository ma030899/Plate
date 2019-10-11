package cn.test.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.test.entity.Record;
import cn.test.mapper.RecordMapper;
import cn.test.service.RecordService;

@Service("recordService")
public class RecordServiceImpl implements RecordService {
	@Resource
	private RecordMapper recordMapper;

	public List<Record> showcolor() {
		// TODO Auto-generated method stub
		return recordMapper.showcolor();
	}

	public void insert(Record coloRecord) {
		//Record record=new Record();
		recordMapper.insertRecord(coloRecord);
		
		
	}

}
