package dao;

import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductJDBCDAO implements ProductDAO{

    @Override
    public void save(Product entity) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into products (name, price) values (?, ?)";
            String update_sql = "update products set name = ?, price = ? where id = ?";
            PreparedStatement pst;
            assert con != null;
            if (entity.getId() == 0) {
                pst = con.prepareStatement(insert_sql);
            } else {
                pst = con.prepareStatement(update_sql);
                pst.setInt(3, entity.getId());
            }
            pst.setString(1, entity.getName());
            pst.setDouble(2, entity.getPrice());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "delete from products where id = ?";
            assert con != null;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Product find(int id) {
        Connection con = null;
        Product p = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from products where id = ?";
            assert con != null;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    @Override
    public ArrayList<Product> findAll() {
        Connection con = null;
        ArrayList<Product> result = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from products";
            assert con != null;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Product cl = map(rs);
                result.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Product findByName(String str) {
        Connection con = null;
        Product p = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from products where name = ?";
            assert con != null;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, str);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    @Override
    public ArrayList<Product> findAllByName(String str) {
        Connection con = null;
        ArrayList<Product> result = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from products where name = ?";
            assert con != null;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, str);
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Product cl = map(rs);
                result.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Product map(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getDouble("price"));
        return p;
    }
}
