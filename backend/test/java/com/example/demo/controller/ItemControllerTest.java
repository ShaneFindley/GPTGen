package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void testGetAllItems() throws Exception {
        List<Item> items = Arrays.asList(new Item(1L, "Item1"), new Item(2L, "Item2"));
        Mockito.when(itemService.getAllItems()).thenReturn(items);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(items.size()));
    }

    @Test
    public void testAddItem() throws Exception {
        Item newItem = new Item(null, "New Item");
        Mockito.when(itemService.addItem(Mockito.any(Item.class))).thenReturn(newItem);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newItem)))
                .andExpect
