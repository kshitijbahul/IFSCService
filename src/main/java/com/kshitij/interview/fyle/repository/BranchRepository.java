package com.kshitij.interview.fyle.repository;

import com.kshitij.interview.fyle.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch,Long> {
    List<Branch> getBranchesByBankNameAndCity(String bankName, String city);
    Optional<Branch> getBranchByIfsc(String ifscCode);
}
