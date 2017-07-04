/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shava.entitymanager.listener;

import com.shava.common.audit.RegistryContextHolder;
import com.shava.common.audit.entity.UserTrack;
import com.shava.common.contextholder.ThreadLocalContextHolder;
import com.shava.entitymanager.entity.BaseEntity;
import java.time.LocalDateTime;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * <ul>
 * <li>Copyright 2017  Shava. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class AuditListener.
 *
 * @author raul
 * @version 1.0 , 04/07/2017
 */

public class AuditListener {
    
    @PrePersist
    public void onCreated(BaseEntity baseEntity){
        baseEntity.setCreatedDate(LocalDateTime.now());
        UserTrack userTrack = (UserTrack)ThreadLocalContextHolder.get(RegistryContextHolder.USER_TRACK);
        baseEntity.setCreatedBy(userTrack.getUserName());
    }
    
    @PreUpdate
    public void onChanged(BaseEntity baseEntity){
        baseEntity.setUpdatedDate(LocalDateTime.now());
        UserTrack userTrack = (UserTrack)ThreadLocalContextHolder.get(RegistryContextHolder.USER_TRACK);
        baseEntity.setUpdatedBy(userTrack.getUserName());
    }

}
