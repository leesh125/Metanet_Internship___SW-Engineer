
public class IfTest {

	public static void main(String[] args) {
		int kor = 98, math = 70, eng = 91;
		double avg = (kor + math + eng) / 3.0;
		avg = (int)Math.round(avg*1000) / 1000d;
		StringBuilder grade = new StringBuilder();
		
		if(avg >= 90) {
			grade.append("A");
			if(avg >= 97) {
				grade.append("+");
			}else if(avg <= 93) {
				grade.append("-");
			}else {
				grade.append("0");
			}
		}else if(avg >= 80) {
			grade.append("B");
			if(avg >= 87) {
				grade.append("+");
			}else if(avg <= 83) {
				grade.append("-");
			}else {
				grade.append("0");
			}
		}else if(avg >= 70) {
			grade.append("C");
			if(avg >= 77) {
				grade.append("+");
			}else if(avg <= 73) {
				grade.append("-");
			}else {
				grade.append("0");
			}
		}else if(avg >= 60) {
			grade.append("D");
			if(avg >= 67) {
				grade.append("+");
			}else if(avg <= 63) {
				grade.append("-");
			}else {
				grade.append("0");
			}
		}else {
			grade.append("F");
		}
		System.out.println("Æò±Õ : " + avg + ", ÇĞÁ¡" + grade);
		

	}

}
