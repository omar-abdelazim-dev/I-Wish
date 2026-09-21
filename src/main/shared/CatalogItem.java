package iti.iwish.shared;

import java.io.Serializable;

public record CatalogItem(long id, String name, String category, double price) implements Serializable { private static final long serialVersionUID = 1L; }
