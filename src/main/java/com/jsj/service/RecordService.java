package com.jsj.service;

import com.jsj.entity.RecordPO;
import com.jsj.exception.ServiceException;

/**
 * @author jiangshenjie
 * @date 2018-9-15
 */
public interface RecordService {

    /**
     * 发送交易记录到消息队列
     * @param userId
     * @param productId
     * @param state
     * @return
     * @throws ServiceException
     */
    boolean sendRecordToMessageUtil(String userId, String productId, Integer state) throws ServiceException;

    /**
     * 直接新增交易记录
     *
     * @return
     * @throws ServiceException
     */
    boolean addRecord(String userId,String productId,Integer state) throws ServiceException;

    /**
     * 根据id查询交易记录
     * @param id
     * @return
     * @throws ServiceException
     */
    RecordPO searchById(Integer id) throws ServiceException;
}
