package com.example;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.CostUser;
import com.example.service.CostUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class MybatisPlusTest {

    @Autowired
    MockMvc mockMvc;

    @Resource
    CostUserService costUserService;

    @Test
    public void testCRUD() {
        CostUser costUser = new CostUser();
        costUser.setName("Alice");
        costUser.setPhone("12345678901");
        costUser.setEmail("alice@example.com");
        costUser.setIcon("path/to/icon1.png");
        costUser.setPassword("password123");
        costUser.setActive(true);

        costUserService.save(costUser);
    }

    @Test
    public void testPatchAdd() throws Exception {
        // 批量添加二十个用户
        for (int i = 0; i < 20; i++) {
            CostUser costUser = new CostUser();
            costUser.setName("User" + i);
            costUser.setPhone("123456789" + i);
            costUser.setEmail("user" + i + "@example.com");
            costUser.setIcon("path/to/icon" + i + ".png");
            costUser.setPassword("password" + i);
            costUser.setActive(true);
            String jsonString = JSONObject.toJSONString(costUser);
            MvcResult mvcResult = mockMvc.perform(post("/costUser/add")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonString)
                    )
                    .andExpect(status().isOk())
                    .andReturn();
        }
    }

}
