package leetcode.enums;

public enum TreeLeftRight {
    TREE_LEFT(1,"上层是左子树"),
    TREE_RIGHT(2,"上层是右子树")
    ;

    private Integer code;
    private String name;

    TreeLeftRight(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
