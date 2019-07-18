package com.kshitij.interview.fyle.service;


import com.kshitij.interview.fyle.entities.Branch;
import com.kshitij.interview.fyle.exceptions.BranchNotFoundException;
import com.kshitij.interview.fyle.repository.BranchRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BranchServiceTest {
    @Mock
    private BranchRepository branchRepository;

    BranchService branchService;

    @Before
    public void setup(){
        branchService =new BranchService(branchRepository);
    }


    @Test
    public void getBrach_brachById(){
        given(branchRepository.getBranchByIfsc("HDFC000112")).willReturn(Optional.of((new Branch("HDFC000112", "HDFC Branch"))));
        Branch branch =branchService.getBranchByIFSC("HDFC000112");
        assertThat(branch.getIfsc(),equalTo("HDFC000112"));
        assertThat(branch.getBranch(),notNullValue());
    }
    @Test
    public void getBrach_getBranchByNameAndCity(){
        List<Branch> branchesPushed= new ArrayList<>(2);
        branchesPushed.add(new Branch("HDFC000112","HDFC Branch"));

        given(branchRepository.getBranchesByBankNameAndCity("HDFC","Mumbai")).willReturn(branchesPushed);
        List<Branch> branches=branchService.getBranchesByBankNameAndCity("HDFC","Mumbai");
        assertThat(branches,not(empty()));
    }
    @Test(expected = BranchNotFoundException.class)
    public void getBranch_getBranchNotFoundException(){
        given(branchRepository.getBranchByIfsc("HDFC00112")).willReturn(Optional.empty());
        branchService.getBranchByIFSC("HDFC00112");
    }

}