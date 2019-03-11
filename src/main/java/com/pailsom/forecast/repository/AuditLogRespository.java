package com.pailsom.forecast.repository;

import com.pailsom.forecast.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRespository extends JpaRepository<AuditLog,Long> {
}
