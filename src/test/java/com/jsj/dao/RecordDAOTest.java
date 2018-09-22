package com.jsj.dao;

import com.jsj.pojo.entity.RecordPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordDAOTest {
    @Resource
    private RecordPoMapper recordPoMapper;

    @Test
    public void testAdd()throws Exception{
        UUID userId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        RecordPO recordPO = new RecordPO(null, userId.toString(), productId.toString(), 1, new Date());
        recordPoMapper.addRecord(recordPO);
    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testUpdate(){

    }

    @Test
    public void testSearchByPrimaryId()throws Exception{
        int id = 1;
        RecordPO recordPO = recordPoMapper.getRecordById(id);
    }

    @Test
    public void testSearch()throws Exception{
        List<RecordPO> recordPOList = recordPoMapper.getAllRecords(0,1000);
        recordPOList.forEach(System.out::println);
    }
}
