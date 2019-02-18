package com.oj.daoImpl;

import com.oj.dao.PoetryDao;
import com.oj.entity.PoetryEntity;
import com.oj.entity.PoetrySubEntity;
import com.oj.utils.JDBCUtil;
import com.oj.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PoetryDaoImpl implements PoetryDao {


    @Override
    public boolean insertPoetry(PoetryEntity poetryEntity) {
        if(poetryEntity == null) return false;

        String sql = "INSERT INTO `poetry` (title,dynasty,author,content) VALUES(?,?,?,?)";

        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        int flag = -1;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, poetryEntity.getTitle());
            ps.setString(2, poetryEntity.getDynasty());
            ps.setString(3, poetryEntity.getAuthor());
            ps.setString(4, poetryEntity.getContent());
            flag = ps.executeUpdate();
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] com.oj.daoImpl.PoetryDaoImpl - insertPoetry() 数据库连接出错");
        }finally {
            JDBCUtil.closeConnection(null, ps, con);
        }

        return flag >= 0;
    }


    @Override
    public ArrayList<PoetryEntity> getPoetryList() {

        String sql = "SELECT * FROM `poetry`";
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<PoetryEntity> poetryEntityArrayList = new ArrayList<>();
        PoetryEntity poetryEntity = null;

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                poetryEntity = new PoetryEntity();
                poetryEntity.setId(rs.getInt(1));
                poetryEntity.setTitle(rs.getString(2));
                poetryEntity.setDynasty(rs.getString(3));
                poetryEntity.setAuthor(rs.getString(4));
                poetryEntity.setContent(rs.getString(5));
                poetryEntityArrayList.add(poetryEntity);
            }
        }catch (SQLException e){
            //e.printStackTrace();
            System.out.println("[x] com.oj.daoImpl.PoetryDaoImpl - getPoetryList() 数据库连接出错");
        }finally {
            JDBCUtil.closeConnection(rs, ps, con);
        }


        return poetryEntityArrayList;
    }

    @Override
    public ArrayList<PoetrySubEntity> getPoetrySubList(ArrayList<PoetryEntity> poetryEntityArrayList, int num) {

        ArrayList<PoetrySubEntity> poetrySubEntityArrayList = new ArrayList<>(); //诗句列表

        for(int i = 0; i < num; i++){
            int rn = Utils.intRangedRandNum(0, poetryEntityArrayList.size()-1);
            PoetryEntity poetryEntity = poetryEntityArrayList.get(rn);
            PoetrySubEntity poetrySubEntity = new PoetrySubEntity(i+1, poetryEntity.getTitle(), poetryEntity.getDynasty(), poetryEntity.getAuthor());

            String content = poetryEntity.getContent().replace(" ", "");
            int seed = Utils.intRangedRandNum(1,2); //截取古诗的前两句还是后两句
            int indexS = 0, indexE = 0; //截取诗句的开始下标和结束下标
            char [] charArray = content.toCharArray();
            if(seed == 1){ //前两句
                int cnt = 0;
                for(int j = 0 ; j < charArray.length; j++){
                    if(!Utils.isChineseChar(charArray[j])){
                        cnt++;
                        if(cnt==2){
                            indexE = j;
                            break;
                        }
                    }
                }
                content = content.substring(indexS, indexE+1);
            }
            else if(seed == 2){ //后两句
                int cnt = 0;
                for(int j = 0 ; j < charArray.length; j++){
                    if(!Utils.isChineseChar(charArray[j])){
                        cnt++;
                        if(cnt == 2) indexS = j;
                        if(cnt == 4){ indexE = j; break; }
                    }
                }
                content = content.substring(indexS+1, indexE+1);
            }

            int seedAns = Utils.intRangedRandNum(1,2); //在前半句内容还是后半句内容中挖空
            int indexAnsA = 0, indexAnsB = 0; //挖空的开始下标和结束下标
            int conLen = content.length()-1;
            int halfConLen = conLen/2;
            String poetryAnswer = "";

            //System.out.println(content+" "+conLen+" "+halfConLen);

            if(seedAns == 1){ //在前半句中挖空
                while (true){
                    indexAnsA = Utils.intRangedRandNum(0, halfConLen-1);
                    indexAnsB = Utils.intRangedRandNum(0, halfConLen-1);
                    if(indexAnsA != indexAnsB) break;
                }
                //System.out.println("前半句："+indexAnsA+" "+indexAnsB);
                poetryAnswer = content.substring(Math.min(indexAnsA, indexAnsB), Math.max(indexAnsA, indexAnsB));
            }
            else if(seedAns == 2){ //在后半句中挖空
                while (true){
                    indexAnsA = Utils.intRangedRandNum(halfConLen+1, conLen-1);
                    indexAnsB = Utils.intRangedRandNum(halfConLen+1, conLen-1);
                    if(indexAnsA != indexAnsB) break;
                }
                //System.out.println("后半句："+indexAnsA+" "+indexAnsB);
                poetryAnswer = content.substring(Math.min(indexAnsA, indexAnsB), Math.max(indexAnsA, indexAnsB));
            }
            String line = "";
            for(int o = 0; o < poetryAnswer.length(); o++) line += "__";
            content = content.replace(poetryAnswer, line);

            poetrySubEntity.setContent(content);
            poetrySubEntity.setAns(poetryAnswer);
            //System.out.println(poetrySubEntity.toString());
            poetrySubEntityArrayList.add(poetrySubEntity);
            //System.out.println(content + "\n"+ poetryAnswer);
        }

        return poetrySubEntityArrayList;
    }


}
