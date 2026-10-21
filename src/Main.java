public class Main {
    public static void main(String[] args) {
        Course c = new Course();
        c.setTitle("Implementasi dan Pengujian SI");

        String[] nama = {"Ani", "Budi", "Citra"};
        int[][] nilai = {{80, 90}, {50, 55}, {70, 65}};

        for (int i = 0; i < nama.length; i++) {
            Student s = new Student();
            s.setName(nama[i]);
            CourseRecord cr = new CourseRecord();
            cr.setStudent(s);
            for (int n : nilai[i]) {
                Assignment a = new Assignment();
                a.setMark(n);
                cr.addAssignment(a);
            }
            cr.addAssignment(new Assignment()); 
            c.addCourseRecord(cr);
        }

        System.out.println("== Semua mahasiswa ==");
        c.printCourseStudents();
        System.out.println("== Terbaik ==");
        c.printBestStudent();
        System.out.println("== Layak ujian akhir ==");
        c.printFinalExamStudents();
    }
}