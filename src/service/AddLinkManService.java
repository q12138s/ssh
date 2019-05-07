package service;

import org.hibernate.Transaction;

import utils.HibernateUtils;
import dao.AddLinkManDao;
import dao.CustomerDao;
import domain.Customer;
import domain.LinkMan;

public class AddLinkManService {

	private AddLinkManDao lmd;
	public void setLmd(AddLinkManDao lmd) {
		this.lmd = lmd;
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	private CustomerDao cd;
	public void save(LinkMan lk) {
		//����
		Transaction session = HibernateUtils.getCurrentSession().beginTransaction();
		try{
			//��װcust_id
		Long cust_id = lk.getCust_id();
		//����dao
		Customer c=cd.getById(cust_id);
		//���ͻ�����linman����ϵ
		lk.setCustomer(c);
		lmd.save(lk);
		}catch(Exception ex){
			session.rollback();
		}
		session.commit();
		
	}

}
