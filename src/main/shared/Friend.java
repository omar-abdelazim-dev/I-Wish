package iti.iwish.shared;

import java.io.Serializable;

public record Friend(long relationshipId, long userId, String name, String email, String status, boolean incoming) implements Serializable { private static final long serialVersionUID = 1L; }
