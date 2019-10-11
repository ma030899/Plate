package cn.test.mapper;

import java.util.List;

import cn.test.entity.Record;

public interface RecordMapper {
	List<Record> showcolor();
	/**
	 * 
	 * @param coloRecord 所有颜色
	 */
	void insertRecord(Record coloRecord);
}
