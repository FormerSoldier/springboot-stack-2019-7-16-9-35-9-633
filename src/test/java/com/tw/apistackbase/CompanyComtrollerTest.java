package com.tw.apistackbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CompanyComtrollerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_return_companies_and_employees_when_call_get_all_companies() throws Exception {
        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"companyName\": \"oocl\",\n" +
                        "        \"employeesNumber\": 10000,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"XiaoHong\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 10\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"XiaoGao\",\n" +
                        "                \"age\": 12,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 100\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"XiaoLiu\",\n" +
                        "                \"age\": 14,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"companyName\": \"alibaba\",\n" +
                        "        \"employeesNumber\": 200,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"alibaba1\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 10\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 11,\n" +
                        "                \"name\": \"tengxun2\",\n" +
                        "                \"age\": 19,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 6,\n" +
                        "                \"name\": \"alibaba3\",\n" +
                        "                \"age\": 19,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"companyName\": \"TW\",\n" +
                        "        \"employeesNumber\": 600,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"huage\",\n" +
                        "                \"age\": 30,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1002\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"niuxin\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1003\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_company_when_call_get_company_by_index_given_index() throws Exception {
        mockMvc.perform(get("/companies/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{\n" +
                        "    \"companyName\": \"oocl\",\n" +
                        "    \"employeesNumber\": 10000,\n" +
                        "    \"employees\": [\n" +
                        "        {\n" +
                        "            \"id\": 0,\n" +
                        "            \"name\": \"XiaoHong\",\n" +
                        "            \"age\": 10,\n" +
                        "            \"gender\": \"female\",\n" +
                        "            \"salary\": 10\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"XiaoGao\",\n" +
                        "            \"age\": 12,\n" +
                        "            \"gender\": \"male\",\n" +
                        "            \"salary\": 100\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"XiaoLiu\",\n" +
                        "            \"age\": 14,\n" +
                        "            \"gender\": \"male\",\n" +
                        "            \"salary\": 1000\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"));
    }

    @Test
    public void should_return_employees_when_call_get_employees_by_company_index_given_company_index() throws Exception {
        mockMvc.perform(get("/companies/1/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"XiaoHong\",\n" +
                        "        \"age\": 10,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 10\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"XiaoGao\",\n" +
                        "        \"age\": 12,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 100\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"XiaoLiu\",\n" +
                        "        \"age\": 14,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 1000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_company_when_call_get_companies_with_page_and_page_size_given_page_page_size() throws Exception {
        mockMvc.perform(get("/companies/s?page=3&pageSize=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"companyName\": \"TW\",\n" +
                        "        \"employeesNumber\": 600,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"huage\",\n" +
                        "                \"age\": 30,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1002\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"niuxin\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1003\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_companies_when_call_add_companies_given_company() throws Exception {
        mockMvc.perform(post("/companies")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "\t\"companyName\": \"new company\",\n" +
                        "\t\"employeesNumber\": 0\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"companyName\": \"oocl\",\n" +
                        "        \"employeesNumber\": 10000,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"XiaoHong\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 10\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"XiaoGao\",\n" +
                        "                \"age\": 12,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 100\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"XiaoLiu\",\n" +
                        "                \"age\": 14,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"companyName\": \"alibaba\",\n" +
                        "        \"employeesNumber\": 200,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"alibaba1\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 10\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 11,\n" +
                        "                \"name\": \"tengxun2\",\n" +
                        "                \"age\": 19,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 6,\n" +
                        "                \"name\": \"alibaba3\",\n" +
                        "                \"age\": 19,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"companyName\": \"TW\",\n" +
                        "        \"employeesNumber\": 600,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"huage\",\n" +
                        "                \"age\": 30,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1002\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"niuxin\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1003\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"companyName\": \"new company\",\n" +
                        "        \"employeesNumber\": 0,\n" +
                        "        \"employees\": null\n" +
                        "    }\n" +
                        "]"));
    }


    @Test
    public void should_return_companies_when_call_update_companies_given_company() throws Exception {
        mockMvc.perform(put("/companies/3")
                .contentType("application/json;charset=UTF-8")
                .content("{\n" +
                        "\t\"companyName\": \"TW\",\n" +
                        "\t\"employeesNumber\": 0\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"companyName\": \"oocl\",\n" +
                        "        \"employeesNumber\": 10000,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"XiaoHong\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 10\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"XiaoGao\",\n" +
                        "                \"age\": 12,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 100\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"XiaoLiu\",\n" +
                        "                \"age\": 14,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"companyName\": \"alibaba\",\n" +
                        "        \"employeesNumber\": 200,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"alibaba1\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 10\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 11,\n" +
                        "                \"name\": \"tengxun2\",\n" +
                        "                \"age\": 19,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 7000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 6,\n" +
                        "                \"name\": \"alibaba3\",\n" +
                        "                \"age\": 19,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 8000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"companyName\": \"TW\",\n" +
                        "        \"employeesNumber\": 0,\n" +
                        "        \"employees\": null\n" +
                        "    }\n" +
                        "]"));
    }


    @Test
    public void should_return_companies_when_call_delete_companies_given_conpany_indes() throws Exception {
        mockMvc.perform(delete("/companies/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"companyName\": \"oocl\",\n" +
                        "        \"employeesNumber\": 10000,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 0,\n" +
                        "                \"name\": \"XiaoHong\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 10\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"XiaoGao\",\n" +
                        "                \"age\": 12,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 100\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"XiaoLiu\",\n" +
                        "                \"age\": 14,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"companyName\": \"TW\",\n" +
                        "        \"employeesNumber\": 600,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"huage\",\n" +
                        "                \"age\": 30,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1002\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"niuxin\",\n" +
                        "                \"age\": 25,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 1003\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }
}
