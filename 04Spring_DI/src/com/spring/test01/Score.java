package com.spring.test01;

public class Score {
	
	//이름,국어,영어,수학,총점,평균,등급 변수 선언하기
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String grade;
	
	public Score() {
		//기본생성자
	}
	//이름,국어,영어.수학을 파라미터로 받는 생성자
	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		int sum = kor + eng + math;
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		double avg = getSum() / 4;
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
	      String s ;
	      switch((int)getAvg()/10) {
	         case 10 :
	         case 9 :s="A"; break;
	         case 8: s="B"; break;
	         case 7: s="C"; break;
	         case 6: s="D"; break;
	         default :s="F";
	      }
	      return s;
	   }

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String toString() {
		return "이름 : " + name + " 국어 : " + kor + " 영어 : " + 
				eng + " 수학 : " + math + " 총점 : " + getSum() + " 평균 : " + getAvg() +
				" 등급 : " + getGrade();
	}
}
