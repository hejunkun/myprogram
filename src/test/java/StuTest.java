

import com.myprogram.entity.Cls;
import com.myprogram.service.StuService;
import org.junit.Test;
import java.util.List;

/**
 * Created by hjk on 2018/1/9.
 */
public class StuTest {

    @Test
    public  void finStu(){
        StuService stuService = new StuService();
        Cls c = new Cls();
        c.setCno(4);
        List list = stuService.findStuList(c);
        System.out.println(list.size());
    }
}
