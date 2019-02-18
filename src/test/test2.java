import com.oj.dao.PoetryDao;
import com.oj.daoImpl.PoetryDaoImpl;
import com.oj.entity.PoetryEntity;
import com.oj.utils.Utils;
import org.junit.Test;

import java.util.ArrayList;

public class test2 {

    //
    //

    @Test
    public void test2_1() {

        String temp = "游蕲水清泉寺，寺临兰溪，溪水西流。山下兰芽短浸溪，松间沙路净无泥，潇潇暮雨子规啼。谁道人生无再少？门前流水尚能西！休将白发唱黄鸡。——宋代·苏轼《浣溪沙·游蕲水清泉寺》https://so.gushiwen.org/shiwenv_a9a16104dd1b.aspx";
        String title = temp.substring(temp.indexOf("《")+1, temp.indexOf("》"));
        String dynasty = temp.substring(temp.indexOf("——")+2, temp.indexOf("·")-1);
        String author = temp.substring(temp.indexOf("·")+1, temp.indexOf("《"));
        String content = temp.substring(0, temp.indexOf("——"));

        System.out.println(title + " " + dynasty + " " + author + " " + content);

        PoetryEntity poetryEntity = new PoetryEntity(title, dynasty, author, content);
        boolean flag = new PoetryDaoImpl().insertPoetry(poetryEntity);
        System.out.println(flag);
//        ArrayList<PoetryEntity> poetryEntityArrayList = poetryDao.getPoetryList();
//        for(PoetryEntity poetryEntity : poetryEntityArrayList){
//            System.out.println(poetryEntity.toString());
//        }

    }


    @Test
    public void test2_2() {
        int randnumber = Utils.intRangedRandNum(0, 52);
        System.out.println(randnumber);
        int count = 100;
        while(count-- >0){
            randnumber = Utils.intRangedRandNum(0, 52);
            System.out.println(randnumber);
        }


    }

    @Test
    public void test2_3() {
        PoetryDao poetryDao = new PoetryDaoImpl();
        ArrayList<PoetryEntity> poetryEntityArrayList = poetryDao.getPoetryList();
        int rn = Utils.intRangedRandNum(0, poetryEntityArrayList.size()-1);
        PoetryEntity poetryEntity = poetryEntityArrayList.get(rn);
        String content = poetryEntity.getContent();
        content = content.replace("，","，<br/>");
        content = content.replace("？","？<br/>");
        content = content.replace("。","。<br/>");
        content = content.replace("；","；<br/>");
        content = content.replace("！","！<br/>");
        poetryEntity.setContent(content);
        System.out.println(poetryEntity.toString());

    }


    @Test
    public void test2_4() {

        int t = Utils.intRangedRandNum(1,2);
        System.out.println(t);

    }


    @Test
    public void test2_5() {
        boolean flag = Utils.isChinesePunctuation('，');
        System.out.println(flag);
    }

    @Test
    public void test2_6() {
        boolean flag = Utils.isChineseChar('。');
        System.out.println(flag);
    }
}
