package com.tallerdesarrollo.repository;

import com.tallerdesarrollo.model.RolePrivilegeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePrivilegeRepository extends JpaRepository<RolePrivilegeModel, String> {
}
