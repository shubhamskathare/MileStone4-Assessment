package com.mindtree.college.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="col_id")
    private Long id;
    @Column(name="col_name")
    private String colName;
    @Column(name="no_stu")
    private int noStu;
    
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(Long id, String colName, int noStu) {
		super();
		this.id = id;
		this.colName = colName;
		this.noStu = noStu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public int getNoStu() {
		return noStu;
	}

	public void setNoStu(int noStu) {
		this.noStu = noStu;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", colName=" + colName + ", noStu=" + noStu + "]";
	}
    
	
    
   
}