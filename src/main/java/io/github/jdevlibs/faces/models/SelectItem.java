package io.github.jdevlibs.faces.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author supot.jdev
 * @version 1.0
 */
@EqualsAndHashCode(of = {"value"})
@Data
public class SelectItem implements Serializable {
    private String value;
    private String label;
    private String description;
    private boolean disabled;

    public SelectItem() {

    }

    public SelectItem(String value, String label) {
        this.value = value;
        this.label = label;
    }
}