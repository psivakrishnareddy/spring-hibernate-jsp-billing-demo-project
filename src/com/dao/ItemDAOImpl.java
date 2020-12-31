package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateUtility;
import com.model.CustomerDTO;
import com.model.ItemDTO;

@Repository("ItemDao")
public class ItemDAOImpl extends ItemDAO{
	
	@Autowired
	 private HibernateUtility HibUtility;
	
	@Override
	public void addItem(ItemDTO item) {
		// TODO Auto-generated method stub
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
//		return 0;
	}

	@Override
	public void updateItem(ItemDTO item) {
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(item);
		tx.commit();
		
	}

	@Override
	public void deleteItem(ItemDTO item) {
		// TODO Auto-generated method stub
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.delete(item);
		tx.commit();
		
	}

	@Override
	public ItemDTO getItem(int itemno) {
		try {
			Session session = getHibUtility().currentSession();
			Query query=session.createQuery("from ItemDTO where itemno=:itemno");
			query.setParameter("itemno", itemno);
			return (ItemDTO) query.uniqueResult();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ItemDTO> getAllItems() {
		try {
			Session session = getHibUtility().currentSession();
			Query query=session.createQuery("from ItemDTO");
			
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ItemDTO> getItemByShop(int shopid) {
		try {
			Session session = getHibUtility().currentSession();
			Query query=session.createQuery("from ItemDTO where shopno=:shopid");
			query.setParameter("shopid", shopid);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public HibernateUtility getHibUtility() {
		return HibUtility;
	}

	public void setHibUtility(HibernateUtility hibUtility) {
		HibUtility = hibUtility;
	}

}
