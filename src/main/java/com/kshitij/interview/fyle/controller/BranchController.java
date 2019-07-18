package com.kshitij.interview.fyle.controller;

import com.kshitij.interview.fyle.entities.Branch;
import com.kshitij.interview.fyle.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BranchController {
    private BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService){

        this.branchService = branchService;
    }

    @GetMapping("/branch/{code}")
    private Branch getBranchByIfsc(@PathVariable("code") String ifsccode){
        return branchService.getBranchByIFSC(ifsccode);
    }

    @GetMapping("/branches/bank/{bank}/city/{city}")
    private List<Branch> getBranchesByBankAndCity(@PathVariable("bank") String bank, @PathVariable("city") String city){
        return branchService.getBranchesByBankNameAndCity(bank,city);
    }
}
