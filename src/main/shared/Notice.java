package iti.iwish.shared;

import java.io.Serializable;
import java.time.LocalDateTime;

public record Notice(long id, String message, boolean read, LocalDateTime createdAt) implements Serializable { private static final long serialVersionUID = 1L; }
