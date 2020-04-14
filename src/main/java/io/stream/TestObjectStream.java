package main.java.io.stream;

import java.io.Serializable;

/**
 * @author zjq
 * @date 2020/4/14 13:58
 */
public class TestObjectStream implements Serializable {

    private static final long serialVersionUID = 1L;
    public String field1;
    public int field2;
    public TestObjectStream(String param1, int param2){
        this.field1 = param1;
        this.field2 = param2;
    }
    @Override
    public String toString() {
        return "TestObjectStream [field1=" + this.field1 + ", field2=" + this.field2 +"]";
    }
}
