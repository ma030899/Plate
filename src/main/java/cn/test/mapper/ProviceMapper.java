package cn.test.mapper;

import java.util.List;

import cn.test.entity.Provice;

public interface ProviceMapper {
	List<Provice> showProvices();
	void insertRecord(Provice provice);
}
