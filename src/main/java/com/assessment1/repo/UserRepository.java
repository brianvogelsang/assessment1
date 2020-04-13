package com.assessment1.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import com.assessment1.config.ConnectionUtil;
import com.assessment1.model.User;

public class UserRepository implements CrudRepository<User, Integer> {

  public User save(User user) {
    try (Connection conn = ConnectionUtil.connect()) {
      String sql =
          "INSERT INTO app_user (username, password, first_name, last_name, role_id) VALUES ( ?, ?, ?, ?, ?)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      ps.setString(3, user.getFirstName());
      ps.setString(4, user.getLastName());
      ps.setInt(5, Integer.parseInt(user.getRole()));
      ps.execute();
      return findUserByUsername(user.getUsername());
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Set<User> findAll() {
    try (Connection conn = ConnectionUtil.connect()) {
      String sql = "select * from app_user order by user_id asc";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      Set<User> set = new HashSet<User>();
      while (rs.next()) {
        set.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5), rs.getString(6)));
      }
      return set;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public User findById(Integer id) {
    try (Connection conn = ConnectionUtil.connect()) {
      String sql = "select * from app_user where user_id = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      rs.next();
      return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
          rs.getString(5), rs.getString(6));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public User findUserByUsername(String username) {
    try (Connection conn = ConnectionUtil.connect()) {
      String sql = "select * from app_user where username = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, username);
      ResultSet rs = ps.executeQuery();
      rs.next();
      return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
          rs.getString(5), rs.getString(6));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public User findUserByCredentials(String username, String pw) {
    try (Connection conn = ConnectionUtil.connect()) {
      String sql = "select * from app_user where username = ? and password = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, username);
      ps.setString(2, pw);
      ResultSet rs = ps.executeQuery();
      rs.next();
      return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
          rs.getString(5), rs.getString(6));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Boolean update(User user) {
    try (Connection conn = ConnectionUtil.connect()) {
      String sql =
          "alter app_user set username =  ?, password = ?, first_name = ?, last_name = ?, role_id = ? where user_id = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      ps.setString(3, user.getFirstName());
      ps.setString(4, user.getLastName());
      ps.setString(5, user.getRole());
      ps.setInt(6, user.getId());
      ps.execute();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public Boolean deleteById(Integer id) {
    try (Connection conn = ConnectionUtil.connect()) {
      String sql = "delete from app_user where user_id = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      ps.execute();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public User findByString(String s) {
    return null;
  }

}
