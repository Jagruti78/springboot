package com.restapipostgresql.restapipostgresql;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapipostgresql.model.Lead;
import com.restapipostgresql.service.ILeadService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
public class LeadControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ILeadService leadService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenLead_whenCreateLead_thenReturn200Ok() throws Exception{

        Lead lead = new Lead(423223, "abc", "def","ghi","Male",5234567890l,
    			"01/04/2021","abc@abc.com");
        
        given(leadService.createLead(any(Lead.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/v1/lead/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(lead)));

        response.andDo(print()).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.status",
                        is("success")))
                .andExpect(jsonPath("$.data",
                        is("Created Leads Successfully")
                ));
        
        

    }

    @Test
    public void givenLead_whenSpaceinFirstName_thenReturn400Error() throws Exception{

        Lead lead = new Lead(601901, "ab c", "def","ghi","Male",5234567890l,
    			"01/04/2021","abc@abc.com");
        
        given(leadService.createLead(any(Lead.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/v1/lead/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(lead)));

        response.andDo(print()).
                andExpect(status().isBadRequest())
               ;
        
        

    }
    
    @Test
    public void givenLead_whenIncorrectEmail_thenReturn400Error() throws Exception{

  
        Lead lead = new Lead(601901, "ab c", "def","ghi","Male",5234567890l,
    			"01/04/2021","abcabc.com");
        
        given(leadService.createLead(any(Lead.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));


        ResultActions response = mockMvc.perform(post("/api/v1/lead/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(lead)));


        response.andDo(print()).
                andExpect(status().isBadRequest())
               ;
        
        

    }
  
}