package iti.iwish.shared;

import java.io.Serializable;

public record ApiResponse(boolean ok, String message, Object payload) implements Serializable {
    private static final long serialVersionUID = 1L;
    public static ApiResponse ok(String message, Object payload) { return new ApiResponse(true, message, payload); }
    public static ApiResponse fail(String message) { return new ApiResponse(false, message, null); }
}
