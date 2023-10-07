import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testSimpleTaskMatchesWithMeaning() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expended = true;

        Assertions.assertEquals(expended, actual);
    }

    @Test
    public void testSimpleTaskMatchesWithoutMeaning() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("позвонить");
        boolean expended = false;

        Assertions.assertEquals(expended, actual);
    }

    @Test
    public void testEpicMatchesWithMeaning() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");
        boolean expended = true;

        Assertions.assertEquals(expended, actual);
    }

    @Test
    public void testEpicMatchesWithoutMeaning() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("яйца");
        boolean expended = false;

        Assertions.assertEquals(expended, actual);
    }

    @Test
    public void testMeetingMatchesWithMeaningInTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("версии");
        boolean expended = true;

        Assertions.assertEquals(expended, actual);
    }

    @Test
    public void testMeetingMatchesWithMeaningInProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Нето");
        boolean expended = true;

        Assertions.assertEquals(expended, actual);
    }

    @Test
    public void testMeetingMatchesWithoutMeaning() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Версии");
        boolean expended = false;

        Assertions.assertEquals(expended, actual);
    }
}

