package com.jsj.api.dao;

import com.alibaba.dubbo.config.annotation.Service;
import com.jsj.api.entity.UserDO;
import com.jsj.api.exception.DAOException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jiangshenjie
 * @date 2018-9-13
 */
public interface UserMapper {

    boolean addUser(UserDO userDO) throws DAOException;

    UserDO getUserByPrimaryId(Long id)throws DAOException;

    List<UserDO> searchUsers(Map<String, Object> params)throws DAOException;
}
