import java.util.Enumeration;
import java.util.Vector;

public class Course {
    private static final double BATAS_UJIAN_AKHIR = 60.0;

    private String title;
    private final Vector<CourseRecord> courseRecords;

    Course() {
        courseRecords = new Vector<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    public void printCourseStudents() {
        Enumeration<CourseRecord> e = courseRecords.elements();
        while (e.hasMoreElements()) {
            CourseRecord cr = e.nextElement();
            System.out.println(cr.getStudent().getName());
        }
    }

    public void printBestStudent() {
        CourseRecord best = null;
        Enumeration<CourseRecord> e = courseRecords.elements();
        while (e.hasMoreElements()) {
            CourseRecord cr = e.nextElement();
            if (best == null || cr.getAverage() > best.getAverage()) {
                best = cr;
            }
        }
        if (best == null) {
            System.out.println("Belum ada mahasiswa di course ini.");
            return;
        }
        System.out.println("Mahasiswa terbaik: " + best.getStudent().getName()
                + " (rata-rata " + best.getAverage() + ")");
    }

    public void printFinalExamStudents() {
        Enumeration<CourseRecord> e = courseRecords.elements();
        while (e.hasMoreElements()) {
            CourseRecord cr = e.nextElement();
            if (cr.getAverage() >= BATAS_UJIAN_AKHIR) {
                System.out.println(cr.getStudent().getName()
                        + " (rata-rata " + cr.getAverage() + ")");
            }
        }
    }
}