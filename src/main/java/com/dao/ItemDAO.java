package com.dao;

import com.vo.ItemVO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAO {

    private int itemId;
    private String itemName;
    private double itemPrice;
    private boolean itemInStock;
    private int itemQuantity;
    public ArrayList<ItemVO> getItems(Connection con) {
        ArrayList<ItemVO> itemList = new ArrayList<ItemVO>();
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
    public void addItem(Connection con, ItemVO item) {
        String query = "INSERT INTO public.items" +
                "(item_name, item_price, item_in_stock, item_quantity)" +
                "VALUES(?, ?, ?, ?);";
        try {
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1, item.getItemName());
            psmt.setDouble(2, item.getItemPrice());
            psmt.setBoolean(3, item.getItemStock());
            psmt.setInt(4, item.getItemQuantity());
            psmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addItems(Connection con, ArrayList<ItemVO> items) {
        for(int i = 0; i < items.size(); i++)
            addItem(con, items.get(i));
    }
//    public Boolean getItemStock(Connection con) {}
}
