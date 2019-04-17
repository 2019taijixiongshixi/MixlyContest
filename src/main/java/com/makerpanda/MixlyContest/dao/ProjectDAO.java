package com.makerpanda.MixlyContest.dao;

import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.DBHelper;

import javax.tools.JavaCompiler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import static com.makerpanda.MixlyContest.DBHelper.closeResource;

public class ProjectDAO {
    // 数据及库连接对象
    private static Connection conn = null;
    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;
    // 结果集
    private static ResultSet resultSet = null;

    /**
     * 获取全部项目信息。
     * @return Project类型的ArrayList集合，其中每个project对象是一个项目。
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
                project.setProjectID(resultSet.getInt("ProjectID"));
                project.setFlowChart(resultSet.getString("FlowChart"));
                project.setProjectMindMap(resultSet.getString("ProjectMindMapping"));
                project.setCodeModuleDiagram(resultSet.getString("CodeModuleDiagram"));
                project.setVideoURL(resultSet.getString("VideoURL"));
                project.setStudentID1(resultSet.getInt("StudentID1"));
                project.setStudentID2(resultSet.getInt("StudentID2"));
                project.setStudentID3(resultSet.getInt("StudentID3"));
                project.setProjectTeamName(resultSet.getString("ProjectTeamName"));
                project.setProjectDisplayMap(resultSet.getString("ProjectDisplayMap"));
                project.setProjectDescription(resultSet.getString("ProjectDescription"));
                project.setHardwareCircuitDiagram(resultSet.getString("HardwareCircuitDiagram"));
                project.setStructureChart(resultSet.getString("SrtuctureChart"));
                project.setEquipment(resultSet.getString("Equipment"));
                project.setCompetitionExperience(resultSet.getString("CompetitionExperience"));
                project.setDesignDocument(resultSet.getString("DesignDocument"));
                project.setPreliminariesScore(resultSet.getString("PreliminariesScore"));
                project.setFinalScore(resultSet.getString("FinalScore"));
                project.setTeacherID(resultSet.getInt("TeacherID"));
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
     */
    public void getProjectInfo(Integer ProjectID,Project project) {

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT * FROM Project WHERE ProjectID = " + ProjectID);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获得项目信息
            if (resultSet.next()) {
                project.setProjectName(resultSet.getString("ProjectName"));
                project.setProjectID(resultSet.getInt("ProjectID"));
                project.setFlowChart(resultSet.getString("FlowChart"));
                project.setProjectMindMap(resultSet.getString("ProjectMindMap"));
                project.setCodeModuleDiagram(resultSet.getString("CodeModuleDiagram"));
                project.setVideoURL(resultSet.getString("VideoURL"));
                project.setStudentID1(resultSet.getInt("StudentID1"));
                project.setStudentID2(resultSet.getInt("StudentID2"));
                project.setStudentID3(resultSet.getInt("StudentID3"));
                project.setProjectTeamName(resultSet.getString("ProjectTeamName"));
                project.setProjectDisplayMap(resultSet.getString("ProjectDisplayMap"));
                project.setProjectDescription(resultSet.getString("ProjectDescription"));
                project.setHardwareCircuitDiagram(resultSet.getString("HardwareCircuitDiagram"));
                project.setStructureChart(resultSet.getString("StructureChart"));
                project.setEquipment(resultSet.getString("Equipment"));
                project.setCompetitionExperience(resultSet.getString("CompetitionExperience"));
                project.setDesignDocument(resultSet.getString("DesignDocument"));
                project.setPreliminariesScore(resultSet.getString("PreliminariesScore"));
                project.setFinalScore(resultSet.getString("FinalScore"));
                project.setTeacherID(resultSet.getInt("TeacherID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(resultSet, pst);
        }
    }
    /**
     * 增加新的项目
     * @param newProject 新的项目对象。
     * @return 如果增加成功返回true，否则返回false。
     */
    public boolean insertNewProject(Project newProject) {
        String sql = "INSERT INTO Project (ProjectName,TeacherID,StudentID1,StudentID2," +
                "StudentID3,ProjectTeamName) VALUES(?,?,?,?,?,?)";
        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);
            pst.setString(1, newProject.getProjectName());
            pst.setInt(2, newProject.getTeacherID());
            pst.setInt(3, newProject.getStudentID1());
            if(newProject.getStudentID2()!=0){
                pst.setInt(4, newProject.getStudentID2());
            }else
                pst.setNull(4, Types.INTEGER);
            if(newProject.getStudentID3()!=0){
                pst.setInt(5, newProject.getStudentID3());
            }else
                pst.setNull(5, Types.INTEGER);
            pst.setString(6,newProject.getProjectTeamName());


            int rowsAffected = pst.executeUpdate();  // 执行语句

            return rowsAffected == 1;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResource(resultSet, pst);
        }
        return false;
    }
    /**
     * 更新项目信息
     * @param project 项目对象。
     * @return 如果更新成功返回true，否则返回false。
     */
    public boolean updateProject(Project project) {
        String sql = "UPDATE Project SET FlowChart=?,ProjectMindMap=?,CodeModuleDiagram=?," +
                "VideoURL=?,ProjectDisplayMap=?,ProjectDescription=?,HardwareCircuitDiagram=?," +
                "StructureChart=?,Equipment=?,VideoURL=?,CompetitionExperience=?,DesignDocument=? " +
                "WHERE ProjectID=?";
        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);
            pst.setString(1, project.getFlowChart());
            pst.setString(2, project.getProjectMindMap());
            pst.setString(3,project.getCodeModuleDiagram());
            pst.setString(4,project.getVideoURL());
            pst.setString(5,project.getProjectDisplayMap());
            pst.setString(6,project.getProjectDescription());
            pst.setString(7,project.getHardwareCircuitDiagram());
            pst.setString(8,project.getStructureChart());
            pst.setString(9,project.getEquipment());
            pst.setString(10,project.getVideoURL());
            pst.setString(11,project.getCompetitionExperience());
            pst.setString(12,project.getDesignDocument());
            pst.setInt(13,project.getProjectID());;

            int rowsAffected = pst.executeUpdate();  // 执行语句

            return rowsAffected == 1;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResource(resultSet, pst);
        }
        return false;
    }
    /**
     * 根据学生ID1，获取项目ID。
     * @param StudentID1 需要获取信息的项目ID。
     * @return 返回ProjectID
     */
    public Integer getProjectIDByStudentID1(Integer StudentID1) {
        Integer ProjectID=null;

        String sql="SELECT * FROM Project WHERE StudentID1 = ?";
        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);  // 预处理语句
            pst.setInt(1, StudentID1);
            resultSet = pst.executeQuery();  // 执行语句
            // 获得项目信息
            if (resultSet.next()) {

                ProjectID=resultSet.getInt("ProjectID");
            }

            return ProjectID;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }
    /**
     * 删除项目
     * @param ProjectID 项目ID。
     * @return 如果删除成功返回true，否则返回false。
     */
    public boolean deleteProject(Integer ProjectID) {
        String sql = "DELETE FROM Project where ProjectID=?";
        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);
            pst.setInt(1, ProjectID);

            int rowsAffected = pst.executeUpdate();  // 执行语句

            return rowsAffected == 1;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResource(resultSet, pst);
        }
        return false;
    }
}

