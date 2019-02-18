import com.oj.utils.Utils;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import org.junit.Test;


public class test3 {
    @Test
    public void test3_1() {

        Evaluator evaluator = new Evaluator();
        try{
            String res = evaluator.evaluate("1+2");
            double ress = Double.parseDouble(res);
            System.out.println(res.trim());


        }catch (EvaluationException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test3_2() {
        for(int i = 0; i < 100; i++){
            int t = Utils.intRangedRandNum(8, 14);
            System.out.println(t);
        }

    }

    @Test
    public void test3_3() {

        int [] lenArray = {3, 5, 7, 9};
        for(int i : lenArray)
            System.out.println(i);

    }
}
