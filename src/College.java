/**
 * College
 *
 * Represents an abstraction of a college. Each college may have courses, professors, students, and teachers.
 *
 * @author Derek Nobbe
 *
 * @version date of completion
 *
 */

public class College {

    /**
     * Maximum number of Courses allowed to be added to a College
     */
    protected static final int MAX_COURSES = 10;

    /**
     * Maximum number of Professors allowed to be hired by a College
     */
    protected static final int MAX_PROFESSORS = 5;

    /**
     * Maximum number of Teachers allowed to be hired by a College
     */
    protected static final int MAX_TEACHERS = 25;

    /**
     * Maximum number of Students allowed to be enrolled to a College
     */
    protected static final int MAX_STUDENTS = 500;


    private String name;
    private Professor[] professors;
    private Teacher[] teachers;
    private Student[] students;
    private Course[] courses;
    private int tuition;

    /**
     * Constructs a new College object with the corresponding parameters as field values, and new arrays of Professors,
     * Students, Teachers, and Courses limited by the corresponding MAX variables.
     *
     * @param name Name of the College to be created.
     * @param tuition Cost for students to attend.
     */
    public College(String name, int tuition) {
        //TODO: Initialize field variables for this College object
        this.name = name;
        this.tuition = tuition;
    }

    /**
     * Adds course to the College's array of courses. If the course is null, the course is already available at the
     * College, or the College cannot add more courses, nothing changes.
     *
     * @param course A course object to be added to the College's array of courses.
     */
    public void addCourse(Course course) {
        //TODO: Add the course to the courses array, if appropriate
        int lastCourseIndex = 0;
        if (course == null) {
            return;
        }
        for (int i = 0; i < courses.length; i++) {
            if (course == courses[i]) {
                return;
            }
        }
        if (courses[9] != null) {
            return;
        }
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                lastCourseIndex = i;
            }
        }
        courses[lastCourseIndex] = course;
    }

    /**
     * Adds professor to the College's array of Professors. If the Professor is null, the College cannot add more
     * Professors, or the Professor is already employed by the College, nothing changes.
     *
     * @param professor Professor to be added to the College's array of Professors
     */
    public void hireProfessor(Professor professor) {
        //TODO: Add the given professor to the professors array, if appropriate
        if (professor == null) {
            return;
        }
        for (int i = 0; i < professors.length; i++) {
            if (professor.getID() == professors[i].getID()) {
                return;
            }
        }
        int lastProfIndex = 0;
        for (int i = 0; i < professors.length; i++) {
            if (professors[i] == null) {
                lastProfIndex = i;
                break;
            }
        }
        professors[lastProfIndex] = professor;
    }

    /**
     * Adds teacher to the College's array of Teachers. If teacher is null, the College cannot add more Teachers,
     * or teacher is already employed by the College, nothing changes.
     *
     * @param teacher Teacher to be added to the College's array of teachers
     */
    public void hireTeacher(Teacher teacher) {
        //TODO: Add the given teacher to the teachers array, if appropriate
        if (teacher == null) {
            return;
        }
        for (int i = 0; i < teachers.length; i++) {
            if (teacher.getID() == teachers[i].getID()) {
                return;
            }
        }
        int lastTeacherIndex = 0;
        for (int i = 0; i < teachers.length; i++) {
            if (students[i] == null) {
                lastTeacherIndex = i;
                break;
            }
        }
        teachers[lastTeacherIndex] = teacher;
    }

    /**
     * Adds student to the College's array of students. If the student is null, the student is already enrolled at the
     * College, or the College cannot add more students, nothing changes.
     *
     * @param student A Student object to be added to the College's array of students.
     */
    public void addStudent(Student student) {
        //TODO: Add the student to the students array, if appropriate
        if (student == null) {
            return;
        }
        for (int i = 0; i < students.length; i++) {
            if (student.getID() == students[i].getID()) {
                return;
            }
        }
        int lastStudentIndex = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                lastStudentIndex = i;
                break;
            }
        }
        students[lastStudentIndex] = student;
    }

    /**
     * Removes student from the College's array of Students. If the student is enrolled in any Courses, they should be
     * removed from these courses. If student is null or the student is not currently enrolled, nothing changes.
     *
     * *HINT* If you try to remove a student from a Course, an exception is thrown. Consider using a try-catch block.
     *
     * @param student Student to be removed from the College's array of students
     */
    public void dropStudent(Student student) {
        //TODO: Remove the given student from the students array and any courses, if appropriate
    }

    /**
     * Returns the net change in the colleges budget. Tuition per student will increase the net change, and payments for
     * Professors and Teachers according to both their base and per course salaries will decrease the net change.
     *
     * @return Net change in the College's funds
     */
    public int calculateNetBudgetChange() {
        //TODO: Calculate the change in budget (Total tuition - Professor Salaries - Teacher Salaries)
        int numStudents = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                numStudents++;
            }
        }
        int profBaseSum = 0;
        int teacherBaseSum = 0;
        for (int i = 0; i < professors.length; i++) {
            if (professors[i] == null) {
                break;
            }
            profBaseSum = profBaseSum + professors[i].getBaseSalary();
        }
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                break;
            }
            teacherBaseSum = teacherBaseSum + teachers[i].getBaseSalary();
        }
        return 0;
    }

    /**
     * @return A reference to the array of courses offered by this College.
     */
    public Course[] getCourses()
    {
        //TODO: Return the array of Courses.
        return courses;
    }

    /**
     * @return A reference to the array of Teachers employed by this College.
     */
    public Teacher[] getTeachers()
    {
        //TODO: Return the array of Teachers
        return teachers;
    }

    /**
     * @return A reference to the array of Professors employed by this College.
     */
    public Professor[] getProfessors()
    {
        //TODO: Return the array of Professors
        return professors;
    }

    /**
     * @return A reference to the array of Students enrolled at this College.
     */
    public Student[] getStudents()
    {
        //TODO: Return the array of Professors
        return students;
    }

    /**
     * @return The name of the College object
     */
    public String getName() {
        //TODO: Return the name of the College object
        return name;
    }

    /**
     * @return The tuition charged per student
     */
    public int getTuition() {
        //TODO: Return the tuition of the College object
        return tuition; // I wish
    }
}
