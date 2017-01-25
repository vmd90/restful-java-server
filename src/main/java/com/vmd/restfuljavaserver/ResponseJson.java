package com.vmd.restfuljavaserver;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author victor
 */
public class ResponseJson {

    public Integer status;
    public String error;
    public String message;

    public ResponseJson(int status, Map<String, Object> attributes) {
        this.status = status;
        this.error = (String) attributes.get("error");
        this.message = (String) attributes.get("message");
    }
    
    public static ResponseEntity getError() {
        Map<String,Object> attributes = new HashMap<>();
        attributes.put("error", "Error happened");
        ResponseJson ej = new ResponseJson(HttpStatus.BAD_REQUEST.value(), attributes);
        return ResponseEntity.ok(ej);
    }
    
    public static ResponseEntity getError(String error) {
        Map<String,Object> attributes = new HashMap<>();
        attributes.put("error", error);
        ResponseJson ej = new ResponseJson(HttpStatus.BAD_REQUEST.value(), attributes);
        return ResponseEntity.ok(ej);
    }
    
    public static ResponseEntity getOk() {
        Map<String,Object> attributes = new HashMap<>();
        attributes.put("message", "success");
        ResponseJson ej = new ResponseJson(HttpStatus.OK.value(), attributes);
        return ResponseEntity.ok(ej);
    }
}
