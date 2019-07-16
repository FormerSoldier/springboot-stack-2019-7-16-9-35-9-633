package com.tw.apistackbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_return_employees_when_call_get_all_employees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"one\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 5000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"two\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5200\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"three\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5300\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_employee_when_call_get_employee_by_id_given_id() throws Exception {
        mockMvc.perform(get("/employees/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"one\",\n" +
                        "    \"age\": 20,\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"salary\": 5000\n" +
                        "}"));
    }

    @Test
    public void should_return_employees_when_call_get_employees_with_page_and_page_size_givn_page_page_size() throws Exception {
        mockMvc.perform(get("/employees?page=2&&pageSize=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"two\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5200\n" +
                        "    }\n" +
                        "]"));
    }
    @Test
    public void should_return_employees_when_call_get_employees_equals_gender_givn_gender() throws Exception {
        mockMvc.perform(get("/employees?gender=female"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"two\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5200\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"three\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5300\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_employees_when_call_add_employees_equals_gender_givn_employee() throws Exception {
        mockMvc.perform(post("/employees")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "\t\"id\": 5,\n" +
                        "\t\"name\": \"five\",\n" +
                        "\t\"age\": 20,\n" +
                        "\t\"gender\": \"male\",\n" +
                        "\t\"salary\": 5500\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"one\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 5000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"two\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5200\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"three\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5300\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 5,\n" +
                        "        \"name\": \"five\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 5500\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_employees_when_call_update_employee_givn_employee() throws Exception {
        mockMvc.perform(put("/employees")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "\t\"id\": 1,\n" +
                        "\t\"name\": \"one_five\",\n" +
                        "\t\"age\": 20,\n" +
                        "\t\"gender\": \"male\",\n" +
                        "\t\"salary\": 5500\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"one_five\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 5500\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"two\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5200\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"three\",\n" +
                        "        \"age\": 20,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5300\n" +
                        "    }\n" +
                        "]"));
    }
}
