package com.dao;

import com.vo.ItemVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDAO {

    private int itemId;
    private String itemName;
    private double itemPrice;
    private boolean itemInStock;
    private int itemQuantity;
    ArrayList<ItemVO> itemList = new ArrayList<ItemVO>();

    public ArrayList<ItemVO> getItems(Connection con) {
        String query = "select * from ITEMS";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ItemVO itemVO = new ItemVO();
                itemVO.setItemId(rs.getInt("item_sys_id"));
                itemVO.setItemName(rs.getString("item_name"));
                itemVO.setItemPrice(rs.getDouble("item_price"));
                itemVO.setItemInStock(rs.getBoolean("item_in_stock"));
                itemVO.setItemQuantity(rs.getInt("item_quantity"));
                itemList.add(itemVO);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return itemList;
    }
//    public Boolean getItemStock(Connection con) {}
}
