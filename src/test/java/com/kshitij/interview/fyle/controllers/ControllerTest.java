package com.kshitij.interview.fyle.controllers;

import com.kshitij.interview.fyle.controller.BranchController;
import com.kshitij.interview.fyle.entities.Branch;
import com.kshitij.interview.fyle.service.BranchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BranchController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BranchService branchService;

    @Test
    public void getBranch_branchWithIFSCCode() throws Exception {
        given(branchService.getBranchByIFSC("HDFC0001")).willReturn(new Branch("HDFC0001","HDFC"));
        mockMvc.perform(MockMvcRequestBuilders.get("/branch/HDFC0001")).andExpect(status().isOk())
                .andExpect(jsonPath("ifsc").exists()).andExpect(jsonPath("ifsc").value("HDFC0001"))
                .andExpect(jsonPath("branch").exists()).andExpect(jsonPath("branch").value("HDFC"));

    }

    @Test
    public void getBranches_branchesWithCityAndBank() throws Exception {
        List<Branch> branchesPushed= new ArrayList<>(2);
        branchesPushed.add(new Branch("HDFC000112","HDFC Branch"));
        given(branchService.getBranchesByBankNameAndCity("HDFC","Mumbai")).willReturn(branchesPushed);
        mockMvc.perform(MockMvcRequestBuilders.get("/branches/bank/HDFC/city/Mumbai")).andExpect(status().isOk())
               .andExpect(jsonPath("$[0].ifsc").value("HDFC000112"))
                .andExpect(jsonPath("$[0].branch").value("HDFC Branch"));
    }

}
