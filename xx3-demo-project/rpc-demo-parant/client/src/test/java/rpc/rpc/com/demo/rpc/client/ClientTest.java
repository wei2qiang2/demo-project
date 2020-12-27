package rpc.rpc.com.demo.rpc.client;

import com.demo.rpc.ClientApplication;
import com.demo.rpc.remote.ISmsService;
import com.demo.rpc.remote.vo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/27 19:54
 * @Version V1.0
 **/

@SpringBootTest(classes = ClientApplication.class)
public class ClientTest {

    @Autowired
    private ISmsService smsService;

    @Test
    public void sendSmsTest() {
        UserInfo userInfo = UserInfo.builder()
                .userName("weqiang")
                .email("1432114216@qq.com")
                .build();

        smsService.sendSms(userInfo);
    }
}
