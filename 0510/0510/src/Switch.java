
public class Switch {

	public static void main(String[] args) {
		int kor = 98, math = 70, eng = 91;
		double avg = (kor + math + eng) / 3.0;
		avg = (int)Math.round(avg*1000) / 1000d;
		StringBuilder grade = new StringBuilder();
		
		switch((int)(avg/10)) {
		case 10:
		case 9:
			grade.append("A");
			break;
		case 8:
			grade.append("B");
			break;
		case 7:
			grade.append("C");
			break;
		case 6:
			grade.append("D");
			break;
		default:
			grade.append("F");
		}
		System.out.println("Æò±Õ: " + avg + ", ÇÐÁ¡: " + grade);
	}

}
