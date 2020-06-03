package br.com.example.deusemar;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String key;

    @Column
    private String value;

    public Parameter() {
    }

    public Parameter(Long id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return Objects.equals(id, parameter.id) &&
                Objects.equals(key, parameter.key) &&
                Objects.equals(value, parameter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, value);
    }
}
