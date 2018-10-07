package com.frank.boot.canal;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.wwjd.starter.canal.annotation.CanalEventListener;
import com.wwjd.starter.canal.annotation.content.DeleteListenPoint;
import com.wwjd.starter.canal.annotation.content.InsertListenPoint;
import com.wwjd.starter.canal.annotation.content.UpdateListenPoint;
import com.wwjd.starter.canal.client.core.CanalMsg;

import java.util.List;

/**
 * 注解监控数据库变动
 */
@CanalEventListener
public class MyAnnoEventListener {

	@InsertListenPoint
	public void onEventInsertData(CanalMsg canalMsg, CanalEntry.RowChange rowChange) {
		List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList();
		for (CanalEntry.RowData rowData : rowDatasList) {
		}
	}

	@UpdateListenPoint
	public void onEventUpdateData(CanalMsg canalMsg, CanalEntry.RowChange rowChange) {
		List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList();
        for (CanalEntry.RowData rowData : rowDatasList) {
        }
	}

	@DeleteListenPoint
	public void onEventDeleteData(CanalEntry.RowChange rowChange, CanalMsg canalMsg) {
//		System.out.println("======================注解方式（删除数据操作）==========================");
	}

}
