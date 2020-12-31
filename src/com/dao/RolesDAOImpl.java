package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateUtility;
import com.model.RolesDTO;

@Repository("RolesDao")
public class RolesDAOImpl extends RoleDAO {
	@Autowired
	 private HibernateUtility HibUtility;
	
	
	@Override
	public RolesDTO getRoleById(int rid) {
		Session session = getHibUtility().currentSession();
		Query query=session.createQuery("from RolesDTO where rid=:rid");
		query.setParameter("rid", rid);
		
		return (RolesDTO) query.uniqueResult();
	}
	
	
	
	public HibernateUtility getHibUtility() {
		return this.HibUtility;
	}
	public void setHibUtility(HibernateUtility hibUtility) {
		this.HibUtility = hibUtility;
	}
}
