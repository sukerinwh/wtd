/**
 * Copyright (c) 2005-2012  
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.wtd.es.showcase.parentchild.repository;

import com.wtd.es.common.repository.BaseRepository;
import com.wtd.es.showcase.parentchild.entity.Child;
import com.wtd.es.showcase.parentchild.entity.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <p>User: Liang Fan
 * <p>Date: 13-2-4 下午3:00
 * <p>Version: 1.0
 */
public interface ChildRepository extends BaseRepository<Child, Long> {

    @Query(value = "select o from Child o where o.parent=?1")
    Page<Child> findByParent(Parent parent, Pageable pageable);


    @Query(value = "select o from Child o where o.parent in(?1)")
    Page<Child> findByParents(List<Parent> parents, Pageable pageable);


    @Modifying
    @Query(value = "delete from Child where parent = ?1")
    void deleteByParent(Parent parent);
}
