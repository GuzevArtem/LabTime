package edu.kpi.labtime.dto;

public class Param<T extends Object> {

    private String name;

    private T value;

    private Class clazz;

    public Param(String name, Class clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public Param(String name, T value) {
        this.name = name;
        this.value = value;
        this.clazz = value.getClass();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Class getType() {
        return clazz;
    }

    public boolean isSame(String name, Class clazz) {
        return this.name.equals(name) && this.clazz.equals(clazz);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Param<?> param = (Param<?>) o;
        return getName().equals(param.getName())
                && getValue().equals(param.getValue());
    }

    @Override
    public int hashCode() {
        return getName().hashCode()^(getValue().hashCode() << 16)^getValue().hashCode();
    }

    @Override
    public String toString() {
        return "Param{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
