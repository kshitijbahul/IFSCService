package com.kshitij.interview.fyle.service;

import com.kshitij.interview.fyle.entities.Branch;
import com.kshitij.interview.fyle.exceptions.BranchNotFoundException;
import com.kshitij.interview.fyle.repository.BranchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class BranchService {
    private BranchRepository branchRepository;
    public BranchService(BranchRepository branchRepository){
        this.branchRepository=branchRepository;
    }

    public Branch getBranchByIFSC(String ifscCode) {
        log.info("returning Bank details with searched with ifscCode");
        return branchRepository.getBranchByIfsc(ifscCode).orElseThrow(() -> new BranchNotFoundException("Branch not found for "+ifscCode));
    }

    public List<Branch> getBranchesByBankNameAndCity(String bank, String city) {
        log.info("returning All Branches for "+bank+" and city "+city);
        return branchRepository.getBranchesByBankNameAndCity(bank,city);
    }
}
