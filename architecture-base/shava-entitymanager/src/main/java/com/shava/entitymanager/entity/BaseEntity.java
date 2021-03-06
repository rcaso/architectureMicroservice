/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shava.entitymanager.entity;

import com.shava.entitymanager.listener.AuditListener;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * <ul>
 * <li>Copyright 2017  Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class Factura.
 *
 * @author raul
 * @version 1.0 , 09/07/2017
 * 
 * columns required in tables are
 * 
 * created_date
 * updated_date
 * created_by
 * updated_by
 */
@MappedSuperclass
@EntityListeners(AuditListener.class)
public abstract class BaseEntity<T> {
    
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
    
    @Column(name = "created_by")
    private T createdBy;
    
    @Column(name = "updated_by")
    private T updatedBy;

    /**
     * @return the createdDate
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the updatedDate
     */
    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate the updatedDate to set
     */
    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * @return the createdBy
     */
    public T getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(T createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the updatedBy
     */
    public T getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(T updatedBy) {
        this.updatedBy = updatedBy;
    }
    
}
