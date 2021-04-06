package org.o7planning.springmvcforms.dao;

import java.util.List;

import org.o7planning.springmvcforms.entity.Applicant;
import org.o7planning.springmvcforms.model.ApplicantInfo;
 
public interface ApplicantDAO {
 
    public Applicant findApplicant(String id);
 
    public List<ApplicantInfo> listApplicantInfos();
 
    public void saveApplicant(Applicant applicantInfo ,boolean isNew);
 
    public ApplicantInfo findApplicantInfo(String id);
 
    public void deleteApplicant(String id);
    
}