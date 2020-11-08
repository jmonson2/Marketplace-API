package com.controller;

import com.conn.DBConnection;
import com.dao.ItemDAO;
import com.vo.ItemVO;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/addItem")
    public void addItem(@RequestBody ItemVO item) {
        itemDAO.addItem(con, item);
    }
    @PostMapping("/addItems")
    public void addItems(@RequestBody ArrayList<ItemVO> items) {
        itemDAO.addItems(con, items);
    }

}
