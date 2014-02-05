/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.datacore.service;

import java.util.List;
import javax.persistence.criteria.Order;

/**
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 5 February 2014
 */
public interface IService<T> {

    public T getEntiyByPK(String id) throws Exception;

    public T getEntiyByPK(Integer id) throws Exception;

    public T getEntiyByPK(Long id) throws Exception;

    public void save(T entity) throws Exception;

    public void update(T entity) throws Exception;

    public void saveOrUpdate(T enntity) throws Exception;

    public T saveData(T entity) throws Exception;

    public T updateData(T entity) throws Exception;

    public T saveOrUpdateData(T entity) throws Exception;

    public T getEntityByPkIsActive(String id, Integer isActive) throws Exception;

    public T getEntityByPkIsActive(String id, Byte isActive) throws Exception;

    public T getEntityByPkIsActive(String id, Boolean isActive) throws Exception;

    public T getEntityByPkIsActive(Integer id, Integer isActive) throws Exception;

    public T getEntityByPkIsActive(Integer id, Byte isActive) throws Exception;

    public T getEntityByPkIsActive(Integer id, Boolean isActive) throws Exception;

    public T getEntityByPkIsActive(Long id, Integer isActive) throws Exception;

    public T getEntityByPkIsActive(Long id, Byte isActive) throws Exception;

    public T getEntityByPkIsActive(Long id, Boolean isActive) throws Exception;

    public void delete(T entity) throws Exception;

    public void softDelete(T entity) throws Exception;

    public Long getTotalData() throws Exception;

    public Long getTotalDataIsActive(Boolean isActive) throws Exception;

    public Long getTotalDataIsActive(Integer isActive) throws Exception;

    public Long getTotalDataIsActive(Byte isActive) throws Exception;

    public List<T> getAllData() throws Exception;

    public List<T> getAllData(Boolean isActive) throws Exception;

    public List<T> getAllData(Integer isActive) throws Exception;

    public List<T> getAllData(Byte isActive) throws Exception;

    public List<T> getAllDataPageAble(int firstResult, int maxResults, Order order) throws Exception;

    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Boolean isActive) throws Exception;

    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Integer isActive) throws Exception;

    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Byte isActive) throws Exception;
}
