package org.o7planning.springmvcforms.service;

import java.util.List;

import org.o7planning.springmvcforms.entity.Applicant;
import org.o7planning.springmvcforms.model.ApplicantInfo;

public interface ApplicantService {

    public Applicant findApplicant(String id);
 
    public List<ApplicantInfo> listApplicantInfos();
 
    public void saveApplicant(ApplicantInfo applicantInfo);
 
    public ApplicantInfo findApplicantInfo(String id);
 
    public void deleteApplicant(String id);
}