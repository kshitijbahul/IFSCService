package com.kshitij.interview.fyle.service;

import com.kshitij.interview.fyle.entities.Branch;
import com.kshitij.interview.fyle.exceptions.BranchNotFoundException;
import com.kshitij.interview.fyle.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BranchService {
    private BranchRepository branchRepository;
    public BranchService(BranchRepository branchRepository){
        this.branchRepository=branchRepository;
    }

    public Branch getBranchByIFSC(String ifscCode) {
        return branchRepository.getBranchByIfsc(ifscCode).orElseThrow(() -> new BranchNotFoundException("Branch not found for "+ifscCode));
    }

    public List<Branch> getBranchesByBankNameAndCity(String bank, String city) {
        return branchRepository.getBranchesByBankNameAndCity(bank,city);
    }
}
