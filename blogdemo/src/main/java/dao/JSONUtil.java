package dao;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.SystemException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @className JSONUtil
 * @Description TODO
 * @Author Fu Xin
 * @Date 2019/8/23 15:30
 * @Version 1.0
 **/
public class JSONUtil {
    public static String format(Object object) throws SystemException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        );
        try {
            return objectMapper.writeValueAsString(object);

        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        return null;
    }
    public static <T> T get(HttpServletRequest request,Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"));
        try {
            return objectMapper.readValue(request.getInputStream(),clazz);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
