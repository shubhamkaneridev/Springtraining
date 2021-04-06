package org.o7planning.springmvcforms.dao.impl;

import java.util.List;
import java.util.UUID;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.o7planning.springmvcforms.dao.ApplicantDAO;
import org.o7planning.springmvcforms.entity.Applicant;
import org.o7planning.springmvcforms.model.ApplicantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class ApplicantDAOImpl implements ApplicantDAO {
 
    @Autowired
    private SessionFactory sessionFactory;

    public Applicant findApplicant(String id) {
        Session session = sessionFactory.getCurrentSession();
        
        
        String sql = "SELECT * FROM applicants WHERE id = :id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Applicant.class);
        query.setParameter("id", id);
        
        
        return (Applicant) query.uniqueResult();
        
   
    }
 

    public ApplicantInfo findApplicantInfo(String id) {
        Applicant applicant = this.findApplicant(id);
        if (applicant == null) {
            return null;
        }
        return new ApplicantInfo(applicant.getId(), applicant.getName(), //
                applicant.getEmail(), applicant.getGender(), //
                applicant.getPosition(), applicant.getSkills());
    }
 
    public List<ApplicantInfo> listApplicantInfos() {
        String sql = "Select new " + ApplicantInfo.class.getName()//
                + "(a.id, a.name, a.email, a.gender, a.position, a.skills) "//
                + " from " + Applicant.class.getName() + " a ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        return query.list();
    }
 
    
 
    public void deleteApplicant(String id) {
        Applicant applicant = this.findApplicant(id);
        if (applicant != null) {
            this.sessionFactory.getCurrentSession().delete(applicant);
        }
    }


	@Override
	public void saveApplicant(Applicant applicantInfo, boolean isNew) {

        if (isNew) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(applicantInfo);
        }
	}
 
}