package com.kshitij.interview.fyle;

import com.kshitij.interview.fyle.entities.Branch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import static java.util.function.Predicate.isEqual;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntergationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;



    @Test
    public void getBranch_takesBranchCodeAndReturnsBranch(){
        ResponseEntity<Branch> responseEntity= testRestTemplate.getForEntity("/branch/HDFC0001",Branch.class);
        assertThat(responseEntity.getStatusCodeValue(),equalTo(HttpStatus.OK));
        //assertThat(jsonPath("ifsc").value("XXXXXXX"),equalTo("FirstBranch"));
        assertThat(responseEntity.getBody().getIfsc(),equalTo("HDFC0001"));
        assertThat(responseEntity.getBody().getBranch(),equalTo("Mumbai"));
    }
}
