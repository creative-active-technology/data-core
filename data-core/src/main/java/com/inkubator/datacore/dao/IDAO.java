/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.datacore.dao;

import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @param <T>
 * @since 5 February 2014
 */
public interface IDAO<T> {

    public T getEntiyByPK(String id);

    public T getEntiyByPK(Integer id);

    public T getEntiyByPK(Long id);

    public void save(T entity);

    public void update(T entity);

    public void saveOrUpdate(T enntity);

    public T saveData(T entity);

    public T updateData(T entity);

    public T saveOrUpdateData(T entity);

    public T getEntityByPkIsActive(String id, Integer isActive);

    public T getEntityByPkIsActive(String id, Byte isActive);

    public T getEntityByPkIsActive(String id, Boolean isActive);

    public T getEntityByPkIsActive(Integer id, Integer isActive);

    public T getEntityByPkIsActive(Integer id, Byte isActive);

    public T getEntityByPkIsActive(Integer id, Boolean isActive);

    public T getEntityByPkIsActive(Long id, Integer isActive);

    public T getEntityByPkIsActive(Long id, Byte isActive);

    public T getEntityByPkIsActive(Long id, Boolean isActive);

    public void delete(T entity);

    public void softDelete(T entity);

    public Long getTotalData();

    public Long getTotalDataIsActive(Boolean isActive);

    public Long getTotalDataIsActive(Integer isActive);

    public Long getTotalDataIsActive(Byte isActive);

    public List<T> getAllData();

    public List<T> getAllData(Boolean isActive);

    public List<T> getAllData(Integer isActive);

    public List<T> getAllData(Byte isActive);

    public List<T> getAllDataPageAble(int firstResult, int maxResults, Order order);

    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Boolean isActive);

    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Integer isActive);

    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Byte isActive);

    public Long getTotalByCode(String code);

    public Long getTotalByCodeAndNotId(String code, Long id);

    public Long getTotalByName(String name);

}
