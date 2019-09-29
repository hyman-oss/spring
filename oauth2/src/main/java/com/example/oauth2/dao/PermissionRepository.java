package com.example.oauth2.dao;

import com.example.oauth2.entity.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hua-cloud
 */
@Repository
public interface PermissionRepository extends CrudRepository<Permission,Integer> {
 
}
 

