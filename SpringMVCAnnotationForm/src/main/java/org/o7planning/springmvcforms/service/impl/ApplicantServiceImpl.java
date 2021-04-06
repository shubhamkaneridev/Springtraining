package org.o7planning.springmvcforms.service.impl;

import java.util.List;
import java.util.UUID;

import org.o7planning.springmvcforms.dao.ApplicantDAO;
import org.o7planning.springmvcforms.entity.Applicant;
import org.o7planning.springmvcforms.model.ApplicantInfo;
import org.o7planning.springmvcforms.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService {
	
	@Autowired
	ApplicantDAO applicantDAO;

	@Override
	public void saveApplicant(ApplicantInfo applicantInfo) {
		String id = applicantInfo.getId();
        Applicant applicant = null;
        if (""!= id && id != null) {
            applicant = applicantDAO.findApplicant(id);
        }
        boolean isNew = false;
        if (applicant == null) {
            isNew = true;
            applicant = new Applicant();
            applicant.setId(UUID.randomUUID().toString());
        }
        applicant.setEmail(applicantInfo.getEmail());
        applicant.setGender(applicantInfo.getGender());
        applicant.setName(applicantInfo.getName());
        applicant.setPosition(applicantInfo.getPosition());
        String skillsString = applicantInfo.getSkillsString();
 
        applicant.setSkills(skillsString);
        
        applicantDAO.saveApplicant(applicant, isNew);
		
	}

	@Override
	public Applicant findApplicant(String id) {
		return applicantDAO.findApplicant(id);
	}

	@Override
	public List<ApplicantInfo> listApplicantInfos() {
		return applicantDAO.listApplicantInfos();
	}

	@Override
	public ApplicantInfo findApplicantInfo(String id) {
		return applicantDAO.findApplicantInfo(id);
	}

	@Override
	public void deleteApplicant(String id) {
		applicantDAO.deleteApplicant(id);
		
	}

}