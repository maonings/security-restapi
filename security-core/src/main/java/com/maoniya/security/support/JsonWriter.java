package security.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JSON工具类
 *
 * date:  Created in 2018/10/8 14:09
 *
 * @author maoning
 */
public final class JsonWriter {

    private JsonWriter() {}

    public static <T> void write(HttpServletResponse response, ResponseModel<T> model)
            throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        objectMapper.writeValue(response.getWriter(), model);
    }
}
