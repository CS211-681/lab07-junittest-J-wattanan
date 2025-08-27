package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("isId ตรงกัน")
    void testIsIdTrue() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertTrue(s.isId("6xxxxxxxxx"));
    }

    @Test
    @DisplayName("isId ไม่ตรง")
    void testIsIdFalse() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertFalse(s.isId("7xxxxxxxxx"));
    }

    @Test
    @DisplayName("isNameContains มีคำย่อย")
    void testIsNameContainsTrue() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertTrue(s.isNameContains("test"));
        assertTrue(s.isNameContains("Student"));
    }

    @Test
    @DisplayName("isNameContains ไม่มีคำย่อย")
    void testIsNameContainsFalse() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertFalse(s.isNameContains("Sensei"));
    }

    @Test
    @DisplayName("getId/getName คืนค่าตามที่ตั้ง")
    void testGetIdAndName() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertEquals("6xxxxxxxxx", s.getId());
        assertEquals("StudentTest", s.getName());
    }

    @Test
    @DisplayName("getScore ค่าตั้งต้นเป็น 0 และแบบกำหนดค่าเริ่มต้น")
    void testGetScoreInitialAndPreset() {
        Student a = new Student("xA", "A");
        Student b = new Student("xB", "B", 12.5);
        assertEquals(0.0, a.getScore());
        assertEquals(12.5, b.getScore());
    }

    @Test @DisplayName("grade: 80 -> A")
    void testGradeA() { assertEquals("A", new Student("id","n",80).getGrade()); }

    @Test @DisplayName("grade: 70 -> B, 79.99 -> B")
    void testGradeB() {
        assertEquals("B", new Student("id","n",70).getGrade());
        assertEquals("B", new Student("id","n",79.99).getGrade());
    }

    @Test @DisplayName("grade: 60 -> C, 69.99 -> C")
    void testGradeC() {
        assertEquals("C", new Student("id","n",60).getGrade());
        assertEquals("C", new Student("id","n",69.99).getGrade());
    }

    @Test @DisplayName("grade: 50 -> D, 59.99 -> D")
    void testGradeD() {
        assertEquals("D", new Student("id","n",50).getGrade());
        assertEquals("D", new Student("id","n",59.99).getGrade());
    }

    @Test @DisplayName("grade: ต่ำกว่า 50 -> F")
    void testGradeF() {
        assertEquals("F", new Student("id","n",49.99).getGrade());
        assertEquals("F", new Student("id","n",0).getGrade());
    }
}
