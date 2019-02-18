import com.oj.dao.AdminDao;
import com.oj.dao.UserDao;
import com.oj.daoImpl.AdminDaoImpl;
import com.oj.daoImpl.UserDaoImpl;
import com.oj.entity.AdminEntity;
import com.oj.entity.UserEntity;
import com.oj.utils.Utils;
import org.junit.Test;

public class test1 {

    AdminDao adminDao = new AdminDaoImpl();
    UserDao userDao = new UserDaoImpl();

    @Test
    public void test1() {
        String res = Utils.toMD5("123456");
        System.out.println(res);

    }

    @Test
    public void adminLoginTest() {
        AdminEntity adminEntity = adminDao.adminLogin("admin1", Utils.toMD5("123456"));
        System.out.println(adminEntity==null);
        System.out.println(adminEntity.toString());
    }

    @Test
    public void userLoginTest() {
        UserEntity userEntity = userDao.userLogin("000001", Utils.toMD5("123456"));
        System.out.println(userEntity==null);
        System.out.println(userEntity.toString());
    }

    @Test
    public void userRegisterTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setSchool_id("000002");
        userEntity.setPassword(Utils.toMD5("123456"));
        System.out.println(userDao.userRegister(userEntity));
    }

    @Test
    public void adminRegisterTest() {
        AdminEntity adminEntity = new AdminEntity("admin2",Utils.toMD5("123456"));
        System.out.println(adminDao.adminRegister(adminEntity));

    }
}
