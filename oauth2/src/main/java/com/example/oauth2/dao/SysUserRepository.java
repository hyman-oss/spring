package com.example.oauth2.dao;

import com.example.oauth2.entity.SysUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Hua-cloud
 */
@Repository
public interface SysUserRepository extends CrudRepository<SysUser,Integer> {

    /**
     * getUserByName
     * @param name
     * @return
     */
    @Query("select a from SysUser a where a.name=:name")
    SysUser getUserByName(@Param("name") String name);
}