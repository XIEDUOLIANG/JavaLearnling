package callback;

import lombok.Data;

/**
 * @author XieDuoLiang
 * @date 2020/11/16 下午4:50
 */
@Data
public class Teacher implements CallBack{

    private Student student;

    public Teacher(Student student){
        this.student = student;
    }

    public void ask(final String s) {
        System.out.println("teacher ask question");
        new Thread(() -> {
            try {
                student.answer(Teacher.this,s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("to do other thing");
    }

    @Override
    public void callBack(String s) {
        System.out.println("student answered the question: "+s);
    }
}
