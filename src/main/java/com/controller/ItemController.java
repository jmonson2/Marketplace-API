package com.controller;

import com.conn.DBConnection;
import com.dao.ItemDAO;
import com.vo.ItemVO;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.ArrayList;

@RestController
public class ItemController {
    DBConnection dbConnection = new DBConnection();
    Connection con = dbConnection.connect();
    ItemDAO itemDAO = new ItemDAO();
    @GetMapping("/inventory")
    public ArrayList<ItemVO> getInventory() {
        ArrayList<ItemVO> itemList = new ArrayList<ItemVO>();
        itemList = itemDAO.getItems(con);
        return itemList;
    }
//    @GetMapping("/stocked")
//    public ItemVO getStock() {
//
//    }
}
