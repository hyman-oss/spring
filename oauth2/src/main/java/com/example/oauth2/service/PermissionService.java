package com.example.oauth2.service;

import com.example.oauth2.entity.Permission;

import java.util.List;

/**
 * @author Hua-cloud
 */
public interface PermissionService {
    /**
     * findAll
     * @return
     */
     List<Permission> findAll();

    /**
     * findByAdminUserId
     * @param userId
     * @return
     */
     List<Permission> findByAdminUserId(int userId);
}
