package cn.test.service;

import java.util.List;

import cn.test.entity.Provice;

public interface ProviceService {
	List<Provice> showProvices();
	void insertRecord(Provice provice);
}
