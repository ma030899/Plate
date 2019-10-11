package cn.test.service;

import java.util.List;

import cn.test.entity.Record;

public interface RecordService {
	List<Record> showcolor();
	void insert(Record coloRecord);
}
