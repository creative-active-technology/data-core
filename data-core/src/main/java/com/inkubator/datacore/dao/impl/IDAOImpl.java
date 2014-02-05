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

    public Criteria findByPk(Object id, Object isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("id", id));
        cekIsActive(criteria, isActive);
        return criteria;
    }

    public void cekIsActive(Criteria criteria, Object isActive) {
        criteria.add(Restrictions.eq("isActive", isActive));
    }

    public T getEntiyByPK(String id) {
        return (T) getCurrentSession().get(getEntityClass(), id);
    }

    public T getEntiyByPK(Integer id) {
        return (T) getCurrentSession().get(getEntityClass(), id);
    }

    public T getEntiyByPK(Long id) {
        return (T) getCurrentSession().get(getEntityClass(), id);
    }

    public void save(T entity) {
        this.getCurrentSession().save(entity);
    }

    public void update(T entity) {
        this.getCurrentSession().update(entity);
    }

    public void saveOrUpdate(T entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public T saveData(T entity) {
        this.save(entity);
        return entity;
    }

    public T updateData(T entity) {
        this.updateData(entity);
        return entity;
    }

    public T saveOrUpdateData(T entity) {
        this.saveOrUpdate(entity);
        return entity;
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public T getEntityByPkIsActive(String id, Integer isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    public T getEntityByPkIsActive(String id, Byte isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    public T getEntityByPkIsActive(String id, Boolean isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    public T getEntityByPkIsActive(Integer id, Integer isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    public T getEntityByPkIsActive(Integer id, Byte isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    public T getEntityByPkIsActive(Integer id, Boolean isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    public T getEntityByPkIsActive(Long id, Integer isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    public T getEntityByPkIsActive(Long id, Byte isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    public T getEntityByPkIsActive(Long id, Boolean isActive) {
        Criteria criteria = findByPk(id, isActive);
        return (T) criteria.uniqueResult();
    }

    public void softDelete(T entity) {
        this.update(entity);
    }

    public Long getTotalData() {
        Long o = (Long) getCurrentSession().createCriteria(getEntityClass())
                .add(Restrictions.isNotNull("id"))
                .setProjection(Projections.rowCount()).uniqueResult();
        return o;
    }

    public Long getTotalDataIsActive(Boolean active) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, active);
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    public Long getTotalDataIsActive(Integer active) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, active);
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    public Long getTotalDataIsActive(Byte active) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, active);
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    public List<T> getAllData() {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        return (List<T>) criteria.list();
    }

    public List<T> getAllData(Boolean active) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, active);
        return (List<T>) criteria.list();
    }

    public List<T> getAllData(Integer active) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, active);
        return (List<T>) criteria.list();
    }

    public List<T> getAllData(Byte isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, isActive);
        return (List<T>) criteria.list();
    }

    public List<T> getAllDataPageAble(int firstResult, int maxResults, Order order) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.addOrder(order);
        criteria.add(Restrictions.isNotNull("id"));
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        return (List<T>) criteria.list();
    }

    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Boolean isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.addOrder(order);
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, isActive);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        return (List<T>) criteria.list();
    }

    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Integer isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.addOrder(order);
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, isActive);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        return (List<T>) criteria.list();
    }

    public List<T> getAllDataPageAbleIsActive(int firstResult, int maxResults, Order order, Byte isActive) {
        Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
        criteria.addOrder(order);
        criteria.add(Restrictions.isNotNull("id"));
        cekIsActive(criteria, isActive);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        return (List<T>) criteria.list();
    }

}
