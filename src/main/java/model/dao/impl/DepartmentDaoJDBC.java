package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection connection;

    public DepartmentDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO department "
                    + "VALUES "
                    + "(?, ?)");
            ps.setInt(1, department.getId());
            ps.setString(2, department.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE department "
                    + "SET Name = ? "
                    + "WHERE Id = ?");
            ps.setString(1, department.getName());
            ps.setInt(2, department.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM department "
                    + "WHERE Id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM department "
                    + "WHERE Id = ? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Department department = instantiateDepartment(rs);
                return department;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM department "
                    + "ORDER BY Id");
            rs = ps.executeQuery();
            List<Department> departments = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();
            while (rs.next()) {
                Department department = map.get(rs.getInt("Id"));
                if (department == null) {
                    department = instantiateDepartment(rs);
                    map.put(rs.getInt("Id"), department);
                }
                Department dprmnt = instantiateDepartment(rs);
                departments.add(dprmnt);
            }
            return departments;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("Id"));
        department.setName(rs.getString("Name"));
        return department;
    }

}
