import java.util.Enumeration;
import java.util.Vector;

public class CourseRecord {
    private Student student;
    private final Vector<Assignment> assignments;

    CourseRecord() {
        assignments = new Vector<>();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student s) {
        student = s;
    }

    public void addAssignment(Assignment a) {
        assignments.addElement(a);
    }

    public Enumeration<Assignment> getAssignments() {
        return assignments.elements();
    }

    public double getAverage() {
        double total = 0;
        int count = 0;
        Enumeration<Assignment> e = assignments.elements();
        while (e.hasMoreElements()) {
            Assignment a = e.nextElement();
            try {
                total += a.getMark();
                count++;
            } catch (NotYetSetException ex) {
                // Tugas yang belum dinilai tidak dihitung.
            }
        }
        if (count == 0) {
            return 0;
        }
        return total / count;
    }
}