package com.jsj.service.impl;

import com.jsj.dao.UserPoMapper;
import com.jsj.entity.UserPO;
import com.jsj.exception.DAOException;
import com.jsj.exception.ServiceException;
import com.jsj.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;


@Service
@Alias("userService")
/**
 * @author jiangshenjie
 * @date 2018-9-15
 */
public class UserServiceImpl implements UserService {
    @Resource
    private UserPoMapper userPoMapper;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public UserPO searchUserById(String id) throws ServiceException {
        if (StringUtils.isEmpty(id)) {
            throw new ServiceException("id不能为空");
        }
        try {
            return userPoMapper.getUserById(id);
        } catch (DAOException d) {
            throw new ServiceException("由DAOException导致");
        }
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public boolean addUser(String userName, String phone) throws ServiceException {
        if (StringUtils.isEmpty(userName)) {
            throw new ServiceException("name不能为空");
        }
        if (StringUtils.isEmpty(phone)) {
            throw new ServiceException("phone不能为空");
        }
        String userId = UUID.randomUUID().toString();
        UserPO userPO = new UserPO(userId, userName, phone, new Date());
        try {
            return userPoMapper.addUser(userPO);
        } catch (DAOException d) {
            throw new ServiceException("由DAOException导致");
        }
    }
}
