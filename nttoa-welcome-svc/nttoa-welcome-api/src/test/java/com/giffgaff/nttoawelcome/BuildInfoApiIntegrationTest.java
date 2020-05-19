package com.giffgaff.nttoawelcome;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;


public class BuildInfoApiIntegrationTest extends AbstractApiIntegrationTest {


    @Test
    public void testBuildInfo() throws Exception {
        String expected = IOUtils
            .toString(new ClassPathResource("expectedResponses/buildInfo.json").getInputStream(),
                StandardCharsets.UTF_8);
        this.mockMvc.perform(get("/manage/info")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(
                sameJSONAs(expected)
                    .allowingExtraUnexpectedFields()
                    .allowingAnyArrayOrdering()));
    }

}
