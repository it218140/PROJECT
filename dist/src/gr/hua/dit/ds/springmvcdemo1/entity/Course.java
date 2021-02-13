package gr.hua.dit.ds.springmvcdemo1.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="course")
public class Course {
    // define fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
                        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="teacher_id")
    @JsonIgnore
    private Teacher teacher;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviews;
    
    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER,
                cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
                          CascadeType.DETACH, CascadeType.REFRESH})    
    
    @JoinTable(
            name="course_student",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="student_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Student> students;
    
    // define constructors
    public Course() {
        
    }

    public Course(String title) {
        this.title = title;
    }

    // define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    
    
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // define toString
    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + "]";
    }
    
    // add a convenience method for adding a review
    public void addReview(Review areview) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(areview);
    }
    
    // add a convenience method  to add course
    
    public void addStudent(Student student) {
    	
        if (students == null) {
            students = new ArrayList<Student>();
        }
        students.add(student);
    }
}