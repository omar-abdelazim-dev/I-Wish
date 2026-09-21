package iti.iwish.shared;

import java.io.Serializable;
import java.util.Map;

/** Small dependency-free request envelope for the desktop client/server protocol. */
public record ApiRequest(String action, Map<String, Object> data) implements Serializable {
    private static final long serialVersionUID = 1L;
}
