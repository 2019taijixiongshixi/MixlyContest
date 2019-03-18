package com.makerpanda.MixlyContest.dao;

import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.makerpanda.MixlyContest.DBHelper.closeResource;

public class ProjectDao {
    // 数据及库连接对象
    private static Connection conn = null;
    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;
    // 结果集
    private static ResultSet resultSet = null;

    /**
     * 获取全部用户信息。
     * @return Project类型的ArrayList集合，其中每个project对象是一个教师。
     */
    public ArrayList getProjects() {
        ArrayList<Project> arrayList = new ArrayList<>();

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT * FROM Project");  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 遍历处理结果集，获得每一行数据
            while (resultSet.next()) {
                Project project = new Project();

                project.setProjectName(resultSet.getString("ProjectName"));
                project.setProjectID(resultSet.getString("ProjectID"));
                project.setFlowChart(resultSet.getString("FlowChart"));
                project.setMindMapping(resultSet.getString("MindMapping"));
                project.setCodeChart(resultSet.getString("CodeChart"));
                project.setVideoLink(resultSet.getString("VideoLink"));
                project.setTeacherID(resultSet.getString("TeacherID"));
                // 将user对象添加进arrayList当中
                arrayList.add(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(resultSet, pst);
        }

        return arrayList;
    }

    /**
     * 根据项目ID，获取全部信息。
     * @param ProjectID 需要获取信息的项目ID。
     * @return 如果能够查询到ProjectID的信息，则返回一个Project类型的对象，其中数据域为该用户信息。否则，返回null。
     */
    public Project getProjectInfo(String ProjectID) {
        Project project = null;

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT * FROM Project WHERE id = " + ProjectID);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获得用户信息
            if (resultSet.next()) {
                project = new Project();

                project.setProjectName(resultSet.getString("ProjectName"));
                project.setProjectID(resultSet.getString("ProjectID"));
                project.setFlowChart(resultSet.getString("FlowChart"));
                project.setMindMapping(resultSet.getString("MindMapping"));
                project.setCodeChart(resultSet.getString("CodeChart"));
                project.setVideoLink(resultSet.getString("VideoLink"));
                project.setTeacherID(resultSet.getString("TeacherID"));
            }

            return project;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }
    }

