package az.pashabank.learningsession.msstudent.util;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private Integer code;
    private String message;

    public static Response getSuccessResponse(){
        Response response = new Response();
        response.setCode(0);
        response.setMessage("SUCCESS!");
        return response;
    }

    public static Response getErrorResponse(){
        Response response = new Response();
        response.setCode(1);
        response.setMessage("ERROR!");
        return response;
    }
}
