package 反射;

import lombok.Data;

import java.util.List;

/**
 * @author XieDuoLiang
 * @date 2020/8/4 1:57 下午
 */
@Data
public class Student {

    private String code;

    private Integer score;

    private List<Game> gameList;
}
