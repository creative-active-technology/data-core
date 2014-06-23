/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.datacore.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * This abstract class is handle all basic function of dao implementation. So
 * every DAOImpl is extent form BaseDAO.
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @param <T> is Entity class (JPA POJO Class or Hibernate POJO Class)
 * @since 5 February 2014
 */
public abstract class IDAOImpl<T> implements Serializable {

    protected transient Logger LOGGER = Logger.getLogger(getClass());
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * For get the instance class on the fly.
     *
     * @return instance class.
     */
    public abstract Class<T> getEntityClass();

    /**
     * Get instance of Hibernate Criteria with parameter input Object id and
     * Object isActive.
     *
     * @param id is Object and can casting to any kind of java Object like
     * String, Integer, or Long.
     * @param isActive is Object and can casting to any kind of java Object like
     * String, Integer, or Long.
     * @return instance class.
     */
    public Criteria findByPk(Object id, Object isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("id", id));
        cekIsActive(criteria, isActive);
        return criteria;
    }

    /**
     * Doing check if some entity isActive or not.
     *
     * @param criteria
     * @param isActive
     */
    public void cekIsActive(Criteria criteria, Object isActive) {
        criteria.add(Restrictions.eq("isActive", isActive));
    }

    /**
     * Get Object of any kind of Entity. Casting from T to Object of Entity.
     *
     * @param id in String value and Primary Key
     * @return T casting to Object.
     */
    public T getEntiyByPK(String id) {
        return (T) getCurrentSession().get(getEntityClass(), id);
    }

    /**
     * Get Object of any kind of Entity. Casting from T to Object of Entity.
     *
     * @param id in Integer value and Primary Key
     * @return T casting to Object.
     */
    public T getEntiyByPK(Integer id) {
        return (T) getCurrentSession().get(getEntityClass(), id);
    }

    /**
     * Get Object of any kind of Entity. Casting from T to Object of Entity.
     *
     * @param id in Long value and Primary Key
     * @return T casting to Object.
     */
    public T getEntiyByPK(Long id) {
        return (T) getCurrentSession().get(getEntityClass(), id);
    }

    /**
     * Doing save object of entity to database.
     *
     * @param entity is java object
     */
    public void save(T entity) {
        this.getCurrentSession().save(entity);
    }

    /**
     * Doing update object of entity to database.
     *
     * @param entity is java object
     */
    public void update(T entity) {
        this.getCurrentSession().update(entity);
    }

    /**
     * Doing save or update object of entity to database.
     *
     * @param entity is java object
     */
    public void saveOrUpdate(T entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    /**
     * Doing save object of entity to database.
     *
     * @param entity is java object
     * @return T is casting to any entity or object
     */
    public T saveData(T entity) {
        this.save(entity);
        return entity;
    }

    /**
     * Doing update object of entity to database.
     *
     * @param entity is java object
     * @return T is casting to any entity or object
     */
    public T updateData(T entity) {
        this.updateData(entity);
        return entity;
    }

    /**
     * Doing saveOrUodate object of entity to database.
     *
     * @param entity is java object
     * @return T is casting to any entity or object
     */
    public T saveOrUpdateData(T entity) {
        this.saveOrUpdate(entity);
        return entity;
    }

    /**
     * Doing delete object of entity of database
     *
     * @param entity is java object
     */
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    /**
     * Get object of entity and depend on id (PK) condition of active or not.
     *
     * @param id is PK
     * @param isActive state 0 = not active and 1 active
     * @return T is casting to any entity or object
     */
    public T getEntityByPkIsActive(String id, Integer isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    /**
     * Get object of entity and depend on id (PK) condition of active or not.
     *
     * @param id is PK in String type
     * @param isActive Byte state -127 = not active and 127 active
     * @return T is casting to any entity or object
     */
    public T getEntityByPkIsActive(String id, Byte isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    /**
     * Get object of entity and depend on id (PK) condition of active or not.
     *
     * @param id is PK in String type
     * @param isActive Boolean state false = not active and true active
     * @return T is casting to any entity or object
     */
    public T getEntityByPkIsActive(String id, Boolean isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    /**
     * Get object of entity and depend on id (PK) condition of active or not.
     *
     * @param id is PK in Integer type
     * @param isActive Integer state 0 = not active and 1 active
     * @return T is casting to any entity or object
     */
    public T getEntityByPkIsActive(Integer id, Integer isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    /**
     * Get object of entity and depend on id (PK) condition of active or not.
     *
     * @param id is PK in Integer type
     * @param isActive Byte state -127 = not active and 127 active
     * @return T is casting to any entity or object
     */
    public T getEntityByPkIsActive(Integer id, Byte isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    /**
     * Get object of entity and depend on id (PK) condition of active or not.
     *
     * @param id is PK in Integer type
     * @param isActive Boolean state -127 = not active and 127 active
     * @return T is casting to any entity or object
     */
    public T getEntityByPkIsActive(Integer id, Boolean isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    /**
     * Get object of entity and depend on id (PK) condition of active or not.
     *
     * @param id is PK in Long type
     * @param isActive Integer state 0 = not active and 1 active
     * @return T is casting to any entity or object
     */
    public T getEntityByPkIsActive(Long id, Integer isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    /**
     * Get object of entity and depend on id (PK) condition of active or not.
     *
     * @param id is PK in Long type
     * @param isActive Byte state -127 = not active and 127 active
     * @return T is casting to any entity or object
     */
    public T getEntityByPkIsActive(Long id, Byte isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    /**
     * Get object of entity and depend on id (PK) condition of active or not.
     *
     * @param id is PK in Long type
     * @param isActive Boolean state false = not active and true active
     * @return T is casting to any entity or object
     */
    public T getEntityByPkIsActive(Long id, Boolean isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    /**
     * Delete data with softly in other word is update condition of isActive
     * from true to false
     *
     * @param entity is java object
     */
    public void softDelete(T entity) {
        this.update(entity);
    }

    /**
     * get total data count of specific entity
     *
     * @return Long type
     */
    public Long getTotalData() {
        Long o = (Long) getCurrentSession().createCriteria(getEntityClass())
                .add(Restrictions.isNotNull("id"))
                .setProjection(Projections.rowCount()).uniqueResult();
        return o;
    }

    /**
     * get total data count of specific entity
     *
     * @param active in boolean condition can be true or false
     * @return Long type
     */
    public Long getTotalDataIsActive(Boolean active) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, active);
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    /**
     * get total data count of specific entity
     *
     * @param active in Integer condition can be 0 or 1
     * @return Long type
     */
    public Long getTotalDataIsActive(Integer active) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, active);
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    /**
     * get total data count of specific entity
     *
     * @param active in Byte condition can be -127 or 127
     * @return Long type
     */
    public Long getTotalDataIsActive(Byte active) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, active);
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    /**
     * Get All data for specific Entity (T). Note this method only return data
     * that have primary key.
     *
     * @return List of entity
     */
    public List<T> getAllData() {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        return (List<T>) criteria.list();
    }

    /**
     * Get All data for specific Entity (T). Note this method only return data
     * that have primary key and condition isActive parameter,
     *
     * @param active is Boolean type.
     * @return List of entity
     */
    public List<T> getAllData(Boolean active) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, active);
        return (List<T>) criteria.list();
    }

    /**
     * Get All data for specific Entity (T). Note this method only return data
     * that have primary key and condition isActive parameter,
     *
     * @param isActive is Integer type.
     * @return List of entity
     */
    public List<T> getAllData(Integer isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, isActive);
        return (List<T>) criteria.list();
    }

    /**
     * Get All data for specific Entity (T). Note this method only return data
     * that have primary key and condition isActive parameter,
     *
     * @param isActive is Byte type.
     * @return List of entity
     */
    public List<T> getAllData(Byte isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, isActive);
        return (List<T>) criteria.list();
    }

    /**
     * Get All data for specific Entity (T). Note this method only return data
     * that have primary key, page able, and Sorting
     *
     * @param firstResult is int type and begin from 0
     * @param maxResults is int type
     * @param order
     * @return List of entity
     */
    public List<T> getAllDataPageAble(int firstResult, int maxResults, Order order) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.addOrder(order);
        criteria.add(Restrictions.isNotNull("id"));
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        return (List<T>) criteria.list();
    }

    /**
     * Get All data for specific Entity (T). Note this method only return data
     * that have primary key, page able, Sorting, and isActive condition
     *
     * @param firstResult is int type and begin from 0
     * @param maxResults is int type
     * @param order is Hibernate Order
     * @param isActive is Boolean condition true or false
     * @return List of entity
     */
    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Boolean isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.addOrder(order);
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, isActive);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        return (List<T>) criteria.list();
    }

    /**
     * Get All data for specific Entity (T). Note this method only return data
     * that have primary key, page able, Sorting, and isActive condition
     *
     * @param firstResult is int type and begin from 0
     * @param maxResults is int type
     * @param order is Hibernate Order
     * @param isActive is Integer condition 0 or 1
     * @return List of entity
     */
    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Integer isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.addOrder(order);
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, isActive);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        return (List<T>) criteria.list();
    }

    /**
     * Get All data for specific Entity (T). Note this method only return data
     * that have primary key, page able, Sorting, and isActive condition
     *
     * @param firstResult is int type and begin from 0
     * @param maxResults is int type
     * @param order is Hibernate Order
     * @param isActive is Byte condition -127 or 127
     * @return List of entity
     */
    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Byte isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.addOrder(order);
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, isActive);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        return (List<T>) criteria.list();
    }

    /**
     * Get Total data for specific Entity (T). Note this method only return data
     * that have code
     *
     *
     * @param code
     * @return total entity
     */
    public Long getTotalByCode(String code) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("code", code));
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    public Long getTotalByCodeAndNotId(String code, Long id) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("code", code));
        criteria.add(Restrictions.ne("id", id));
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    public Long getTotalByName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("name", name));
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }
    
    public Long getTotalByNameAndNotId(String name, Long id) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("name", name));
        criteria.add(Restrictions.ne("id", id));
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }
}
